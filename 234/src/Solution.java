import java.util.ArrayList;

class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> all_nodes = new ArrayList<>();
        ListNode ptr = head;
        while(ptr!=null){
            all_nodes.add(ptr.val);
            ptr = ptr.next;
        }
        int half = all_nodes.size()/2;
        for(int i = 0;i<half;i++){
            if (!all_nodes.get(i).equals(all_nodes.get(all_nodes.size()-1-i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(head));
    }
}
