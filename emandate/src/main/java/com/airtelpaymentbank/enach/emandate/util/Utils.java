package com.airtelpaymentbank.enach.emandate.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.ibm.icu.text.RuleBasedNumberFormat;

public class Utils {

	public static String getMoneyIntoWord(BigDecimal input) {
		Locale locale = Locale.US;
		RuleBasedNumberFormat formatter = new RuleBasedNumberFormat(locale, RuleBasedNumberFormat.SPELLOUT);
		String result = formatter.format(input);
		return result;
	}

	public static String dateConverter(Date date) {
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		String dated="";
		try {
			dated = DateFor.format(date);
			System.out.println("Date : " + date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dated;
	}

}
