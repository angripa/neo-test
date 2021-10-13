package com.neo.saving.util;

import com.neo.saving.constant.ResultCode;
import com.neo.saving.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Objects;
@Slf4j
@Component
public class AssertUtil implements Serializable {

   private static final long serialVersionUID = 4174197081114404861L;

   public void isFalse(Boolean b, ResultCode resultCode) {
      isTrue(!b, resultCode);
   }

   public void isTrue(Boolean b, ResultCode resultCode) {
      if (b) {
         log.error("Error {}",resultCode);
         throw new CommonException(resultCode);
      }
   }

   public void isNull(Object o, ResultCode resultCode) {
      if (Objects.isNull(o)) {
         log.error("Error isNull {}",o);
         throw new CommonException(resultCode);
      }
   }

   public void notNull(Object o, ResultCode resultCode) {
      if (!Objects.isNull(o)) {
         log.error("Error notNull {}",o);
         throw new CommonException(resultCode);
      }
   }

   public void empty(String str, ResultCode resultCode) {
      if (str == null || str.isEmpty()) {
         log.error("Error empty {}",str);
         throw new CommonException(resultCode);
      }
   }

   public void regexNotValid(String str, String regex, ResultCode resultCode) {
      if (str == null || str.isEmpty() || !RegexUtil.regexValidate(str, regex)) {
         log.error("Error regexNotValid {}",str);
         throw new CommonException(resultCode);
      }
   }

   public void isEqual(Object o, Object o1, ResultCode resultCode) {
      if (Objects.equals(o, o1)) {
         log.error("Error isEqual {} {}",o,o1);
         throw new CommonException(resultCode);
      }
   }

   public void notEqual(Object o, Object o1, ResultCode resultCode) {
      if (!Objects.equals(o, o1)) {
         log.error("Error  notEqual {} {}",o,o1);
         throw new CommonException(resultCode);
      }
   }

   public void notJson(String str, ResultCode resultCode) {
      try {
         if (null == str || str.isEmpty())
            return;

         AppUtil.parse(str);
      } catch (Exception e) {
         log.error("Error  notJson {} ",str);
         throw new CommonException(resultCode);
      }
   }
}
