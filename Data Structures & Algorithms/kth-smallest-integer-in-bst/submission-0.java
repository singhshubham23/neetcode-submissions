
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> l1 = new ArrayList<>();
        inorder(root, l1);
        return l1.get(k-1);
    }
    private void inorder(TreeNode root, List<Integer> l1) {
        if(root == null) return;
        inorder(root.left, l1);
        l1.add(root.val);
        inorder(root.right, l1);
    }
}
