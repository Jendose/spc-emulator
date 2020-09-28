package com.spcn.spcemulator.dto;

public class SpcAlarmDto {
    private boolean alarmStartedSuccessfully;

    public SpcAlarmDto(boolean alarmStartedSuccessfully) {
        this.alarmStartedSuccessfully = alarmStartedSuccessfully;
    }

    public boolean isAlarmStartedSuccessfully() {
        return alarmStartedSuccessfully;
    }

    public void setAlarmStartedSuccessfully(boolean alarmStartedSuccessfully) {
        this.alarmStartedSuccessfully = alarmStartedSuccessfully;
    }
}