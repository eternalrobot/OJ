package com.leetcode;

public class TimeLine {
    /**
     * @param time time数组是被选取的数组
     * @param line line数组是被参考的数组
     * @return 根据line，找到time数组中最近的一个数（数组a的值只能被取一次；如果有两个相等，取后面一个；）
     */
    public static String findProximateNumber(int[] time, int[] line) {
        if(time==null||line==null||time.length==0||line.length==0){
            return null;
        }
        //由于字符串要多次更新所以使用StringBuilder，而不是String
        StringBuilder stringBuilder = new StringBuilder();
        //记录长度，每次会排除一个time中的数字
        int length=time.length;
        for (int lineNumber : line) {
            int distance = 10000;
            int index = 0;
            for (int i=0;i<length;i++) {
                //Math.abs取绝对值，距离小于等于distance的就更新下标index与distance
                if (Math.abs(time[i] - lineNumber) <= distance) {
                    distance = Math.abs(time[i] - lineNumber);
                    index = i;
                }
            }
            stringBuilder.append(" {line:" + lineNumber + ",time:" + time[index] + "},");
            //进行排除time中的一个数字
            for(int i=index;i<length-1;i++){
                time[i]=time[i+1];
            }
            length--;
        }
        stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        int[] time = new int[]{1, 5, 8, 11, 16, 17, 29, 34, 39};
        int[] line = new int[]{3, 7, 12, 17, 19, 31, 40};
        System.out.println(findProximateNumber(time, line));
    }
}
