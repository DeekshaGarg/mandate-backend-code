package com.airtelpaymentbank.enach.emandate.util;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {

    @Test
    void testGetMoneyIntoWord() {
        assertEquals("result", Utils.getMoneyIntoWord(new BigDecimal("0.00")));
    }

    @Test
    void testDateConverter() {
        assertEquals("result", Utils.dateConverter(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime()));
    }
}
