
public class Codec {

    // Encodes a tree to a single string.

    public void serializeHelp(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("X,");
            return;
        }

        sb.append(root.val).append(",");
        serializeHelp(root.left, sb);
        serializeHelp(root.right, sb);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelp(root, sb);
        return sb.toString();
    }



    // Decodes your encoded data to tree.
    public TreeNode deserializeHelp(Queue<String> nodes){
        String val = nodes.poll();
        if(val.equals("X")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));

        root.left = deserializeHelp(nodes);
        root.right = deserializeHelp(nodes);
        return root;
    }
    public TreeNode deserialize(String data) {
        Queue<String> node = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelp(node);
    }
}
