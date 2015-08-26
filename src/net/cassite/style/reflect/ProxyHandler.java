package net.cassite.style.reflect;

import net.cassite.style.Style;

/**
 * Use {@link Style#proxy(ProxyHandler)} with ProxyHandler to simplify Dynamic
 * Proxy creation.<br>
 * Here's an example:<br>
 * If you need to print "before get invoked with arg0:"+index before invoking
 * List.get(int)<br>
 * and print "after get invoked with res:"+result after invoking it.
 * 
 * <pre>
 * List&lt;String&gt; listProxy = proxy(new ProxyHandler&lt;List&lt;String&gt;&gt;(list) {
 *         String get(int index) {
 *                 System.out.println("before get invoked with arg0:" + index);
 *                 String res = target.get(index);
 *                 System.out.println("after get invoked with res:" + res);
 *                 return res;
 *         }
 * });
 * </pre>
 * 
 * listProxy is the proxy object you need.
 * 
 * @author wkgcass
 *
 * @param <T>
 * @since 1.0.2
 */
public abstract class ProxyHandler<T> extends Style {
        public T target;

        /**
         * Create a proxy handler.<br>
         * Check doc on ProxyHandler for more info
         * 
         * @param target
         *                the object to proxy
         * 
         * @see ProxyHandler
         */
        public ProxyHandler(T target) {
                this.target = target;
        }
}
