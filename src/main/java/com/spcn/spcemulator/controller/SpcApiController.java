package com.spcn.spcemulator.controller;

import com.spcn.spcemulator.dto.SpcAlarmDto;
import com.spcn.spcemulator.dto.SpcInfoDto;
import com.spcn.spcemulator.service.SpcAlarmService;
import com.spcn.spcemulator.service.SpcInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpcApiController {
    private final SpcAlarmService spcAlarmService;
    private final SpcInfoService spcInfoService;

    @Autowired
    public SpcApiController(SpcAlarmService spcAlarmService, SpcInfoService spcInfoService) {
        this.spcAlarmService = spcAlarmService;
        this.spcInfoService = spcInfoService;
    }

    @GetMapping("/alarm")
    public ResponseEntity<SpcAlarmDto> startAlarm(){
        System.out.println("\nПолучен сигнал о начале приема");
        System.out.println("Отправлен ответ");
        return new ResponseEntity<>(spcAlarmService.startAlarm(), HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<SpcInfoDto> readInfo(){
        System.out.println("\nЗапрошена информация о приеме");
        System.out.println("Отправлен ответ");
        return new ResponseEntity<>(spcInfoService.readInfo(), HttpStatus.OK);
    }
}
