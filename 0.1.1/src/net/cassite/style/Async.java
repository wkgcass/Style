package net.cassite.style;

import net.cassite.style.Supportters.StyleRuntimeException;
import net.cassite.style.interfaces.Void1ArgInterface;

public class Async<R> {
	private Container<R> container;
	private Thread t;

	private StyleRuntimeException throwable = null;
	private def<Object> handler = null;
	private Object lock = new Object();

	private boolean hasHandler = false;

	private static class Container<R> {
		R ret = null;
		boolean inProcess = false;

		Container() {
		}
	}

	private class AsyncRunnable<T> implements Runnable {
		private final Container<T> container;
		private final def<T> func;
		private final Object[] args;

		AsyncRunnable(Container<T> container, def<T> func, Object... args) {
			this.container = container;
			this.func = func;
			this.args = args;
		}

		@Override
		public void run() {
			synchronized (container) {
				container.inProcess = true;
				try {
					container.ret = func.apply(args);
				} catch (Throwable t) {
					synchronized (lock) {
						throwable = Style.$(t);
						if (handler != null) {
							handler.apply(Style.$(throwable));
						}
					}
				}
			}
		}
	}

	Async(def<R> func, Object... args) {
		this.container = new Container<R>();
		t = new Thread(new AsyncRunnable<R>(container, func, args));
		t.start();
	}

	public R await() {
		while (!container.inProcess) {
			// block
		}
		synchronized (container) {
			return container.ret;
		}
	}

	public Thread getThread() {
		return t;
	}

	public void onError(Void1ArgInterface<StyleRuntimeException> handler) {
		onError(Style.$(handler));
	}

	public void onError(def<Object> handler) {
		hasHandler = true;
		synchronized (lock) {
			this.handler = handler;
			if (null != throwable) {
				handler.apply(Style.$(throwable));
			}
		}
	}

	public void awaitError(Void1ArgInterface<StyleRuntimeException> handler) {
		awaitError(Style.$(handler));
	}

	public void awaitError(def<Object> handler) {
		while (!container.inProcess) {
			// block
		}
		synchronized (container) {
			if (null != throwable) {
				handler.apply(Style.$(throwable));
			}
		}
	}

	public boolean hasErrHandler() {
		return hasHandler;
	}

	public StyleRuntimeException getErr() {
		return throwable;
	}
}