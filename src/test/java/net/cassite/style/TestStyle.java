package net.cassite.style;

import static net.cassite.style.Style.*;
import static net.cassite.style.aggregation.Aggregation.*;
import static net.cassite.style.reflect.Reflect.*;
import static net.cassite.style.util.Utils.*;
import static org.junit.Assert.*;

import net.cassite.style.control.Break;
import net.cassite.style.control.BreakWithResult;
import net.cassite.style.interfaces.RFunc0;
import net.cassite.style.interfaces.VFunc1;
import net.cassite.style.reflect.*;
import net.cassite.style.reflect.readonly.ModifyReadOnlyException;
import net.cassite.style.tuple.*;
import net.cassite.style.util.PathMapper;
import net.cassite.style.util.lang.MInteger;
import org.junit.Test;

import java.math.BigInteger;
import java.util.*;

/**
 * test style
 */
public class TestStyle {
        final Object oo1 = new Object();
        final Object oo2 = new Object();
        final Object oo3 = new Object();
        final Object oo4 = new Object();
        final Object oo5 = new Object();
        final Object oo6 = new Object();
        final Object oo7 = new Object();

        @Test
        public void testFunctionDefinitionUsing$() {
                def<Void> vfunc3 = $((def<?> function, Boolean hasReturnVal, Integer count) -> {
                        assertEquals((int) count, function.argCount());
                        assertEquals(hasReturnVal, function.hasReturnValue());
                });
                assertEquals(3, vfunc3.argCount());
                assertEquals(false, vfunc3.hasReturnValue());
                assertNotNull(vfunc3.void3);

                def<Void> vfunc0 = $(() -> {
                });
                vfunc3.apply(vfunc0, false, 0);
                assertNotNull(vfunc0.void0);

                def<Void> vfunc1 = $((Object o) -> {
                });
                vfunc3.apply(vfunc1, false, 1);
                assertNotNull(vfunc1.void1);
                assertNull(vfunc1.apply(oo1));

                def<Void> vfunc2 = $((Object o1, Object o2) -> {
                });
                vfunc3.apply(vfunc2, false, 2);
                assertNotNull(vfunc2.void2);
                assertNull(vfunc2.apply(oo1, oo2));

                def<Void> vfunc4 = $((Object o1, Object o2, Object o3, Object o4) -> {
                });
                vfunc3.apply(vfunc4, false, 4);
                assertNotNull(vfunc4.void4);
                assertNull(vfunc1.apply(oo1, oo2, oo3, oo4));

                def<Void> vfunc5 = $((Object o1, Object o2, Object o3, Object o4, Object o5) -> {
                });
                vfunc3.apply(vfunc5, false, 5);
                assertNotNull(vfunc5.void5);
                assertNull(vfunc1.apply(oo1, oo2, oo3, oo4, oo5));

                def<Void> vfunc6 = $((Object o1, Object o2, Object o3, Object o4, Object o5, Object o6) -> {
                });
                vfunc3.apply(vfunc6, false, 6);
                assertNotNull(vfunc6.void6);
                assertNull(vfunc1.apply(oo1, oo2, oo3, oo4, oo5, oo6));

                def<Void> vfunc7 = $((Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7) -> {
                });
                vfunc3.apply(vfunc7, false, 7);
                assertNotNull(vfunc7.void7);
                assertNull(vfunc1.apply(oo1, oo2, oo3, oo4, oo5, oo6, oo7));

                def<Object> rfunc0 = $(Object::new);
                vfunc3.apply(rfunc0, true, 0);
                assertNotNull(rfunc0.body0);
                assertTrue(rfunc0.apply().getClass().equals(Object.class));

                def<Object> rfunc1 = $((Object o) -> o);
                vfunc3.apply(rfunc1, true, 1);
                assertNotNull(rfunc1.body1);
                assertEquals(oo1, rfunc1.apply(oo1));

                def<Object> rfunc2 = $((Object o1, Object o2) -> o2);
                vfunc3.apply(rfunc2, true, 2);
                assertNotNull(rfunc2.body2);
                assertEquals(oo2, rfunc2.apply(oo1, oo2));

                def<Object> rfunc3 = $((Object o1, Object o2, Object o3) -> o3);
                vfunc3.apply(rfunc3, true, 3);
                assertNotNull(rfunc3.body3);
                assertEquals(oo3, rfunc3.apply(oo1, oo2, oo3));

                def<Object> rfunc4 = $((Object o1, Object o2, Object o3, Object o4) -> o4);
                vfunc3.apply(rfunc4, true, 4);
                assertNotNull(rfunc4.body4);
                assertEquals(oo4, rfunc4.apply(oo1, oo2, oo3, oo4));

                def<Object> rfunc5 = $((Object o1, Object o2, Object o3, Object o4, Object o5) -> o5);
                vfunc3.apply(rfunc5, true, 5);
                assertNotNull(rfunc5.body5);
                assertEquals(oo5, rfunc5.apply(oo1, oo2, oo3, oo4, oo5));

                def<Object> rfunc6 = $((Object o1, Object o2, Object o3, Object o4, Object o5, Object o6) -> o6);
                vfunc3.apply(rfunc6, true, 6);
                assertNotNull(rfunc6.body6);
                assertEquals(oo6, rfunc6.apply(oo1, oo2, oo3, oo4, oo5, oo6));

                def<Object> rfunc7 = $((Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7) -> o7);
                vfunc3.apply(rfunc7, true, 7);
                assertNotNull(rfunc7.body7);
                assertEquals(oo7, rfunc7.apply(oo1, oo2, oo3, oo4, oo5, oo6, oo7));
        }

