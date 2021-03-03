package com.leetcode;

public class findFirstOneTimeNumber {
    /**
     * 找到第一次值出现一次的数字并返回
     * @param numbers int类型数组
     * @return 第一次只出现一次的数字
     */
    public static int find(int[] numbers){
        int[] checkedNumbers=new int[numbers.length];
        int zeroflag=0;
        for (int number : numbers) {
            if (number == 0) {
                zeroflag++;
                if (zeroflag == 2) break;
            }
        }
        if(zeroflag==1)return 0;
        int result=-1;
        int checkedNumbersIndex=0;
        for(int i=0;i<numbers.length;i++){
            if(!isHasNumber(checkedNumbers,numbers[i])){
                boolean flag=true;
                for(int j=i+1;j<numbers.length;j++){
                    if(numbers[i]==numbers[j]){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    result =numbers[i];
                    break;
                }
                checkedNumbers[checkedNumbersIndex]=numbers[i];
                checkedNumbersIndex++;
            }
        }
        return result;
    }

    /**
     * numbers中是否含有number
     * @param numbers int类型数组
     * @param number int类型
     * @return true表示含有，false表示不含有
     */
    private static boolean isHasNumber(int[] numbers,int number){
        for(int comparativeNumber:numbers){
            if(comparativeNumber==number)return true;
        }
        return false;
    }
}
