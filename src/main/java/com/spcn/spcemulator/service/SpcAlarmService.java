package com.spcn.spcemulator.service;

import com.spcn.spcemulator.dto.SpcAlarmDto;
import org.springframework.stereotype.Service;

@Service
public class SpcAlarmService {
    public SpcAlarmDto startAlarm(){
        // Hardcoded
        return new SpcAlarmDto(true);
    }
}