        @Test
        public void testFunctionDefinitionUsingFunction() {
                def<Void> vfunc3 = function((def<?> function, Boolean hasReturnVal, Integer count) -> {
                        assertEquals((int) count, function.argCount());
                        assertEquals(hasReturnVal, function.hasReturnValue());
                });
                assertEquals(3, vfunc3.argCount());
                assertEquals(false, vfunc3.hasReturnValue());
                assertNotNull(vfunc3.void3);

                def<Void> vfunc0 = function(() -> {
                });
                vfunc3.apply(vfunc0, false, 0);
                assertNotNull(vfunc0.void0);

                def<Void> vfunc1 = function((Object o) -> {
                });
                vfunc3.apply(vfunc1, false, 1);
                assertNotNull(vfunc1.void1);
                assertNull(vfunc1.apply(oo1));

                def<Void> vfunc2 = function((Object o1, Object o2) -> {
                });
                vfunc3.apply(vfunc2, false, 2);
                assertNotNull(vfunc2.void2);
                assertNull(vfunc2.apply(oo1, oo2));

                def<Void> vfunc4 = function((Object o1, Object o2, Object o3, Object o4) -> {
                });
                vfunc3.apply(vfunc4, false, 4);
                assertNotNull(vfunc4.void4);
                assertNull(vfunc1.apply(oo1, oo2, oo3, oo4));

                def<Void> vfunc5 = function((Object o1, Object o2, Object o3, Object o4, Object o5) -> {
                });
                vfunc3.apply(vfunc5, false, 5);
                assertNotNull(vfunc5.void5);
                assertNull(vfunc1.apply(oo1, oo2, oo3, oo4, oo5));

                def<Void> vfunc6 = function((Object o1, Object o2, Object o3, Object o4, Object o5, Object o6) -> {
                });
                vfunc3.apply(vfunc6, false, 6);
                assertNotNull(vfunc6.void6);
                assertNull(vfunc1.apply(oo1, oo2, oo3, oo4, oo5, oo6));

                def<Void> vfunc7 = function((Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7) -> {
                });
                vfunc3.apply(vfunc7, false, 7);
                assertNotNull(vfunc7.void7);
                assertNull(vfunc1.apply(oo1, oo2, oo3, oo4, oo5, oo6, oo7));

                def<Object> rfunc0 = function(Object::new);
                vfunc3.apply(rfunc0, true, 0);
                assertNotNull(rfunc0.body0);
                assertTrue(rfunc0.apply().getClass().equals(Object.class));

                def<Object> rfunc1 = function((Object o) -> o);
                vfunc3.apply(rfunc1, true, 1);
                assertNotNull(rfunc1.body1);
                assertEquals(oo1, rfunc1.apply(oo1));

                def<Object> rfunc2 = function((Object o1, Object o2) -> o2);
                vfunc3.apply(rfunc2, true, 2);
                assertNotNull(rfunc2.body2);
                assertEquals(oo2, rfunc2.apply(oo1, oo2));

                def<Object> rfunc3 = function((Object o1, Object o2, Object o3) -> o3);
                vfunc3.apply(rfunc3, true, 3);
                assertNotNull(rfunc3.body3);
                assertEquals(oo3, rfunc3.apply(oo1, oo2, oo3));

                def<Object> rfunc4 = function((Object o1, Object o2, Object o3, Object o4) -> o4);
                vfunc3.apply(rfunc4, true, 4);
                assertNotNull(rfunc4.body4);
                assertEquals(oo4, rfunc4.apply(oo1, oo2, oo3, oo4));

                def<Object> rfunc5 = function((Object o1, Object o2, Object o3, Object o4, Object o5) -> o5);
                vfunc3.apply(rfunc5, true, 5);
                assertNotNull(rfunc5.body5);
                assertEquals(oo5, rfunc5.apply(oo1, oo2, oo3, oo4, oo5));

                def<Object> rfunc6 = function((Object o1, Object o2, Object o3, Object o4, Object o5, Object o6) -> o6);
                vfunc3.apply(rfunc6, true, 6);
                assertNotNull(rfunc6.body6);
                assertEquals(oo6, rfunc6.apply(oo1, oo2, oo3, oo4, oo5, oo6));

                def<Object> rfunc7 = function((Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7) -> o7);
                vfunc3.apply(rfunc7, true, 7);
                assertNotNull(rfunc7.body7);
                assertEquals(oo7, rfunc7.apply(oo1, oo2, oo3, oo4, oo5, oo6, oo7));
        }

