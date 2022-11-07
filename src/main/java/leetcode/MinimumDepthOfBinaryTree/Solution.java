package leetcode.MinimumDepthOfBinaryTree;


import leetcode.util.TreeNode;
import org.junit.Assert;

class Solution {

    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(15);
        TreeNode tn2 = new TreeNode(7);
        TreeNode tn3 = new TreeNode(20, tn2, tn1);
        TreeNode tn4 = new TreeNode(9);
        TreeNode tn5 = new TreeNode(3, tn3, tn4);

        Assert.assertEquals(2, minDepth(tn5));

        TreeNode tn2_1 = new TreeNode(6, null, null);
        TreeNode tn2_2 = new TreeNode(5, null, tn2_1);
        TreeNode tn2_3 = new TreeNode(4, null, tn2_2);
        TreeNode tn2_4 = new TreeNode(3, null, tn2_3);
        TreeNode tn2_5 = new TreeNode(2, null, tn2_4);

        Assert.assertEquals(5, minDepth(tn2_5));

    }

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return (left==0 || right == 0) ? left + right + 1 : Math.min(left, right)+1;
    }
}