public class solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode pA =headA,pB = headB;
        while(pA!=pB){
            if (pA==null){
                pA= headB;
            }
            else {
                pA = pA.next;
            }
            if (pB==null){
                pB= headA;
            }
            else {
                pB = pB.next;
            }
        }
        return pA;
    }
    public static void main(String[] args) {
        ListNode headA = new ListNode(3);
        ListNode headB = new ListNode(2);
        headB.next = new ListNode(3);
        intersection in = new intersection();
        in.getIntersectionNode(headA,headB);
    }
}
