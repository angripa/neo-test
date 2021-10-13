package com.neo.saving.exception;

import com.neo.saving.constant.ResultCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommonException extends RuntimeException {
   ResultCode resultCode;

   public CommonException() {
      super("[CommonException]");
      this.resultCode = ResultCode.SYSTEM_BUSY;
   }

   public CommonException(ResultCode resultCode) {
      super(String.format("[CommonException %d]", resultCode.getCode()));
      this.resultCode = resultCode;
   }
}