        @Test
        public void testFunctionTakeMoreArgs() {
                def<Object> rfunc3 = function((Object o1, Object o2, Object o3) -> o3);
                assertEquals(oo3, rfunc3.apply(oo1, oo2, oo3, oo4));
        }

        @Test
        public void testFunctionTakeLessArgs() {
                def<Object> rfunc3 = function((Object o1, Object o2, Object o3) -> o3);
                assertNull(rfunc3.apply(oo1, oo2));
        }

        @Test
        @SuppressWarnings("unchecked")
        public void testFunctionNullAutoUnboxing() {
                RFunc0<?> rFunc0 = () -> null;
                def<Boolean> boolFunc = function((RFunc0<Boolean>) rFunc0);
                def<Integer> intFunc = function((RFunc0<Integer>) rFunc0);
                def<Long> longFunc = function((RFunc0<Long>) rFunc0);
                def<Double> doubleFunc = function((RFunc0<Double>) rFunc0);
                def<Short> shortFunc = function((RFunc0<Short>) rFunc0);
                def<Byte> byteFunc = function((RFunc0<Byte>) rFunc0);
                def<Character> charFunc = function((RFunc0<Character>) rFunc0);
                def<Float> floatFunc = function((RFunc0<Float>) rFunc0);
                try {
                        assertEquals(false, boolFunc.applyCheckPrimitive(boolean.class));
                        assertEquals(0, (int) intFunc.applyCheckPrimitive(int.class));
                        assertEquals(0, (long) longFunc.applyCheckPrimitive(long.class));
                        assertEquals(0, doubleFunc.applyCheckPrimitive(double.class), 0);
                        assertEquals(0, (short) shortFunc.applyCheckPrimitive(short.class));
                        assertEquals(0, (byte) byteFunc.applyCheckPrimitive(byte.class));
                        assertEquals(0, (char) charFunc.applyCheckPrimitive(char.class));
                        assertEquals(0, floatFunc.applyCheckPrimitive(float.class), 0);
                } catch (NullPointerException e) {
                        fail();
                }
        }

        @Test
        public void testAsync() {
                Thread t = Thread.currentThread();
                def<Object> vfunc0 = function(() -> {
                        Thread tInFunc = Thread.currentThread();
                        assertNotEquals(t, tInFunc);
                        return oo1;
                });
                Async<Object> async = vfunc0.async();
                assertEquals(oo1, await(async));
        }

        @Test
        public void testAsyncError() throws InterruptedException {
                Thread t = Thread.currentThread();
                def<Object> vfunc0 = function(() -> {
                        Thread tInFunc = Thread.currentThread();
                        assertNotEquals(t, tInFunc);
                        throw new Exception();
                });
                Async<Object> async = vfunc0.async();
                assertTrue(!async.hasErrHandler());
                sleep(10);
                assertTrue(async.getErr().origin().getClass().equals(Exception.class));
        }

        @Test
        public void testAsyncErrorAwait() throws InterruptedException {
                Thread t = Thread.currentThread();
                def<Object> vfunc0 = function(() -> {
                        Thread tInFunc = Thread.currentThread();
                        assertNotEquals(t, tInFunc);
                        throw new Exception();
                });
                Async<Object> async = vfunc0.async();
                sleep(10);
                async.awaitError((e) -> {
                        assertEquals(t, Thread.currentThread());
                        assertTrue(e.origin().getClass().equals(Exception.class));
                });
                assertTrue(!async.hasErrHandler());
        }

        @Test
        public void testAsyncErrorCallbackOnCurrentThread() throws InterruptedException {
                Thread t = Thread.currentThread();
                def<Object> vfunc0 = function(() -> {
                        Thread tInFunc = Thread.currentThread();
                        assertNotEquals(t, tInFunc);
                        throw new Exception();
                });
                Async<Object> async = vfunc0.async();
                sleep(10);
                async.onError((e) -> {
                        assertEquals(t, Thread.currentThread());
                        assertTrue(e.origin().getClass().equals(Exception.class));
                });
                assertTrue(async.hasErrHandler());
        }

        @Test
        public void testAsyncErrorCallbackOnRunningThread() throws InterruptedException {
                ptr<Thread> ptr = ptr(null);
                def<Object> vfunc0 = function(() -> {
                        Thread tInFunc = Thread.currentThread();
                        $(ptr, tInFunc);
                        sleep(100);
                        throw new Exception();
                });
                Async<Object> async = vfunc0.async();
                async.onError((e) -> {
                        assertEquals($(ptr), Thread.currentThread());
                        assertTrue(e.origin().getClass().equals(Exception.class));
                });
                assertTrue(async.hasErrHandler());
                sleep(110);
                assertEquals(async.getThread(), $(ptr));
        }

