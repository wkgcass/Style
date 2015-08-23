package net.cassite.style;

import net.cassite.style.interfaces.RFunc1;

public interface A1ArrTransformer<R, T> extends var {
	default R[] via(RFunc1<R, T> method) {
		return via($(method));
	}

	R[] via(def<R> method);
}
