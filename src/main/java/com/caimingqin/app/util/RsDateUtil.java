package com.caimingqin.app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class RsDateUtil {
	public static int getDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}  

	public static String getDateFormat(String forMatType) {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat(forMatType);
		return format.format(date);
	}

	public static Date getDate(String date, String forMatType) {
		SimpleDateFormat format = new SimpleDateFormat(forMatType);
		Date dates = null;
		try {
			dates = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dates;
	}

	public static Integer getWeekOfDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		return w == 1 ? 7 : w;
	}

	public static String getNowOfMonth(String format, Integer dMonth) {
		SimpleDateFormat aSimpleDateFormat = new SimpleDateFormat(format);
		GregorianCalendar aGregorianCalendar = new GregorianCalendar();
		aGregorianCalendar.set(Calendar.MONTH,
				aGregorianCalendar.get(Calendar.MONTH) - dMonth);
		String nowOfLastMonth = aSimpleDateFormat.format(aGregorianCalendar
				.getTime());
		return nowOfLastMonth;
	}
   /*******************************************caimingqin**********************************************************/
	public static Object[] parse(Object[] params) {
		List<Object> all = new ArrayList<Object>();
		for (Object p : params) {
			if (p == null || "".equals(p) || "isnull".equals(p)) {
				p = "%";
			} else {
				p = p + "%";
			}
			all.add(p);
		}
		System.out.println("params====>" + all.toString());
		return all.toArray();
	}
	
	public static String [] createLikeConditions(String [] params){
		for(int i=0;i<params.length;i++){
			params[i]=createLikeCondition(params[i]);
		}
		return  params;
	}
	
	public static String createLikeCondition(String param) {
		if (param == null || "".equals(param)) {
			param = "%";
		} else {
			param = param + "%";
		}
		return param;
	}
	
	public static boolean validateNull(List<? extends Object> all, Object... objects) {
		if (all == null || all.size() == 0) {
			return true;
		}
		for (Object obj : objects) {
			if (obj == null||"".equals(obj.toString().trim())) {
				return true;
			}
		}
		return false;
	}
	
	
	public static boolean isCurrentMonth(String YYYYMM){
		
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		SimpleDateFormat format=new SimpleDateFormat("yyyyMM");
		String CurrentMonth = format.format(date);
		if(CurrentMonth.compareTo(YYYYMM)==0){
			return true;
		}
		return false;
	}
	
	/******************************************caimingqin***********************************************************/




	
}
