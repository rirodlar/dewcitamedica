package pe.com.citasmedicas.commons;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

public class CitasFormatter
{
  private static final String emptyString = "";

  public static String formatDate(Date param)
  {
    if (param == null) return emptyString;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    return df.format(param);
  }
  
  public static String formatDate2(Date param)
  {
      if (param == null) return emptyString;
      DateFormat df = new SimpleDateFormat("MMM-yy");
      return df.format(param);
  }

  public static String formatDate(Date param, String format)
  {
     if (param == null) return emptyString;
     DateFormat df = new SimpleDateFormat(format);
     return df.format(param);
  }

  public static String formatTime(Date param)
  {
    if (param == null) return emptyString;
    DateFormat df = new SimpleDateFormat("h:mm a");
    return df.format(param);
  }

  public static String formatString(String param)
  {
    if (param == null) return emptyString;
    return param;
  }

  public static String formatCurrency(double param)
  {
    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    symbols.setDecimalSeparator('.');
    symbols.setGroupingSeparator(',');

    NumberFormat nf = new DecimalFormat("#,##0.00", symbols);
    return nf.format(param);
  }

  public static String formatPercentage(double param)
  {
    return String.valueOf(param);
  }

  public static String formatInteger(int param, boolean hiddenZero)
  {
    if (param == 0 && hiddenZero) {
      return "";
    } else {
    return String.valueOf(param);
  }
  }

  public static String formatInteger(int param)
  {
    return formatInteger(param, false);
  }

  public static String formatChar(char param)
  {
    return String.valueOf(param);
  }

  public static String formatLong(long param)
  {
    return String.valueOf(param);
  }

  public static String formatBoolean(boolean param)
  {
    return String.valueOf(param);
  }
  
  public static String formatDouble(String param)
  {
      return param.replaceAll(",","");
  }
   
    public static String formatCurrency2(double param)
    {
      NumberFormat nf = new DecimalFormat("#,##0.000");
      return nf.format(param); 
    }
   
    public static String formatDecimal( double param, int numdecimales ){
        
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        symbols.setGroupingSeparator(',');

        String sFormatoDecimal = "";
        for(int i=0; i < numdecimales; i++){
            sFormatoDecimal += "0";
        }
        NumberFormat nf = new DecimalFormat("#,##0."+ sFormatoDecimal,symbols);
        return nf.format(param); 
    }
   
    public static String formatTimeHHMMSS(Date param)
    {
      if (param == null) return emptyString;
      DateFormat df = new SimpleDateFormat("h:mm:ss a");
      return df.format(param);
    }
   
}