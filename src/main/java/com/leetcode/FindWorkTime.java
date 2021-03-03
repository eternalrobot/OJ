package com.leetcode;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class FindWorkTime {

    public static String findWorkTime(String nowTime) {
        if (nowTime == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setLenient(false);
        try {
            format.parse(nowTime);
        } catch (ParseException e) {
            return "不是合法字符串";
        }
        String[] dateAndTime = nowTime.split(" ");
        String[] yearAndMonthAndDay = dateAndTime[0].split("-");
        String[] hourAndMinuteAndSecond = dateAndTime[1].split(":");
        LocalDate localDate = LocalDate.of(Integer.parseInt(yearAndMonthAndDay[0]), Integer.parseInt(yearAndMonthAndDay[1]), Integer.parseInt(yearAndMonthAndDay[2]));
        LocalTime localTime = LocalTime.of(Integer.parseInt(hourAndMinuteAndSecond[0]), Integer.parseInt(hourAndMinuteAndSecond[1]), Integer.parseInt(hourAndMinuteAndSecond[2]));
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        //星期五下午18点过后到星期一上午8点前，的下一个工作时间是星期一上午11点
        if (dayOfWeek.getValue() > 5 || (dayOfWeek.getValue() == 5 && isHigher(localTime, 18)) || (dayOfWeek.getValue() == 1 && isLowerEqual(localTime, 8))) {
            while (localDate.getDayOfWeek().getValue() != 1) localDate = localDate.plusDays(1);
            return formatReturn(LocalTime.of(11, 0, 0), localDate);
        }
        //星期五下午15点过后到星期五下午18点之间，的下一个工作时间是星期一上午8点过后对应时间
        else if (dayOfWeek.getValue() == 5 && isHigher(localTime, 15) && isLowerEqual(localTime, 18)) {
            localDate = localDate.plusDays(3);
            return formatReturn(LocalTime.of(8 + localTime.getHour() - 15, localTime.getMinute(), localTime.getSecond()), localDate);
        }
        //星期一到星期四每天下午18点过后，的下一个工作时间是第二天上午11点
        else if (isHigher(localTime, 18) && dayOfWeek.getValue() < 5) {
            localDate = localDate.plusDays(1);
            return formatReturn(LocalTime.of(11, 0, 0), localDate);
        }
        //星期二到星期五每天上午8点前,的下一个工作时间是当天上午11点
        else if (isLowerEqual(localTime, 8) && dayOfWeek.getValue() > 1 && dayOfWeek.getValue() < 6) {
            return formatReturn(LocalTime.of(11, 0, 0), localDate);
        }
        //星期一到星期四每天下午15点过后到18点之间，的下一个工作时间是第二天上午8点过后对应时间
        else if (isHigher(localTime, 15) && isLowerEqual(localTime, 18) && dayOfWeek.getValue() < 5) {
            localDate = localDate.plusDays(1);
            return formatReturn(LocalTime.of(8 + localTime.getHour() - 15, localTime.getMinute(), localTime.getSecond()), localDate);
        }
        //星期一到星期五每天早上8点到9点之间，的下一个工作时间是三个小时后
        else if (isHigher(localTime, 8) && isLowerEqual(localTime, 9) && dayOfWeek.getValue() < 6) {
            localTime = localTime.plusHours(3);
            return formatReturn(localTime, localDate);
        }
        //星期一到星期五每天早上9点到12点之间，的下一个工作时间是14点过后对应时间
        else if (isHigher(localTime, 9) && isLowerEqual(localTime, 12) && dayOfWeek.getValue() < 6) {
            return formatReturn(LocalTime.of(14 + localTime.getHour() - 9, localTime.getMinute(), localTime.getSecond()), localDate);
        }
        //星期一到星期五每天12点到14点之间，的下一个工作时间是17点
        else if (isHigher(localTime, 12) && isLowerEqual(localTime, 14) && dayOfWeek.getValue() < 6) {
            return formatReturn(LocalTime.of(17, 0, 0), localDate);
        }
        //星期一到星期五每天14点到15点之间，的下一个工作时间是3个小时后
        //isHigher(localTime,14)&&isLowerEqual(localTime,15)&&dayOfWeek.getValue()<6
        else {
            localTime = localTime.plusHours(3);
            return formatReturn(localTime, localDate);
        }
    }

    /**
     * 时间点是否小于等于某个时间，如小于等于5点，则05:00:00，04:59:59
     */
    public static Boolean isLowerEqual(LocalTime localTime, int hour) {
        return localTime.getHour() < hour || (localTime.getHour() == hour && localTime.getSecond() == 0 && localTime.getMinute() == 0);
    }

    /**
     * 时间点是否大于某个时间，如大于15点，则15:00:01,16:00:00等
     */
    public static Boolean isHigher(LocalTime localTime, int hour) {
        return localTime.getHour() > hour || (localTime.getHour() == hour && (localTime.getSecond() != 0 || localTime.getMinute() != 0));
    }

    public static String formatReturn(LocalTime localTime, LocalDate localDate) {
        String month = String.valueOf(localDate.getMonth().getValue());
        if (localDate.getMonth().getValue() < 10) month = "0" + month;
        String dayOfMonth = String.valueOf(localDate.getDayOfMonth());
        if (localDate.getDayOfMonth() < 10) dayOfMonth = "0" + dayOfMonth;
        String hour = String.valueOf(localTime.getHour());
        if (localTime.getHour() < 10) hour = "0" + hour;
        String minute = String.valueOf(localTime.getMinute());
        if (localTime.getMinute() < 10) minute = "0" + minute;
        String second = String.valueOf(localTime.getSecond());
        if (localTime.getSecond() < 10) second = "0" + second;
        return "" + localDate.getYear() + "-" + month + "-" + dayOfMonth + " " + hour
                + ":" + minute + ":" + second;
    }
}
