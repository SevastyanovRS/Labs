package leetcode.twosum;


import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));

        stopWatch.stop();
        System.out.println("Spend time: " + stopWatch.getTotalTimeNanos());

    }

    //4 ms
    public static int[] twoSum2(int[] nums, int target) {
        int n = nums.length;
        int ans[] = new int[2];

        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(mp.containsKey(target - nums[i])){
                ans[0] = i;
                ans[1] = mp.get(target - nums[i]);
                return ans;
            }
            else{
                mp.put(nums[i], i);
            }
        }
        return ans;
    }

    //132 ms
    public static int[] twoSum(int[] nums, int target) {
        for (int f = 0; f < nums.length; f++) {
            for (int s = f+1; s < nums.length; s++) {
                if (nums[f]+nums[s] == target) {
                    return new int[] {f, s};
                }
            }
        }
        throw new RuntimeException();
    }
}
