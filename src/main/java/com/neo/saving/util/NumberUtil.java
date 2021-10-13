package com.neo.saving.util;

import java.text.DecimalFormat;

public class NumberUtil {
   static final DecimalFormat df = new DecimalFormat("#,###.00");
   public static String parse(double d){
      return df.format(d);
   }
}
