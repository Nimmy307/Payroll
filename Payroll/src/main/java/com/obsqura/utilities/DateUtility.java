package com.obsqura.utilities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DateUtility {

	public String currentdate() {
		// Instantiate a Date object
		Date date = new Date();
		// display time and date using toString()
		return (date.toString());
	}

	public String simpleformatdate() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

		return ("Current Date: " + ft.format(dNow));

	}

	public String currentTimeDate() {
		LocalDateTime myObj = LocalDateTime.now();
		String localtimedate = myObj.toString();
		return (localtimedate);
	}

}
