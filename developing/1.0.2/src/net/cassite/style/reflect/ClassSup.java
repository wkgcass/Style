package net.cassite.style.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import net.cassite.style.A1FuncSup;
import net.cassite.style.Style;

public class ClassSup<T> extends Style {
	private Class<T> cls;

	public Class<T> getCls() {
		return cls;
	}

	public ClassSup(Class<T> cls) {
		this.cls = cls;
	}

	public String name() {
		return cls.getName();
	}

	public String simpleName() {
		return cls.getSimpleName();
	}

	public <A extends Annotation> A annotation(Class<A> annoCls) {
		return cls.getAnnotation(annoCls);
	}

	public <A extends Annotation> boolean isAnnotationPresent(Class<A> annoCls) {
		return cls.isAnnotationPresent(annoCls);
	}

	public boolean isInstance(Object obj) {
		return cls.isInstance(obj);
	}

	public ConstructorSup<T> constructor() {
		return constructor(new Class[0]);
	}

	public ConstructorSup<T> constructor(Class<?>... argTypes) {
		try {
			return new ConstructorSup<>(cls.getConstructor(argTypes));
		} catch (Exception e) {
			throw $(e);
		}
	}

	public ConstructorSup<T> constructor(A1FuncSup<Class<?>> argTypes) {
		List<Class<?>> typeList = new ArrayList<Class<?>>();
		argTypes.forEach(e -> {
			typeList.add(e);
		});
		return constructor(typeList.toArray(new Class[typeList.size()]));
	}

	public <F> FieldSupport<F, T> field(String name, Class<F> type) {
		net.cassite.style.ptr<Class<?>> clazz = ptr(cls);
		return new FieldSupport<F, T>(While(() -> $(clazz) != Object.class, () -> {
			try {
				return BreakWithResult(cls.getDeclaredField(name));
			} catch (NoSuchFieldException e) {
				$(clazz, $(clazz).getSuperclass());
				return Continue();
			}
		}), type, cls);
	}

	public List<FieldSupport<?, T>> allFields() {
		net.cassite.style.ptr<Class<?>> clazz = ptr(cls);
		return While(() -> $(clazz) != Object.class, (i) -> {
			List<FieldSupport<?, T>> list = avoidNull(i.lastRes, () -> new ArrayList<>());
			$($(clazz).getDeclaredFields()).forThose(e -> avoidNull($(list).forEach(t -> {
				if (e.getName().equals(t.name()))
					BreakWithResult(false);
				return true;
			}), () -> true), e -> {
				list.add(new FieldSupport<>(e, Object.class, cls));
			});
			$(clazz, $(clazz).getSuperclass());
			return list;
		});
	}

	public <R> MethodSupport<R, T> method(String name, Class<R> returnType) {
		return method(name, returnType, new Class[0]);
	}

	public <R> MethodSupport<R, T> method(String name, Class<R> returnType, Class<?>... argTypes) {
		net.cassite.style.ptr<Class<?>> clazz = ptr(cls);
		return new MethodSupport<R, T>(While(() -> $(clazz) != Object.class, () -> {
			try {
				return BreakWithResult(cls.getDeclaredMethod(name, argTypes));
			} catch (NoSuchMethodException e) {
				$(clazz, $(clazz).getSuperclass());
				return Continue();
			}
		}), returnType, cls);
	}

	public List<MethodSupport<?, T>> allMethods() {
		net.cassite.style.ptr<Class<?>> clazz = ptr(cls);
		return While(() -> $(clazz) != Object.class, (i) -> {
			List<MethodSupport<?, T>> list = avoidNull(i.lastRes, () -> new ArrayList<>());
			$($(clazz).getDeclaredMethods()).forThose(method -> avoidNull($(list).forEach(packed -> {
				if (method.getName().equals(packed.name())
						&& method.getParameterTypes().length == packed.argTypes().length
						&& avoidNull($(method.getParameterTypes()).forEach((ep, info) -> {
					if (!ep.equals(packed.argTypes()[info.currentIndex]))
						return BreakWithResult(false);
					return true;
				}), () -> false))
					BreakWithResult(false);
				return true;
			}), () -> true), e -> {
				list.add(new MethodSupport<>(e, Object.class, cls));
			});
			$(clazz, $(clazz).getSuperclass());
			return list;
		});
	}

	public String toString() {
		return cls.toString();
	}

	// modifiers

	public boolean isPublic() {
		return Modifier.isPublic(getCls().getModifiers());
	}

	public boolean isProtected() {
		return Modifier.isProtected(getCls().getModifiers());
	}

	public boolean isPrivate() {
		return Modifier.isPrivate(getCls().getModifiers());
	}

	public boolean isAbstract() {
		return Modifier.isAbstract(getCls().getModifiers());
	}

	public boolean isFinal() {
		return Modifier.isFinal(getCls().getModifiers());
	}

	public boolean isInterface() {
		return Modifier.isInterface(getCls().getModifiers());
	}

	public boolean isNative() {
		return Modifier.isNative(getCls().getModifiers());
	}

	public boolean isStatic() {
		return Modifier.isStatic(getCls().getModifiers());
	}

	public boolean isStrict() {
		return Modifier.isStrict(getCls().getModifiers());
	}

	public boolean isSynchronized() {
		return Modifier.isSynchronized(getCls().getModifiers());
	}

	public boolean isTransient() {
		return Modifier.isTransient(getCls().getModifiers());
	}

	public boolean isVolatile() {
		return Modifier.isVolatile(getCls().getModifiers());
	}

}
