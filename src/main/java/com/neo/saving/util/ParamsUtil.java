package com.neo.saving.util;

import com.neo.saving.constant.ResultCode;
import com.neo.saving.exception.ParamException;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;

@Component
public class ParamsUtil implements Serializable {

   private static final long serialVersionUID = 4174197081114404861L;

   public void check(String str) {
      check(str, ResultCode.INVALID_PARAM);
   }

   public void check(String str, ResultCode resultCode) {
      if (str == null || str.isEmpty())
         throw new ParamException(resultCode);
   }

   public void isFalse(Boolean b, ResultCode resultCode) {
      isTrue(!b, resultCode);
   }

   public void isTrue(Boolean b, ResultCode resultCode) {
      if (b)
         throw new ParamException(resultCode);
   }

   public void isNull(Object o, ResultCode resultCode) {
      if (Objects.isNull(o))
         throw new ParamException(resultCode);
   }

   public void notNull(Object o, ResultCode resultCode) {
      if (!Objects.isNull(o))
         throw new ParamException(resultCode);
   }

   public void empty(String str, ResultCode resultCode) {
      if (str == null || str.isEmpty())
         throw new ParamException(resultCode);
   }

   public void regexNotValid(String str, String regex, ResultCode resultCode) {
      if (str == null || str.isEmpty() || !RegexUtil.regexValidate(str, regex))
         throw new ParamException(resultCode);
   }
}