        @Test
        public void testPtr() {
                ptr<String> p = ptr("1234");
                assertEquals("1234", p.item);
                assertTrue(p.equals("1234"));
        }

        @Test
        public void testImp() {
                User user = imp("cass,20", User.class);

                assertEquals("cass", user.getName());
                assertEquals(20, user.getAge());
                assertEquals("cass,20", imp(user, String.class));
        }

        @Test
        public void testTupleWithField() {
                def func = $((Tuple tuple, Integer count) -> {
                        assertEquals((int) count, tuple.count());
                });
                Tuple1<Boolean> tuple1 = tuple(true);
                assertEquals(true, tuple1._1);
                func.apply(tuple1, 1);

                Tuple2<Boolean, Integer> tuple2 = tuple(true, 1);
                assertEquals(true, tuple2._1);
                assertEquals(1, (int) tuple2._2);
                func.apply(tuple2, 2);

                Tuple3<Boolean, Integer, Long> tuple3 = tuple(true, 1, 2L);
                assertEquals(true, tuple3._1);
                assertEquals(1, (int) tuple3._2);
                assertEquals(2L, (long) tuple3._3);
                func.apply(tuple3, 3);

                Tuple4<Boolean, Integer, Long, Double> tuple4 = tuple(true, 1, 2L, 3.0);
                assertEquals(true, tuple4._1);
                assertEquals(1, (int) tuple4._2);
                assertEquals(2L, (long) tuple4._3);
                assertEquals(3.0, tuple4._4, 0);
                func.apply(tuple4, 4);

                Tuple5<Boolean, Integer, Long, Double, Float> tuple5 = tuple(true, 1, 2L, 3.0, 4f);
                assertEquals(true, tuple5._1);
                assertEquals(1, (int) tuple5._2);
                assertEquals(2L, (long) tuple5._3);
                assertEquals(3.0, tuple5._4, 0);
                assertEquals(4f, tuple5._5, 0);
                func.apply(tuple5, 5);

                Tuple6<Boolean, Integer, Long, Double, Float, Byte> tuple6 = tuple(true, 1, 2L, 3.0, 4f, (byte) 5);
                assertEquals(true, tuple6._1);
                assertEquals(1, (int) tuple6._2);
                assertEquals(2L, (long) tuple6._3);
                assertEquals(3.0, tuple6._4, 0);
                assertEquals(4f, tuple6._5, 0);
                assertEquals((byte) 5, (byte) tuple6._6);
                func.apply(tuple6, 6);

                Tuple7<Boolean, Integer, Long, Double, Float, Byte, Short> tuple7 = tuple(true, 1, 2L, 3.0, 4f, (byte) 5, (short) 6);
                assertEquals(true, tuple7._1);
                assertEquals(1, (int) tuple7._2);
                assertEquals(2L, (long) tuple7._3);
                assertEquals(3.0, tuple7._4, 0);
                assertEquals(4f, tuple7._5, 0);
                assertEquals((byte) 5, (byte) tuple7._6);
                assertEquals((short) 6, (short) tuple7._7);
                func.apply(tuple7, 7);

                assertEquals(true, tuple7.$(1));
                assertEquals(1, (int) tuple7.$(2));
                assertEquals(2L, (long) tuple7.$(3));
                assertEquals(3.0, tuple7.$(4), 0);
                assertEquals(4f, tuple7.$(5), 0);
                assertEquals((byte) 5, (byte) tuple7.$(6));
                assertEquals((short) 6, (short) tuple7.$(7));
        }

