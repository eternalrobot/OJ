package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class reverseOrder {
    /**
     * 输入最后的序列如[1,2,3]，可以得到最初的序列如[3,1,2]
     * @param endOrder 最后的序列，int类型的数组
     * @return 返回最初的序列
     */
    public static int[] beginOrder(int[] endOrder){
        if(endOrder==null||endOrder.length==0)return null;
        if(endOrder.length==1)return endOrder;
        Deque<Integer> deque=new LinkedList<>();
        deque.offerLast(endOrder[0]);
        deque.offerLast(endOrder[1]);
        for(int i=2;i<endOrder.length;i++){
            int tail=deque.removeFirst();
            deque.offerLast(tail);
            deque.offerLast(endOrder[i]);
        }
        int[] beginOrder=new int[endOrder.length];
        int i=0;
        while (!deque.isEmpty()){
            beginOrder[i]=deque.removeLast();
            i++;
        }
        return beginOrder;
    }
}
