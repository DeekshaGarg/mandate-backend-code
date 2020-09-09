package com.airtelpaymentbank.enach.emandate.util;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.bind.DatatypeConverter;

import com.ibm.icu.text.RuleBasedNumberFormat;

public class Utils {

	public static String getMoneyIntoWord(BigDecimal input) {
		Locale locale = Locale.US;
		RuleBasedNumberFormat formatter = new RuleBasedNumberFormat(locale, RuleBasedNumberFormat.SPELLOUT);
		return formatter.format(input);
	}

	public static String dateConverter(Date date) {
		SimpleDateFormat DateFor = new SimpleDateFormat("yyyy-mm-dd");
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
