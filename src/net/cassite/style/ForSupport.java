package net.cassite.style;

import net.cassite.style.interfaces.*;

/**
 * Supporter for For-to-step expression
 * 
 * @author wkgcass
 *
 * @param <N>
 *                Start, End or Step number type
 */
public class ForSupport<N extends Number> extends Style {
        private N start;

        ForSupport(N start) {
                this.start = start;
        }

        /**
         * end value when checking to see if the loops should end
         * 
         * @param end
         *                the end number
         * @return ToSupport object
         */
        public ToSupport<N> to(N end) {
                return new ToSupport<>(start, end);
        }

        /**
         * Supporter for For-<b>to-step</b> expression
         * 
         * @author wkgcass
         *
         * @param <N>
         *                End or Step number type
         */
        public static class ToSupport<N extends Number> {
                private N start;
                private N end;
                private N step;

                ToSupport(N start, N end) {
                        this.start = start;
                        this.end = end;
                }

                /**
                 * set step
                 * 
                 * @param s
                 *                step value
                 * @return
                 */
                public ToSupport<N> step(N s) {
                        this.step = s;
                        return this;
                }

                /**
                 * start to do the loop<br>
                 * if start &lt; end, then step would be 1 as default.<br>
                 * if end &gt; start, then step would be -1 as default.
                 * 
                 * @param doLoop
                 *                the loop to take<br>
                 *                which takes in current cursor
                 * @return last loop result<br>
                 *         check
                 *         <a href="https://github.com/wkgcass/Style/">tutorial
                 *         </a> for more info about 'last loop result'.
                 * @see LoopInfo
                 */
                @SuppressWarnings("unchecked")
                public <R, T extends N> R loop(VFunc1<T> doLoop) {
                        return (R) loop($(doLoop));
                }

                /**
                 * start to do the loop<br>
                 * if start &lt; end, then step would be 1 as default.<br>
                 * if end &gt; start, then step would be -1 as default.
                 * 
                 * @param doLoop
                 *                the loop to take<br>
                 *                which takes in current cursor and returns
                 *                'last loop result'
                 * @return last loop result<br>
                 *         check
                 *         <a href="https://github.com/wkgcass/Style/">tutorial
                 *         </a> for more info about 'last loop result'.
                 * @see LoopInfo
                 */
                public <R, T extends N> R loop(RFunc1<R, T> doLoop) {
                        return loop($(doLoop));
                }

                /**
                 * start to do the loop<br>
                 * if start &lt; end, then step would be 1 as default.<br>
                 * if end &gt; start, then step would be -1 as default.
                 * 
                 * @param doLoop
                 *                the loop to take<br>
                 *                which takes in current cursor and LoopInfo
                 * @return last loop result<br>
                 *         check
                 *         <a href="https://github.com/wkgcass/Style/">tutorial
                 *         </a> for more info about 'last loop result'.
                 * @see LoopInfo
                 */
                @SuppressWarnings("unchecked")
                public <R, T extends N> R loop(VFunc2<T, LoopInfo<R>> doLoop) {
                        return (R) loop($(doLoop));
                }

                /**
                 * start to do the loop<br>
                 * if start &lt; end, then step would be 1 as default.<br>
                 * if end &gt; start, then step would be -1 as default.
                 * 
                 * @param doLoop
                 *                the loop to take<br>
                 *                which takes in current cursor and LoopInfo and
                 *                returns 'last loop result'
                 * @return last loop result<br>
                 *         check
                 *         <a href="https://github.com/wkgcass/Style/">tutorial
                 *         </a> for more info about 'last loop result'.
                 * @see LoopInfo
                 */
                public <R, T extends N> R loop(RFunc2<R, T, LoopInfo<R>> doLoop) {
                        return loop($(doLoop));
                }

