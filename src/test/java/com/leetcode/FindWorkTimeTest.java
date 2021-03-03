package com.leetcode;

import junit.framework.TestCase;

public class FindWorkTimeTest extends TestCase {

    public void testFindWorkTime() {
        //由于方法中使用的是Java内置的LocalDate，所以其不需要测试2月28号的情况，也不需要测试12月29号的情况，或者3月30号类似的情况，其是内部实现没有问题
        //测试用例覆盖情况100%Line
        String nowTime1 = "2020-03-20 05:23:31";
        assertEquals(FindWorkTime.findWorkTime(nowTime1), "2020-03-20 11:00:00");
        String nowTime2 = "2020-03-20 14:23:31";
        assertEquals(FindWorkTime.findWorkTime(nowTime2), "2020-03-20 17:23:31");
        //第一,二，三个测试用例星期五下午18点过后到星期一上午8点前，的下一个工作时间是星期一上午11点
        String mytest1 = "2020-03-20 18:00:01";
        assertEquals(FindWorkTime.findWorkTime(mytest1), "2020-03-23 11:00:00");
        String mytest2 = "2020-03-21 09:20:01";
        assertEquals(FindWorkTime.findWorkTime(mytest2), "2020-03-23 11:00:00");
        String mytest3 = "2020-03-23 07:59:59";
        assertEquals(FindWorkTime.findWorkTime(mytest3), "2020-03-23 11:00:00");
        //第四，五个测试用例星期五下午15点过后到星期五下午18点之间，的下一个工作时间是星期一上午8点过后对应时间
        String mytest4 = "2020-03-20 15:00:01";
        assertEquals(FindWorkTime.findWorkTime(mytest4), "2020-03-23 08:00:01");
        String mytest5 = "2020-03-20 18:00:00";
        assertEquals(FindWorkTime.findWorkTime(mytest5), "2020-03-23 11:00:00");
        //第六个测试用例星期一到星期四每天下午18点过后，的下一个工作时间是第二天上午11点
        String mytest6 = "2020-03-25 18:00:01";
        assertEquals(FindWorkTime.findWorkTime(mytest6), "2020-03-26 11:00:00");
        //第七个测试用例星期二到星期五每天上午8点前,的下一个工作时间是当天上午11点
        String mytest7 = "2020-03-26 07:59:59";
        assertEquals(FindWorkTime.findWorkTime(mytest7), "2020-03-26 11:00:00");
        //第八，九个测试用例星期一到星期四每天下午15点过后到18点之间，的下一个工作时间是第二天上午8点过后对应时间
        String mytest8 = "2020-03-24 15:00:01";
        assertEquals(FindWorkTime.findWorkTime(mytest8), "2020-03-25 08:00:01");
        String mytest9 = "2020-03-24 18:00:00";
        assertEquals(FindWorkTime.findWorkTime(mytest9), "2020-03-25 11:00:00");
        //第十，十一个测试用例星期一到星期五每天早上8点到9点之间，的下一个工作时间是三个小时后
        String mytest10 = "2020-03-24 08:00:01";
        assertEquals(FindWorkTime.findWorkTime(mytest10), "2020-03-24 11:00:01");
        String mytest11 = "2020-03-25 09:00:00";
        assertEquals(FindWorkTime.findWorkTime(mytest11), "2020-03-25 12:00:00");
        //第十二，十三个测试用例星期一到星期五每天早上9点到12点之间，的下一个工作时间是14点过后对应时间
        String mytest12 = "2020-03-24 09:00:01";
        assertEquals(FindWorkTime.findWorkTime(mytest12), "2020-03-24 14:00:01");
        String mytest13 = "2020-03-25 12:00:00";
        assertEquals(FindWorkTime.findWorkTime(mytest13), "2020-03-25 17:00:00");
        //第十四，十五个测试用例星期一到星期五每天12点到14点之间，的下一个工作时间是17点
        String mytest14 = "2020-03-24 12:00:01";
        assertEquals(FindWorkTime.findWorkTime(mytest14), "2020-03-24 17:00:00");
        String mytest15 = "2020-03-25 14:00:00";
        assertEquals(FindWorkTime.findWorkTime(mytest15), "2020-03-25 17:00:00");
        //第十六，十七个测试用例星期一到星期五每天14点到15点之间，的下一个工作时间是3个小时后
        String mytest16 = "2020-03-24 14:00:01";
        assertEquals(FindWorkTime.findWorkTime(mytest16), "2020-03-24 17:00:01");
        String mytest17 = "2020-03-25 15:00:00";
        assertEquals(FindWorkTime.findWorkTime(mytest17), "2020-03-25 18:00:00");
        //第十八个测试用例输入无效字符串
        String mytest18="XXSAXSX";
        assertEquals(FindWorkTime.findWorkTime(mytest18), "不是合法字符串");
        //第十九个测试用例输入null
        assertNull(FindWorkTime.findWorkTime(null));
    }
}