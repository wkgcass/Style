package net.cassite.style.tuple;

import net.cassite.style.Entry;

public class Tuple2<T1, T2> extends Entry<T1, T2>implements Tuple {
        public final T1 _1;
        public final T2 _2;

        public Tuple2(T1 _1, T2 _2) {
                super(_1, _2);
                this._1 = _1;
                this._2 = _2;
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T> T $(int index) {
                if (index == 1)
                        return (T) _1;
                else if (index == 2)
                        return (T) _2;
                throw new IndexOutOfBoundsException(new Integer(index).toString());
        }

        @Override
        public int count() {
                return 2;
        }
}
