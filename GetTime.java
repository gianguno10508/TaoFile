package updateFile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class GetTime {
	String dayNow, monthNow, yearNow, hourNow, minNow, secNow; 
	String dayOfWeek;
	Calendar cal = Calendar.getInstance();
	
	public String getDayNow() {
		dayNow = String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) ;
		return dayNow;
	}
	
	public String getMonthNow() {
		monthNow = String.valueOf((cal.get(Calendar.MONTH)+1));
		return monthNow;
	}
	
	public String getYearNow() {
		yearNow = String.valueOf(cal.get(Calendar.YEAR));
		return yearNow;
	}
	
	public String getHourNow() {
		hourNow = String.valueOf(cal.get(Calendar.HOUR));
		return hourNow;
	}
	public String getMinNow() {
		minNow = String.valueOf(cal.get(Calendar.MINUTE));
		return minNow;
	}
	public String getSecNow() {
		secNow = String.valueOf(cal.get(Calendar.SECOND));
		return secNow;
	}
	
	public String getDOW() {
		int y, d, m;
		y = Integer.parseInt(getYearNow());
		d = Integer.parseInt(getMonthNow());
		m = Integer.parseInt(getDayNow());
        cal.set(y, d, m);
        DateFormat formatter = new SimpleDateFormat("EEEE", Locale.getDefault());
        dayOfWeek = formatter.format(cal.getTime());
		return dayOfWeek;
	}
	
	public String getTimeNow() {
		String timeNow = (getYearNow()+"\\" +getMonthNow()+"-"+getYearNow()+"\\"+getDayNow()+"-"+getMonthNow()+"-"+getYearNow());
    	return timeNow;
    }
}
