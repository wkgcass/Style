package net.cassite.style;

public class LoopInfo<R> {
	public int currentIndex;
	public int effectiveIndex;
	public R lastRes;

	public LoopInfo<R> setValues(int currentIndex, int effectiveIndex, R lastRes) {
		this.currentIndex = currentIndex;
		this.effectiveIndex = effectiveIndex;
		this.lastRes = lastRes;
		return this;
	}
}