        @Test
        public void testTupleWithMethod() {
                def func = $((Tuple tuple, Integer count) -> {
                        assertEquals((int) count, tuple.count());
                });
                Tuple1<Boolean> tuple1 = tuple(true);
                assertEquals(true, tuple1.$(1));
                func.apply(tuple1, 1);

                Tuple2<Boolean, Integer> tuple2 = tuple(true, 1);
                assertEquals(true, tuple2.$(1));
                assertEquals(1, (int) tuple2.$(2));
                func.apply(tuple2, 2);

                Tuple3<Boolean, Integer, Long> tuple3 = tuple(true, 1, 2L);
                assertEquals(true, tuple3.$(1));
                assertEquals(1, (int) tuple3.$(2));
                assertEquals(2L, (long) tuple3.$(3));
                func.apply(tuple3, 3);

                Tuple4<Boolean, Integer, Long, Double> tuple4 = tuple(true, 1, 2L, 3.0);
                assertEquals(true, tuple4.$(1));
                assertEquals(1, (int) tuple4.$(2));
                assertEquals(2L, (long) tuple4.$(3));
                assertEquals(3.0, tuple4.$(4), 0);
                func.apply(tuple4, 4);

                Tuple5<Boolean, Integer, Long, Double, Float> tuple5 = tuple(true, 1, 2L, 3.0, 4f);
                assertEquals(true, tuple5.$(1));
                assertEquals(1, (int) tuple5.$(2));
                assertEquals(2L, (long) tuple5.$(3));
                assertEquals(3.0, tuple5.$(4), 0);
                assertEquals(4f, tuple5.$(5), 0);
                func.apply(tuple5, 5);

                Tuple6<Boolean, Integer, Long, Double, Float, Byte> tuple6 = tuple(true, 1, 2L, 3.0, 4f, (byte) 5);
                assertEquals(true, tuple6.$(1));
                assertEquals(1, (int) tuple6.$(2));
                assertEquals(2L, (long) tuple6.$(3));
                assertEquals(3.0, tuple6.$(4), 0);
                assertEquals(4f, tuple6.$(5), 0);
                assertEquals((byte) 5, (byte) tuple6.$(6));

                Tuple7<Boolean, Integer, Long, Double, Float, Byte, Short> tuple7 = tuple(true, 1, 2L, 3.0, 4f, (byte) 5, (short) 6);
                assertEquals(true, tuple7.$(1));
                assertEquals(1, (int) tuple7.$(2));
                assertEquals(2L, (long) tuple7.$(3));
                assertEquals(3.0, tuple7.$(4), 0);
                assertEquals(4f, tuple7.$(5), 0);
                assertEquals((byte) 5, (byte) tuple7.$(6));
                assertEquals((short) 6, (short) tuple7.$(7));
        }

        @Test
        public void testClass() {
                ClassSup<User> userCls = cls(User.class);
                User user = new User("cass", 20);
                assertEquals(userCls, cls(user));
                assertEquals(userCls, cls("net.cassite.style.User"));

                assertTrue(userCls == cls(user));
                assertTrue((ClassSup<?>) userCls == cls("net.cassite.style.User"));
        }

        @Test
        public void testConstructor() {
                ClassSup<User> userCls = cls(User.class);
                ConstructorSup<User> con0 = userCls.constructor();
                ConstructorSup<User> con2 = userCls.constructor(String.class, int.class);

                User user = con0.newInstance();
                assertNull(user.getName());
                assertEquals(0, user.getAge());

                user = con2.newInstance("cass", 20);
                assertEquals("cass", user.getName());
                assertEquals(20, user.getAge());

                assertTrue(con0 == userCls.constructor());
                assertTrue(con2 == userCls.constructor(String.class, int.class));

                assertEquals(2, userCls.constructors().size());
        }

        @Test
        public void testField() {
                ClassSup<User> userCls = cls(User.class);
                FieldSupport<String, User> nameField = userCls.field("name", String.class);
                User user = new User("cass", 20);
                assertEquals("cass", nameField.get(user));

                FieldSupport<String, User> nameField2 = userCls.field("name");
                assertTrue(nameField == nameField2);

                nameField.set(user, "cass2");
                assertEquals("cass2", user.getName());

                assertEquals(2, userCls.allFields().size());
        }

        @Test
        public void testMethod() {
                ClassSup<User> userCls = cls(User.class);
                User user = userCls.newInstance();
                MethodSupport<Void, User> setAge = userCls.method("setAge", Void.TYPE, int.class);
                assertEquals(1, setAge.argCount());
                assertArrayEquals(new Class[]{int.class}, setAge.argTypes());
                setAge.invoke(user, 20);
                assertEquals(20, user.getAge());

                assertEquals(6, userCls.allMethods().size()); // hashCode defined in java.lang.Object

                assertEquals(2, userCls.setters().size());
                assertEquals(2, userCls.getters().size());
        }

        @Test
        public void testProxy() {
                List<Integer> list = proxy((a, b, c) -> null, list(1, 2, 3));
                assertNull(list.get(0));

                List<Integer> list2 = proxy(new ProxyHandler<List<Integer>>(list(1, 2, 3)) {
                        Integer get(int index) {
                                if (index < 0) {
                                        index = target.size() + index;
                                }
                                return target.get(index);
                        }
                });
                assertEquals(3, (int) list2.get(-1));
        }

        @Test
        public void testReadOnly() {
                IUser user = readOnly(new User("cass", 20));
                user.getAge();
                user.setAge(19);
                try {
                        user.setName("xcass");
                } catch (StyleRuntimeException e) {
                        assertTrue(e.origin() instanceof ModifyReadOnlyException);
                        try {
                                user.getName();
                        } catch (StyleRuntimeException e2) {
                                assertTrue(e.origin() instanceof ModifyReadOnlyException);
                                return;
                        }
                        fail();
                }
                fail();
        }

