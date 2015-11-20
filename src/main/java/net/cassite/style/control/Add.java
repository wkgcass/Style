package net.cassite.style.control;

public class Add extends IterationControl {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1995758335331507814L;
	private Object obj;

	public Add(Object obj) {
		this.obj = obj;
	}

	@SuppressWarnings("unchecked")
	public <T> T getAdd() {
		return (T) obj;
	}
}
