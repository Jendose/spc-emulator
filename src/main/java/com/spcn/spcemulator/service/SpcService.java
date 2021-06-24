package com.spcn.spcemulator.service;

import com.spcn.spcemulator.dto.SpcInfoDto;
import com.spcn.spcemulator.service.utils.SpcInfoWriter;
import org.springframework.stereotype.Service;

@Service
public class SpcService {

    public Boolean startTake(){
        System.out.println("\nПолучен сигнал о начале приема");
        System.out.println("\nВведите 1 для открытия крышки и 0 для закрытия");
        SpcInfoWriter.setInfo(0);
        return true;
    }

    public SpcInfoDto endTake(){
        System.out.println("\nЗапрошена информация о приеме");
        Integer resInfo = SpcInfoWriter.getInfo();
        SpcInfoWriter.setInfo(0);
        return new SpcInfoDto(resInfo);
    }

}
