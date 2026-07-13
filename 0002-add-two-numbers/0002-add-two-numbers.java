class Solution {
    int carry=0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null && carry==0){
            return null;
        }
        int sum = carry;
        if(l1!=null){sum+=l1.val;}
        if(l2!=null){sum+=l2.val;}
        carry = sum/10;
        ListNode temp = new ListNode(sum%10);
        temp.next = addTwoNumbers(
            (l1!=null) ? l1.next:null,
            (l2!=null) ? l2.next:null
        );
        return temp;
    }
}