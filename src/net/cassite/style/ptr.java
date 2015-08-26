package net.cassite.style;

/**
 * A container of objects, usually used when accessing a non-final value from
 * inner classes.
 * 
 * @author wkgcass
 *
 * @param <T>
 *                type of the object to contain
 */
public class ptr<T> {
        /**
         * contained object
         */
        public T item;

        ptr(T o) {
                this.item = o;
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
}
