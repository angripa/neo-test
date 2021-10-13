package com.neo.saving.dto.result;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SearchResult<T> extends BaseResult {

   private static final long serialVersionUID = 1041179869887727048L;

   int totalPage;
   long totalData;
   T content;
}
