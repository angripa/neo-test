package com.neo.saving.constant;

import lombok.Getter;

@Getter
public enum ResultCode {

   SUCCESS(200, "default.success"),

   CREATED(201, "default.created"),

   BAD_REQUEST(400, "bad.request"),
   ILLEGAL_PARAM(400, "illegal.params"),
   INVALID_PARAM(400, "invalid.param"),
   DATA_DUPLICATE(400, "data.duplicate"),
   ORDER_ALREADY_PAID(400, "order.already.paid"),
   PRODUCT_ALREADY_MAPPED(400, "productcode.paymentchannel.already.mapped"),

   UNAUTHORIZED(401, "unauthorized"),

   UNAUTHORIZE_ACCESS(403, "access.not.allowed"),
   SERVICE_NOT_FOUND(404, "service.not.found"),
   NOT_FOUND(404, "no.data.found"),
   PAYMENT_CHANNEL_INVALID(404, "payment.channel.not.found"),
   DATA_NOT_FOUND(404, "data.not.found"),
   TRANSACTION_NOT_FOUND(404, "transaction.with.order.id.not.found"),
   METHOD_NOT_ALLOWED(405, "method.not.allowed"),

   RADSOFT_ERROR(500, "Matriks connection error "),
   SYSTEM_BUSY(500, "system.busy");

   private int code;
   private String message;

   ResultCode(int code, String message) {
      this.code = code;
      this.message = message;
   }

   public static ResultCode fromMessage(String message) {

      for (ResultCode resultCode : ResultCode.values()) {
         if (resultCode.getMessage().equals(message))
            return resultCode;
      }
      return SYSTEM_BUSY;
   }
}
