package net.cassite.style.reflect;

import net.cassite.style.Style;

public class ProxyHandler<T> extends Style {
	public T toProxy;

	public ProxyHandler(T toProxy) {
		this.toProxy = toProxy;
	}
}
