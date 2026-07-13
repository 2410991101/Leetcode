class Solution {
    private ListNode front;
    public boolean isPalindrome(ListNode head) {
        if (front == null) {
            front = head;
        }
        if (head == null) {
            return true;
        }
        if (!isPalindrome(head.next)) {
            return false;
        }
        if (front.val != head.val) {
            return false;
        }
        front = front.next;
        return true;
    }
}
