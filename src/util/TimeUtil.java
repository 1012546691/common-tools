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
 * ʱ�乤����
 * @author nagsh
 * @version 1.0
 */
public class TimeUtil {

	/**
	 * ��ȡ��ǰʱ��.
	 * @param format ��ʽ,�� yyyy-MM-dd hh:mm:ss
	 * @return ��ǰʱ��
	 */
	public static String getCurrentTime(String format){
		DateFormat dateFormat = new SimpleDateFormat(format);
		String dateStr = dateFormat.format(new Date());
		return dateStr;
	}
	/**
	 * ��ȡ�����������.
	 * @param beginDateStr ��ʼʱ��
	 * @param endDateStr   ����ʱ��
	 * @return �����������
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
     * ��ȡ�����뵱ǰ������������.
     * @param beginDateStr  ָ������
     * @return �����뵱ǰ������������
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
	 * ��ø������ڵ�ǰ���������.
	 * @param dateStr  ����,��:2016-01-01
	 * @param day  ǰ������ ��: 5 �� -21
	 * @return �������ڵ�ǰ���������
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
	 * ��õ�ǰ���ڵ�ǰ���������.
	 * @param day  ǰ������ ��: 5 �� -21
	 * @return ��ǰ���ڵ�ǰ���������
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
	 * ��������£���ȡ���µĵ�һ��.
	 * @param year ��
	 * @param month ��
	 * @return ��ʽΪ:yyyy-MM-dd
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
	 * ��ȡ�������������µĵ�һ��.
	 * @param dateStr  yyyy-MM-dd
	 * @return �������������µĵ�һ��
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
	 * ��������£���ȡ���µ����һ��.
	 * @param year ��
	 * @param month ��
	 * @return ��ʽΪ:yyyy-MM-dd
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
	 * ��ȡ�������������µ����һ��.
	 * @param dateStr  yyyy-MM-dd
	 * @return �������������µ����һ��
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
	 * �жϸ����ַ����Ƿ�Ϊyyyy-MM-dd��ʽ
	 * @param dateStr �����ַ���
	 * @return �����ַ����Ƿ�Ϊyyyy-MM-dd��ʽ
	 */
    public static boolean is_yyyyMMdd(String dateStr){
    	String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
		Pattern p = Pattern.compile(rexp);
		Matcher m = p.matcher(dateStr);
		boolean dateFlag = m.matches();
    	return dateFlag;
    }
    /**
	 * �жϸ����ַ����Ƿ�Ϊyyyy-MM-dd hh:mm:ss��ʽ
	 * @param dateStr �����ַ���
	 * @return �����ַ����Ƿ�Ϊyyyy-MM-dd hh:mm:ss��ʽ
	 */
    public static boolean is_yyyyMMddhhmmss(String dateStr){
    	String rexp = "^(((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8])))))) ((20|21|22|23|[0-1][0-9]):[0-5][0-9]:[0-5][0-9]){1})";
		Pattern p = Pattern.compile(rexp);
		Matcher m = p.matcher(dateStr);
		boolean dateFlag = m.matches();
    	return dateFlag;
    }
    /**
     * �жϸ����ַ����Ƿ�Ϊ yyyy-MM-dd hh:mm��ʽ
     * @param dateStr �����ַ���
     * @return �����ַ����Ƿ�Ϊ yyyy-MM-dd hh:mm��ʽ
     */
    public static boolean is_yyyyMMddhhmm(String dateStr){
    	String rexp = "^(((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8])))))) ((20|21|22|23|[0-1][0-9]):[0-5][0-9]){1})";
		Pattern p = Pattern.compile(rexp);
		Matcher m = p.matcher(dateStr);
		boolean dateFlag = m.matches();
    	return dateFlag;
    }
    /**
     * �жϸ������ַ����Ƿ�Ϊhh:mm��ʽ
     * @param dateStr �����ַ���
     * @return �������ַ����Ƿ�Ϊhh:mm��ʽ
     */
    public static boolean is_hhmm(String dateStr){
    	String rexp = "^(((20|21|22|23|[0-1][0-9]):[0-5][0-9]){1})";
		Pattern p = Pattern.compile(rexp);
		Matcher m = p.matcher(dateStr);
		boolean dateFlag = m.matches();
    	return dateFlag;
    }
    /**
     * �жϸ������ַ����Ƿ�Ϊhh:mm:ss��ʽ
     * @param dateStr �����ַ���
     * @return �������ַ����Ƿ�Ϊhh:mm:ss��ʽ
     */ 
    public static boolean is_hhmmss(String dateStr){
    	String rexp = "^(((20|21|22|23|[0-1][0-9]):[0-5][0-9]:[0-5][0-9]){1})";
		Pattern p = Pattern.compile(rexp);
		Matcher m = p.matcher(dateStr);
		boolean dateFlag = m.matches();
    	return dateFlag;
    }
	/**
	 * ��ȡ�����������ܼ�.
	 * @param dateStr �����ַ���
	 * @return �����������ܼ�
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
     * �Ƚ��������ڵ��Ⱥ�˳��
     * @param formatStr   ��yyyy-MM-dd
     * @param before   ��12:10
     * @param end   ��09:00
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

