package net.cassite.style.control;

public class Return extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7162296671000189405L;
	private Object res;

	public Return(Object res) {
		this.res = res;
	}

	public Object getRes() {
		return res;
	}
}
