package com.spcn.spcemulator.service;

import com.spcn.spcemulator.dto.SpcRegistrationDataDto;
import com.spcn.spcemulator.dto.SpcRegistrationResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SpcRegistrationService {

    public SpcRegistrationResponseDto registerSpc(){
        SpcRegistrationDataDto spcRegistrationData = new SpcRegistrationDataDto();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SpcRegistrationResponseDto> response = restTemplate.postForEntity("http://localhost", spcRegistrationData, SpcRegistrationResponseDto.class);
        return response.getBody();
    }
}
