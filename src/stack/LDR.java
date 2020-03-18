package stack;

import java.util.*;

public class LDR {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        travel(root);
        return ans;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Set<TreeNode> visited = new HashSet<>();
        List<Integer> ans2 = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left == null || visited.contains(node.left)) {
                ans2.add(node.val);
                stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
            } else {
                stack.push(node.left);
            }


            visited.add(node);

        }

        return ans2;
    }

    void travel(TreeNode node) {
        if (node == null) {
            return;
        }
        travel(node.left);
        ans.add(node.val);
        travel(node.right);
    }

    public static  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = null;
        node1.right = node2;
        node2.left = node3;
        node2.right = null;
        node3.left = null;
        node3.right = null;

        System.out.println(new LDR().inorderTraversal2(node1));
    }
}