        @Test
        public void testAsyncGroup() {
                // calculate (100!)
                // divide into 4 threads
                def<BigInteger> cal1_25 = $(() -> {
                        BigInteger integer = new BigInteger("1");
                        for (Integer i = 1; i <= 25; ++i) {
                                integer = integer.multiply(new BigInteger(i.toString()));
                        }
                        return integer;
                });
                def<BigInteger> cal26_50 = $(() -> {
                        BigInteger integer = new BigInteger("1");
                        for (Integer i = 26; i <= 50; ++i) {
                                integer = integer.multiply(new BigInteger(i.toString()));
                        }
                        return integer;
                });
                def<BigInteger> cal51_75 = $(() -> {
                        BigInteger integer = new BigInteger("1");
                        for (Integer i = 50; i <= 75; ++i) {
                                integer = integer.multiply(new BigInteger(i.toString()));
                        }
                        return integer;
                });
                def<BigInteger> cal76_100 = $(() -> {
                        BigInteger integer = new BigInteger("1");
                        for (Integer i = 76; i <= 100; ++i) {
                                integer = integer.multiply(new BigInteger(i.toString()));
                        }
                        return integer;
                });

                // directly calculating
                BigInteger integer = new BigInteger("1");
                for (Integer i = 1; i <= 100; ++i) {
                        integer = integer.multiply(new BigInteger(i.toString()));
                }
                String res = integer.toString();

                AsyncGroup group = $(cal1_25.async(), cal26_50.async(), cal51_75.async(), cal76_100.async());
                Thread t = Thread.currentThread();

                ptr<Boolean> entered1 = ptr(false);
                group.callback((BigInteger r1_25, BigInteger r26_50, BigInteger r51_75, BigInteger r76_100) -> {
                        $(entered1, true);
                        assertNotEquals(t, Thread.currentThread());
                        assertEquals(res, r1_25.multiply(r26_50).multiply(r51_75).multiply(r76_100).toString());
                });
                sleep(100);
                assertTrue($(entered1));
                ptr<Boolean> entered2 = ptr(false);
                group.callbackSync((BigInteger r1_25, BigInteger r26_50, BigInteger r51_75, BigInteger r76_100) -> {
                        $(entered2, true);
                        assertEquals(t, Thread.currentThread());
                        assertEquals(res, r1_25.multiply(r26_50).multiply(r51_75).multiply(r76_100).toString());
                });
                assertTrue($(entered2));
        }

        @Test
        public void testIf() {
                ptr<Integer> intP = ptr(0);
                // vfunc0
                assertNull(If(true, () -> {
                        intP.item = 1;
                }).End());

                assertEquals(1, (int) $(intP));

                // rfun1
                assertEquals(21, (int) If(20, (v) -> (intP.item = v) + 1).End());

                assertEquals(20, (int) $(intP));

                // rfun1 else
                assertEquals(22, (int) If(false, () -> 0).Else(() -> 22));
        }

        @Test
        public void testSwitch() {
                User cass = new User("cass", 20);
                assertEquals("b", Switch(cass, String.class, (a, b) -> a.getName().equals(b.getName()) && a.getAge() == b.getAge())
                        .Case(new User("cass", 20), "b").Default(() -> null));
        }

        @Test
        public void testFor() {
                MInteger ii = $(0);
                MInteger mInt = $(0);
                assertNull(For(0, i -> i < 20, i -> i + 1, (VFunc1<Integer>) mInt::inc));
                assertEquals(190, mInt.intValue());

                List<Integer> list = For(0, i -> i < 10, i -> i + 1, (i, info) -> {
                        assertEquals(ii.intValue(), info.currentIndex);
                        assertEquals(ii.intValue(), info.effectiveIndex);
                        if (ii.intValue() == 0) {
                                assertNull(info.lastRes);
                        } else {
                                assertNotNull(info.lastRes);
                        }
                        ii.inc(1);
                        List<Integer> l = info.initRes(new ArrayList<>());
                        l.add(i);
                        return l;
                });
                assertEquals($(0).until(10), list);
        }

        @Test
        public void testForToStep() {
                int res = For(0).to(10).step(2).loop((i, info) -> i + info.initRes(0));
                assertEquals(30, res);
        }

        @Test
        public void testWhile() {
                MInteger mInt = $(20);
                MInteger count = $(0);
                MInteger i = $(0);
                While(() -> mInt.intValue() > 0, (info) -> {
                        assertEquals(i.intValue(), info.currentIndex);
                        assertEquals(0, info.effectiveIndex);
                        assertNull(info.lastRes);
                        i.inc(1);
                        mInt.inc(-1);
                        count.inc(1);
                });
                assertEquals(20, count.intValue());
        }

        @Test
        public void testBreak() {
                MInteger mInt = $(0);
                assertNull(For(0, i -> i < 20, i -> i + 1, (VFunc1<Integer>) mInt::inc));
                assertEquals(190, mInt.intValue());

                List<Integer> list = For(0, i -> i < 20, i -> i + 1, (i, info) -> {
                        List<Integer> l = info.initRes(new ArrayList<>());
                        l.add(i);
                        if (i == 9) Break();
                        return l;
                });
                assertEquals($(0).to(9), list);
        }

