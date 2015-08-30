package net.cassite.style.control;

public class $Set extends IterationControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7380234014914054542L;
	private Object obj;

	public $Set(Object obj) {
		this.obj = obj;
	}

	@SuppressWarnings("unchecked")
	public <T> T getSet() {
		return (T) obj;
	}
}
