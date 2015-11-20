package net.cassite.style.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

import net.cassite.style.$;

import static net.cassite.style.Style.*;

import net.cassite.style.aggregation.A1FuncSup;

/**
 * Supporter for Constructors
 *
 * @param <T> The type of constructed objects
 * @author wkgcass
 */
public class ConstructorSup<T> implements MemberSup<Constructor<T>> {
        private final Constructor<T> con;

        public Constructor<T> getMember() {
                return con;
        }

        ConstructorSup(Constructor<T> con) {
                this.con = con;
        }

        /**
         * Returns this element's annotation for the specified type if such an
         * annotation is present, else null.<br>
         * Simply invokes {@link Constructor#getAnnotation(Class)}
         *
         * @param annoCls the Class object corresponding to the annotation type
         * @return this element's annotation for the specified annotation type
         * if present on this element, else null
         * @see Constructor#getAnnotation(Class)
         */
        public <A extends Annotation> A annotation(Class<A> annoCls) {
                return con.getAnnotation(annoCls);
        }

        /**
         * Returns true if an annotation for the specified type is present on
         * this element, else false. This method is designed primarily for
         * convenient access to marker annotations.<br>
         * Simply invokes {@link Constructor#getAnnotations()}
         *
         * @param annoCls the Class object corresponding to the annotation type
         * @return true if an annotation for the specified annotation type is
         * present on this element, else false
         * @see Constructor#getAnnotations()
         */
        public <A extends Annotation> boolean isAnnotationPresent(Class<A> annoCls) {
                return con.isAnnotationPresent(annoCls);
        }

        /**
         * Create an instance with no args
         *
         * @return created instance
         */
        public T newInstance() {
                return newInstance(new Object[0]);
        }

        /**
         * Create an instance with given args
         *
         * @param args arguments to fill the parameter list
         * @return created instance
         */
        public T newInstance(Object... args) {
                try {
                        con.setAccessible(true);
                        return con.newInstance(args);
                } catch (Exception e) {
                        throw $(e);
                }
        }

        /**
         * Create an instance with given args
         *
         * @param args arguments to fill the parameter list in the form of
         *             $(array/iterable)
         * @return created instance
         * @see net.cassite.style.aggregation.Aggregation#$(Iterable)
         * @see net.cassite.style.aggregation.Aggregation#$(Object[])
         */
        public T newInstance(A1FuncSup<?> args) {
                return newInstance(args.to(new Object[args.size()]).via($.copy()));
        }

        /**
         * Returns an array of Class objects that represent the formal parameter
         * types, in declaration order, of the executable represented by this
         * object. Returns an array of length 0 if the underlying executable
         * takes no parameters.<br>
         * Simply invokes {@link Constructor#getParameterTypes()}
         *
         * @return the parameter types for the executable this object represents
         */
        public Class<?>[] argTypes() {
                return con.getParameterTypes();
        }

        public int argCount() {
                return con.getParameterCount();
        }

        public String toString() {
                return con.toString();
        }
}
