package chapter09_day02_practice.utils;

/**
 * A byte tools to implement transfer byte into integer and String. The class is
 * in order to implement modify the constant value in constant pool.
 * 
 * @author ygh Jun 23, 2017
 */
public class ByteUtils {

	/**
	 * Transfer byte array value into integer value from start index to end
	 * which equal start plus length
	 * 
	 * @param b
	 *            A bytes array that read from class file
	 * @param start
	 *            The start index which the the integer value we want to get
	 * @param len
	 *            The length of the elements which we will transfer them into
	 *            integer value
	 * @return A integer value whose index is specified in byte array
	 */
	public static int bytesToInt(byte[] b, int start, int len) {
		int sum = 0;
		int end = start + len;
		for (int i = start; i < end; i++) {
			int n = ((int) b[i]) & 0xff;
			n <<= (--len) * 8;
			sum = n + sum;
		}
		return sum;
	}

	/**
	 * Transfer a integer value into a byte array specified length
	 * 
	 * @param value
	 *            The integer value need to transfer into byte array
	 * @param len
	 *            The length of the byte array specified
	 * @return A byte array the integer transfer into
	 */
	public static byte[] intToBytes(int value, int len) {
		byte[] b = new byte[len];
		for (int i = 0; i < len; i++) {
			b[len - i - 1] = (byte) ((value >> 8 * i) & 0xff);
		}
		return b;
	}

	/**
	 * Transfer into a byte into string
	 * 
	 * @param b
	 * @param start
	 * @param lne
	 * @return
	 */
	public static String bytesToString(byte[] b, int start, int len) {
		return new String(b, start, len);
	}

	/**
	 * Transfer a string into byte array
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] stringToBytes(String str) {
		return str.getBytes();
	}

	/**
	 * A method to replace some elements whose index is given in a byte array
	 * use another byte array,
	 * 
	 * @param originalBytes
	 *            The original byte array
	 * @param offset
	 *            The start index of the elements replaced
	 * @param len
	 *            The length of elements replaced
	 * @param replaceBytes
	 *            The new byte array which will to replace the elements
	 *            specified
	 * @return A new byte array has completed the replaced
	 */
	public static byte[] bytesReplace(byte[] originalBytes, int offset, int len, byte[] replaceBytes) {
		byte[] newBytes = new byte[originalBytes.length + replaceBytes.length - len];
		System.arraycopy(originalBytes, 0, newBytes, 0, offset);
		System.arraycopy(replaceBytes, 0, newBytes, offset, replaceBytes.length);
		System.arraycopy(originalBytes, offset + len, newBytes, offset + replaceBytes.length,
				originalBytes.length - len - offset);
		return newBytes;
	}

}
