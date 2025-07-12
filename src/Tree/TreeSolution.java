package Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeSolution {

    public static void main(String[] args) {

    }

    private static TreeNode invertTree(TreeNode root)
    {
        if(root == null)
        {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    private static int depthOfTree(TreeNode root)
    {
        if (root == null)
            return 0;

        return 1 + Math.max(depthOfTree(root.left), depthOfTree(root.right));
    }

    public int depth(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = depth(node.left);
        if(leftDepth == -1)
            return -1;

        int rightDepth = depth(node.right);
        if(rightDepth == -1)
            return -1;

        if (Math.abs(leftDepth - rightDepth) > 1)
            return -1;

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private static boolean sameTree(TreeNode t1, TreeNode t2)
    {
        if(t1 == null && t2 == null)
            return true;
        else if(t1 != null && t2 == null)
            return false;
        else if (t1 == null && t2 != null) {
            return false;
        }
        else {
            if(t1.val != t2.val)
            {
                return false;
            }
            else {
                return sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
            }
        }
    }

    private List<List<Integer>> levelOrderTraversal(TreeNode root)
    {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if(root == null)
            return levels;
        else {

            Queue<TreeNode> treeNodeQueue = new LinkedList<>();
            treeNodeQueue.add(root);
            int level = 0;

            while(!treeNodeQueue.isEmpty()){

                levels.add(new ArrayList<Integer>());
                int levelLength = treeNodeQueue.size();

                for(int i=0;i<levelLength;i++)
                {
                    TreeNode node = treeNodeQueue.remove();
                    levels.get(level).add(node.val);

                    if(node.left != null){
                        treeNodeQueue.add(node.left);
                    }

                    if(node.right != null){
                        treeNodeQueue.add(node.right);
                    }
                }
                level++;
            }

            return levels;
        }
    }


}
