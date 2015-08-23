package net.cassite.style.interfaces;

@FunctionalInterface
public interface RFunc1<R, T> {
	R apply(T t) throws Throwable;
}
