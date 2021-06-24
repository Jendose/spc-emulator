package com.spcn.spcemulator.service;

import org.springframework.stereotype.Service;

@Service
public class SpcConnectionTestService {

    public Boolean testConnection(){
        // Включение зеленого сигнала
        System.out.println("\nЗЕЛЕНЫЙ СИГНАЛ ВКЛЮЧЕН – дозатор A активен");
        return true;
    }

}
