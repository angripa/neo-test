package com.neo.saving.dto.request;

import com.neo.saving.constant.SavingPurpose;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SavingRequest extends BaseRequest {
   @NotNull(message = "tenor required")
   @Min(value = 1,message = "tenor must be > 0")
   private Integer tenor;

   @NotNull(message = "firstDepositAmount required")
   @Min(value = 1,message = "firstDepositAmount must be > 0")
   private Integer firstDepositAmount;

   @NotNull(message = "monthlyDepositAmount required")
   @Min(value = 1,message = "monthlyDepositAmount must be > 0")
   private Integer monthlyDepositAmount;

   @NotNull(message = "purpose required")
   private SavingPurpose purpose;
}
