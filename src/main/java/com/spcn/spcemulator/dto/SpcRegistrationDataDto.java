package com.spcn.spcemulator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SpcRegistrationDataDto {
    private String spcSerialNumber;
    private String spcIp;

}
