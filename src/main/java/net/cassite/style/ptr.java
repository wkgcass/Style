package net.cassite.style;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import net.cassite.style.reflect.Reflect;

/**
 * A container of objects, usually used when accessing a non-final value from
 * inner classes.
 * 
 * @author wkgcass
 *
 * @param <T>
 *                type of the object to contain
 */
public class ptr<T> implements InvocationHandler {
        /**
         * contained object
         */
        public T item;

        public final T proxy;

        ptr(T o) {
                this.item = o;
                if (o.getClass().getInterfaces() != null && o.getClass().getInterfaces().length != 0) {
                        proxy = Reflect.proxy(this, o);
                } else {
                        proxy = null;
                }
        }

        @Override
        public int hashCode() {
                return item.hashCode();
        }

        @Override
        public String toString() {
                return item.toString();
        }

        @Override
        public boolean equals(Object another) {
                return item.equals(another);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(item, args);
        }
}
