package net.cassite.style.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

import net.cassite.style.$;
import static net.cassite.style.aggregation.Aggregation.*;
import net.cassite.style.reflect.readonly.ModifyReadOnlyException;
import net.cassite.style.reflect.readonly.ReadOnly;
import net.cassite.style.reflect.readonly.Writable;
import net.cassite.style.util.PathMapper;

public abstract class Reflect {

        private static PathMapper mapper = new PathMapper();

        protected Reflect() {

        }

        // ┌─────────────────────────────────┐
        // │...........reflection............│
        // └─────────────────────────────────┘

        /**
         * create a class supporter with given class
         * 
         * @param cls
         *                the class object to be supported
         * @return Class supporter
         * @see ClassSup
         */
        public static <T> ClassSup<T> cls(Class<T> cls) {
                return mapper.get(cls.getName(), () -> new ClassSup<>(cls));
        }

        /**
         * create a class supporter with given class name
         * 
         * @param clsName
         *                full name of the class to be supported
         * @return Class supporter
         * @see ClassSup
         */
        @SuppressWarnings("unchecked")
        public static <T> ClassSup<T> cls(String clsName) {
                try {
                        return mapper.get(clsName, () -> (ClassSup<T>) cls(Class.forName(clsName)));
                } catch (Exception e) {
                        throw $(e);
                }
        }

        /**
         * create a class supporter with given object
         * 
         * @param obj
         *                instance of the class to be supported
         * @return Class supporter
         * @see ClassSup
         */
        @SuppressWarnings("unchecked")
        public static <T> ClassSup<T> cls(T obj) {
                return mapper.get(obj.getClass().getName(), () -> (ClassSup<T>) cls(obj.getClass()));
        }

        /**
         * generate proxy object with given InvocationHandler and the object to
         * do proxy
         * 
         * @param handler
         *                InvocationHandler instance
         * @param toProxy
         *                the object to do proxy
         * @return proxy object generated with Proxy.newProxyInstance(...)
         * @see InvocationHandler
         * @see Proxy#newProxyInstance(ClassLoader, Class[], InvocationHandler)
         */
        @SuppressWarnings("unchecked")
        public static <T> T proxy(InvocationHandler handler, T toProxy) {
                return (T) Proxy.newProxyInstance(toProxy.getClass().getClassLoader(), toProxy.getClass().getInterfaces(), handler);
        }

        /**
         * generate proxy object with given ProxyHandler<br>
         * ProxyHandler is an abstract class with a constructor taking in the
         * object to do proxy<br>
         * see ProxyHandler or
         * <a href="https://github.com/wkgcass/Style/">tutorial</a> for more
         * info on how to use.
         * 
         * @param proxyHandler
         * @return proxy object generated with Proxy.newProxyInstance(...)
         * @see ProxyHandler
         * @see Proxy#newProxyInstance(ClassLoader, Class[], InvocationHandler)
         */
        @SuppressWarnings("unchecked")
        public static <P> P proxy(ProxyHandler<P> proxyHandler) {
                List<MethodSupport<?, ProxyHandler<P>>> methods = cls(proxyHandler).allMethods();
                P toProxy = proxyHandler.target;

                return (P) Proxy.newProxyInstance(toProxy.getClass().getClassLoader(), toProxy.getClass().getInterfaces(), (p, m, args) -> {
                        return If($(methods).forEach(e -> {
                                if (e.name().equals(m.getName()) && e.argCount() == m.getParameterCount()
                                                && avoidNull($(m.getParameterTypes()).forEach((pt, i) -> {
                                        if (!pt.isAssignableFrom(e.argTypes()[$(i)]))
                                                return BreakWithResult(false);
                                        else
                                                return true;
                                }), () -> true))
                                        return BreakWithResult(e);
                                else
                                        return null;
                        }), res -> (Object) res.invoke(proxyHandler, args)).Else(() -> m.invoke(toProxy, args));
                });
        }

        /**
         * Make an object which has interfaces to a read-only one.<br>
         * When an invocation comes, the InvocatinHandler will check the method.
         * 
         * <pre>
         if methodName.contains elements in $.readOnlyToSearch
                Check whether the method has ReadOnly annotation
                        if has
                            do invoking
                        else
                            throw an exception(ModifyReadOnlyException)
        else
                Check whether the method has Writable annotation
                        if has
                            throw an exception(ModifyReadOnlyException)
                        else
                            do invoking
         * </pre>
         * 
         * @param toReadOnly
         *                the object to be readonly
         * @return read-only object(dynamic proxy supported)
         */
        public static <R> R readOnly(R toReadOnly) {
                return proxy((p, m, args) -> {
                        return If($($.readOnlyToSearch).forEach(s -> {
                                if (m.getName().contains(s))
                                        return BreakWithResult(m);
                                else
                                        return null;
                        }), rm -> {
                                if (rm.isAnnotationPresent(ReadOnly.class))
                                        return m.invoke(toReadOnly, args);
                                else
                                        throw new ModifyReadOnlyException(toReadOnly, m);
                        }).Else(() -> {
                                if (m.isAnnotationPresent(Writable.class))
                                        throw new ModifyReadOnlyException(toReadOnly, m);
                                else
                                        return m.invoke(toReadOnly, args);
                        });
                } , toReadOnly);
        }
}
