package com.spcn.spcemulator.service.utils;


public class SpcInfoWriter {

    private static Integer info = 0;

    public static Integer getInfo() {
        return info;
    }

    public static void setInfo(Integer info) {
        SpcInfoWriter.info = info;
    }

    public static void writeOpening(){
        info++;
    }

    public static void writeClosing(){
        info++;
    }

}
