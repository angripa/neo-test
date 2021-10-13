package com.neo.saving.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.neo.saving.constant.ResultCode;
import com.neo.saving.exception.CommonException;

public class AppUtil {
   public static JsonObject parse(String credential) {
      try {
         JsonObject jsonObject = new Gson().fromJson(credential, JsonObject.class);
         return jsonObject;
      } catch (Exception e) {
         throw new CommonException(ResultCode.SYSTEM_BUSY);
      }

   }
}
