package net.cassite.style;

import org.junit.Test;

import static net.cassite.style.Style.*;

import java.math.BigInteger;

/**
 * test performance and compare
 */
public class TestPerformance {
        @Test
        public void testTimeOfPlainMulFrom0To100000() {
                BigInteger integer = new BigInteger("1");
                for (Integer i = 1; i <= 100000; ++i) {
                        integer = integer.multiply(new BigInteger(i.toString()));
                }
        }

        @Test
        public void testTimeOfMultipleThreadMulFrom0To100000() {
                def<BigInteger> cal1_25000 = $(() -> {
                        BigInteger integer = new BigInteger("1");
                        for (Integer i = 1; i <= 25000; ++i) {
                                integer = integer.multiply(new BigInteger(i.toString()));
                        }
                        return integer;
                });
                def<BigInteger> cal25001_50000 = $(() -> {
                        BigInteger integer = new BigInteger("1");
                        for (Integer i = 25001; i <= 50000; ++i) {
                                integer = integer.multiply(new BigInteger(i.toString()));
                        }
                        return integer;
                });
                def<BigInteger> cal50001_75000 = $(() -> {
                        BigInteger integer = new BigInteger("1");
                        for (Integer i = 50001; i <= 75000; ++i) {
                                integer = integer.multiply(new BigInteger(i.toString()));
                        }
                        return integer;
                });
                def<BigInteger> cal75001_100000 = $(() -> {
                        BigInteger integer = new BigInteger("1");
                        for (Integer i = 75001; i <= 100000; ++i) {
                                integer = integer.multiply(new BigInteger(i.toString()));
                        }
                        return integer;
                });
                AsyncGroup group = $(cal1_25000.async(), cal25001_50000.async(), cal50001_75000.async(), cal75001_100000.async());
                group.callbackSync((BigInteger r1_25, BigInteger r26_50, BigInteger r51_75, BigInteger r76_100) -> {
                        r1_25.multiply(r26_50).multiply(r51_75).multiply(r76_100).toString();
                });
        }
}
