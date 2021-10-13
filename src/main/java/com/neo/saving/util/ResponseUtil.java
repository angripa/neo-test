package com.neo.saving.util;

import com.neo.saving.constant.ResultCode;
import com.neo.saving.dto.result.ZeusResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
   public static ZeusResult success(Object o) {
      return ZeusResult.builder()
              .code(ResultCode.SUCCESS.getCode())
              .message(ResultCode.SUCCESS.getMessage())
              .data(o)
              .build();
   }

   public static ResponseEntity<ZeusResult> buildSuccess(Object data) {
      return ResponseEntity.ok().body(ZeusResult.builder()
              .code(ResultCode.SUCCESS.getCode())
              .message(ResultCode.SUCCESS.getMessage())
              .build());
   }

   public static ResponseEntity<ZeusResult> buildResponse(HttpStatus status, ResultCode resultCode) {
      return buildResponse(status, resultCode, null);
   }

   public static ResponseEntity<ZeusResult> buildResponse(HttpStatus status, ResultCode resultCode, Object data) {
      return ResponseEntity.status(status).body(ZeusResult.builder()
              .code(resultCode.getCode())
              .message(resultCode.getMessage())
              .data(data)
              .build());
   }
}
