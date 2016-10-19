package test;

import util.TimeUtil;

public class TimeUtilTest {

	public static void main(String[] args) {
		System.out.println(TimeUtil.getCurrentTime("yyyy-MM-dd hh:mm:ss"));
		System.out.println(TimeUtil.getDateSub("2015-10-09", "2016-04-08"));
		System.out.println(TimeUtil.getDateSub("2016-02-29"));
		System.out.println(TimeUtil.getDate("2016-04-01",5));
		System.out.println(TimeUtil.getDate(6));
		System.out.println(TimeUtil.getFirstDayOfMonth(2016, 1));
		System.out.println(TimeUtil.getLastDayOfMonth(2016, 2));
		System.out.println(TimeUtil.getFirstDayOfMonth("2016-04-05"));
		System.out.println(TimeUtil.getLastDayOfMonth("2016-04-05"));
		System.out.println(TimeUtil.is_yyyyMMdd("2016-02-29"));
		System.out.println(TimeUtil.is_yyyyMMddhhmmss("2016-02-29 00:00:59"));
		System.out.println(TimeUtil.is_yyyyMMddhhmm("2016-02-29 00:00"));
		System.out.println(TimeUtil.is_hhmm("01:00"));
		System.out.println(TimeUtil.is_hhmmss("01:00:59"));
		System.out.println(TimeUtil.getWeek("2016-02-30"));
		System.out.println(TimeUtil.compareTime("hh:mm","01:00","09:00"));

	}

}
