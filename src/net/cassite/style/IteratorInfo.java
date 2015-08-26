package net.cassite.style;

/**
 * Info about current Iterator.<br/>
 * It's a subclass of LoopInfo
 * 
 * @author wkgcass
 *
 * @param <R>
 *                last loop result type
 */
public class IteratorInfo<R> extends LoopInfo<R> {
        /**
         * previous index<br/>
         * usually currentIndex - 1
         */
        public int previousIndex;
        /**
         * next index<br/>
         * usually currentIndex + 1
         */
        public int nextIndex;
        /**
         * see if the iterator has previous elements
         */
        public boolean hasPrevious;
        /**
         * see if the iterator has more elements to iterate
         */
        public boolean hasNext;

        IteratorInfo() {
        }

        /**
         * set all fields of the Iterator Info
         * 
         * @param previousIndex
         * @param nextIndex
         * @param hasPrevious
         * @param hasNext
         * @param currentIndex
         * @param effectiveIndex
         *                the times 'last loop value' has been modified
         * @param res
         *                last loop result
         * @return <code>this</code>
         */
        IteratorInfo<R> setValues(int previousIndex, int nextIndex, boolean hasPrevious, boolean hasNext, int currentIndex, int effectiveIndex,
                        R res) {
                this.previousIndex = previousIndex;
                this.nextIndex = nextIndex;
                this.hasPrevious = hasPrevious;
                this.hasNext = hasNext;
                return (IteratorInfo<R>) setValues(currentIndex, effectiveIndex, res);
        }
}