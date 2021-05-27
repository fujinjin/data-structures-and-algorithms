package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintTreeNode {
    public List<List<Integer>> Print(TreeNode pRoot) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        Queue<TreeNode> qu2 = new LinkedList<>();
        if (pRoot == null) {
            return result;
        }
        qu.add(pRoot);
        while (!qu.isEmpty() || !qu2.isEmpty()){
            List<Integer> list = new ArrayList<>();
            while (!qu.isEmpty() && qu.peek()!=null){
                qu2.add(qu.peek());
                list.add(qu.peek().val);
                qu.remove(qu.peek());
            }
            result.add(list);
            while (!qu2.isEmpty() && qu2.peek() !=null){
                if (qu2.peek().left != null){
                    qu.add(qu2.peek().left);
                }
                if (qu2.peek().right !=null){
                    qu.add(qu2.peek().right);
                }
                qu2.remove(qu2.peek());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);
        treeNode.setLeft(new TreeNode(5));
        treeNode.setRight(new TreeNode(8));
        treeNode.getRight().setLeft(new TreeNode(9));
        treeNode.getRight().setRight(new TreeNode(10));
        treeNode.getLeft().setLeft(new TreeNode(4));
        treeNode.getLeft().setRight(new TreeNode(3));
        PrintTreeNode printTreeNode = new PrintTreeNode();
        List<List<Integer>> result = printTreeNode.Print(treeNode);
        for (List<Integer> subResult : result ) {
            for (Integer num : subResult){
                System.out.println(num);
            }
        }
    }
}
