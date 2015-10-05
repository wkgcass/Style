package net.cassite.style;

/**
 * Info about current Iterator.<br>
 * It's a subclass of LoopInfo
 * 
 * @author wkgcass
 *
 * @param <R>
 *                last loop result type
 */
public class LoopInfo<R> {
        /**
         * index of the iterator current position
         */
        public int currentIndex;
        /**
         * the times 'last loop result' was changed
         */
        public int effectiveIndex;
        /**
         * last loop result
         */
        public R lastRes;

        /**
         * set all fields of the loop info
         * 
         * @param currentIndex
         * @param effectiveIndex
         *                the times 'last loop value' has been modified
         * @param lastRes
         *                last loop result
         * @return <code>this</code>
         */
        public LoopInfo<R> setValues(int currentIndex, int effectiveIndex, R lastRes) {
                this.currentIndex = currentIndex;
                this.effectiveIndex = effectiveIndex;
                this.lastRes = lastRes;
                return this;
        }

        /**
         * set the last result to given value if it's <code>null</code><br>
         * it won't effect the last value of the loop.<br>
         * it's only a simplified way of reducing null value of lastRes.
         * 
         * @param init
         *                the initial value
         * @return the init value itself
         */
        public R initRes(R init) {
                if (lastRes == null) {
                        lastRes = init;
                }
                return init;
        }
}
