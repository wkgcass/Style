package net.cassite.style.tuple;

public class Tuple3<T1, T2, T3> implements Tuple {
        public final T1 _1;
        public final T2 _2;
        public final T3 _3;

        public Tuple3(T1 _1, T2 _2, T3 _3) {
                this._1 = _1;
                this._2 = _2;
                this._3 = _3;
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
                throw new IndexOutOfBoundsException(new Integer(index).toString());
        }

        @Override
        public int count() {
                return 3;
        }
}
