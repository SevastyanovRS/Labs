package leetcode.Permutations;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1, 2, 3}));

    }
    public static void generate(int[] nums, List<List<Integer>> v, int i)
    {
        if (i >= nums.length) {
            ArrayList<Integer> cl = new ArrayList<>();
            for(int x: nums) {
                cl.add(x);
            }
            v.add(cl);
            return;
        }
        for (int j=i; j<nums.length; j++) {
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            generate(nums,v,i+1);
            temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }

    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>v=new ArrayList<>();
        generate(nums,v,0);
        return v;
    }

}
