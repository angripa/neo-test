package com.neo.saving.config.handler;

import com.neo.saving.constant.ResultCode;
import com.neo.saving.exception.CommonException;
import com.neo.saving.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice
public class GlobalServiceHandler implements Serializable {

   private static final long serialVersionUID = -2776309723271890552L;

   @ExceptionHandler({ServletException.class})
   public ResponseEntity<?> runtimeException(ServletException ex) {
      ex.printStackTrace();
      return ResponseUtil.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, ResultCode.SYSTEM_BUSY);
   }
   @ExceptionHandler({Exception.class, RuntimeException.class})
   public ResponseEntity<?> runtimeException(Exception ex) {
      ex.printStackTrace();
      return ResponseUtil.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, ResultCode.SYSTEM_BUSY);
   }


   @ExceptionHandler(NoSuchElementException.class)
   public ResponseEntity<?> noElementException(NoSuchElementException ex) {
      ex.printStackTrace();
      return ResponseUtil.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, ResultCode.SYSTEM_BUSY);
   }

   @ExceptionHandler({HttpRequestMethodNotSupportedException.class, HttpMediaTypeNotAcceptableException.class})
   public ResponseEntity<?> error(Exception ex) {
      ex.printStackTrace();
      return ResponseUtil.buildResponse(HttpStatus.NOT_FOUND, ResultCode.SERVICE_NOT_FOUND);
   }

   @ResponseStatus(HttpStatus.BAD_REQUEST)
   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
      ex.printStackTrace();
      List<String> err = new ArrayList<>();
      ex.getBindingResult().getFieldErrors().forEach(fieldError -> {
         err.add(fieldError.getDefaultMessage());
      });
      return ResponseUtil.buildResponse(HttpStatus.BAD_REQUEST, ResultCode.BAD_REQUEST, err);
   }

   @ExceptionHandler(HttpMessageNotReadableException.class)
   public ResponseEntity<?> handleValidationExceptions(HttpMessageNotReadableException ex) {
      ex.printStackTrace();
      return ResponseUtil.buildResponse(HttpStatus.BAD_REQUEST, ResultCode.BAD_REQUEST);
   }

   @ExceptionHandler(NoHandlerFoundException.class)
   @ResponseStatus(HttpStatus.NOT_FOUND)
   public ResponseEntity<?> exception(NoHandlerFoundException ex) {
      ex.printStackTrace();
      return ResponseUtil.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, ResultCode.SERVICE_NOT_FOUND);
   }

   @ExceptionHandler(value = {CommonException.class})
   public ResponseEntity<?> commonException(CommonException e) {
      e.printStackTrace();
      return ResponseUtil.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getResultCode());
   }

}
