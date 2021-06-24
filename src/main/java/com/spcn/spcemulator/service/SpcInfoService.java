package com.spcn.spcemulator.service;

import com.spcn.spcemulator.service.utils.SpcInfoWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SpcInfoService {

    private static final Logger log = LoggerFactory.getLogger(SpcInfoService.class);

    private enum CoverPosition{
        OPENED,
        CLOSED
    }

    private CoverPosition currentCoverPosition = CoverPosition.CLOSED;

    public void writeOpening(){
        if (currentCoverPosition.equals(CoverPosition.CLOSED)){
            currentCoverPosition = CoverPosition.OPENED;
            SpcInfoWriter.writeOpening();
            log.info("Вы открыли крышку");
            log.info("Текущий счет: " + SpcInfoWriter.getInfo());
        }
        else log.info("Крышка уже открыта");
    }

    public void writeClosing(){
        if (currentCoverPosition.equals(CoverPosition.OPENED)){
            currentCoverPosition = CoverPosition.CLOSED;
            SpcInfoWriter.writeClosing();
            log.info("Вы закрыли крышку");
            log.info("Текущий счет: " + SpcInfoWriter.getInfo());
        }
        else log.info("Крышка ещё не открыта");
    }
}
