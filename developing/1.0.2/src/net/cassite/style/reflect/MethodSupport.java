package net.cassite.style.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import net.cassite.style.Style;

public class MethodSupport<R, ObjectType> extends Style implements MemberSup<Method> {
	private Method method;

	public Method getMember() {
		return method;
	}

	MethodSupport(Method method, Class<R> retType, Class<ObjectType> objType) {
		if (method == null)
			throw $(new NoSuchMethodException());
		this.method = method;
	}

	public <A extends Annotation> A annotation(Class<A> annoCls) {
		return method.getAnnotation(annoCls);
	}

	public <A extends Annotation> boolean isAnnotationPresent(Class<A> annoCls) {
		return method.isAnnotationPresent(annoCls);
	}

	@SuppressWarnings("unchecked")
	public R invoke(ObjectType target, Object... args) {
		try {
			method.setAccessible(true);
			return (R) method.invoke(target, args);
		} catch (Exception e) {
			throw $(e);
		}
	}

	public String name() {
		return method.getName();
	}

	public Class<?>[] argTypes() {
		return method.getParameterTypes();
	}

	public int argCount() {
		return method.getParameterCount();
	}

	public String toString() {
		return method.toString();
	}

	public Annotation[][] argAnnos() {
		return method.getParameterAnnotations();
	}

	public Annotation[] argAnnos(int argIndex) {
		return argAnnos()[argIndex];
	}
}
