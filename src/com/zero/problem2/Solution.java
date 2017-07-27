package com.zero.problem2;

/**
 * Created by Zero on 2017/6/29.
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class Solution {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headerNode = new ListNode(0);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode currNode = headerNode;
        int carry = 0;
        while (null != temp1 || null != temp2) {
            int val1 = null == temp1 ? 0 : temp1.val;
            int val2 = null == temp2 ? 0 : temp2.val;
            int sum = carry + val1 + val2;
            carry = sum / 10;
            currNode.next = new ListNode(sum % 10);
            currNode = currNode.next;
            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;
        }
        // 如果最后以为的和大于１０变在最后加一位
        if (carry == 1) {
            currNode.next = new ListNode(1);
        }
        return headerNode.next;
    }
}
