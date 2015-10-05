package net.cassite.style;

import net.cassite.style.interfaces.RFunc0;
import net.cassite.style.interfaces.RFunc1;
import net.cassite.style.interfaces.VFunc0;
import net.cassite.style.interfaces.VFunc1;

import static net.cassite.style.Style.*;

/**
 * Supporter for if expression
 * 
 * @author wkgcass
 *
 * @param <T>
 *                return type of if expression
 * @param <INIT>
 *                type of condition of if expression
 */
public class IfBlock<T, INIT> {
        private def<T> body;
        private final boolean procceed;
        private T val;

        private INIT initVal;

        IfBlock(RFunc0<INIT> initVal, def<T> body) {
                try {
                        this.initVal = initVal.apply();
                } catch (Throwable e) {
                        throw $(e);
                }
                this.body = body;
                procceed = true;
        }

        private IfBlock(T val) {
                this.val = val;
                procceed = false;
        }

        /**
         * define the value to return if the condition is false or null<br>
         * and execute if expression
         * 
         * @param value
         *                the value to return
         * @return if-expression result
         */
        public T Else(T value) {
                return Else(() -> value);
        }

        /**
         * define the function to apply if the condition is false or null<br>
         * and execute if expression
         * 
         * @param func
         *                function to invoke
         * @return if-expression result
         */
        @SuppressWarnings("unchecked")
        public T Else(VFunc0 func) {
                return Else((def<T>) $(func));
        }

        /**
         * define the function of whose result is to return if the condition is
         * false or null<br>
         * and execute if expression
         * 
         * @param func
         *                function to invoke with result
         * @return if-expression result
         */
        public T Else(RFunc0<T> func) {
                return Else($(func));
        }

        /**
         * define the function of whose result is to return if the condition is
         * false or null<br>
         * and execute if expression
         * 
         * @param func
         *                function to invoke with result
         * @return if-expression result
         */
        public T Else(def<T> func) {
                if (procceed)
                        if (initVal != null && !initVal.equals(false)) {
                                return body.apply(initVal);
                        } else {
                                return func.apply();
                        }
                else
                        return this.val;
        }

        /**
         * define an ElseIf block.<br>
         * 
         * @param init
         *                an object or boolean value, init==null ||
         *                init.equals(false) will be considered <b>false</b> in
         *                traditional if expression. in other cases, considered
         *                true
         * @param val
         *                return val if init is considered true
         * @return <code>this</code>
         */
        public IfBlock<T, INIT> ElseIf(INIT init, T val) {
                return ElseIf(() -> init, () -> val);
        }

        /**
         * define an ElseIf block.<br>
         * 
         * @param init
         *                an object or boolean value, init==null ||
         *                init.equals(false) will be considered <b>false</b> in
         *                traditional if expression. in other cases, considered
         *                true
         * @param body
         *                takes in INIT value, and return null if init is
         *                considered true
         * @return <code>this</code>
         */
        @SuppressWarnings("unchecked")
        public IfBlock<T, INIT> ElseIf(INIT init, VFunc1<INIT> body) {
                return ElseIf(() -> init, (def<T>) $(body));
        }

        /**
         * define an ElseIf block.<br>
         * 
         * @param init
         *                an object or boolean value, init==null ||
         *                init.equals(false) will be considered <b>false</b> in
         *                traditional if expression. in other cases, considered
         *                true
         * @param body
         *                takes in INIT value, and return body's return value if
         *                init is considered true
         * @return
         */
        public IfBlock<T, INIT> ElseIf(INIT init, RFunc1<T, INIT> body) {
                return ElseIf(() -> init, $(body));
        }

        /**
         * define an ElseIf block.<br>
         * 
         * @param init
         *                an object or boolean value, init==null ||
         *                init.equals(false) will be considered <b>false</b> in
         *                traditional if expression. in other cases, considered
         *                true
         * @param body
         *                return null if init is considered true
         * @return
         */
        @SuppressWarnings("unchecked")
        public IfBlock<T, INIT> ElseIf(INIT init, VFunc0 body) {
                return ElseIf(() -> init, (def<T>) $(body));
        }

