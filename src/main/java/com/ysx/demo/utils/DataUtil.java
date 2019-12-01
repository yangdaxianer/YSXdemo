package com.ysx.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: yangboss
 * \* Date: 2019/11/27
 * \* Time: 22:11
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class DataUtil {
    /**
     * 根据年月获取当月最后一天
     * @param yearmonth yyyy-MM
     * @return yyyy-MM-dd
     * @throws ParseException
     */
    public static String getLastDayOfMonth(String yearmonth) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
            Date dd = format.parse(yearmonth);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dd);
            int cc=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            String result = yearmonth+"-"+cc;
            return result;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}