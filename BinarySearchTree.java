public class BinarySearchTree {
    class TreeNode {
//         root = null;
        int val;
        TreeNode root;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;

        }


    }

    public int maxDepth(TreeNode root) {
        int depth = 0;
        if(root == null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        if(leftHeight < rightHeight) {
            depth = 1 + rightHeight;
        } else{
            depth = 1 + leftHeight;
        }
        return depth;
    }
}
