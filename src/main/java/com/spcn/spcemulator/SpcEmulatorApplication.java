package com.spcn.spcemulator;

import com.spcn.spcemulator.service.utils.SpcInfoWriter;
import com.spcn.spcemulator.service.SpcRegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpcEmulatorApplication implements CommandLineRunner {

//    private final SpcRegistrationService spcRegistrationService;
//
//    @Autowired
//    public SpcEmulatorApplication(SpcRegistrationService spcRegistrationService) {
//        this.spcRegistrationService = spcRegistrationService;
//    }

    private static final Logger log = LoggerFactory.getLogger(SpcEmulatorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpcEmulatorApplication.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        log.info("Start SpcEmulatorApplication...");
//        boolean successfulRegistration = false;
//        while (!successfulRegistration){
//            System.out.println("Попытка запроса на добавление дозатора в базу данных");
//            SpcRegistrationResponseDto response = spcRegistrationService.registerSpc();
//            if (response.isSuccessfulRegistration()) successfulRegistration = true;
//            else Thread.sleep(60000);
//        }

//        System.out.println("Попытка запроса на добавление дозатора в базу данных");
//        spcRegistrationService.registerSpc();

        // Управление открытием и закрытием крышки через консоль
        int cur = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 0:
                    if(cur==0){
                        System.out.println("Крышка ещё не открыта");
                    }
                    else {
                        System.out.println("Вы закрыли крышку");
                        SpcInfoWriter.writeClosing();
                        cur=0;
                        System.out.println("Текущий счет: " + SpcInfoWriter.getInfo());
                    }
                    break;
                case 1:
                    if(cur==1){
                        System.out.println("Крышка уже открыта");
                    }
                    else {
                        System.out.println("Вы открыли крышку");
                        SpcInfoWriter.writeOpening();
                        cur=1;
                        System.out.println("Текущий счет: " + SpcInfoWriter.getInfo());
                    }
                    break;
                default:
            }
        }
    }
}
