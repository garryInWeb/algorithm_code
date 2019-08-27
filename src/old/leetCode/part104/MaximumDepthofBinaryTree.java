package old.leetCode.part104;

public class MaximumDepthofBinaryTree {


    //  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public int maxDepth(TreeNode root) {

        return depthFirstOrderCount(0,root);
    }
    private int depthFirstOrderCount(int count, TreeNode node){
        if (node == null)
            return 0;

        return count + 1 + Math.max(depthFirstOrderCount(count,node.left),
                depthFirstOrderCount(count,node.right));
    }
}
