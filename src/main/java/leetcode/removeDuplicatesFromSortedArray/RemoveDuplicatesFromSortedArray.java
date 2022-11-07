package leetcode.removeDuplicatesFromSortedArray;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        System.out.println(removeDuplicates2(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates2(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));

    }

    public static int removeDuplicates2(int[] nums) {
        int j = 1;
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[j]) {
                count++;
                nums[count] = nums[j];
            }
            j++;
        }
        return count + 1;

    }

    public static int removeDuplicates(int[] nums) {
        int cnt = 0;
        int j = 1;

        for (int cursor = 0; cursor < nums.length - 1; cursor++) {
            if (nums[j] != nums[cursor]) {
                cnt++;
                nums[cnt] = nums[j];
            }
            j++;
        }

        return cnt+1;
    }
}
