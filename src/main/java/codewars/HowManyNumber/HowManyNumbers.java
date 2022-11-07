package codewars.HowManyNumber;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HowManyNumbers {

    public static void main(String[] args) {
//        assertTrue(digitsIsOrdered(123456L));
//        assertEquals(Arrays.asList(8L, 118L, 334L), HowManyNumbers.findAll(10, 3));
//        assertEquals(Arrays.asList(1L, 999L, 999L), HowManyNumbers.findAll(27, 3));
//        assertEquals(new ArrayList<Long>(), HowManyNumbers.findAll(84, 4));
//        assertEquals(Arrays.asList(123L, 116999L, 566666L), HowManyNumbers.findAll(35, 6));
        StopWatch stopWatch = new StopWatch("awqwe");
        stopWatch.start();
        assertEquals(Arrays.asList(255L, 11111599L, 33334444L), HowManyNumbers.findAll(28, 8));
        stopWatch.stop();
        System.out.println(stopWatch.getTime());
    }

    public static List<Long> findAll(final int sumDigits, final int numDigits) {
        int min = (int) (Math.pow(10, numDigits - 1));
        int max = (int) (Math.pow(10, numDigits));

        List<Integer> collect = IntStream.range(min, max)
//                .boxed()
                .filter(HowManyNumbers::digitsIsOrdered)
                .boxed()
                .filter(i -> sumDigits(i) == sumDigits)
//                .boxed()
                .toList();

        Integer maxInt = collect.stream().max(Comparator.comparing(Integer::intValue)).orElse(0);

        Integer minInt = collect.stream().min(Comparator.comparing(Integer::intValue)).orElse(0);

//        Integer maxInt = IntStream.range(min, max)
//                .boxed()
//                .filter(i -> sumDigits(i) == sumDigits)
//                .filter(HowManyNumbers::digitsIsOrdered)
//                .max(Comparator.comparing(Integer::intValue)).orElse(0);
//        Integer minInt = IntStream.range(min, max)
//                .boxed()
//                .filter(i -> sumDigits(i) == sumDigits)
//                .filter(HowManyNumbers::digitsIsOrdered)
//                .min(Comparator.comparing(Integer::intValue)).orElse(0);

        int count = collect.size();
//        int count = 255;

        return count > 0 ? List.of((long) count, minInt.longValue(), maxInt.longValue()) : new ArrayList<Long>();
    }

    public static long sumDigits(long i) {
        return i == 0 ? 0 : i % 10 + sumDigits(i / 10);
    }

    public static boolean digitsIsOrdered(long number) {
        long prevDigit = number % 10;
        long clone = number / 10;
        while (clone > 0) {
            long currentDigit = clone % 10;
            if (currentDigit > prevDigit) {
                return false;
            }
            prevDigit = currentDigit;
            clone = clone / 10;
        }
        return true;
    }
}
