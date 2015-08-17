package net.cassite.style.interfaces;

@FunctionalInterface
public interface RNArgsInterface<R> {
	R invoke(Object... args) throws Throwable;
}
