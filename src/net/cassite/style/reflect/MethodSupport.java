package net.cassite.style.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import static net.cassite.style.Style.*;

/**
 * Supporter for methods
 * 
 * @author wkgcass
 *
 * @param <R>
 *                return type
 * @param <ObjectType>
 *                type of class this field resolves to
 */
public class MethodSupport<R, ObjectType> implements MemberSup<Method> {
        private final Method method;

        public Method getMember() {
                return method;
        }

        /**
         * 
         * @param method
         *                method to support
         * @param retType
         *                return type
         * @param objType
         *                resolved object's type
         */
        public MethodSupport(Method method, Class<R> retType, Class<ObjectType> objType) {
                if (method == null)
                        throw $(new NoSuchMethodException());
                this.method = method;
        }

        /**
         * Returns this element's annotation for the specified type if such an
         * annotation is present, else null.
         * 
         * 
         * @param annoCls
         *                the Class object corresponding to the annotation type
         * 
         * @return this element's annotation for the specified annotation type
         *         if present on this element, else null
         * 
         */
        public <A extends Annotation> A annotation(Class<A> annoCls) {
                return method.getAnnotation(annoCls);
        }

        /**
         * Returns true if an annotation for the specified type is present on
         * this element, else false. This method is designed primarily for
         * convenient access to marker annotations.
         * 
         * 
         * @param annoCls
         *                the Class object corresponding to the annotation type
         * 
         * @return true if an annotation for the specified annotation type is
         *         present on this element, else false
         * 
         */
        public <A extends Annotation> boolean isAnnotationPresent(Class<A> annoCls) {
                return method.isAnnotationPresent(annoCls);
        }

        /**
         * set accessible to 'true' then invoke the method with given arguments
         * 
         * @param target
         *                the object the underlying method is invoked from
         * @param args
         *                the arguments used for the method call
         * @return the result of dispatching the method represented by this
         *         object on obj with parameters args
         * 
         */
        @SuppressWarnings("unchecked")
        public R invoke(ObjectType target, Object... args) {
                try {
                        method.setAccessible(true);
                        return (R) method.invoke(target, args);
                } catch (Exception e) {
                        throw $(e);
                }
        }

        public String name() {
                return method.getName();
        }

        /**
         * Returns an array of Class objects that represent the formal parameter
         * types, in declaration order, of the executable represented by this
         * object. Returns an array of length 0 if the underlying executable
         * takes no parameters.
         * 
         * @return the parameter types for the executable this object represents
         */
        public Class<?>[] argTypes() {
                return method.getParameterTypes();
        }

        public int argCount() {
                return method.getParameterCount();
        }

        public String toString() {
                return method.toString();
        }

        public Class<?> returnType() {
                return method.getReturnType();
        }
}
