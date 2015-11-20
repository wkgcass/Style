package net.cassite.style;

import net.cassite.style.interfaces.*;

/**
 * an object representing a function<br>
 *
 * @param <R> return type
 * @author wkgcass
 */
public class def<R> {
        private final int argCount;
        private final boolean hasReturnValue;

        public int argCount() {
                return argCount;
        }

        public boolean hasReturnValue() {
                return hasReturnValue;
        }

        private VFunc0 void0;
        private VFunc1<Object> void1;
        private VFunc2<Object, Object> void2;
        private VFunc3<Object, Object, Object> void3;
        private VFunc4<Object, Object, Object, Object> void4;
        private VFunc5<Object, Object, Object, Object, Object> void5;
        private VFunc6<Object, Object, Object, Object, Object, Object> void6;
        private VFunc7<Object, Object, Object, Object, Object, Object, Object> void7;

        private RFunc0<R> body0;
        private RFunc1<R, Object> body1;
        private RFunc2<R, Object, Object> body2;
        private RFunc3<R, Object, Object, Object> body3;
        private RFunc4<R, Object, Object, Object, Object> body4;
        private RFunc5<R, Object, Object, Object, Object, Object> body5;
        private RFunc6<R, Object, Object, Object, Object, Object, Object> body6;
        private RFunc7<R, Object, Object, Object, Object, Object, Object, Object> body7;

        def(VFunc0 body) {
                argCount = 0;
                this.void0 = body;
                this.hasReturnValue = false;
        }

        @SuppressWarnings("unchecked")
        def(VFunc1<?> body) {
                argCount = 1;
                this.void1 = (VFunc1<Object>) body;
                this.hasReturnValue = false;
        }

        @SuppressWarnings("unchecked")
        def(VFunc2<?, ?> body) {
                argCount = 2;
                this.void2 = (VFunc2<Object, Object>) body;
                this.hasReturnValue = false;
        }

        @SuppressWarnings("unchecked")
        def(VFunc3<?, ?, ?> body) {
                argCount = 3;
                this.void3 = (VFunc3<Object, Object, Object>) body;
                this.hasReturnValue = false;
        }

        @SuppressWarnings("unchecked")
        def(VFunc4<?, ?, ?, ?> body) {
                argCount = 4;
                this.void4 = (VFunc4<Object, Object, Object, Object>) body;
                this.hasReturnValue = false;
        }

        @SuppressWarnings("unchecked")
        def(VFunc5<?, ?, ?, ?, ?> body) {
                argCount = 5;
                this.void5 = (VFunc5<Object, Object, Object, Object, Object>) body;
                this.hasReturnValue = false;
        }

        @SuppressWarnings("unchecked")
        def(VFunc6<?, ?, ?, ?, ?, ?> body) {
                argCount = 6;
                this.void6 = (VFunc6<Object, Object, Object, Object, Object, Object>) body;
                this.hasReturnValue = false;
        }

        @SuppressWarnings("unchecked")
        def(VFunc7<?, ?, ?, ?, ?, ?, ?> body) {
                argCount = 7;
                this.void7 = (VFunc7<Object, Object, Object, Object, Object, Object, Object>) body;
                this.hasReturnValue = false;
        }

        def(RFunc0<R> body) {
                argCount = 0;
                this.body0 = body;
                this.hasReturnValue = true;
        }

        @SuppressWarnings("unchecked")
        def(RFunc1<R, ?> body) {
                argCount = 1;
                this.body1 = (RFunc1<R, Object>) body;
                this.hasReturnValue = true;
        }

        @SuppressWarnings("unchecked")
        def(RFunc2<R, ?, ?> body) {
                argCount = 2;
                this.body2 = (RFunc2<R, Object, Object>) body;
                this.hasReturnValue = true;
        }

        @SuppressWarnings("unchecked")
        def(RFunc3<R, ?, ?, ?> body) {
                argCount = 3;
                this.body3 = (RFunc3<R, Object, Object, Object>) body;
                this.hasReturnValue = true;
        }

        @SuppressWarnings("unchecked")
        def(RFunc4<R, ?, ?, ?, ?> body) {
                argCount = 4;
                this.body4 = (RFunc4<R, Object, Object, Object, Object>) body;
                this.hasReturnValue = true;
        }

        @SuppressWarnings("unchecked")
        def(RFunc5<R, ?, ?, ?, ?, ?> body) {
                argCount = 5;
                this.body5 = (RFunc5<R, Object, Object, Object, Object, Object>) body;
                this.hasReturnValue = true;
        }

        @SuppressWarnings("unchecked")
        def(RFunc6<R, ?, ?, ?, ?, ?, ?> body) {
                argCount = 6;
                this.body6 = (RFunc6<R, Object, Object, Object, Object, Object, Object>) body;
                this.hasReturnValue = true;
        }

