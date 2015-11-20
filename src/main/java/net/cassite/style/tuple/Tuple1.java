package net.cassite.style.tuple;

public class Tuple1<T1> implements Tuple {
        public final T1 _1;

        public Tuple1(T1 _1) {
                this._1 = _1;
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T> T $(int index) {
                if (index == 1)
                        return (T) _1;
                throw new IndexOutOfBoundsException();
        }

        @Override
        public int count() {
                return 1;
        }
}
