package tree;

import tools.TreePrinter;

import java.util.Arrays;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * 前序遍历：根结点 ---> 左子树 ---> 右子树
 *
 * 中序遍历：左子树---> 根结点 ---> 右子树
 *
 * 后序遍历：左子树 ---> 右子树 ---> 根结点
 *
 * 层次遍历：只需按层次遍历即可
 */
public class RecreateBinaryTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //数组长度为0的时候要处理
        if (pre.length == 0) {
            return null;
        }

        int rootVal = pre[0];

        //数组长度仅为1的时候就要处理
        if (pre.length == 1) {
            return new TreeNode(rootVal);
        }

        //我们先找到root所在的位置，确定好前序和中序中左子树和右子树序列的范围
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = 0; i < in.length; i++) {
            if (rootVal == in[i]) {
                rootIndex = i;
                break;
            }
        }

        //递归，假设root的左右子树都已经构建完毕，那么只要将左右子树安到root左右即可
        //这里注意Arrays.copyOfRange(int[],start,end)是[)的区间
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex + 1), Arrays.copyOfRange(in, 0, rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length), Arrays.copyOfRange(in, rootIndex + 1, in.length));


        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{8,6,5,7,10,9,11};
        int[] in = new int[]{5,6,7,8,9,10,11};
        RecreateBinaryTree recreateBinaryTree = new RecreateBinaryTree();
        TreeNode treeNode = recreateBinaryTree.reConstructBinaryTree(pre, in);
        TreePrinter.printBinaryTree(treeNode);

    }
}
