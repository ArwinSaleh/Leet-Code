import java.util.*;

class Main {
    public static void main(String[] args) {
        IterativeSolution testSolution = new IterativeSolution();
        TreeNode testNode = new TreeNode(1);
        testNode.right = new TreeNode(2);
        testNode.right.left = new TreeNode(3);
        List<Integer> result = testSolution.preorderTraversal(testNode);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        traverseTree(root, preorder);
        return preorder;
    }
    private void traverseTree(TreeNode node, List<Integer> preorder) {
        if (node == null) {
            return;
        }
        preorder.add(node.val);
        traverseTree(node.left, preorder);
        traverseTree(node.right, preorder);
    }
}

class IterativeSolution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> rightNodes = new Stack<>();
        while (root != null) {
            preorder.add(root.val);
            if (root.right != null) {
                rightNodes.add(root.right);
            }
            root = root.left;
            if (root == null && !rightNodes.isEmpty()) {
                root = rightNodes.pop();
            }
        }
        return preorder;
    }
}