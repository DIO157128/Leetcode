import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class solution2 {
    Map<Integer,TreeNode> parents = new HashMap<Integer,TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();
    public void dfs(TreeNode root){
        if(root.left!=null){
            parents.put(root.left.val,root);
            dfs(root.left);
        }
        if(root.right!=null){
            parents.put(root.right.val,root);
            dfs(root.right);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        TreeNode ptr_p = p;
        while(ptr_p!=null){
            visited.add(ptr_p.val);
            ptr_p = parents.get(ptr_p.val);
        }
        TreeNode ptr_q = q;
        while (ptr_q!=null){
            if(visited.contains(ptr_q.val)){
                return ptr_q;
            }
            ptr_q = parents.get(ptr_q.val);
        }
        return null;
    }
}
