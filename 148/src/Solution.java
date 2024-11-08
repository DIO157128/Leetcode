class Solution {
    public ListNode sortList(ListNode head) {
        if (head==null || head.next ==null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast !=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while(left!=null&&right!=null){
            if(left.val<right.val){
                h.next = left;
                left = left.next;
            }
            else {
                h.next=right;
                right = right.next;
            }
            h = h.next;
        }

        h.next = left!=null?left:right;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4,new ListNode(2,new ListNode(1,new ListNode(3))));
        System.out.println(new Solution().sortList(node));
    }
}
