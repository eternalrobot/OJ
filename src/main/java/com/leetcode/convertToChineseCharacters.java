package com.leetcode;

public class convertToChineseCharacters {
    /**
     * 输入字符串的阿拉伯数字（最大不超过千万亿，小数点后任意位数），转化为中文数字
     * 如：输入1220023101003.22，输出一万二千二百亿二千三百一十万一千零三点二二
     *
     * @param number String字符串类型的阿拉伯数字
     * @return 中文数字
     */
    public static String convert(String number) {
        String[] numbersString = number.split("\\.")[0].split("");
        if (numbersString.length > 16) {
            return "最多可以转化千万亿的数字，小数点后的数字不计";
        }
        String[] decimalNumber = number.split("\\.")[1].split("");
        StringBuilder decimalNumberString = new StringBuilder();
        decimalNumberString.append("点");
        for (String dn : decimalNumber) {
            decimalNumberString.append(oneNumberConvert(Integer.parseInt(dn)));
        }
        int[] numbers = new int[numbersString.length];
        for (int i = 0; i < numbersString.length; i++) {
            numbers[i] = Integer.parseInt(numbersString[i]);
        }
        String yiResult = yiNumberConvert(numbers);
        if (yiResult.equals("")) {
            return "零" + decimalNumberString.toString();
        } else {
            return yiNumberConvert(numbers) + decimalNumberString.toString();
        }
    }

    private static String yiNumberConvert(int[] numbers) {
        if (numbers.length <= 8) return wanNumberConvert(numbers);
        int length = numbers.length;
        int yilength = length - 8;
        int[] yinumbers = new int[length - 8];
        int[] wannumbers = new int[8];
        for (int i = 0; i < length; i++) {
            if (i < yilength) {
                yinumbers[i] = numbers[i];
            } else {
                wannumbers[i - yilength] = numbers[i];
            }
        }
        String yiResult = wanNumberConvert(yinumbers);
        if (yiResult.length() > 1 && yiResult.charAt(yiResult.length() - 1) == '零') {
            return yiResult.substring(0, yiResult.length() - 1) + "亿" + wanNumberConvert(wannumbers);
        } else {
            return wanNumberConvert(yinumbers) + "亿" + wanNumberConvert(wannumbers);
        }
    }

    private static String wanNumberConvert(int[] numbers) {
        if (numbers.length <= 4) return qianNumberConvert(numbers);
        int length = numbers.length;
        int wanlength = length - 4;
        int[] wannumbers = new int[length - 4];
        int[] qiannumbers = new int[4];
        for (int i = 0; i < length; i++) {
            if (i < wanlength) {
                wannumbers[i] = numbers[i];
            } else {
                qiannumbers[i - wanlength] = numbers[i];
            }
        }
        String wanResult = qianNumberConvert(wannumbers);
        String qianResult = qianNumberConvert(qiannumbers);
        if (wanResult.length() > 1 && !qianResult.matches("零+[一,二,三,四,五,六,七,八,九,十,百,千]*")) {
            String wanFinalChar = wanResult.substring(wanResult.length() - 1, wanResult.length());
            if ((wanFinalChar.equals("十") || wanFinalChar.equals("百") || wanFinalChar.equals("千"))) {
                return wanResult + "万零" + qianNumberConvert(qiannumbers);
            }
        }
        if (wanResult.length() == 0) {
            return "零" + qianNumberConvert(qiannumbers);
        }
        return wanResult + "万" + qianNumberConvert(qiannumbers);
    }

    private static String qianNumberConvert(int[] numbers) {
        if (numbers == null || numbers.length > 4 || numbers.length == 0) return "输入错误";
        boolean zeroflag = false;
        StringBuilder stringBuilder = new StringBuilder();
        int digit = numbers.length;
        for (int number : numbers) {
            if (number != 0) zeroflag = false;
            stringBuilder.append(qianNumberConvertHelper(number, digit, zeroflag));
            if (number == 0) zeroflag = true;
            digit--;
        }
        if (stringBuilder.length() > 0 && stringBuilder.substring(stringBuilder.length() - 1, stringBuilder.length()).equals("零"))
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        return stringBuilder.toString();
    }

    private static String qianNumberConvertHelper(int number, int digit, Boolean zeroflag) {
        if (number == 0 && digit == 1) return "";
        if (number == 0) {
            if (!zeroflag) {
                return oneNumberConvert(number);
            }
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(oneNumberConvert(number));
        switch (digit) {
            case 1:
                return stringBuilder.toString();
            case 2:
                return stringBuilder.append("十").toString();
            case 3:
                return stringBuilder.append("百").toString();
            default:
                return stringBuilder.append("千").toString();
        }
    }

    private static String oneNumberConvert(int number) {
        if (number > 9 || number < 0) return "输入错误";
        switch (number) {
            case 0:
                return "零";
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            default:
                return "九";
        }
    }
}
