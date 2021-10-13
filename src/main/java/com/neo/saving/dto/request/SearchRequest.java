package com.neo.saving.dto.request;

import lombok.*;

import javax.validation.constraints.Min;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest extends BaseRequest {

   private static final long serialVersionUID = 939757849426016414L;

   @Min(message = "", value = 0)
   Integer offset;
   @Min(message = "", value = 1)
   Integer limit;
   String search;
}
