package leetcode.PlusOne;

import org.junit.Assert;

import java.util.Arrays;
import java.util.stream.Stream;

public class PlusOne {

    public static void main(String[] args) {
        Assert.assertEquals(Arrays.toString(new int[]{4, 3, 2, 2}), Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
        Assert.assertEquals(Arrays.toString(new int[]{1,0}), Arrays.toString(plusOne(new int[]{9})));
        Assert.assertEquals(Arrays.toString(new int[]{1,0,0,0}), Arrays.toString(plusOne(new int[]{9,9,9})));
        Assert.assertEquals(Arrays.toString(new int[]{9,8,7,6,5,4,3,2,1,1}), Arrays.toString(plusOne(new int[]{9,8,7,6,5,4,3,2,1,0})));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        int[] newOne = new int[digits.length+1];
        newOne[0] = 1;
        return newOne;
    }

}
