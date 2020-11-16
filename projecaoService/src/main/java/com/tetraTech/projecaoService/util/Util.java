package com.tetraTech.projecaoService.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public  class Util {

    public Calendar stringToCalendar(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date dateConvert = formatter.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateConvert);

        return calendar;
    }

    public String calendarToString(Calendar calendar) throws ParseException {
        Date date = calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return formatter.format(date);
    }

}
