import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            TreeNode tem = cur.left;
            cur.left = cur.right;
            cur.right = tem;
            if (cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
        return root;
    }
}
