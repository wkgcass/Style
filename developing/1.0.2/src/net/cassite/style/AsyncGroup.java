package net.cassite.style;

import java.util.Arrays;

import net.cassite.style.interfaces.*;

public class AsyncGroup {
	private Async<?>[] group;

	private StyleRuntimeException err;
	private def<Object> handler;
	private Object lock = new Object();

	AsyncGroup(def<Object> asyncHandler, Async<?>... group) {
		if (group.length == 0)
			throw new IllegalArgumentException("at least one Async object should be passed in");
		this.group = Arrays.copyOf(group, group.length);
		if (null != asyncHandler) {
			for (Async<?> a : group) {
				if (!a.hasErrHandler()) {
					a.onError(asyncHandler);
				}
			}
		}
	}

	public AsyncGroup callback(VFunc0 func) {
		return callback(Style.$(func));
	}

	public AsyncGroup callback(VFunc1<?> func) {
		return callback(Style.$(func));
	}

	public AsyncGroup callback(VFunc2<?, ?> func) {
		return callback(Style.$(func));
	}

	public AsyncGroup callback(VFunc3<?, ?, ?> func) {
		return callback(Style.$(func));
	}

	public AsyncGroup callback(VFunc4<?, ?, ?, ?> func) {
		return callback(Style.$(func));
	}

	public AsyncGroup callback(VFunc5<?, ?, ?, ?, ?> func) {
		return callback(Style.$(func));
	}

	public AsyncGroup callback(VFunc6<?, ?, ?, ?, ?, ?> func) {
		return callback(Style.$(func));
	}

	public AsyncGroup callback(VFunc7<?, ?, ?, ?, ?, ?, ?> func) {
		return callback(Style.$(func));
	}

	public AsyncGroup callback(def<Object> func) {
		Style.run(() -> {
			callbackSync(func);
		});
		return this;
	}

	public AsyncGroup callbackSync(VFunc0 func) {
		return callbackSync(Style.$(func));
	}

	public AsyncGroup callbackSync(VFunc1<?> func) {
		return callbackSync(Style.$(func));
	}

	public AsyncGroup callbackSync(VFunc2<?, ?> func) {
		return callbackSync(Style.$(func));
	}

	public AsyncGroup callbackSync(VFunc3<?, ?, ?> func) {
		return callbackSync(Style.$(func));
	}

	public AsyncGroup callbackSync(VFunc4<?, ?, ?, ?> func) {
		return callbackSync(Style.$(func));
	}

	public AsyncGroup callbackSync(VFunc5<?, ?, ?, ?, ?> func) {
		return callbackSync(Style.$(func));
	}

	public AsyncGroup callbackSync(VFunc6<?, ?, ?, ?, ?, ?> func) {
		return callbackSync(Style.$(func));
	}

	public AsyncGroup callbackSync(VFunc7<?, ?, ?, ?, ?, ?, ?> func) {
		return callbackSync(Style.$(func));
	}

	public AsyncGroup callbackSync(def<Object> func) {
		try {
			Object[] awaits = new Object[group.length];
			int i = 0;
			for (Async<?> async : group) {
				awaits[i] = async.await();
				++i;
			}
			func.apply(awaits);
		} catch (Throwable e) {
			synchronized (lock) {
				err = Style.$(e);
				if (handler != null) {
					handler.apply(err);
				}
			}
		}
		return this;
	}

	public void onError(VFunc1<StyleRuntimeException> handler) {
		onError(Style.$(handler));
	}

	public void onError(def<Object> handler) {
		synchronized (lock) {
			this.handler = handler;
			if (err != null) {
				handler.apply(err);
			}
		}
	}

	public StyleRuntimeException getErr() {
		return err;
	}
}