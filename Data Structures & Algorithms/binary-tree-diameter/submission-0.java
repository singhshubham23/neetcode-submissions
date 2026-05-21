/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int d = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return d;
    }
    private int height(TreeNode node){
        if(node == null) return 0;

        int l = height(node.left);
        int r = height(node.right);

        d = Math.max(d,l+r);
        return 1+Math.max(l,r);
    }
}
