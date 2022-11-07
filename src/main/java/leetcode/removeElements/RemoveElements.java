package leetcode.removeElements;

import java.util.Arrays;

public class RemoveElements {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1, 1, 2}, 2));
        System.out.println(removeElement(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 1));
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));

    }

    public static int removeElement(int[] nums, int val) {
        int cursor = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[cursor] = nums[i];
                cursor++;
            }
        }
        return cursor;
    }
}
