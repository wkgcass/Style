package net.cassite.style.reflect;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

/**
 * Supporter for members
 * 
 * @author wkgcass
 *
 * @param <T>
 *                type of the supported member(Field, Method, Constructor)
 */
public interface MemberSup<T extends Member> {
        /**
         * retrieve the supporting member
         * 
         * @return
         */
        T getMember();

        /**
         * Returns the simple name of the underlying member or constructor
         * represented by this Member.
         * 
         * 
         * @return the simple name of the underlying member
         */
        default String name() {
                return getMember().getName();
        }

        /**
         * Check if this member has modifier 'public'
         * 
         * @return true if has, false otherwise.
         */
        default boolean isPublic() {
                return Modifier.isPublic(getMember().getModifiers());
        }

        /**
         * Check if this member has modifier 'protected'
         * 
         * @return true if has, false otherwise.
         */
        default boolean isProtected() {
                return Modifier.isProtected(getMember().getModifiers());
        }

        /**
         * Check if this member has modifier 'private'
         * 
         * @return true if has, false otherwise.
         */
        default boolean isPrivate() {
                return Modifier.isPrivate(getMember().getModifiers());
        }

        /**
         * Check if this member has modifier 'abstract'
         * 
         * @return true if has, false otherwise.
         */
        default boolean isAbstract() {
                return Modifier.isAbstract(getMember().getModifiers());
        }

        /**
         * Check if this member has modifier 'final'
         * 
         * @return true if has, false otherwise.
         */
        default boolean isFinal() {
                return Modifier.isFinal(getMember().getModifiers());
        }

        /**
         * Check if this member has modifier 'interface'
         * 
         * @return true if has, false otherwise.
         */
        default boolean isInterface() {
                return Modifier.isInterface(getMember().getModifiers());
        }

        /**
         * Check if this member has modifier 'native'
         * 
         * @return true if has, false otherwise.
         */
        default boolean isNative() {
                return Modifier.isNative(getMember().getModifiers());
        }

        /**
         * Check if this member has modifier 'static'
         * 
         * @return true if has, false otherwise.
         */
        default boolean isStatic() {
                return Modifier.isStatic(getMember().getModifiers());
        }

        /**
         * Check if this member has modifier 'strict'
         * 
         * @return true if has, false otherwise.
         */
        default boolean isStrict() {
                return Modifier.isStrict(getMember().getModifiers());
        }

        /**
         * Check if this member has modifier 'synchronized'
         * 
         * @return true if has, false otherwise.
         */
        default boolean isSynchronized() {
                return Modifier.isSynchronized(getMember().getModifiers());
        }

        /**
         * Check if this member has modifier 'transient'
         * 
         * @return true if has, false otherwise.
         */
        default boolean isTransient() {
                return Modifier.isTransient(getMember().getModifiers());
        }

        /**
         * Check if this member has modifier 'volatile'
         * 
         * @return true if has, false otherwise.
         */
        default boolean isVolatile() {
                return Modifier.isVolatile(getMember().getModifiers());
        }
}
