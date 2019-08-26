package old.leetCode.part102;

import java.util.ArrayList;
import java.util.*;

public class LevelOrder {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;

          TreeNode(int x) {
              val = x;
          }
      }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        if (root != null)
            linkedList.push(root);


        while(!linkedList.isEmpty()){
            List<Integer> list = new LinkedList<>();
            LinkedList<TreeNode> temp = new LinkedList<>();
            while(!linkedList.isEmpty()){
                TreeNode node = linkedList.poll();
                list.add(node.val);
                temp.offer(node);
            }
            result.add(list);
            while(!temp.isEmpty()){
                TreeNode node = temp.poll();
                if (node.left != null)
                    linkedList.offer(node.left);
                if (node.right != null)
                    linkedList.offer(node.right);
            }
        }
        return result;
    }
}
