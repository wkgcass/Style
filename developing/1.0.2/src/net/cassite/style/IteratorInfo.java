package net.cassite.style;

public class IteratorInfo<R> extends LoopInfo<R> {
	public int previousIndex;
	public int nextIndex;
	public boolean hasPrevious;
	public boolean hasNext;

	IteratorInfo() {
	}

	IteratorInfo<R> setValues(int previousIndex, int nextIndex, boolean hasPrevious, boolean hasNext, int currentIndex,
			int effectiveIndex,
			R res) {
		this.previousIndex = previousIndex;
		this.nextIndex = nextIndex;
		this.hasPrevious = hasPrevious;
		this.hasNext = hasNext;
		return (IteratorInfo<R>) setValues(currentIndex, effectiveIndex, res);
	}
}