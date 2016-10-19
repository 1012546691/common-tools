package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 时间工具类
 * @author nagsh
 * @version 1.0
 */
public class TimeUtil {

	/**
	 * 获取当前时间.
	 * @param format 格式,如 yyyy-MM-dd hh:mm:ss
	 * @return 当前时间
	 */
	public static String getCurrentTime(String format){
		DateFormat dateFormat = new SimpleDateFormat(format);
		String dateStr = dateFormat.format(new Date());
		return dateStr;
	}
	/**
	 * 获取日期相差天数.
	 * @param beginDateStr 开始时间
	 * @param endDateStr   结束时间
	 * @return 日期相差天数
	 */
	public static long getDateSub(String beginDateStr,String endDateStr){
		long day = 0;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate;
		Date endDate;
		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
			day = (endDate.getTime()-beginDate.getTime())/(1000*60*60*24);
		} catch (ParseException e) {
			 e.printStackTrace();
		}
		return day;
	}
    /**
     * 获取日期与当前日期相差的天数.
     * @param beginDateStr  指定日期
     * @return 日期与当前日期相差的天数
     */
	public static long getDateSub(String beginDateStr){
		long day = 0;
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate;
		Date now = new Date();
		try {
			beginDate = format.parse(beginDateStr);
			day = (now.getTime()-beginDate.getTime())/(24*60*60*1000);
		} catch (ParseException e) {
			 e.printStackTrace();
		}
		return day;
	}
	/**
	 * 获得给定日期的前后几天的日期.
	 * @param dateStr  日期,如:2016-01-01
	 * @param day  前后天数 如: 5 或 -21
	 * @return 给定日期的前后几天的日期
	 */
	public static String getDate(String dateStr,int day){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = dateFormat.parse(dateStr);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			calendar.add(Calendar.DATE, day);
			date = calendar.getTime();
			dateStr  = dateFormat.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateStr;
	}
	/**
	 * 获得当前日期的前后几天的日期.
	 * @param day  前后天数 如: 5 或 -21
	 * @return 当前日期的前后几天的日期
	 */
	public static String getDate(int day){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = "";
		Date now = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(now);
		calendar.add(Calendar.DATE, day);
		Date date = calendar.getTime();
		dateStr  = dateFormat.format(date);	
		return dateStr;
	}
	/**
	 * 给定年和月，获取该月的第一天.
	 * @param year 年
	 * @param month 月
	 * @return 格式为:yyyy-MM-dd
	 */
	public static String getFirstDayOfMonth(int year,int month){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		int firstDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, firstDay);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    String firstDayOfMonth = dateFormat.format(calendar.getTime());
	    return firstDayOfMonth;
	}
	/**
	 * 获取给定日期所在月的第一天.
	 * @param dateStr  yyyy-MM-dd
	 * @return 给定日期所在月的第一天
	 */
	public static String getFirstDayOfMonth(String dateStr){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		String firstDayOfMonth = null;
		try {
			date = dateFormat.parse(dateStr);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			int year = calendar.getTime().getYear()+1900;
			int month = calendar.getTime().getMonth()+1;
			firstDayOfMonth = getFirstDayOfMonth(year,month);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return firstDayOfMonth;
	}
	/**
	 * 给定年和月，获取该月的最后一天.
	 * @param year 年
	 * @param month 月
	 * @return 格式为:yyyy-MM-dd
	 */
	public static String getLastDayOfMonth(int year,int month){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, lastDay);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    String lastDayOfMonth = dateFormat.format(calendar.getTime());
	    return lastDayOfMonth;
	}
	/**
	 * 获取给定日期所在月的最后一天.
	 * @param dateStr  yyyy-MM-dd
	 * @return 给定日期所在月的最后一天
	 */
	public static String getLastDayOfMonth(String dateStr){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		String firstDayOfMonth = null;
		try {
			date = dateFormat.parse(dateStr);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			int year = calendar.getTime().getYear()+1900;
			int month = calendar.getTime().getMonth()+1;
			firstDayOfMonth = getLastDayOfMonth(year, month);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return firstDayOfMonth;
	}
	/**
	 * 判断给定字符串是否为yyyy-MM-dd格式
	 * @param dateStr 日期字符串
	 * @return 给定字符串是否为yyyy-MM-dd格式
	 */
    public static boolean is_yyyyMMdd(String dateStr){
    	String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
		Pattern p = Pattern.compile(rexp);
		Matcher m = p.matcher(dateStr);
		boolean dateFlag = m.matches();
    	return dateFlag;
    }
    /**
	 * 判断给定字符串是否为yyyy-MM-dd hh:mm:ss格式
	 * @param dateStr 日期字符串
	 * @return 给定字符串是否为yyyy-MM-dd hh:mm:ss格式
	 */
    public static boolean is_yyyyMMddhhmmss(String dateStr){
    	String rexp = "^(((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8])))))) ((20|21|22|23|[0-1][0-9]):[0-5][0-9]:[0-5][0-9]){1})";
		Pattern p = Pattern.compile(rexp);
		Matcher m = p.matcher(dateStr);
		boolean dateFlag = m.matches();
    	return dateFlag;
    }
    /**
     * 判断给定字符串是否为 yyyy-MM-dd hh:mm格式
     * @param dateStr 日期字符串
     * @return 给定字符串是否为 yyyy-MM-dd hh:mm格式
     */
    public static boolean is_yyyyMMddhhmm(String dateStr){
    	String rexp = "^(((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8])))))) ((20|21|22|23|[0-1][0-9]):[0-5][0-9]){1})";
		Pattern p = Pattern.compile(rexp);
		Matcher m = p.matcher(dateStr);
		boolean dateFlag = m.matches();
    	return dateFlag;
    }
    /**
     * 判断给定的字符串是否为hh:mm格式
     * @param dateStr 日期字符串
     * @return 给定的字符串是否为hh:mm格式
     */
    public static boolean is_hhmm(String dateStr){
    	String rexp = "^(((20|21|22|23|[0-1][0-9]):[0-5][0-9]){1})";
		Pattern p = Pattern.compile(rexp);
		Matcher m = p.matcher(dateStr);
		boolean dateFlag = m.matches();
    	return dateFlag;
    }
    /**
     * 判断给定的字符串是否为hh:mm:ss格式
     * @param dateStr 日期字符串
     * @return 给定的字符串是否为hh:mm:ss格式
     */ 
    public static boolean is_hhmmss(String dateStr){
    	String rexp = "^(((20|21|22|23|[0-1][0-9]):[0-5][0-9]:[0-5][0-9]){1})";
		Pattern p = Pattern.compile(rexp);
		Matcher m = p.matcher(dateStr);
		boolean dateFlag = m.matches();
    	return dateFlag;
    }
	/**
	 * 获取给定日期是周几.
	 * @param dateStr 日期字符串
	 * @return 给定日期是周几
	 */
    public static Integer getWeek(String dateStr){
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		Integer week = null;
		try {
			date = dateFormat.parse(dateStr);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			week = calendar.get(Calendar.DAY_OF_WEEK) -1;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return week;
    }
    /**
     * 比较两个日期的先后顺序
     * @param formatStr   如yyyy-MM-dd
     * @param before   如12:10
     * @param end   如09:00
     * @return end>before
     */
    public static boolean compareTime(String formatStr,String before,String end){
    	DateFormat format = new SimpleDateFormat(formatStr);
    	long ms;
		Date beginDate;
		Date endDate;
		try {
			beginDate = format.parse(before);
			endDate = format.parse(end);
			ms = endDate.getTime()-beginDate.getTime();
			System.out.println(ms);
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
    	return ms>0;
    }

}

