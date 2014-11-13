package com.example.action.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateHelper {

	static public final String datePattern1 = "yyyy-MM-dd"; 
	
	static public Date convertidorString2DateConLocaleRoot(String pattern, String dateString) throws ParseException{
		if(dateString != null && dateString.trim().length()>0){
			return new SimpleDateFormat(pattern,Locale.ROOT).parse(dateString);			
		}else{
			return null;
		}
	}

}
