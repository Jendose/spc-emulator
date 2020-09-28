package com.spcn.spcemulator.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class SpcInfoDto {
    private Map<LocalDateTime, Boolean> info;

    public SpcInfoDto(Map<LocalDateTime, Boolean> info) {
        this.info = info;
    }

    public Map<LocalDateTime, Boolean> getInfo() {
        return info;
    }

    public void setInfo(Map<LocalDateTime, Boolean> info) {
        this.info = info;
    }
}
