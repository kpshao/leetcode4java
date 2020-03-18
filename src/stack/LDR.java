package stack;

import java.util.ArrayList;
import java.util.List;

public class LDR {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        travel(root);
        return ans;
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
}
