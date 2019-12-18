package tree;

import tools.TreePrinter;
/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。\
 * 递归的方式做的
 * */
public class BinaryTreeMirror {
    public static TreeNode mirror(TreeNode node) {
        if (node != null) {
            swap(node);
            if (node.left != null) {
                mirror(node.left);
            }
            if (node.right != null) {
                mirror(node.right);
            }
            return node;
        }
        return null;
    }

    static void swap(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
/**
 * 首先生成二叉树，再做镜像
 * */
    public static void main(String[] args) {
        int[] pre = new int[]{8, 6, 5, 7, 10, 9, 11};
        int[] in = new int[]{5, 6, 7, 8, 9, 10, 11};
        RecreateBinaryTree recreateBinaryTree = new RecreateBinaryTree();
        TreeNode inTreeNode = recreateBinaryTree.reConstructBinaryTree(pre, in);
        TreePrinter.printBinaryTree(inTreeNode);
        TreeNode outTreeNode = BinaryTreeMirror.mirror(inTreeNode);
        TreePrinter.printBinaryTree(outTreeNode);

    }
}
