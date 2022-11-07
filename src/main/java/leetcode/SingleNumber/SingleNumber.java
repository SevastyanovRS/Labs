package leetcode.SingleNumber;

import org.junit.Assert;

public class SingleNumber {

    public static void main(String[] args) {
        Assert.assertEquals(1, singleNumber(new int[]{1,2,2}));
        Assert.assertEquals(4, singleNumber(new int[]{4,1,2,1,3,2,3}));
    }

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }

        return res;
    }
}
