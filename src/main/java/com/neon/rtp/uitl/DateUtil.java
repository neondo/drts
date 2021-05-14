package com.neon.rtp.uitl;

import org.apache.commons.lang.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class DateUtil{

    public static final String YYYYMMDD_HHMMSS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYYMMDD = "yyyy-MM-dd";

    public static final String YYYYMM = "yyyy-MM";

    public static final String HHMMSS = "HH:mm:ss";

    public static Date add(Date date, Integer num, Unit unit) {
        if(date == null || num == null || num == 0)
            return date;
        else {
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            int kind;
            switch(unit) {
                case MILLISECOND:
                    kind = Calendar.MILLISECOND;
                    break;
                case SECOND:
                    kind = Calendar.SECOND;
                    break;
                case MINUTE:
                    kind = Calendar.MINUTE;
                    break;
                case HOUR:
                    kind = Calendar.HOUR;
                    break;
                case WEEK:
                    kind = Calendar.WEEK_OF_MONTH;
                    break;
                case MONTH:
                    kind = Calendar.MONTH;
                    break;
                case YEAR:
                    kind = Calendar.YEAR;
                    break;
                default:
                    kind = Calendar.DAY_OF_MONTH;
            }
            instance.add(kind, num);
            return instance.getTime();
        }
    }

    /**
     * 得到指定日期的前/后几天
     */
    public static String afterDays(Date date, int days, String sdf) {
        SimpleDateFormat df = getFormat(sdf);
        Calendar calander = Calendar.getInstance();
        calander.setTime(date);
        calander.add(Calendar.DAY_OF_MONTH, days);
        Date endDay = calander.getTime();
        return df.format(endDay);
    }

    /**
     * 格式化日期
     */
    public static String formatDate(Date date, String fmt) {
        if(date == null)
            return null;
        SimpleDateFormat simpleDateFormat = getFormat(fmt);
        return simpleDateFormat.format(date);
    }

    /**
     * 格式化日期, DateUtil.YYYYMMDD_HHMMSS
     */
    public static String formatDate(Date date) {
        return formatDate(date, YYYYMMDD_HHMMSS);
    }

    /**
     * 获取当前时间距离到指定的Unit(年月日...)的秒数
     * (一般用于设置缓存时间)
     * @param unit {@code DateUnit.Unit} Unit不可低于MINUTE
     * @return second(int)
     */
    public static int getRemainInSeconds(Unit unit) {
        int unitType;
        long millis = DateUtils.MILLIS_PER_DAY;
        switch(unit) {
            case MINUTE:
                millis = DateUtils.MILLIS_PER_MINUTE;
                unitType = Calendar.MINUTE;
                break;
            case HOUR:
                millis = DateUtils.MILLIS_PER_HOUR;
                unitType = Calendar.HOUR;
                break;
            case DAY:
                unitType = Calendar.DATE;
                break;
            case WEEK:
                millis = DateUtils.MILLIS_PER_DAY * 7;
                unitType = Calendar.WEEK_OF_MONTH;
                break;
            case MONTH:
                millis = DateUtils.MILLIS_PER_DAY * 30;
                unitType = Calendar.MONTH;
                break;
            case YEAR:
                millis = DateUtils.MILLIS_PER_DAY * 365;
                unitType = Calendar.YEAR;
                break;
            default:
                unitType = Calendar.DATE;
        }
        //获取今天已过的秒数
        long hasExpireSeconds = DateUtils.getFragmentInSeconds(Calendar.getInstance(), unitType);
        //剩余秒数
        long seconds = millis / DateUtils.MILLIS_PER_SECOND - hasExpireSeconds;
        return Math.toIntExact(seconds);
    }

    /**
     * 查询两个时间的时间间隔
     * 根据指定的类型返回不同的值(Unit.YEAR Unit.MONTH Unit.DAY... )
     * @param start 开始时间
     * @param end   结束时间
     * @param unit  返回的类型
     * @return unit(Long)
     */
    public static Long betweenTimes(Long start, Long end, Unit unit) {
        long times = end - start;
        Long result = 0L;
        if(Unit.SECOND.equals(unit)) {
            result = times / 1000;
        } else if(Unit.MINUTE.equals(unit)) {
            result = times / 1000 / 60;
        } else if(Unit.HOUR.equals(unit)) {
            result = times / 1000 / 60 / 60;
        } else if(Unit.DAY.equals(unit)) {
            result = times / 1000 / 60 / 60 / 24;
        } else if(Unit.WEEK.equals(unit)) {
            result = times / 1000 / 60 / 60 / 24 / 7;
        } else if(Unit.MONTH.equals(unit)) {
            result = times / 1000 / 60 / 60 / 24 / 30;
        } else if(Unit.YEAR.equals(unit)) {
            result = times / 1000 / 60 / 60 / 24 / 365;
        }
        return result;
    }

    /**
     * 将字符串转化成指定的日期格式
     */
    public static Date parseDate(String date, String fmt) {
        if(!Check.notNull(date))
            return null;
        SimpleDateFormat simpleDateFormat = getFormat(fmt);
        try {
            return simpleDateFormat.parse(date);
        } catch(ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * parse date with format <code>yyyy-MM-dd HH:mm:ss</code>
     * @param dateStr date string value
     */
    public static Date parse(String dateStr) {
        return parseDate(dateStr, YYYYMMDD_HHMMSS);
    }

    /**
     * @param calendar Calendar 时间c






     * @return Date
     * @desc 获取时间的日期起点时间,
     * for example:        2018-07-04 15:24:37 123
     * String unit=YEAR -> 2018-01-01 00:00:00 000
     * String unit=MONTH -> 2018-07-01 00:00:00 000
     * String unit=WEEK -> 2018-07-02 00:00:00 000(该时间所在周周一)
     * String unit=DAY -> 2018-07-04 00:00:00 000
     * String unit=HOUR -> 2018-07-05 15:00:00 000
     * String unit=MINUTE -> 2018-07-04 15:26:00 000
     * String unit=SECOND -> 2018-07-04 15:26:37 000
     */
    public static Date format2start(Calendar calendar, Unit unit) {
        //保持原传入时间不变
        Calendar clone = (Calendar) calendar.clone();
        //年
        if(Unit.YEAR.equals(unit)) {
            clone.set(Calendar.MONTH, Calendar.JANUARY);
            clone.set(Calendar.DAY_OF_MONTH, 1);
            clone.set(Calendar.HOUR_OF_DAY, 0);
            clone.set(Calendar.MINUTE, 0);
            clone.set(Calendar.SECOND, 0);
            //月
        } else if(Unit.MONTH.equals(unit)) {
            clone.set(Calendar.DAY_OF_MONTH, 1);
            clone.set(Calendar.HOUR_OF_DAY, 0);
            clone.set(Calendar.MINUTE, 0);
            clone.set(Calendar.SECOND, 0);
            //天
        } else if(Unit.WEEK.equals(unit)) {
            clone.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            clone.set(Calendar.HOUR_OF_DAY, 0);
            clone.set(Calendar.MINUTE, 0);
            clone.set(Calendar.SECOND, 0);
            //时
        } else if(Unit.DAY.equals(unit)) {
            clone.set(Calendar.HOUR_OF_DAY, 0);
            clone.set(Calendar.MINUTE, 0);
            clone.set(Calendar.SECOND, 0);
            //时
        } else if(Unit.HOUR.equals(unit)) {
            clone.set(Calendar.MINUTE, 0);
            clone.set(Calendar.SECOND, 0);
            //分
        } else if(Unit.MINUTE.equals(unit)) {
            clone.set(Calendar.SECOND, 0);
        }
        clone.set(Calendar.MILLISECOND, 0);
        return clone.getTime();
    }

    /**
     * @param date 指定时间
     * @param unit 初始化的类型
     * @see this#format2start(Calendar, Unit)
     */
    public static Date format2start(Date date, Unit unit) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return format2start(instance, unit);
    }

    public static boolean compareTime(Date time1, Date time2) {
        String str1 = formatDate(time1, HHMMSS);
        String str2 = formatDate(time2, HHMMSS);
        String[] array1 = str1.split(":");
        int total1 = Integer.parseInt(array1[0]) * 3600 + Integer.parseInt(array1[1]) * 60 + Integer.valueOf(array1[2]);
        String[] array2 = str2.split(":");
        int total2 = Integer.parseInt(array2[0]) * 3600 + Integer.valueOf(array2[1]) * 60 + Integer.valueOf(array2[2]);
        return total1 - total2 > 0;
    }

    public static Date dateAdapter(String dateStr) throws Exception {
        Date ret = null;
        if(dateStr.contains("CST")) {
            ret = new Date(dateStr);
            return ret;
        }
        dateStr = dateStr.replace("年", "-").replace("月", "-").replace("日", "").replaceAll("/", "-")
                .replaceAll("\\.", "-")
                .trim();
        String fm = "";
        if(Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}.*").matcher(dateStr).matches()) {
            fm = "yyyy-MM-dd";
        } else if(Pattern.compile("^[0-9]{4}-[0-9]{1}-[0-9]+.*||^[0-9]{4}-[0-9]+-[0-9]{1}.*").matcher(dateStr)
                .matches()) {
            fm = "yyyy-M-d";
        } else if(Pattern.compile("^[0-9]{2}-[0-9]{2}-[0-9]{2}.*").matcher(dateStr).matches()) {
            fm = "yy-MM-dd";
        } else if(Pattern.compile("^[0-9]{2}-[0-9]{1}-[0-9]+.*||^[0-9]{2}-[0-9]+-[0-9]{1}.*").matcher(dateStr)
                .matches()) {
            fm = "yy-M-d";
        }
        // 确定时间格式
        if(Pattern.compile(".*[ ][0-9]{2}").matcher(dateStr).matches()) {
            fm += " HH";
        } else if(Pattern.compile(".*[ ][0-9]{2}:[0-9]{2}").matcher(dateStr).matches()) {
            fm += " HH:mm";
        } else if(Pattern.compile(".*[ ][0-9]{2}:[0-9]{2}:[0-9]{2}").matcher(dateStr).matches()) {
            fm += " HH:mm:ss";
        } else if(Pattern.compile(".*[ ][0-9]{2}:[0-9]{2}:[0-9]{2}:[0-9]{0,3}").matcher(dateStr).matches()) {
            fm += " HH:mm:ss:sss";
        }
        if(!"".equals(fm)) {
            ret = getFormat(fm).parse(dateStr);
        }
        return ret;
    }

    private static SimpleDateFormat getFormat(String format) {
        return new SimpleDateFormat(format);
        //SimpleDateFormat 在多线程下会存在 multiple points 问题
        //ThreadLocal不建议使用
        // return FORMAT_MAP.computeIfAbsent(format, s->new SimpleDateFormat(format));
    }

    /**
     * 切割时间
     * @param start 开始时间
     * @param end   结束时间
     * @param size  分割跨度
     * @param unit  分割跨度时间单位
     * @return Map, K:开始时间,V结束时间
     */
    public static Map<Date, Date> splitTime(Date start, Date end, int size, Unit unit) {
        long timeSize;
        switch(unit) {
            case SECOND:
                timeSize = TimeUnit.SECONDS.toMillis(size);
                break;
            case MINUTE:
                timeSize = TimeUnit.MINUTES.toMillis(size);
                break;
            case HOUR:
                timeSize = TimeUnit.HOURS.toMillis(size);
                break;
            case DAY:
                timeSize = TimeUnit.DAYS.toMillis(size);
                break;
            case WEEK:
                timeSize = TimeUnit.DAYS.toMillis(size) * 7;
                break;
            case MONTH:
                timeSize = TimeUnit.DAYS.toMillis(size) * 30;
                break;
            case YEAR:
                timeSize = TimeUnit.DAYS.toMillis(size) * 365;
                break;
            default:
                throw new OperateException("时间单位不合法!");
        }
        PageUtil init = PageUtil.range(timeSize, start::getTime, end::getTime);
        Map<Date, Date> dateMap = new LinkedHashMap<>();
        IntStream.rangeClosed(1, init.getPage()).forEach(i->dateMap.put(new Date(init.getLongStartIndex(i)), new Date(init.getLongEndIndex(i))));
        return dateMap;
    }
}
