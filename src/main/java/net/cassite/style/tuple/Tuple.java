package net.cassite.style.tuple;

public interface Tuple {
        <T> T $(int index);

        int count();
}
