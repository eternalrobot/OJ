package com.leetcode;

import junit.framework.TestCase;

import java.util.Arrays;

public class reverseOrderTest extends TestCase {

    public void testBeginOrder() {
        //测试没有数字
        assertEquals(Arrays.toString(reverseOrder.beginOrder(null)), "null");
        assertEquals(Arrays.toString(reverseOrder.beginOrder(new int[]{})), "null");
        //测试一个数字
        assertEquals(Arrays.toString(reverseOrder.beginOrder(new int[]{1})), Arrays.toString(new int[]{1}));
        //测试两个数字
        assertEquals(Arrays.toString(reverseOrder.beginOrder(new int[]{1, 2})), Arrays.toString(new int[]{2, 1}));
        //测试三个数字
        assertEquals(Arrays.toString(reverseOrder.beginOrder(new int[]{1, 2, 3})), Arrays.toString(new int[]{3, 1, 2}));
        //测试四个数字
        assertEquals(Arrays.toString(reverseOrder.beginOrder(new int[]{1, 2, 3, 4})), Arrays.toString(new int[]{4, 2, 3, 1}));
        //测试五个数字
        assertEquals(Arrays.toString(reverseOrder.beginOrder(new int[]{1, 2, 3, 4, 5})), Arrays.toString(new int[]{5, 1, 4, 2, 3}));
        //测试六个数字
        assertEquals(Arrays.toString(reverseOrder.beginOrder(new int[]{1, 2, 3, 4, 5, 6})), Arrays.toString(new int[]{6, 3, 5, 1, 4, 2}));
    }
}