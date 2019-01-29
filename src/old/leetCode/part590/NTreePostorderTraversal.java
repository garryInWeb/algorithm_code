package old.leetCode.part590;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengtengfei on 2019/1/29.
 */
public class NTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        recursion(root,result);
        return result;
    }
    public void recursion(Node root,List<Integer> result){
        if (root.children == null){
            result.add(root.val);
        }else{
            for (Node node : root.children){
                recursion(node,result);
            }
            result.add(root.val);
        }
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
};
