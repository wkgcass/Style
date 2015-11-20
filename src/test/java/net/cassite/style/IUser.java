package net.cassite.style;

import net.cassite.style.reflect.readonly.ReadOnly;
import net.cassite.style.reflect.readonly.Writable;

/**
 * test read only
 */
public interface IUser {
        @Writable
        String getName(); // throw

        int getAge(); // ok

        void setName(String name); // throw

        @ReadOnly
        void setAge(int age); // ok
}
