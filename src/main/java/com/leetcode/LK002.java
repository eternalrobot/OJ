package com.leetcode;

import java.math.BigInteger;

public class LK002 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = new Solution().addTwoBigNumbers(l1, l2);
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode l1T = l1;
        ListNode l2T = l2;
        ListNode result = new ListNode();
        ListNode resultT = result;
        long l1number = 0;
        long l2number = 0;
        int l1flag = 0;
        int l2flag = 0;
        while (l1T != null) {
            l1number += 1.0 * l1T.val * Math.pow(10, l1flag);
            l1T = l1T.next;
            l1flag++;
        }
        while (l2T != null) {
            l2number += 1.0 * l2T.val * Math.pow(10, l2flag);
            l2T = l2T.next;
            l2flag++;
        }
        long resultnumber = l1number + l2number;
        result.val = (int) (resultnumber % 10);
        resultnumber = resultnumber / 10;
        while (resultnumber != 0) {
            result.next = new ListNode((int) (resultnumber % 10));
            resultnumber = resultnumber / 10;
            result = result.next;
        }
        return resultT;
    }


    public ListNode addTwoBigNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode l1T = l1;
        ListNode l2T = l2;
        ListNode result = new ListNode();
        ListNode resultT = result;
        BigInteger l1number = new BigInteger(String.valueOf(0));
        BigInteger l2number = new BigInteger(String.valueOf(0));
        int l1flag = 0;
        int l2flag = 0;
        while (l1T != null) {
            BigInteger addnumber = new BigInteger(new BigInteger(String.valueOf(l1T.val)).multiply(new BigInteger(String.valueOf(10)).pow(l1flag)).toString());
            l1number = l1number.add(addnumber);
            l1T = l1T.next;
            l1flag++;
        }
        while (l2T != null) {
            BigInteger addnumber = new BigInteger(new BigInteger(String.valueOf(l2T.val)).multiply(new BigInteger(String.valueOf(10)).pow(l2flag)).toString());
            l2number = l2number.add(addnumber);
            l2T = l2T.next;
            l2flag++;
        }
        BigInteger resultnumber = l1number.add(l2number);
        BigInteger[] resultdivideAndRemainder10 = resultnumber.divideAndRemainder(BigInteger.valueOf(10));
        result.val = resultdivideAndRemainder10[1].intValue();
        resultnumber = resultdivideAndRemainder10[0];
        while (!resultnumber.toString().equals("0")) {
            resultdivideAndRemainder10 = resultnumber.divideAndRemainder(BigInteger.valueOf(10));
            result.next = new ListNode((resultdivideAndRemainder10[1].intValue()));
            resultnumber = resultdivideAndRemainder10[0];
            result = result.next;
        }
        return resultT;
    }
}