        /**
         * define an ElseIf block.<br>
         * 
         * @param init
         *                an object or boolean value, init==null ||
         *                init.equals(false) will be considered <b>false</b> in
         *                traditional if expression. in other cases, considered
         *                true
         * @param body
         *                return body's return value if init is considered true
         * @return
         */
        public IfBlock<T, INIT> ElseIf(INIT init, RFunc0<T> body) {
                return ElseIf(() -> init, $(body));
        }

        /**
         * define an ElseIf block.<br>
         * 
         * @param init
         *                lambda expression returns an object or boolean value,
         *                init==null || init.equals(false) will be considered
         *                <b>false</b> in traditional if expression. in other
         *                cases, considered true
         * @param val
         *                return val if init is considered true
         * @return
         */
        public IfBlock<T, INIT> ElseIf(RFunc0<INIT> init, T val) {
                return ElseIf(init, () -> val);
        }

        /**
         * define an ElseIf block.<br>
         * 
         * @param init
         *                lambda expression returns an object or boolean value,
         *                init==null || init.equals(false) will be considered
         *                <b>false</b> in traditional if expression. in other
         *                cases, considered true
         * @param body
         *                takes in INIT value, and return null if init is
         *                considered true
         * @return
         */
        @SuppressWarnings("unchecked")
        public IfBlock<T, INIT> ElseIf(RFunc0<INIT> init, VFunc1<INIT> body) {
                return ElseIf(init, (def<T>) $(body));
        }

        /**
         * define an ElseIf block.<br>
         * 
         * @param init
         *                lambda expression returns an object or boolean value,
         *                init==null || init.equals(false) will be considered
         *                <b>false</b> in traditional if expression. in other
         *                cases, considered true
         * @param body
         *                takes in INIT value, and return body's return value if
         *                init is considered true
         * @return
         */
        public IfBlock<T, INIT> ElseIf(RFunc0<INIT> init, RFunc1<T, INIT> body) {
                return ElseIf(init, $(body));
        }

        /**
         * define an ElseIf block.<br>
         * 
         * @param init
         *                lambda expression returns an object or boolean value,
         *                init==null || init.equals(false) will be considered
         *                <b>false</b> in traditional if expression. in other
         *                cases, considered true
         * @param body
         *                return null if init is considered true
         * @return
         */
        @SuppressWarnings("unchecked")
        public IfBlock<T, INIT> ElseIf(RFunc0<INIT> init, VFunc0 body) {
                return ElseIf(init, (def<T>) $(body));
        }

        /**
         * define an ElseIf block.<br>
         * 
         * @param init
         *                lambda expression returns an object or boolean value,
         *                init==null || init.equals(false) will be considered
         *                <b>false</b> in traditional if expression. in other
         *                cases, considered true
         * @param body
         *                return body's return value if init is considered true
         * @return
         */
        public IfBlock<T, INIT> ElseIf(RFunc0<INIT> init, RFunc0<T> body) {
                return ElseIf(init, $(body));
        }

        /**
         * define an ElseIf block.<br>
         * 
         * @param init
         *                lambda expression returns an object or boolean value,
         *                init==null || init.equals(false) will be considered
         *                <b>false</b> in traditional if expression. in other
         *                cases, considered true
         * @param body
         *                return body's return value if init is considered true
         * @return
         */
        public IfBlock<T, INIT> ElseIf(RFunc0<INIT> init, def<T> body) {
                if (procceed)
                        if (initVal != null && !initVal.equals(false)) {
                                return new IfBlock<T, INIT>(this.body.apply(initVal));
                        } else {
                                return new IfBlock<T, INIT>(init, body);
                        }
                else
                        return new IfBlock<T, INIT>(this.val);
        }

        /**
         * execute the if expression without an Else block
         * 
         * @return if-expression result
         */
        public T End() {
                if (procceed)
                        if (initVal != null && !initVal.equals(false)) {
                                return body.apply(initVal);
                        } else {
                                return null;
                        }
                else
                        return this.val;
        }

}