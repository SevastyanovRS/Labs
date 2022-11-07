package leetcode.SearchInsertPosition;

import org.junit.Assert;

public class SearchInsertPosition {

    public static void main(String[] args) {
        Assert.assertEquals(2, searchInsert(new int[]{1,3,5,6}, 5));
        Assert.assertEquals(1, searchInsert(new int[]{1,3,5,6}, 2));
        Assert.assertEquals(4, searchInsert(new int[]{1,3,5,6}, 7));

    }

    public static int searchInsert(int[] nums, int target) {
        int cursor = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] < target) {
                cursor++;
            } else if (nums[i] > target) {
                return cursor;
            }
        }
        return cursor;
    }
}
