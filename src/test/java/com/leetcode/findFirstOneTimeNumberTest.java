package com.leetcode;

import junit.framework.TestCase;

public class findFirstOneTimeNumberTest extends TestCase {

    public void testFind() {
        //测试不存在只出现一次的数字
        assertEquals(findFirstOneTimeNumber.find(new int[]{4,2,4,2}),-1);
        //测试一个数字
        assertEquals(findFirstOneTimeNumber.find(new int[]{1}),1);
        //测试两个数字
        assertEquals(findFirstOneTimeNumber.find(new int[]{2,1}),2);
        //测试三个数字
        assertEquals(findFirstOneTimeNumber.find(new int[]{3,2,1}),3);
        assertEquals(findFirstOneTimeNumber.find(new int[]{3,2,3}),2);
        assertEquals(findFirstOneTimeNumber.find(new int[]{3,3,1}),1);
        //测试四个数字
        assertEquals(findFirstOneTimeNumber.find(new int[]{4,3,2,1}),4);
        assertEquals(findFirstOneTimeNumber.find(new int[]{4,3,2,4}),3);
        assertEquals(findFirstOneTimeNumber.find(new int[]{4,4,2,1}),2);
        assertEquals(findFirstOneTimeNumber.find(new int[]{4,4,4,1}),1);
        //测试五个数字
        assertEquals(findFirstOneTimeNumber.find(new int[]{5,4,3,2,1}),5);
        assertEquals(findFirstOneTimeNumber.find(new int[]{5,5,3,2,1}),3);
        assertEquals(findFirstOneTimeNumber.find(new int[]{5,5,5,2,1}),2);
        assertEquals(findFirstOneTimeNumber.find(new int[]{5,5,5,5,1}),1);
        assertEquals(findFirstOneTimeNumber.find(new int[]{5,5,4,4,1}),1);
        //测试13个数字
        assertEquals(findFirstOneTimeNumber.find(new int[]{1,2,9,3,0,4,5,1,2,3,6,5,9}),0);
        assertEquals(findFirstOneTimeNumber.find(new int[]{1,2,9,3,0,4,5,1,2,3,5,0,9}),4);
    }
}