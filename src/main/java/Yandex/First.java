package Yandex;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class First {

    /**
     * ана последовательность целых чисел.
     * Необходимо найти минимально возможное произведение пары элементов последовательности.
     * Например, для последовательности чисел 9 4 2 5 3 ответ будет 6.
     * @param args
     */
    public static void main(String[] args) {

//        9 4 2 5 3
        // 1 отрицательное и минимальное одно положительное
        // либо находим два минимальных положительных числа
        // находим наибольшеи отрицательные два числа
        int[] intsPositive = {9, 4, 2, 5, 3};
        Assert.assertEquals(6, minMultiplex(intsPositive));

        int[] intsNegative = {9, 4, -2, -5, 3};
        Assert.assertEquals(-45, minMultiplex(intsNegative));

        int[] intsNegativeOnly = {-9, -4, -2, -5, -3};
        Assert.assertEquals(6, minMultiplex(intsNegativeOnly));

        int[] intsNegative2 = {-9, -4, 2, -5, -3};
        int a = intsNegative2.length;
        Assert.assertEquals(-18, minMultiplex(intsNegative2));

        int[] intsNegative3 = {-9, -4, 2, 5, 3};
        Assert.assertEquals(-45, minMultiplex(intsNegative3));
    }

    public static int minMultiplex(int[] ints) {
        List<Integer> integers = Arrays.stream(ints).sorted().boxed().toList();

        int first = integers.get(0);
        int second = integers.get(1);

        if (first < 0 && second > 0 || second < 0 && integers.get(integers.size() - 1) > 0) {
            second = integers.get(integers.size() - 1);
        } else if (first < 0 && second < 0) {
            first = integers.get(integers.size()-1);
            second = integers.get(integers.size()-2);
        }

        return first * second;
    }

}
