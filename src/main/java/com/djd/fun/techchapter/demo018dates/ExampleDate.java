package com.djd.fun.techchapter.demo018dates;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExampleDate {
  public static void main(String[] args) throws ParseException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    long time = simpleDateFormat.parse("05/20/2018").getTime();
    Date date = new Date(time);
    System.out.println("date: " + date);
  }
}
