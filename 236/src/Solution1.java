import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    public boolean DFSfindNode(TreeNode root, TreeNode tofind){
        if (root==null){
            return false;
        }
        if(root.val== tofind.val) {
            return true;
        }
        else {
            boolean leftres = DFSfindNode(root.left,tofind);
            if (leftres){
                return true;
            }
            return DFSfindNode(root.right,tofind);
        }
    }
    public ArrayList<TreeNode> BFSsearch(TreeNode root){
        if (root==null){
            return null;
        }
        ArrayList<TreeNode> nodes= new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        nodes.add(root);
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            nodes.add(cur.left);
            nodes.add(cur.right);
            if (cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
        return nodes;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> treeNodes = BFSsearch(root);
        for(int i = treeNodes.size()-1;i>=0;i--){
            TreeNode cur = treeNodes.get(i);
            if(DFSfindNode(cur,p)&&DFSfindNode(cur,q)){
                return cur;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        TreeNode root = new TreeNode(1);
        root.left = p;
        root.right = new TreeNode(3);
        root.left.right = q;
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.lowestCommonAncestor(root,p,q).val);
    }
}
