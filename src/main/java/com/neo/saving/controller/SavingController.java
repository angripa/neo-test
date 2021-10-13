package com.neo.saving.controller;

import com.neo.saving.dto.request.SavingRequest;
import com.neo.saving.dto.request.SearchRequest;
import com.neo.saving.dto.result.ZeusResult;
import com.neo.saving.service.SavingService;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class SavingController {

   @Autowired
   SavingService savingService;

   @ApiOperation(value = "Calculate a saving")
   @PostMapping(value = "/saving/calculate")
   public ResponseEntity<ZeusResult> calculate(@Valid @RequestBody SavingRequest request) {
      return ResponseEntity.ok(savingService.calculate(request));
   }

   @ApiOperation(value = "create a saving")
   @PostMapping(value = "/saving/create")
   public ResponseEntity<ZeusResult> create(@Valid @RequestBody SavingRequest request) {
      return ResponseEntity.ok(savingService.create(request));
   }

   @ApiOperation(value = "get saving detail")
   @GetMapping(value = "/saving/detail/{id}")
   public ResponseEntity<ZeusResult> detail(@PathVariable("id") String id) {
      return ResponseEntity.ok(savingService.detail(id));
   }

   @ApiOperation(value = "get saving ")
   @PostMapping(value = "/saving/list")
   public ResponseEntity<ZeusResult> detail(@Valid @RequestBody SearchRequest request) {
      return ResponseEntity.ok(savingService.list(request));
   }

}
