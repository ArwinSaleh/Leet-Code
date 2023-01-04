package medium_problems.lca_binary_search_tree;
class Main {
    public static void main(String[] args) {
        Solution testSolution = new Solution();
        TreeNode testNode = new TreeNode(6, new TreeNode(2), new TreeNode(8));
        testNode.left.left = new TreeNode(0);
        testNode.left.right = new TreeNode(4);
        testNode.right.left = new TreeNode(7);
        testNode.right.right = new TreeNode(9);
        TreeNode testNodeP = new TreeNode(2);
        TreeNode testNodeQ = new TreeNode(4);
        TreeNode result = testSolution.lowestCommonAncestor(testNode, testNodeP, testNodeQ);
        System.out.println(result.val);
    }
}

/**
 *** NOTE: COMMENTS TAKEN FROM LEETCODE SAMPLE SUBMISSION ***
If the node that we are at is in between or equal to both p and q, then we know that we have
found our solution. 
Otherwise, there are 2 cases
both p and q are greater than current node, so we traverse right
both p and q are lesser than current node, so we traverse left
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int x, TreeNode y, TreeNode z) {
        val = x;
        left = y;
        right = z;
    }
}