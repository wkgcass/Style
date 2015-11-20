package net.cassite.style.aggregation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import net.cassite.style.Entry;
import net.cassite.style.interfaces.VFunc1;
import net.cassite.style.ptr;

import static net.cassite.style.Core.*;
import static net.cassite.style.aggregation.Aggregation.*;

public class JoinedList<E> implements List<E> {
        private List<List<E>> lists;

        @SafeVarargs
        public JoinedList(List<E>... toJoin) {
                lists = new ArrayList<>(toJoin.length);
                $(toJoin).forEach((VFunc1<List<E>>) lists::add);
        }

        @Override
        public int size() {
                return $(lists).forEach((list, i) -> avoidNull(i.lastRes, 0) + list.size());
        }

        @Override
        public boolean isEmpty() {
                return lists.isEmpty() ? true : $(lists).forEach(list -> {
                        if (!list.isEmpty())
                                BreakWithResult(false);
                        return true;
                });
        }

        @Override
        public boolean contains(Object o) {
                return lists.isEmpty() ? false : $(lists).forEach(list -> {
                        if (list.contains(o))
                                BreakWithResult(true);
                        return false;
                });
        }

        @Override
        public Iterator<E> iterator() {
                return listIterator(0);
        }

        @Override
        public Object[] toArray() {
                Object[] arr = new Object[size()];
                $(this).forEach((e, i) -> {
                        arr[$(i)] = e;
                });
                return arr;
        }

        @SuppressWarnings("unchecked")
        @Override
        public <T> T[] toArray(T[] arr) {
                $(lists).forEach((list, i) -> {
                        int res = $(list).forEach((e, j) -> {
                                int index = (int) avoidNull(i.lastRes, 0) + avoidNull(j.lastRes, 0);
                                if (index >= arr.length)
                                        BreakWithResult(-1);
                                arr[index] = (T) e;
                                return (int) avoidNull(i.lastRes, 0) + 1;
                        });
                        return res == -1 ? Break() : res;
                });
                $(this).forEach((e, i) -> {
                        if ($(i) >= arr.length)
                                Break();
                        arr[$(i)] = (T) e;
                });
                return arr;
        }

        @Override
        public boolean add(E e) {
                throw new UnsupportedOperationException();
        }

        @Override
        public boolean remove(Object o) {
                throw new UnsupportedOperationException();
        }

        @Override
        public boolean containsAll(Collection<?> c) {
                return lists.isEmpty() ? false : $(c).forEach(e -> {
                        if (!contains(e))
                                BreakWithResult(false);
                        return true;
                });
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
                throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(int index, Collection<? extends E> c) {
                throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(Collection<?> c) {
                throw new UnsupportedOperationException();
        }

        @Override
        public boolean retainAll(Collection<?> c) {
                throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
                throw new UnsupportedOperationException();
        }

        private Entry<List<E>, Integer> getListAndPos(int index) {
                int baseIndex = 0;
                int current = 0;
                while (index - baseIndex >= lists.get(current).size()) {
                        baseIndex += lists.get(current).size();
                        ++current;
                }
                return new Entry<>(lists.get(current), index - baseIndex);
        }

        @Override
        public E get(int index) {
                Entry<List<E>, Integer> entry = getListAndPos(index);
                return entry.key.get(entry.value);
        }

        @Override
        public E set(int index, E element) {
                Entry<List<E>, Integer> entry = getListAndPos(index);
                return entry.key.set(entry.value, element);
        }

        @Override
        public void add(int index, E element) {
                throw new UnsupportedOperationException();
        }

        @Override
        public E remove(int index) {
                throw new UnsupportedOperationException();
        }

        @Override
        public int indexOf(Object o) {
                ptr<Integer> count = ptr(0);
                return lists.size() == 0 ? -1 : $(lists).forEach((list, i) -> {
                        int indexJ = list.size() == 0 ? -1 : $(list).forEach((e, j) -> e.equals(o) ? BreakWithResult($(j)) : -1);
                        try {
                                return indexJ == -1 ? -1 : BreakWithResult(indexJ + $(count));
                        } finally {
                                $(count, $(count) + list.size());
                        }
                });
        }

        @Override
        public int lastIndexOf(Object o) {
                return lists.size() == 0 ? -1 : For(lists.size() - 1).to(0).step(-1).loop(i -> {
                        int index = avoidNull(For(lists.get(i).size() - 1).to(0).step(-1).loop(j -> lists.get(i).get(j).equals(o) ? BreakWithResult(j) : -1), -1);
                        return index == -1 ? -1
                                : BreakWithResult(index + avoidNull(
                                For(0).to(i - 1).step(1).loop((k, info) -> avoidNull(info.lastRes, 0) + lists.get(k).size()),
                                0));
                });
        }

        @Override
        public ListIterator<E> listIterator() {
                return listIterator(0);
        }

        @Override
        public ListIterator<E> listIterator(int index) {
                return new JoinedListIterator(index);
        }

        @Override
        public List<E> subList(int fromIndex, int toIndex) {
                if (fromIndex > toIndex)
                        throw new IllegalArgumentException();
                List<E> toReturn = new ArrayList<>();
                For(fromIndex).to(toIndex).step(1).loop(i -> {
                        Entry<List<E>, Integer> listAndPos = getListAndPos(i);
                        toReturn.add(listAndPos.key.get(listAndPos.value));
                });
                return toReturn;
        }

        public String toString() {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                boolean isFirst = true;
                for (E e : this) {
                        if (isFirst) {
                                sb.append(e);
                                isFirst = false;
                        } else {
                                sb.append(", ").append(e);
                        }
                }

                sb.append("]");
                return sb.toString();
        }

        private class JoinedListIterator implements ListIterator<E> {
                private int cursor;
                private int size = size();

                public JoinedListIterator(int index) {
                        this.cursor = index - 1;
                }

                @Override
                public boolean hasNext() {
                        return cursor < size - 1;
                }

                @Override
                public E next() {
                        return get(++cursor);
                }

                @Override
                public boolean hasPrevious() {
                        return cursor >= 0;
                }

                @Override
                public E previous() {
                        return cursor == 0 ? null : get(--cursor);
                }

                @Override
                public int nextIndex() {
                        return cursor + 1;
                }

                @Override
                public int previousIndex() {
                        return cursor - 1;
                }

                @Override
                public void remove() {
                        throw new UnsupportedOperationException();
                }

                @Override
                public void set(E e) {
                        if (cursor >= 0 && cursor < size)
                                JoinedList.this.set(cursor, e);
                }

                @Override
                public void add(E e) {
                        throw new UnsupportedOperationException();
                }

        }

}
