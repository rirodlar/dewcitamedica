package pe.com.citasmedicas.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class ValidationUtil
{
  public static boolean isChecked(String param)
  {
    return (param != null);
  }

  public static boolean isNull(String param)
  {
    return (param == null);
  }
  
    public static String parseString(String param)
    {
      if (param == null) return "";
      return param;
    }

    public static String parseString(int param)
    {
      if (param == 0) return "";
      return String.valueOf(param);
    }

  public static Date parseDate(String param)
  {
    Date date;
    try
    {
      date = (param != null && !param.equalsIgnoreCase(""))? (new SimpleDateFormat("dd/MM/yyyy")).parse(param) : null;
    }
    catch (ParseException ex)
    {
      date = null;
    }
    return date;
  }

  public static Date parseDate(String param, String format)
  {
    Date date;
    try
    {
      date = (param != null && !param.equalsIgnoreCase(""))? (new SimpleDateFormat(format)).parse(param) : null;
    }
    catch (ParseException ex)
    {
      date = null;
    }
    return date;
  }

  public static double parseDouble(String param)
  {
    return (param != null && !param.equalsIgnoreCase(""))? Double.parseDouble(param) : 0;
  }

  public static int parseInt(String param)
  {  
    return (param != null && !param.equalsIgnoreCase(""))? Integer.parseInt(param) : 0;
  }
  
  public static long parseLong(String param)
  {
    return (param != null && !param.equalsIgnoreCase(""))? Long.parseLong(param) : 0;
  }
   
   public static String isEmpty(String checkValue, String replacementValue) {
       return checkValue.equalsIgnoreCase("") ? replacementValue : checkValue;
   }
}