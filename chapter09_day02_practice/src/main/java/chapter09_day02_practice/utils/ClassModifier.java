package chapter09_day02_practice.utils;

/**
 * A class to implement replace a class use another class at runtime. But in
 * this class,we just implement to update the <code>CONSTANT_Utf8_into</code>
 * field in class file
 * 
 * @author ygh Jun 23, 2017
 */
public class ClassModifier {
	/**
	 * The entrance address of constant pool
	 */
	private static final int CONSTANT_POOL_COUNT_INDEX = 8;

	/**
	 * Define the tag of the CONSTANT_Utf8_into
	 */
	private static final int CONSTANT_Utf8_into_tag = 1;

	/**
	 * The length of another eleven constant value,except for
	 * <code>CONSTANT_Utf8_into</code>. Because its length is not fired
	 * 
	 */
	private static final int[] CONSTANT_ITEM_LENGTH = { -1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5 };

	/**
	 * Define the bytes of <code>u1</code> and <code>u2</code>. The value is set
	 * in JVM
	 */
	private static final int u1 = 1;
	private static final int u2 = 2;

	/**
	 * A byte array to store the byte of class file
	 */
	private byte[] classByte;

	public ClassModifier(byte[] classByte) {
		super();
		this.classByte = classByte;
	}

	/**
	 * A method to replace a <code>CONSTANT_Utf8_into</code> filed with a new
	 * file.
	 * 
	 * @param oldStr
	 *            The name of the old <code>CONSTANT_Utf8_into</code>
	 * @param newStr
	 *            The name of the new <code>CONSTANT_Utf8_into</code>
	 * @return A new byte which complete replace
	 */
	public byte[] modifyUTF8Constant(String oldStr, String newStr) {
		int cpc = getConstantPoolCount();
		int offset = CONSTANT_POOL_COUNT_INDEX + u2;
		for (int i = 0; i < cpc; i++) {
			int tag = ByteUtils.bytesToInt(classByte, offset, u1);
			if (tag == CONSTANT_Utf8_into_tag) {
				int len = ByteUtils.bytesToInt(classByte, offset + u1, u2);
				/**
				 * Let offset point to point the bytes
				 */
				offset = offset + u1 + u2;
				String str = ByteUtils.bytesToString(classByte, offset, len);
				if (str.equalsIgnoreCase(oldStr)) {
					byte[] strBytes = ByteUtils.stringToBytes(newStr);
					byte[] strlen = ByteUtils.intToBytes(strBytes.length, u2);
					classByte = ByteUtils.bytesReplace(classByte, offset - u2, u2, strlen);
					classByte = ByteUtils.bytesReplace(classByte, offset, len, strBytes);
					return classByte;
				} else {
					offset = offset + len;
				}
			} else {
				offset = offset + CONSTANT_ITEM_LENGTH[tag];
			}

		}
		return classByte;
	}

	/**
	 * Get the constant pool counter
	 * 
	 * @return
	 */
	private int getConstantPoolCount() {
		return ByteUtils.bytesToInt(classByte, CONSTANT_POOL_COUNT_INDEX, u2);
	}

}
