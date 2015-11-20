package net.cassite.style.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.cassite.style.Style.*;
import static net.cassite.style.aggregation.Aggregation.*;

import net.cassite.style.aggregation.A1FuncSup;
import net.cassite.style.interfaces.VFunc1;
import net.cassite.style.util.PathMapper;

/**
 * Supporter for Class objects
 *
 * @param <T>
 * @author wkgcass
 */
public class ClassSup<T> {
        private final Class<T> cls;
        private final PathMapper mapper = new PathMapper();

        /**
         * retrieve the supported Class object
         *
         * @return class support object
         */
        public Class<T> getCls() {
                return cls;
        }

        /**
         * Construct the class supporter with given Class object
         *
         * @param cls class to support
         */
        public ClassSup(Class<T> cls) {
                this.cls = cls;
        }

        /**
         * Returns the name of the entity (class, interface, array class,
         * primitive type, or void) represented by this Class object, as a
         * String.<br>
         * Simply invokes {@link Class#getName()}
         *
         * @return the name of the class or interface represented by this
         * object.
         * @see Class#getName()
         */
        public String name() {
                return cls.getName();
        }

        /**
         * Returns the simple name of the underlying class as given in the
         * source code. Returns an empty string if the underlying class is
         * anonymous.<br>
         * Simply invokes {@link Class#getSimpleName()}
         *
         * @return the simple name of the underlying class
         * @see Class#getSimpleName()
         */
        public String simpleName() {
                return cls.getSimpleName();
        }

        /**
         * Returns this element's annotation for the specified type if such an
         * annotation is present, else null.<br>
         * Simply invokes {@link Class#getAnnotation(Class)}
         *
         * @param annoCls the Class object corresponding to the annotation type
         * @return this element's annotation for the specified annotation type
         * if present on this element, else null
         * @see Class#getAnnotation(Class)
         */
        public <A extends Annotation> A annotation(Class<A> annoCls) {
                return cls.getAnnotation(annoCls);
        }

        /**
         * Returns true if an annotation for the specified type is present on
         * this element, else false. This method is designed primarily for
         * convenient access to marker annotations.<br>
         * Simply invoke {@link Class#isAnnotationPresent(Class)}
         *
         * @param annoCls the Class object corresponding to the annotation type
         * @return true if an annotation for the specified annotation type is
         * present on this element, else false
         */
        public <A extends Annotation> boolean isAnnotationPresent(Class<A> annoCls) {
                return cls.isAnnotationPresent(annoCls);
        }

        /**
         * Determines if the specified Object is assignment-compatible with the
         * object represented by this Class. This method is the dynamic
         * equivalent of the Java language instanceof operator. The method
         * returns true if the specified Object argument is non-null and can be
         * cast to the reference type represented by this Class object without
         * raising a ClassCastException. It returns false otherwise.<br>
         * Simply invoke {@link Class#isInstance(Object)}
         *
         * @param obj the object to check
         * @return true if obj is an instance of this class
         * @see Class#isInstance(Object)
         */
        public boolean isInstance(Object obj) {
                return cls.isInstance(obj);
        }

        /**
         * Retrieve constructor with no parameters
         *
         * @return a constructor supporter which supports found constructor
         */
        public ConstructorSup<T> constructor() {
                return constructor(new Class[0]);
        }

        /**
         * Retrieve constructor with given parameters types
         *
         * @return a constructor supporter which supports found constructor
         */
        public ConstructorSup<T> constructor(Class<?>... argTypes) {
                try {
                        return mapper.get("constructors." + Arrays.toString(argTypes), () -> new ConstructorSup<>(cls.getConstructor(argTypes)));
                } catch (Exception e) {
                        throw $(e);
                }
        }

        /**
         * Retrieve constructor with given parameters types in the form of a
         * $(array/iterable)
         *
         * @return a constructor supporter which supports found constructor
         * @see net.cassite.style.aggregation.Aggregation#$(Iterable)
         * @see net.cassite.style.aggregation.Aggregation#$(Object[])
         */
        public ConstructorSup<T> constructor(A1FuncSup<Class<?>> argTypes) {
                List<Class<?>> typeList = new ArrayList<>();
                argTypes.forEach((VFunc1<Class<?>>) typeList::add);
                return constructor(typeList.toArray(new Class[typeList.size()]));
        }

