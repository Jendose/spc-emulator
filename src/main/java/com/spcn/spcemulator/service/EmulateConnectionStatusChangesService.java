package com.spcn.spcemulator.service;

import com.spcn.spcemulator.service.utility.PropertiesReloader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmulateConnectionStatusChangesService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private boolean connected;

    private PropertiesReloader propertiesReloader;

    @Autowired
    public EmulateConnectionStatusChangesService(PropertiesReloader propertiesReloader) {
        this.propertiesReloader = propertiesReloader;
        checkPortProperty();
    }

    private void checkPortProperty(){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (lines != null) {
            for(String line : lines) {
                if(line.contains("server.port")){
                    if(line.equals("server.port=8081")){
                        connected = true;
                    }
                    else if(line.equals("server.port=-1")) {
                        connected = false;
                    }
                    else log.info("Wrong port specified");
                }
            }
        }
    }

    private void setPortProperty(String port){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (lines != null) {
            for(String line : lines) {
                if(line.contains("server.port")){
                    line = "server.port=" + port;
                }
            }
            try {
                Files.write(Paths.get("resources/application.properties"), lines);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loseConnection(){
        checkPortProperty();
        if(!connected){
            log.info("Spc is already disconnected");
        }
        else {
            setPortProperty("-1");
            propertiesReloader.reload();
        }
    }

    public void startConnection(){
        checkPortProperty();
        if(connected){
            log.info("Spc is already connected");
        }
        else {
            setPortProperty("8081");
            propertiesReloader.reload();
        }
    }

    public boolean isConnected() {
        checkPortProperty();
        return connected;
    }
}
