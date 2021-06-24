package com.spcn.spcemulator.service;

import com.spcn.spcemulator.dto.SpcRegistrationDataDto;
import com.spcn.spcemulator.dto.SpcRegistrationResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpcRegistrationService {

    private String spcSerialNumber;
    private String spcIp;
    private String spcApiUrl;

    private String getUri(String ip){
        return "http://" + ip;
    }

    private String getUri(String ip, String method){
        return "http://" + ip + "/" + method;
    }

    public SpcRegistrationResponseDto registerSpc(){
        SpcRegistrationDataDto spcRegistrationData = new SpcRegistrationDataDto(spcSerialNumber, spcIp);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<SpcRegistrationResponseDto> response = restTemplate.postForEntity(getUri(spcApiUrl, "register"), spcRegistrationData, SpcRegistrationResponseDto.class);
        return response.getBody();
    }
}
