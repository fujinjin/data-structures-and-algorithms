package tree;

import tools.TreePrinter;

import java.util.Stack;

/**
 * 二叉树先序遍历
 * */
public class BinaryIterator {
    // 非递归先序遍历
    public static void preOrderTraversal(TreeNode root) {
        // 用来暂存节点的栈
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        // 新建一个游标节点为根节点
        TreeNode node = root;
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !treeNodeStack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                System.out.print(node.val + " ");
                // 为了之后能找到该节点的右子树，暂存该节点
                treeNodeStack.push(node);
                node = node.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                node = node.right;
            }
        }
    }

    public static void main(String[] args) {
        int[] pre = new int[]{8, 6, 5, 7, 10, 9, 11};
        int[] in = new int[]{5, 6, 7, 8, 9, 10, 11};
        RecreateBinaryTree recreateBinaryTree = new RecreateBinaryTree();
        TreeNode treeNode = recreateBinaryTree.reConstructBinaryTree(pre, in);
        TreePrinter.printBinaryTree(treeNode);
        BinaryIterator.preOrderTraversal(treeNode);

    }
}
