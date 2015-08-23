package net.cassite.style.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

import net.cassite.style.$;
import net.cassite.style.A1FuncSup;
import net.cassite.style.Style;

public class ConstructorSup<T> extends Style implements MemberSup<Constructor<T>> {
	private Constructor<T> con;

	public Constructor<T> getMember() {
		return con;
	}

	ConstructorSup(Constructor<T> con) {
		this.con = con;
	}

	public String name() {
		return con.getName();
	}

	public <A extends Annotation> A annotation(Class<A> annoCls) {
		return con.getAnnotation(annoCls);
	}

	public <A extends Annotation> boolean isAnnotationPresent(Class<A> annoCls) {
		return con.isAnnotationPresent(annoCls);
	}

	public T newInstance() {
		return newInstance(new Object[0]);
	}

	public T newInstance(Object... args) {
		try {
			return con.newInstance(args);
		} catch (Exception e) {
			throw $(e);
		}
	}

	public T newInstance(A1FuncSup<?> args) {
		return newInstance(args.to(new Object[args.size()]).via($.copy()));
	}

	public Class<?>[] argTypes() {
		return con.getParameterTypes();
	}

	public Annotation[][] argAnnos() {
		return con.getParameterAnnotations();
	}

	public Annotation[] argAnnos(int argIndex) {
		return argAnnos()[argIndex];
	}

	public String toString() {
		return con.toString();
	}
}
