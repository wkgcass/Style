package net.cassite.style.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import net.cassite.style.Style;

/**
 * Supporter for fields
 * 
 * @author wkgcass
 *
 * @param <FieldType>
 *                type of the field
 * @param <ObjectType>
 *                type of class this field resolves to
 */
public class FieldSupport<FieldType, ObjectType> extends Style implements MemberSup<Field> {
        private Field f;

        public Field getMember() {
                return f;
        }

        FieldSupport(Field f, Class<FieldType> cls, Class<ObjectType> objCls) {
                if (f == null)
                        throw $(new NoSuchFieldException());
                this.f = f;
        }

        /**
         * Returns this element's annotation for the specified type if such an
         * annotation is present, else null.<br>
         * Simply invokes {@link Field#getAnnotation(Class)}
         * 
         * @param annoCls
         *                the Class object corresponding to the annotation type
         * @return this element's annotation for the specified annotation type
         *         if present on this element, else null
         * @see Field#getAnnotation(Class)
         */
        public <A extends Annotation> A annotation(Class<A> annoCls) {
                return f.getAnnotation(annoCls);
        }

        /**
         * Returns true if an annotation for the specified type is present on
         * this element, else false. This method is designed primarily for
         * convenient access to marker annotations.<br>
         * Simply invokes {@link Field#getAnnotations()}
         * 
         * @param annoCls
         *                the Class object corresponding to the annotation type
         * @return true if an annotation for the specified annotation type is
         *         present on this element, else false
         * @see Field#getAnnotation(Class)
         */
        public <A extends Annotation> boolean isAnnotationPresent(Class<A> annoCls) {
                return f.isAnnotationPresent(annoCls);
        }

        /**
         * set accessible to 'true' then get field value
         * 
         * @param obj
         *                object from which the represented field's value is to
         *                be extracted
         * @return the value of the represented field in object obj; primitive
         *         values are wrapped in an appropriate object before being
         *         returned
         */
        @SuppressWarnings("unchecked")
        public FieldType get(ObjectType obj) {
                try {
                        f.setAccessible(true);
                        return (FieldType) f.get(obj);
                } catch (Exception e) {
                        throw $(e);
                }
        }

        /**
         * set accessible to 'true' then set field value
         * 
         * @param obj
         *                the object whose field should be modified
         * @param toSet
         *                the new value for the field of obj being modified
         * @return <code>this</code>
         */
        public FieldSupport<FieldType, ObjectType> set(ObjectType obj, Object toSet) {
                try {
                        f.setAccessible(true);
                        f.set(obj, toSet);
                        return this;
                } catch (Exception e) {
                        throw $(e);
                }
        }

        public String toString() {
                return f.toString();
        }
}
