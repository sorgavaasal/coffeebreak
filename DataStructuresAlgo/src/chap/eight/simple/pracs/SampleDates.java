package chap.eight.simple.pracs;

import java.util.Calendar;
import java.util.Date;

public class SampleDates {
	
	public static void main(String[] args) {
		System.out.println(new Date().getTime());
		System.out.println(new Date(1475301600));
		System.out.println(new Date(1477980000));
		System.out.println(new Date(1480575600));
		System.out.println(new Date(1483254000));
		System.out.println(new Date(1485932400));
		Calendar myCalendar = Calendar.getInstance();
		myCalendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		myCalendar.set(Calendar.MONTH, Calendar.JANUARY);
		myCalendar.set(Calendar.DAY_OF_MONTH, 17);
		myCalendar.set(Calendar.YEAR, 1970);
		myCalendar.set(Calendar.HOUR, 23);
		myCalendar.set(Calendar.MINUTE, 45);
		//myCalendar.set(Calendar.SECOND, );
		for (int i=1; i<=60; ++i) {
			myCalendar.set(Calendar.SECOND, i);
			System.out.println(myCalendar.getTimeInMillis());
		}
	}

}
