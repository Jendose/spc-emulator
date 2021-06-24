package com.spcn.spcemulator.controller;

import com.spcn.spcemulator.service.SpcService;
import com.spcn.spcemulator.service.SpcConnectionTestService;
import com.spcn.spcemulator.service.utils.SpcInfoWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpcApiController {

    private final SpcConnectionTestService spcConnectionTestService;
    private final SpcService spcService;

    @Autowired
    public SpcApiController(SpcConnectionTestService spcConnectionTestService, SpcService spcService) {
        this.spcConnectionTestService = spcConnectionTestService;
        this.spcService = spcService;
    }

    @GetMapping("/connectionTest")
    public ResponseEntity<Boolean> testConnection(){
        return new ResponseEntity<>(spcConnectionTestService.testConnection(), HttpStatus.OK);
    }

    @GetMapping("/startTake")
    public ResponseEntity<Boolean> startTake(){
        return new ResponseEntity<>(spcService.startTake(), HttpStatus.OK);
    }

    @GetMapping("/endTake")
    public ResponseEntity<Integer> endTake(){
        return new ResponseEntity<>(spcService.endTake().getInfo(), HttpStatus.OK);
    }
}
