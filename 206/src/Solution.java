import java.util.Stack;

class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack();
        ListNode ptr1 = head;
        while(ptr1!=null){
            stack.push(ptr1);
            ptr1 = ptr1.next;
        }
        int count = 0;
        ListNode last = null;
        while(!stack.isEmpty()){
            ListNode ptr = stack.pop();
            ptr.next = !stack.isEmpty()?stack.peek():null;
            if (count==0){
                last = ptr;
            }
            count++;
        }
        return last;
    }
    public ListNode reverseList2(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while(cur!=null){
            ListNode next =cur.next;
            cur.next = pre;
            cur = next;
            pre = cur;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        new Solution().reverseList(head);
    }
}