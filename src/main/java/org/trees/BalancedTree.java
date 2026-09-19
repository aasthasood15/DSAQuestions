package org.trees;

public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        int height = getHeight(root);
        return (height!=-1);
    }
    public int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        // post order traversal
        int leftSubtreeHeight = getHeight(root.left);
        int rightSubtreeHeight = getHeight(root.right);
        if(leftSubtreeHeight==-1 || rightSubtreeHeight==-1){
            return -1;
        }
        if(Math.abs(leftSubtreeHeight - rightSubtreeHeight)>1){
            return -1;
        }
        return 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }
}
