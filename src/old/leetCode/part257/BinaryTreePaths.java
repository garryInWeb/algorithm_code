package old.leetCode.part257;

import java.util.*;

public class BinaryTreePaths {

    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return result;
        StringBuilder temp = new StringBuilder();
        temp.append(root.val);
        StringBuilder rTemp = new StringBuilder(temp);
        if (root.left == null && root.right == null)
            result.add(temp.toString());
        if (root.left != null){
            binaryF(root.left,temp);
        }
        if (root.right != null){
            binaryF(root.right,new StringBuilder(rTemp));
        }

        return result;
    }
    public void binaryF(TreeNode root,StringBuilder temp){
        temp.append("->" + root.val);
        if (root.left != null){
            binaryF(root.left,new StringBuilder(temp));
        }

        if (root.right != null){
            binaryF(root.right,new StringBuilder(temp));
        }
        if (root.right == null && root.left == null)
            result.add(temp.toString());

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode.left = treeNode2;
        treeNode2.right = treeNode5;
        treeNode.right = treeNode3;

        BinaryTreePaths paths = new BinaryTreePaths();
        paths.binaryTreePaths(treeNode);
    }
}
