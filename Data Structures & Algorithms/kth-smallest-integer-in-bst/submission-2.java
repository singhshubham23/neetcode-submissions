
class Solution {
    // ***************myLogic****************//
    // public int kthSmallest(TreeNode root, int k) {
    //     List<Integer> l1 = new ArrayList<>();
    //     inorder(root, l1);
    //     return l1.get(k-1);
    // }
    // private void inorder(TreeNode root, List<Integer> l1) {
    //     if(root == null) return;
    //     inorder(root.left, l1);
    //     l1.add(root.val);
    //     inorder(root.right, l1);
    // }

    private int cnt = 0;
    private int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        helper(root);
        return res;
    }
    private void helper(TreeNode node){
        if(node == null) return;

        helper(node.left);
        cnt--;

        if(cnt == 0){
            res = node.val;
            return;
        }
        helper(node.right);
    }
}