                /**
                 * start to do the loop<br>
                 * if start &lt; end, then step would be 1 as default.<br>
                 * if end &gt; start, then step would be -1 as default.
                 * 
                 * @param doLoop
                 *                the loop to take<br>
                 *                which returns 'last loop result'
                 * @return last loop result<br>
                 *         check
                 *         <a href="https://github.com/wkgcass/Style/">tutorial
                 *         </a> for more info about 'last loop result'.
                 */
                @SuppressWarnings("unchecked")
                public <R> R loop(def<R> doLoop) {
                        if (start instanceof Integer) {
                                if (((Integer) start).compareTo((Integer) end) > 0) {
                                        if (null == step) {
                                                step = (N) new Integer(-1);
                                        }
                                        return For((Integer) start, i -> i.compareTo((Integer) end) >= 0, i -> i + (Integer) step, doLoop);
                                } else {
                                        if (null == step) {
                                                step = (N) new Integer(1);
                                        }
                                        return For((Integer) start, i -> i.compareTo((Integer) end) <= 0, i -> i + (Integer) step, doLoop);
                                }
                        } else if (start instanceof Double) {
                                if (((Double) start).compareTo((Double) end) > 0) {
                                        if (null == step) {
                                                step = (N) new Double(-1);
                                        }
                                        return For((Double) start, i -> i.compareTo((Double) end) >= 0, i -> i + (Double) step, doLoop);
                                } else {
                                        if (null == step) {
                                                step = (N) new Double(1);
                                        }
                                        return For((Double) start, i -> i.compareTo((Double) end) <= 0, i -> i + (Double) step, doLoop);
                                }
                        } else if (start instanceof Long) {
                                if (((Long) start).compareTo((Long) end) > 0) {
                                        if (null == step) {
                                                step = (N) new Long(-1);
                                        }
                                        return For((Long) start, i -> i.compareTo((Long) end) >= 0, i -> i + (Long) step, doLoop);
                                } else {
                                        if (null == step) {
                                                step = (N) new Long(1);
                                        }
                                        return For((Long) start, i -> i.compareTo((Long) end) <= 0, i -> i + (Long) step, doLoop);
                                }
                        } else if (start instanceof Short) {
                                if (((Short) start).compareTo((Short) end) > 0) {
                                        if (null == step) {
                                                step = (N) new Short((short) -1);
                                        }
                                        return For((Short) start, i -> i.compareTo((Short) end) >= 0,
                                                        i -> (short) (i.shortValue() + step.shortValue()), doLoop);
                                } else {
                                        if (null == step) {
                                                step = (N) new Short((short) 1);
                                        }
                                        return For((Short) start, i -> i.compareTo((Short) end) <= 0,
                                                        i -> (short) (i.shortValue() + step.shortValue()), doLoop);
                                }
                        } else if (start instanceof Float) {
                                if (((Float) start).compareTo((Float) end) > 0) {
                                        if (null == step) {
                                                step = (N) new Float(-1);
                                        }
                                        return For((Float) start, i -> i.compareTo((Float) end) >= 0, i -> i + (Float) step, doLoop);
                                } else {
                                        if (null == step) {
                                                step = (N) new Float(1);
                                        }
                                        return For((Float) start, i -> i.compareTo((Float) end) <= 0, i -> i + (Float) step, doLoop);
                                }
                        } else if (start instanceof Byte) {
                                if (((Byte) start).compareTo((Byte) end) > 0) {
                                        if (null == step) {
                                                step = (N) new Byte((byte) -1);
                                        }
                                        return For((Byte) start, i -> i.compareTo((Byte) end) >= 0, i -> (byte) (i.byteValue() + step.byteValue()),
                                                        doLoop);
                                } else {
                                        if (null == step) {
                                                step = (N) new Byte((byte) 1);
                                        }
                                        return For((Byte) start, i -> i.compareTo((Byte) end) <= 0, i -> (byte) (i.byteValue() + step.byteValue()),
                                                        doLoop);
                                }
                        } else {
                                throw new IllegalArgumentException();
                        }
                }
        }
}