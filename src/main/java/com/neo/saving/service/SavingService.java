package com.neo.saving.service;

import com.neo.saving.constant.ResultCode;
import com.neo.saving.domain.entity.Saving;
import com.neo.saving.domain.repository.SavingRepository;
import com.neo.saving.dto.request.SavingRequest;
import com.neo.saving.dto.request.SearchRequest;
import com.neo.saving.dto.result.ZeusResult;
import com.neo.saving.exception.CommonException;
import com.neo.saving.util.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class SavingService {

   @Autowired
   SavingRepository savingRepository;

   public ZeusResult calculate(SavingRequest request) {
      Integer grandTotal = request.getTenor() * request.getMonthlyDepositAmount() + request.getFirstDepositAmount();
      double finalBalance = ((request.getTenor().doubleValue() / 12d) * 0.06 * grandTotal.doubleValue()) + grandTotal.doubleValue();
      return ZeusResult.builder()
              .code(ResultCode.SUCCESS.getCode())
              .message(ResultCode.SUCCESS.getMessage())
              .data(NumberUtil.parse(finalBalance))
              .build();
   }

   public ZeusResult create(SavingRequest request) {
      Saving saving = new Saving();
      saving.setTenor(request.getTenor());
      saving.setFirstDepositAmount(request.getFirstDepositAmount());
      saving.setMonthlyDepositAmount(request.getMonthlyDepositAmount());
      saving.setSavingPurpose(request.getPurpose());
      savingRepository.saveAndFlush(saving);
      return ZeusResult.builder()
              .code(ResultCode.SUCCESS.getCode())
              .message(ResultCode.SUCCESS.getMessage())
              .data(saving)
              .build();
   }

   public ZeusResult detail(String id) {

      return ZeusResult.builder()
              .code(ResultCode.SUCCESS.getCode())
              .message(ResultCode.SUCCESS.getMessage())
              .data(savingRepository.findByIdAndDeletedIsFalse(id).<CommonException>orElseThrow(() -> {
                 throw new CommonException(ResultCode.DATA_NOT_FOUND);
              }))
              .build();
   }

   public ZeusResult list(SearchRequest request) {

      return ZeusResult.builder()
              .code(ResultCode.SUCCESS.getCode())
              .message(ResultCode.SUCCESS.getMessage())
              .data(savingRepository.findAllByDeletedIsFalse(PageRequest.of(request.getOffset(), request.getLimit())).getContent())
              .build();
   }
}