        @Test
        public void testContinue() {
                MInteger mInt = $(0);
                assertNull(For(0, i -> i < 20, i -> i + 1, (VFunc1<Integer>) mInt::inc));
                assertEquals(190, mInt.intValue());

                List<Integer> list = For(0, i -> i < 10, i -> i + 1, (i, info) -> {
                        if (i == 8) Continue();
                        List<Integer> l = info.initRes(new ArrayList<>());
                        l.add(i);
                        return l;
                });
                assertEquals(list(0, 1, 2, 3, 4, 5, 6, 7, 9), list);
        }

        @Test
        public void testBreakWithResult() {
                MInteger mInt = $(0);
                assertNull(For(0, i -> i < 20, i -> i + 1, (VFunc1<Integer>) mInt::inc));
                assertEquals(190, mInt.intValue());

                List<Integer> list = For(0, i -> i < 10, i -> i + 1, (i, info) -> {
                        if (i == 8) BreakWithResult(list(0));
                        List<Integer> l = info.initRes(new ArrayList<>());
                        l.add(i);
                        return l;
                });
                assertEquals(list(0), list);
        }

        @Test
        public void testBreakable() {
                ptr<Integer> intP = ptr(0);
                try {
                        breakable(() -> {
                                $(intP, 1);
                                Break();
                                fail();
                        });
                } catch (Break b) {
                        fail();
                }
                assertEquals(1, (int) $(intP));

                try {
                        breakable(() -> {
                                $(intP, 2);
                                BreakWithResult(0);
                                fail();
                        });
                } catch (BreakWithResult b) {
                        fail();
                }
                assertEquals(2, (int) $(intP));
        }

        @Test
        public void testConstructing() {
                List<Integer> list = list(0, 1, 2, 3, 4);
                assertEquals(Arrays.asList(0, 1, 2, 3, 4), list);
                List<Integer> list2 = $(list, 5, 6, 7, 8);
                assertEquals(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8), list2);
                assertTrue(list == list2);

