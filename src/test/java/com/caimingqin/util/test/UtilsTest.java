package com.caimingqin.util.test;

import java.util.Calendar;

import org.junit.Test;

public class UtilsTest {
	
	@Test
	public void test(){
		Calendar c = Calendar.getInstance();
		int i = c.get(Calendar.YEAR);
		int j = c.get(Calendar.MONTH)+1;
		 int k = c.get(Calendar.DAY_OF_MONTH);
		 String day=k+"";
		 if(k<10){
			 day="0"+k;
		 }
		 String yyyyMMdd=i+""+""+j+day;
		System.out.println(i+""+""+j+""+day);
	}

}
