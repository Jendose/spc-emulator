package com.spcn.spcemulator.controller;

import com.spcn.spcemulator.service.SpcInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class SpcInfoController {

    private final SpcInfoService spcInfoService;

    @Autowired
    public SpcInfoController(SpcInfoService spcInfoService) {
        this.spcInfoService = spcInfoService;
    }

    // TODO: Будет вызываться реактовским визуализатором для открытия крышки
    @GetMapping("/writeOpening")
    public ResponseEntity<Void> writeOpening(){
        spcInfoService.writeOpening();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // TODO: Будет вызываться реактовским визуализатором для закрытия крышки
    @GetMapping("/writeClosing")
    public ResponseEntity<Void> writeClosing(){
        spcInfoService.writeClosing();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // TODO: Будет вызываться реактовским визуализатором для проверки, запущен ли эмулятор
    @GetMapping("/")
    public ResponseEntity<Void> test(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
