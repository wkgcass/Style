package net.cassite.style.reflect;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public interface MemberSup<T extends Member> {
	T getMember();

	default boolean isPublic() {
		return Modifier.isPublic(getMember().getModifiers());
	}

	default boolean isProtected() {
		return Modifier.isProtected(getMember().getModifiers());
	}

	default boolean isPrivate() {
		return Modifier.isPrivate(getMember().getModifiers());
	}

	default boolean isAbstract() {
		return Modifier.isAbstract(getMember().getModifiers());
	}

	default boolean isFinal() {
		return Modifier.isFinal(getMember().getModifiers());
	}

	default boolean isInterface() {
		return Modifier.isInterface(getMember().getModifiers());
	}

	default boolean isNative() {
		return Modifier.isNative(getMember().getModifiers());
	}

	default boolean isStatic() {
		return Modifier.isStatic(getMember().getModifiers());
	}

	default boolean isStrict() {
		return Modifier.isStrict(getMember().getModifiers());
	}

	default boolean isSynchronized() {
		return Modifier.isSynchronized(getMember().getModifiers());
	}

	default boolean isTransient() {
		return Modifier.isTransient(getMember().getModifiers());
	}

	default boolean isVolatile() {
		return Modifier.isVolatile(getMember().getModifiers());
	}
}
