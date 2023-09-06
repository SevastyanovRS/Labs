package lab;

import java.util.Arrays;

public class ArrayReference {

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,5};
        System.out.println(Arrays.toString(ints));

        doSomething(ints);

        System.out.println(Arrays.toString(ints));

    }

    private static void doSomething(int[] nums) {

        nums[1] = 500;

    }
}
