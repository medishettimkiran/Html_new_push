task 7.1
class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class LongestUnivaluePath {
    private int maxLength = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxLength;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftLength = dfs(node.left);
        int rightLength = dfs(node.right);

        int leftPath = 0, rightPath = 0;
        if (node.left != null && node.left.val == node.val) {
            leftPath = leftLength + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            rightPath = rightLength + 1;
        }

        maxLength = Math.max(maxLength, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);

        LongestUnivaluePath solution = new LongestUnivaluePath();
        System.out.println("Longest Univalue Path Length: " + solution.longestUnivaluePath(root));
    }
}