package leetcode.CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        generate(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void generate(int[] candidates, int target, int cursor, ArrayList<Integer> sum, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(sum));
            return;
        }

        for (int i = cursor; i<candidates.length; i++) {
            if(cursor!= i && candidates[i]==candidates[i-1])
                continue;

            if (candidates[i] <= target) {
                sum.add(candidates[i]);
                generate(candidates, target - candidates[i], i + 1, sum, result);
                sum.remove(Integer.valueOf(candidates[i]));
            }

        }
    }


}
