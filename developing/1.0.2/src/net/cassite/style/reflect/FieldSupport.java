package net.cassite.style.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import net.cassite.style.Style;

public class FieldSupport<FieldType, ObjectType> extends Style implements MemberSup<Field> {
	private Field f;

	public Field getMember() {
		return f;
	}

	FieldSupport(Field f, Class<FieldType> cls, Class<ObjectType> objCls) {
		if (f == null)
			throw $(new NoSuchFieldException());
		this.f = f;
	}

	public <A extends Annotation> A annotation(Class<A> annoCls) {
		return f.getAnnotation(annoCls);
	}

	public <A extends Annotation> boolean isAnnotationPresent(Class<A> annoCls) {
		return f.isAnnotationPresent(annoCls);
	}

	@SuppressWarnings("unchecked")
	public FieldType get(ObjectType obj) {
		try {
			f.setAccessible(true);
			return (FieldType) f.get(obj);
		} catch (Exception e) {
			throw $(e);
		}
	}

	public String name() {
		return f.getName();
	}

	public String toString() {
		return f.toString();
	}
}
