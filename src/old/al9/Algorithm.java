package old.al9;

import java.util.Random;
import java.util.TreeMap;

/**
 * Created by zhengtengfei on 2018/11/27.
 */
public class Algorithm {

    // 查找
    public static boolean traversingPre(Tree tree, int aim){
        if (aim > tree.str)
            return tree.leftTree != null && traversingPre(tree.leftTree, aim);
        else
            return aim >= tree.str || tree.rightTree != null && traversingPre(tree.rightTree, aim);
    }
    public static Tree[] traversingMin(Tree tree,Tree parent){
        if (tree.leftTree == null){
            Tree[] trees = new Tree[2];
            trees[0] = tree;
            trees[1] = parent;
            return trees;
        }else{
            return traversingMin(tree.leftTree,tree);
        }
    }
    // 查找
    public static Tree[] traversing(Tree tree,Tree parent, int aim){
        if (aim == tree.str){
            Tree[] trees = new Tree[2];
            trees[0] = tree;
            trees[1] = parent;
            return trees;
        }else if(aim > tree.str){
            if (tree.leftTree == null){
                return null;
            }
            return traversing(tree.leftTree,tree,aim);
        }else{
            if (tree.rightTree == null){
                return null;
            }
            return traversing(tree.rightTree,tree,aim);
        }

    }
    // 插入
    public static void insert(Tree tree, int aim){
        if (aim > tree.str) {
            if (tree.leftTree == null) {
                Tree temp = new Tree();
                temp.str = aim;
                tree.leftTree = temp;
            } else {
                insert(tree.leftTree, aim);
            }
        }
        else {
            if (tree.rightTree == null) {
                Tree temp = new Tree();
                temp.str = aim;
                tree.rightTree = temp;
            } else {
                insert(tree.rightTree, aim);
            }
        }
    }
    // 中序遍历
    public static void traverse(Tree tree){
        if (tree.leftTree != null){
            traverse(tree.leftTree);
        }
        System.out.print(tree.str + ",");
        if (tree.rightTree != null){
            traverse(tree.rightTree);
        }
    }
    public static void del(Tree tree,int aim){
        Tree[] delTrees = traversing(tree,null,aim);
        Tree delTree = delTrees[0];
        Tree parent = delTrees[1];
        Tree nextTree = null;
        if (parent == null){
            tree = null;
        }
        if (delTree.leftTree == null || delTree.rightTree == null){
            if (delTree.leftTree == null){
                nextTree = delTree.rightTree;
            }else{
                nextTree = delTree.leftTree;
            }
        }
        if (delTree.leftTree !=null && delTree.rightTree !=null){
            Tree[] trees = traversingMin(delTree.rightTree,delTree);
            parent.rightTree = trees[0];
            trees[1].leftTree = null;
        }

        if (parent.leftTree == delTree){
            parent.leftTree = nextTree;
        }else if(parent.rightTree == delTree){
            parent.rightTree = nextTree;
        }
    }


    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.str = 1;
        Random random = new Random();
        for (int i = 2; i < 20; i ++){
            insert(tree,random.nextInt(20));
        }
        traverse(tree);
        System.out.println(traversingPre(tree,1));
//        System.out.println(traversing(tree,null,3)[1].str);
        del(tree,3);
        traverse(tree);
        TreeMap treeMap = new TreeMap();
        treeMap.put("","");
//        del(tree,4);
//        traverse(tree);

    }
}
