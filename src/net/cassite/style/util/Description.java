package net.cassite.style.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD,
                ElementType.PACKAGE, ElementType.PARAMETER, ElementType.TYPE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE })
public @interface Description {
        String value();
}
