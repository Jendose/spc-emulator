package com.spcn.spcemulator.dto;

public class SpcRegistrationResponseDto {
    private boolean spcRegistratedSuccessfully;

    public SpcRegistrationResponseDto(boolean spcRegistratedSuccessfully) {
        this.spcRegistratedSuccessfully = spcRegistratedSuccessfully;
    }

    public boolean isSpcRegistratedSuccessfully() {
        return spcRegistratedSuccessfully;
    }

    public void setSpcRegistratedSuccessfully(boolean spcRegistratedSuccessfully) {
        this.spcRegistratedSuccessfully = spcRegistratedSuccessfully;
    }
}
