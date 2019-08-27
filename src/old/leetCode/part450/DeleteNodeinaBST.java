package old.leetCode.part450;

public class DeleteNodeinaBST {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = root;
        TreeNode preNode = null;
        while(node != null && node.val != key) {
            preNode = node;
            if (key < node.val) {
                node = node.left;
            }else {
                node = node.right;
            }
        }

        if (node == null)
            return root;

        if (node.left != null && node.right != null){
            preNode = node;
            TreeNode rightNode = node.right;
            while(rightNode.left != null){
                preNode = rightNode;
                rightNode = rightNode.left;
            }
            node.val = rightNode.val;
            node = rightNode;
        }

        TreeNode changeNode;
        if (node.left != null) changeNode = node.left;
        else if(node.right != null) changeNode = node.right;
        else changeNode = null;

        if (preNode == null)
            root = changeNode;
        else if (preNode.left == node)
            preNode.left = changeNode;
        else
            preNode.right = changeNode;

        return root;
    }
}
