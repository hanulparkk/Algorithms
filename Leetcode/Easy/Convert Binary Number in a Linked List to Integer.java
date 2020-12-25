/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int decimalValue = 0;
        ListNode searchNode = head;
        while (searchNode != null) {
            decimalValue = (decimalValue * 2) + searchNode.val;
            // decimalValue = (decimalValue << 1) + searchNode.val;
            searchNode = searchNode.next;
        }
        return decimalValue;
    }
}