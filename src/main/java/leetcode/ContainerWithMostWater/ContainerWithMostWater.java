package leetcode.ContainerWithMostWater;

import org.junit.Assert;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        Assert.assertEquals(49, maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        Assert.assertEquals(42, maxArea(new int[]{1,8,6,2,8,4,8,3,6}));

    }

    public static int maxArea(int[] height) {
        int maxV = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int l = height[left];
            int r = height[right];
            if (l < r) {
                int V = (right - left) * l;
                if (V > maxV) { maxV = V; }
                left++;
            } else {
                int V = (right - left) * r;
                if (V > maxV) { maxV = V; }
                right--;
            }

        }
        return maxV;
    }

}
