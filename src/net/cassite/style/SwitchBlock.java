package net.cassite.style;

import net.cassite.style.interfaces.RFunc0;
import net.cassite.style.interfaces.VFunc0;

/**
 * Supporter for switch expression<br>
 * Note that it doesn't support break, because it doesn't go through other cases
 * except the matched one.
 * 
 * @author wkgcass
 *
 * @param <T>
 *                type of the object to switch
 * @param <R>
 *                type of the return value of switch-expression
 */
public class SwitchBlock<T, R> extends Style {
        private final T toSwitch;
        private final def<Boolean> method;
        private R res;
        private boolean found = false;

        SwitchBlock(T t, def<Boolean> method) {
                this.toSwitch = t;
                this.method = method;
        }

        /**
         * add a Case block to the expression
         * 
         * @param ca
         *                the object for switch-expression to match
         * @param func
         *                function to apply when matches and return a result for
         *                expression to return
         * @return <code>this</code>
         */
        public SwitchBlock<T, R> Case(T ca, def<R> func) {
                if (!found) {
                        if (method.applyCheckPrimitive(boolean.class, toSwitch, ca)) {
                                res = func.apply();
                                found = true;
                        }
                }
                return this;
        }

        /**
         * add a Case block to the expression
         * 
         * @param ca
         *                the object for switch-expression to match
         * @param res
         *                an object for expression to return when matches.
         * @return <code>this</code>
         */
        public SwitchBlock<T, R> Case(T ca, R res) {
                return Case(ca, () -> res);
        }

        /**
         * add a Case block to the expression
         * 
         * @param ca
         *                the object for switch-expression to match
         * @param func
         *                function to apply when matches
         * @return <code>this</code>
         */
        @SuppressWarnings("unchecked")
        public SwitchBlock<T, R> Case(T ca, VFunc0 func) {
                return Case(ca, (def<R>) $(func));
        }

        /**
         * add a Case block to the expression
         * 
         * @param ca
         *                the object for switch-expression to match
         * @param func
         *                function to apply when matches and return a result for
         *                expression to return
         * @return <code>this</code>
         */
        public SwitchBlock<T, R> Case(T ca, RFunc0<R> func) {
                return Case(ca, (def<R>) $(func));
        }

        /**
         * set the default result for the switch-expression<br>
         * and execute the expression<br>
         * and return the result
         * 
         * @param func
         *                function to apply when all cases are not matched and
         *                return a result for expression to return
         * @return
         */
        public R Default(def<R> func) {
                if (found) {
                        return res;
                } else {
                        return func.apply();
                }
        }

        /**
         * set the default result for the switch-expression<br>
         * and execute the expression<br>
         * and return the result
         * 
         * @param func
         *                function to apply when all cases are not matched
         * @return
         */
        @SuppressWarnings("unchecked")
        public R Default(VFunc0 func) {
                return Default((def<R>) $(func));
        }

        /**
         * set the default result for the switch-expression<br>
         * and execute the expression<br>
         * and return the result
         * 
         * @param func
         *                function to apply when all cases are not matched and
         *                return a result for expression to return
         * @return
         */
        public R Default(RFunc0<R> func) {
                return Default((def<R>) $(func));
        }
}