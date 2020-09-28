package com.spcn.spcemulator.service;

import com.spcn.spcemulator.dto.SpcInfoDto;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class SpcInfoService {
    public SpcInfoDto readInfo(){
        // Hardcoded
        Map<LocalDateTime, Boolean> info = new HashMap<>();
        info.put(LocalDateTime.of(2020,8,20,12,50), true);
        info.put(LocalDateTime.of(2020,8,20,12,52), false);
        return new SpcInfoDto(info);
    }
}