        /**
         * Retrieve a field supporter with given field name
         *
         * @param name name of the field
         * @param <F>  field type
         * @return a field supporter which supports found field
         */
        @SuppressWarnings("unchecked")
        public <F> FieldSupport<F, T> field(String name) {
                return field(name, (Class<F>) Object.class);
        }

        /**
         * Retrieve a field supporter with given field name, and specify its
         * type with the 2nd arg
         *
         * @param name name of the field
         * @param type field type
         * @param <F>  field type
         * @return a field supporter which supports found field
         */
        public <F> FieldSupport<F, T> field(String name, Class<F> type) {
                net.cassite.style.ptr<Class<?>> clazz = ptr(cls);
                return mapper.get("fields." + name, () -> new FieldSupport<>(While(() -> $(clazz) != Object.class, () -> {
                        try {
                                return BreakWithResult(cls.getDeclaredField(name));
                        } catch (NoSuchFieldException e) {
                                $(clazz, $(clazz).getSuperclass());
                                return Continue();
                        }
                }), type, cls));
        }

        /**
         * Retrieve all field supporters which the class contains
         *
         * @return a list with field supporters which supports fields in the
         * class
         */
        public List<FieldSupport<?, T>> allFields() {
                net.cassite.style.ptr<Class<?>> clazz = ptr(cls);
                return While(() -> $(clazz) != Object.class, (i) -> {
                        List<FieldSupport<?, T>> list = avoidNull(i.lastRes, () -> new ArrayList<>());
                        $($(clazz).getDeclaredFields()).forThose(e -> avoidNull($(list).forEach(t -> {
                                if (e.getName().equals(t.name()))
                                        BreakWithResult(false);
                                return true;
                        }), () -> true), e -> {
                                list.add(mapper.get("fields." + e.getName(), () -> new FieldSupport<>(e, Object.class, cls)));
                        });
                        $(clazz, $(clazz).getSuperclass());
                        return list;
                });
        }

        /**
         * Retrieve the supporter with given method name and parameter types,
         * and specify the return type with the 2nd arg
         *
         * @param name       name of the method
         * @param returnType return type
         * @param argTypes   parameter types
         * @return a method supporter which supports found method
         */
        public <R> MethodSupport<R, T> method(String name, Class<R> returnType, Class<?>... argTypes) {
                net.cassite.style.ptr<Class<?>> clazz = ptr(cls);
                return mapper.get("methods." + name + Arrays.toString(argTypes),
                        () -> new MethodSupport<>(While(() -> $(clazz) != Object.class, () -> {
                                try {
                                        return BreakWithResult(cls.getDeclaredMethod(name, argTypes));
                                } catch (NoSuchMethodException e) {
                                        $(clazz, $(clazz).getSuperclass());
                                        return Continue();
                                }
                        }), returnType, cls));
        }

        /**
         * Retrieve all method supporters which the class contains
         *
         * @return a list with method supporters which supports methods in the
         * class
         */
        public List<MethodSupport<?, T>> allMethods() {
                net.cassite.style.ptr<Class<?>> clazz = ptr(cls);
                return While(() -> $(clazz) != Object.class, (i) -> {
                        List<MethodSupport<?, T>> list = avoidNull(i.lastRes, () -> new ArrayList<>());
                        $($(clazz).getDeclaredMethods()).forThose(method -> avoidNull($(list).forEach(packed -> {
                                if (method.getName().equals(packed.name()) && method.getParameterTypes().length == packed.argTypes().length
                                        && avoidNull($(method.getParameterTypes()).forEach((ep, info) -> {
                                        if (!ep.equals(packed.argTypes()[info.currentIndex]))
                                                return BreakWithResult(false);
                                        return true;
                                }), () -> false))
                                        BreakWithResult(false);
                                return true;
                        }), () -> true), e -> {
                                list.add(mapper.get("methods." + e.getName() + Arrays.toString(e.getParameterTypes()),
                                        () -> new MethodSupport<>(e, Object.class, cls)));
                        });
                        $(clazz, $(clazz).getSuperclass());
                        return list;
                });
        }

        public String toString() {
                return cls.toString();
        }

        // modifiers

        /**
         * Check whether this has modifier 'public'
         *
         * @return true if has, false otherwise
         */
        public boolean isPublic() {
                return Modifier.isPublic(getCls().getModifiers());
        }