        @SuppressWarnings("unchecked")
        def(RFunc7<R, ?, ?, ?, ?, ?, ?, ?> body) {
                argCount = 7;
                this.body7 = (RFunc7<R, Object, Object, Object, Object, Object, Object, Object>) body;
                this.hasReturnValue = true;
        }

        /**
         * invoke the supported function on current thread
         *
         * @param args args to fill the function.<br>
         *             arguments can be more or less than the function can
         *             take.<br>
         *             more then the more args would be ignored, less then
         *             the less args would be set to null
         * @return return value of the function
         */
        public R apply(Object... args) {
                try {
                        Object[] realArgs = new Object[argCount];
                        for (int i = 0; i < args.length && i < argCount; ++i) {
                                realArgs[i] = args[i];
                        }
                        for (int i = args.length; i < argCount; ++i) {
                                realArgs[i] = null;
                        }
                        if (argCount == 0) {
                                if (body0 == null) {
                                        void0.invoke();
                                        return null;
                                } else {
                                        return body0.apply();
                                }
                        } else if (argCount == 1) {
                                if (body1 == null) {
                                        void1.accept(realArgs[0]);
                                        return null;
                                } else {
                                        return body1.apply(realArgs[0]);
                                }
                        } else if (argCount == 2) {
                                if (body2 == null) {
                                        void2.accept(realArgs[0], realArgs[1]);
                                        return null;
                                } else {
                                        return body2.apply(realArgs[0], realArgs[1]);
                                }
                        } else if (argCount == 3) {
                                if (body3 == null) {
                                        void3.accept(realArgs[0], realArgs[1], realArgs[2]);
                                        return null;
                                } else {
                                        return body3.apply(realArgs[0], realArgs[1], realArgs[2]);
                                }
                        } else if (argCount == 4) {
                                if (body4 == null) {
                                        void4.accept(realArgs[0], realArgs[1], realArgs[2], realArgs[3]);
                                        return null;
                                } else {
                                        return body4.apply(realArgs[0], realArgs[1], realArgs[2], realArgs[3]);
                                }
                        } else if (argCount == 5) {
                                if (body5 == null) {
                                        void5.accept(realArgs[0], realArgs[1], realArgs[2], realArgs[3], realArgs[4]);
                                        return null;
                                } else {
                                        return body5.apply(realArgs[0], realArgs[1], realArgs[2], realArgs[3], realArgs[4]);
                                }
                        } else if (argCount == 6) {
                                if (body6 == null) {
                                        void6.accept(realArgs[0], realArgs[1], realArgs[2], realArgs[3], realArgs[4], realArgs[5]);
                                        return null;
                                } else {
                                        return body6.apply(realArgs[0], realArgs[1], realArgs[2], realArgs[3], realArgs[4], realArgs[5]);
                                }
                        } else if (argCount == 7) {
                                if (body7 == null) {
                                        void7.accept(realArgs[0], realArgs[1], realArgs[2], realArgs[3], realArgs[4], realArgs[5], realArgs[6]);
                                        return null;
                                } else {
                                        return body7.apply(realArgs[0], realArgs[1], realArgs[2], realArgs[3], realArgs[4], realArgs[5], realArgs[6]);
                                }
                        } else {
                                throw new IllegalArgumentException();
                        }
                } catch (Throwable t) {
                        throw Core.$(t);
                }
        }

        @SuppressWarnings("unchecked")
        public R applyCheckPrimitive(Class<?> primitive, Object... args) {
                R r = apply(args);
                if (null == r) {
                        if (primitive.equals(int.class) || primitive.equals(Integer.class)) {
                                return (R) new Integer(0);
                        } else if (primitive.equals(long.class) || primitive.equals(Long.class)) {
                                return (R) new Long(0);
                        } else if (primitive.equals(short.class) || primitive.equals(Short.class)) {
                                return (R) new Short((short) 0);
                        } else if (primitive.equals(float.class) || primitive.equals(Float.class)) {
                                return (R) new Float(0);
                        } else if (primitive.equals(double.class) || primitive.equals(Double.class)) {
                                return (R) new Double(0);
                        } else if (primitive.equals(boolean.class) || primitive.equals(Boolean.class)) {
                                return (R) Boolean.FALSE;
                        } else if (primitive.equals(byte.class) || primitive.equals(Byte.class)) {
                                return (R) new Byte((byte) 0);
                        } else if (primitive.equals(char.class) || primitive.equals(Character.class)) {
                                return (R) new Character((char) 0);
                        } else {
                                return r;
                        }
                } else {
                        return r;
                }
        }

        /**
         * invoke the supported function on a new thread
         *
         * @param args args to fill the function.<br>
         *             arguments can be more or less than the function can
         *             take.<br>
         *             more then the more args would be ignored, less then
         *             the less args would be set to null
         * @return an Async object representing the async call
         */
        public Async<R> async(Object... args) {
                return new Async<>(this, args);
        }
}
