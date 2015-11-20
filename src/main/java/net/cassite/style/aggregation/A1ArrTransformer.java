package net.cassite.style.aggregation;

import net.cassite.style.def;

import static net.cassite.style.Core.*;

import net.cassite.style.interfaces.RFunc1;

/**
 * Interface of classes to transform an array or an iterable object into another
 * array
 *
 * @param <R> returned array type
 * @param <T> input array/iterable type
 * @author wkgcass
 */
public interface A1ArrTransformer<R, T> {
        /**
         * define the transform process
         *
         * @param method a function takes in each object from the
         *               array/iterable and returns it's transformed state.
         * @return an array with objects after the transform
         */
        default R[] via(RFunc1<R, T> method) {
                return via($(method));
        }

        /**
         * define the transform process
         *
         * @param method a function takes in each object from the
         *               array/iterable and returns it's transformed state.
         * @return an array with objects after the transform
         */
        R[] via(def<R> method);
}
