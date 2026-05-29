

class Solution {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode root){
        if(root == null) return 0;

        int lGain = Math.max(maxGain(root.left), 0);
        int rGain = Math.max(maxGain(root.right), 0);

        int currPathSum = root.val+lGain+rGain;

        maxSum = Math.max(maxSum, currPathSum);

        return root.val + Math.max(lGain, rGain);
    }
}
