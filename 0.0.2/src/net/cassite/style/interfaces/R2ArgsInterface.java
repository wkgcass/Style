package net.cassite.style.interfaces;

@FunctionalInterface
public interface R2ArgsInterface<R, T0, T1> {
	R apply(T0 arg0, T1 arg1) throws Throwable;
}