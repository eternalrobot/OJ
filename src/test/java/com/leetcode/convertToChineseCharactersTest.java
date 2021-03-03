package com.leetcode;

import junit.framework.TestCase;
public class convertToChineseCharactersTest extends TestCase {

    public void testConvert() {
        //测试小数点后翻译是否成功
        assertEquals(convertToChineseCharacters.convert("0.1234498765"),"零点一二三四四九八七六五");
        //测试个位数字翻译
        assertEquals(convertToChineseCharacters.convert("4.321445"),"四点三二一四四五");
        //测试十位数字翻译
        assertEquals(convertToChineseCharacters.convert("17.321445"),"一十七点三二一四四五");
        assertEquals(convertToChineseCharacters.convert("10.321445"),"一十点三二一四四五");
        //测试百位数字翻译
        assertEquals(convertToChineseCharacters.convert("134.55632"),"一百三十四点五五六三二");
        assertEquals(convertToChineseCharacters.convert("103.55632"),"一百零三点五五六三二");
        assertEquals(convertToChineseCharacters.convert("100.55632"),"一百点五五六三二");
        assertEquals(convertToChineseCharacters.convert("130.55632"),"一百三十点五五六三二");
        //测试千位数字翻译
        assertEquals(convertToChineseCharacters.convert("1348.55632"),"一千三百四十八点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1048.55632"),"一千零四十八点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1308.55632"),"一千三百零八点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1340.55632"),"一千三百四十点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1008.55632"),"一千零八点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1300.55632"),"一千三百点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1040.55632"),"一千零四十点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1000.55632"),"一千点五五六三二");
        //测试万位数字翻译，由于代码是千位为一类翻译，万位为一类翻译，亿位为一类翻译，所以千位测试正确后，万位只需要测试在其后加上万是否正确以及能否将万划分为两个千来翻译
        assertEquals(convertToChineseCharacters.convert("17321.55632"),"一万七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("107321.55632"),"一十万零七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1287321.55632"),"一百二十八万七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1087321.55632"),"一百零八万七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1007321.55632"),"一百万零七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("12927321.55632"),"一千二百九十二万七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("10007321.55632"),"一千万零七千三百二十一点五五六三二");
        //测试亿位数字翻译
        assertEquals(convertToChineseCharacters.convert("100007321.55632"),"一亿零七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1000007321.55632"),"一十亿零七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("10000007321.55632"),"一百亿零七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("100000007321.55632"),"一千亿零七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1000000007321.55632"),"一万亿零七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("10000000007321.55632"),"一十万亿零七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("100000000007321.55632"),"一百万亿零七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1000000000007321.55632"),"一千万亿零七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1000000100007321.55632"),"一千万零一亿零七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1000001100007321.55632"),"一千万零一十一亿零七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1000098400007321.55632"),"一千万零九百八十四亿零七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1000298400007321.55632"),"一千万零二千九百八十四亿零七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1008298400007321.55632"),"一千零八万二千九百八十四亿零七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1088298400007321.55632"),"一千零八十八万二千九百八十四亿零七千三百二十一点五五六三二");
        assertEquals(convertToChineseCharacters.convert("1288298400007321.55632"),"一千二百八十八万二千九百八十四亿零七千三百二十一点五五六三二");
        //超出位数输入
        assertEquals(convertToChineseCharacters.convert("128829840000732100.55632"),"最多可以转化千万亿的数字，小数点后的数字不计");

    }
}