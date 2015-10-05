package net.cassite.style.aggregation;

import java.util.Collection;

import net.cassite.style.def;
import static net.cassite.style.Style.*;
import net.cassite.style.interfaces.RFunc1;

/**
 * Transformer which transforms an array/iterable into a collection
 * 
 * @author wkgcass
 *
 * @param <R>
 *                element type of collection to transform to
 * @param <T>
 *                element type of the array/iterable
 * @param <Coll>
 *                collection
 */
public interface A1Transformer<R, T, Coll extends Collection<R>> {
        /**
         * define the transform process
         * 
         * @param method
         *                a function takes in each object from the
         *                array/iterable and returns it's transformed state.
         * @return collection with objects after the transform
         */
        default Coll via(RFunc1<R, T> method) {
                return via($(method));
        }

        /**
         * define the transform process
         * 
         * @param method
         *                a function returns it's transformed state.
         * @return collection with objects after the transform
         */
        Coll via(def<R> method);
}