                Map<String, Integer> map = map("a", 1).$("b", 2).$("c", 3);
                assertEquals(3, map.size());
                Map<String, Integer> map2 = $(map, map("d", 4).$("e", 5).$("f", 6));
                assertEquals(6, map2.size());
                assertTrue(map == map2);
        }

        @Test
        public void testForEach() {
                List<Integer> list = $(list(0, 1, 2, 3, 4, 5)).forEach((i, info) -> {
                        List<Integer> ls = info.initRes(new ArrayList<>());
                        ls.add(i + 1);
                        return ls;
                });

                assertEquals($(1).to(6), list);
        }

        @Test
        public void testRemove() {
                List<Integer> ls = list(0, 1, 2, 3, 4, 5);
                $(ls).forEach(i -> {
                        if (i == 1 || i == 5) {
                                Remove();
                        }
                });
                assertEquals(list(0, 2, 3, 4), ls);
        }

        @Test
        public void testSet() {
                List<Integer> ls = list(0, 1, 2, 3, 4, 5);
                $(ls).forEach(i -> {
                        Set(i + 1);
                });
                assertEquals($(1).to(6), ls);
        }

        @Test
        public void testAdd() {
                List<Integer> ls = list(0, 1, 2, 3, 4, 5);
                $(ls).forEach(i -> {
                        if (i == 0) Add(6);
                });
                assertEquals(list(0, 6, 1, 2, 3, 4, 5), ls);
        }

        @Test
        public void testForThose() {
                List<Integer> ls = list(0, 1, 2, 3, 4, 5);
                $(ls).forThose(i -> i > 2, i -> {
                        Set(i + 1);
                });
                assertEquals(list(0, 1, 2, 4, 5, 6), ls);
        }

        @Test
        public void testArrayForThose() {
                Integer[] ls = new Integer[]{0, 1, 2, 3, 4, 5};
                ptr<String> strP = ptr("");
                $(ls).forThose(i -> i > 2, i -> {
                        strP.item += i;
                });
                assertEquals("345", strP.item);
        }

        @Test
        public void testMapForEach() {
                Map<String, Integer> birthMap = map("cass", 1995).$("john", 1994).$("cassie", 1996);
                ptr<String> strP = ptr("");
                $(birthMap).forEach((k, v) -> {
                        strP.item += (k + "" + v);
                });
                assertEquals("cass1995john1994cassie1996", strP.item);
        }

        @Test
        public void testToVia() {
                List<Integer> list = list(0, 1, 2, 3, 4);
                Set<String> set = $(list).to(new HashSet<String>()).via(i -> i + "+");
                assertEquals(new HashSet<>(list("0+", "1+", "2+", "3+", "4+")), set);
        }

        @Test
        public void testMapToVia() {
                Map<String, Integer> birthMap = map("cass", 1995).$("john", 1994).$("cassie", 1996);
                Map<Integer, String> res = $(birthMap).to(new HashMap<Integer, String>()).via((k, v) -> tuple(v, k));
                assertEquals(map(1995, "cass").$(1994, "john").$(1996, "cassie"), res);
        }

        @Test
        public void testFindOne() {
                List<Integer> list = list(0, 1, 2, 3, 4);
                assertNull($(list).findOne(i -> i >= 5));
                assertEquals(3, (int) $(list).findOne(i -> i > 2));

                Map<String, Integer> birthMap = map("cass", 1995).$("john", 1994).$("cassie", 1996);
                assertEquals(new Entry<>("john", 1994), $(birthMap).findOne((k, v) -> v == 1994));
                assertNull($(birthMap).findOne((k, v) -> v == 0));
        }

        @Test
        public void testAvoidNull() {
                int i = avoidNull(null, 1);
                assertEquals(1, i);

                long l = avoidNull(null, () -> 1);
                assertEquals(1L, l);
        }

        @Test
        public void testDate() {
                long time = 1448180688655L;
                Date date = new Date(time);
                assertEquals(time + 3 + 5 * 1000 + 4 * 60 * 1000 + 2 * 3600 * 1000 + 1 * 24 * 3600 * 1000, $(date).add(d -> d.day(1).hour(2).milli(3).minute(4).second(5)).getDate().getTime());
                assertEquals(time, $(date).subtract(d -> d.day(1).hour(2).milli(3).minute(4).second(5)).getDate().getTime());
                assertEquals("48-48-24-24-4-16-04-16-22-22-11-11-15-2015-pm-PM", $(date).toString("s-ss-i-ii-h-H-hh-HH-d-dd-m-mm-yy-yyyy-a-A"));
        }

        @Test
        public void testRegex() {
                assertEquals("abc", regex("/<[^>]*>/g").replace("<html>abc</html>", ""));
                assertTrue(regex("/<[^>]*>/").matches("<html>"));
                assertTrue(regex("/<[^>]*>/").test("abc<html>def"));
                assertArrayEquals(new String[]{"bc", "def", "gh"}, regex("/a(bc)(def)(gh)/").exec("abcdefghi"));
        }

        @Test
        public void testComparable() {
                int i = 1;
                assertTrue($((Comparable<Integer>) i).eq(1));
                assertTrue($((Comparable<Integer>) i).ne(2));
                assertTrue($((Comparable<Integer>) i).neq(2));
                assertTrue($((Comparable<Integer>) i).gt(0));
                assertTrue($((Comparable<Integer>) i).gte(1));
                assertTrue($((Comparable<Integer>) i).ge(1));
                assertTrue($((Comparable<Integer>) i).gte(0));
                assertTrue($((Comparable<Integer>) i).ge(0));
                assertTrue($((Comparable<Integer>) i).lt(2));
                assertTrue($((Comparable<Integer>) i).le(1));
                assertTrue($((Comparable<Integer>) i).lte(1));
                assertTrue($((Comparable<Integer>) i).le(2));
        }

        @Test
        public void testString() {
                assertEquals("hello, my name is cass, let's write java with Style!", $("hello, my name is {0}, let's write java with {1}!").fill("cass", "Style"));
                User user = new User("cass", 20);
                assertEquals("my name is cass, im 20 years old", $("my name is ${name}, im ${age} years old").from(user));
                assertTrue($("testtest") == $("testtest"));
        }

        @Test
        public void testJSON() {
                JSONLike jsonLike = map(new Object[]{
                        "name", "cass",
                        "age", 20,
                        "sex", "male"
                });
                assertEquals(map("name", (Object) "cass").$("age", 20).$("sex", "male"), jsonLike);
        }

        @Test
        public void testJoin() {
                List<Integer> l1 = list(3, 7, 5, 4);
                List<Integer> l2 = list(8);
                List<Integer> l3 = list(2, 9, 6);
                List<Integer> l4 = list(1, 0);
                List<Integer> list = join(l1, l2, l3, l4);
                assertEquals(10, list.size());
                ptr<String> strP = ptr("");
                list.stream().sorted().forEach(i -> {
                        strP.item += i;
                });
                assertEquals("0123456789", strP.item);
        }

        @Test
        public void testPathMapper() {
                PathMapper mapper = new PathMapper();
                mapper.put("a.b.c", "i am a.b.c");
                mapper.get("a.b", () -> "abc");
                assertEquals("i am a.b.c", mapper.get("a.b.c"));
                assertEquals("abc", mapper.get("a.b"));
                assertEquals(1, mapper.getContainMap().size());
                assertEquals(1, ((Map) mapper.getContainMap().get("a")).size());
                assertEquals(2, ((Map) ((Map) mapper.getContainMap().get("a")).get("b")).size());
                assertEquals(1, ((Map) ((Map) ((Map) mapper.getContainMap().get("a")).get("b")).get("c")).size());
        }
}
