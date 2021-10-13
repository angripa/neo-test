package com.neo.saving.exception;

import com.neo.saving.constant.ResultCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ParamException extends RuntimeException {
   ResultCode resultCode;

   public ParamException() {
      this.resultCode = ResultCode.SYSTEM_BUSY;
   }

   public ParamException(ResultCode resultCode) {
      super(resultCode.getMessage());
      this.resultCode = resultCode;
   }
}
