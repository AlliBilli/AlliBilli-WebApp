package com.utils;

import java.util.Calendar;
import java.util.TimeZone;

public class TimeZoneConversion
{

	//private static final Logger logger = Logger.getLogger(TimeZoneConversion.class);
	public static void convertTimeZoneTime(TimeZone fromTimeZone, TimeZone toTimeZone, Calendar output ) 
	{

		// FROM TimeZone to UTC
		int rawOffset_from_UTC = fromTimeZone.getRawOffset();
		output.add(Calendar.MILLISECOND, rawOffset_from_UTC*-1);

		if (fromTimeZone.inDaylightTime(output.getTime())) {
			int dstOffset_from_UTC = output.getTimeZone().getDSTSavings();
			output.add(Calendar.MILLISECOND, dstOffset_from_UTC*-1);
		}
		
		// UTC to TO TimeZone
		output.add(Calendar.MILLISECOND, toTimeZone.getRawOffset());

		if (toTimeZone.inDaylightTime(output.getTime())) {
			output.add(Calendar.MILLISECOND, toTimeZone.getDSTSavings());
		}
	}

}
