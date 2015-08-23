package net.cassite.style;

import java.util.Collection;

import net.cassite.style.interfaces.RFunc1;

public interface A1Transformer<R, T, Coll extends Collection<R>> extends var {
	default Coll via(RFunc1<R, T> method) {
		return via($(method));
	}

	Coll via(def<R> method);
}
