
class Solution {
    private int preorderIndex;
    private Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, inorder.length-1);
    }

    private TreeNode arrayToTree(int[] preorder, int l, int r){
        if(l > r) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inorderRootIndex = inorderIndexMap.get(rootVal);

        root.left = arrayToTree(preorder, l, inorderRootIndex-1);
        root.right = arrayToTree(preorder, inorderRootIndex+1, r);

        return root;
    }
}
