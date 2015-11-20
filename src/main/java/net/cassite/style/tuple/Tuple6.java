package net.cassite.style.tuple;

public class Tuple6<T1, T2, T3, T4, T5, T6> implements Tuple {
        public final T1 _1;
        public final T2 _2;
        public final T3 _3;
        public final T4 _4;
        public final T5 _5;
        public final T6 _6;

        public Tuple6(T1 _1, T2 _2, T3 _3, T4 _4, T5 _5, T6 _6) {
                this._1 = _1;
                this._2 = _2;
                this._3 = _3;
                this._4 = _4;
                this._5 = _5;
                this._6 = _6;
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T> T $(int index) {
                if (index == 1)
                        return (T) _1;
                else if (index == 2)
                        return (T) _2;
                else if (index == 3)
                        return (T) _3;
                else if (index == 4)
                        return (T) _4;
                else if (index == 5)
                        return (T) _5;
                else if (index == 6)
                        return (T) _6;
                throw new IndexOutOfBoundsException(new Integer(index).toString());
        }

        @Override
        public int count() {
                return 6;
        }
}
