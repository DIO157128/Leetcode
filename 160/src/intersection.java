import java.util.ArrayList;
import java.util.Collections;

public class intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ArrayList<ListNode> listA= new ArrayList<>();
        ArrayList<ListNode> listB= new ArrayList<>();
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        while(ptrA!=null){
            listA.add(ptrA);
            ptrA = ptrA.next;
        }
        while(ptrB!=null){
            listB.add(ptrB);
            ptrB = ptrB.next;
        }
        Collections.reverse(listA);
        Collections.reverse(listB);
        boolean condition = listA.get(0).equals(listB.get(0));
        int index = 0;
        if (!condition){
            return null;
        }
        else {
            while(true){
                if(index< listA.size()&&index< listB.size()){
                    condition = listA.get(index).equals(listB.get(index));
                    if (condition){
                        index++;
                    }
                    else {
                        break;
                    }
                }
                else{
                    if (listA.size()>= listB.size()){
                        return headB;
                    }
                    else{
                        return headA;
                    }
                }
            }
            int true_index = listA.size()-index;
            ptrA = headA;
            for(int i =0;i<true_index;i++){
                ptrA = ptrA.next;
            }
            return ptrA;
        }
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        headA.next.next.next = new ListNode(2);
        headA.next.next.next.next = new ListNode(4);
        ListNode headB = new ListNode(3);
        headB.next = new ListNode(2);
        headB.next.next = new ListNode(4);
        intersection in = new intersection();
        in.getIntersectionNode(headA,headB);
    }

}
