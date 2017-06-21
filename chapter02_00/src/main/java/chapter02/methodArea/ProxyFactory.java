package chapter02.methodArea;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * A factory to produce Proxy object
 * 
 * @author ygh Jun 9, 2017
 */
public class ProxyFactory {
	/**
	 * target object
	 */
	private Object targetObject;

	/**
	 * Before advice object
	 */
	private BeforeAdvice beforeAdvice;

	/**
	 * After advice object
	 */
	private AfterAdvice afterAdvice;

	public Object getProxyObject() {
		ClassLoader loader = this.getClass().getClassLoader();
		Class<? extends Object>[] interfaces = this.getTargetObject().getClass().getInterfaces();

		InvocationHandler h = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if (beforeAdvice != null) {
					beforeAdvice.before();
				}
				Object result = method.invoke(targetObject, args);
				if (afterAdvice != null) {
					afterAdvice.after();
				}
				return result;
			}
		};
		Object proxyObject = Proxy.newProxyInstance(loader, interfaces, h);
		return proxyObject;
	}

	public Object getTargetObject() {
		return targetObject;
	}

	public void setTargetObject(Object targetObject) {
		this.targetObject = targetObject;
	}

	public BeforeAdvice getBeforeAdvice() {
		return beforeAdvice;
	}

	public void setBeforeAdvice(BeforeAdvice beforeAdvice) {
		this.beforeAdvice = beforeAdvice;
	}

	public AfterAdvice getAfterAdvice() {
		return afterAdvice;
	}

	public void setAfterAdvice(AfterAdvice afterAdvice) {
		this.afterAdvice = afterAdvice;
	}

}
