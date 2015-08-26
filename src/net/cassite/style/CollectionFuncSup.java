package net.cassite.style;

import java.util.Collection;

/**
 * Supporter of collections
 * 
 * @author wkgcass
 *
 * @param <T>
 *                element type of the collection
 */
public class CollectionFuncSup<T> extends IterableFuncSup<T> {
        CollectionFuncSup(Collection<T> collection) {
                super(collection);
        }

        /**
         * a chain to simplify 'add' process
         * 
         * <pre>
         * $(collection).add(e1).add(e2).add(e3)
         * </pre>
         * 
         * @param t
         *                the element to add
         * @return <code>this</code>
         */
        @SuppressWarnings("unchecked")
        public <Coll extends CollectionFuncSup<T>> Coll add(T t) {
                Collection<T> coll = (Collection<T>) iterable;
                coll.add(t);
                return (Coll) this;
        }

        @Override
        public int size() {
                return ((Collection<T>) iterable).size();
        }
}