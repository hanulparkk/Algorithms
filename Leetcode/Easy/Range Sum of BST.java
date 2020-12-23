/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
* Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
* Output: 23
*/

// First solution
class Solution {
    private static int sum;
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        inOrder(root, low, high);
        return sum;
    }
    
    public void inOrder(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }

        inOrder(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }
        inOrder(root.right, low, high);
    }
}

// Second solution
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        
        int rootval = 0;
        if (root.val >= low && root.val <= high) {
            rootval =  root.val;
        }
        if (root.left == null || root.val <= low) {
            return rootval + rangeSumBST(root.right, low, high);
        }
        if (root.right == null || root.val >= high) {
            return rootval + rangeSumBST(root.left, low, high);
        }
        return rangeSumBST(root.left, low, high) + rootval + rangeSumBST(root.right, low, high);
    }
}

// Third solution
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;   
        }
        
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if (node.val >= low && node.val <= high) {
                sum += node.val; 
            }
            
            if (node.left != null && node.val >= low) {
                queue.offer(node.left);
            }
            
            if (node.right != null && node.val <= high) {
                queue.add(node.right);
            }
        }
        return sum;
    }
}