        /**
         * Check whether this has modifier 'protected'
         *
         * @return true if has, false otherwise
         */
        public boolean isProtected() {
                return Modifier.isProtected(getCls().getModifiers());
        }

        /**
         * Check whether this has modifier 'private'
         *
         * @return true if has, false otherwise
         */
        public boolean isPrivate() {
                return Modifier.isPrivate(getCls().getModifiers());
        }

        /**
         * Check whether this has modifier 'abstract'
         *
         * @return true if has, false otherwise
         */
        public boolean isAbstract() {
                return Modifier.isAbstract(getCls().getModifiers());
        }

        /**
         * Check whether this has modifier 'final'
         *
         * @return true if has, false otherwise
         */
        public boolean isFinal() {
                return Modifier.isFinal(getCls().getModifiers());
        }

        /**
         * Check whether this has modifier 'interface'
         *
         * @return true if has, false otherwise
         */
        public boolean isInterface() {
                return Modifier.isInterface(getCls().getModifiers());
        }

        /**
         * Check whether this has modifier 'native'
         *
         * @return true if has, false otherwise
         */
        public boolean isNative() {
                return Modifier.isNative(getCls().getModifiers());
        }

        /**
         * Check whether this has modifier 'static'
         *
         * @return true if has, false otherwise
         */
        public boolean isStatic() {
                return Modifier.isStatic(getCls().getModifiers());
        }

        /**
         * Check whether this has modifier 'strict'
         *
         * @return true if has, false otherwise
         */
        public boolean isStrict() {
                return Modifier.isStrict(getCls().getModifiers());
        }

        /**
         * Check whether this has modifier 'synchronized'
         *
         * @return true if has, false otherwise
         */
        public boolean isSynchronized() {
                return Modifier.isSynchronized(getCls().getModifiers());
        }

        /**
         * Check whether this has modifier 'transient'
         *
         * @return true if has, false otherwise
         */
        public boolean isTransient() {
                return Modifier.isTransient(getCls().getModifiers());
        }

        /**
         * Check whether this has modifier 'volatile'
         *
         * @return true if has, false otherwise
         */
        public boolean isVolatile() {
                return Modifier.isVolatile(getCls().getModifiers());
        }

        /**
         * retrieve all setters
         *
         * @return setters in the form of MethodSupport
         */
        public List<MethodSupport<?, T>> setters() {
                List<MethodSupport<?, T>> methods = allMethods();
                List<MethodSupport<?, T>> toReturn = new ArrayList<>();
                methods.forEach(e -> {
                        if (e.name().startsWith("set") && e.name().length() > 3 && e.name().charAt(3) >= 'A' && e.name().charAt(3) <= 'Z'
                                && e.argCount() == 1 &&
                                (e.returnType().equals(Void.TYPE) || e.returnType().equals(e.getMember().getDeclaringClass()))
                                && !e.isStatic())
                                toReturn.add(e);
                });
                return toReturn;
        }

        /**
         * retrieve all getters
         *
         * @return getters in the form of MethodSupport
         */
        public List<MethodSupport<?, T>> getters() {
                List<MethodSupport<?, T>> methods = allMethods();
                List<MethodSupport<?, T>> toReturn = new ArrayList<>();
                methods.forEach(e -> {
                        if (e.name().startsWith("get") && e.name().length() > 3 && e.name().charAt(3) >= 'A' && e.name().charAt(3) <= 'Z'
                                && e.argCount() == 0 && !e.returnType().equals(Void.TYPE) && !e.isStatic())
                                toReturn.add(e);
                });
                return toReturn;
        }

        /**
         * retrieve all constructors
         *
         * @return constructors in the form of ConstructorSup
         */
        @SuppressWarnings("unchecked")
        public List<ConstructorSup<T>> constructors() {
                List<ConstructorSup<T>> toReturn = new ArrayList<>();
                $(cls.getDeclaredConstructors()).forEach((VFunc1<Constructor<?>>) c -> toReturn.add(mapper.get("constructors." + Arrays.toString(c.getParameterTypes()),
                        () -> new ConstructorSup<>((Constructor<T>) c))));
                return toReturn;
        }

        /**
         * create a new instance invoking constructor().newInstance;
         *
         * @return new instance
         * @see ConstructorSup#newInstance()
         */
        public T newInstance() {
                return constructor().newInstance();
        }

}
