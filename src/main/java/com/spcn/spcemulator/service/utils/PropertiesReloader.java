package com.spcn.spcemulator.service.utils;

import lombok.Cleanup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

@Component
public class PropertiesReloader {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private StandardEnvironment environment;
    private long lastModTime = 0L;
    private PropertySource<?> appConfigPropertySource = null;
    private Path configPath;
    private static final String PROPERTY_NAME = "application.properties";

    @PostConstruct
    private void createContext() {
        MutablePropertySources propertySources = environment.getPropertySources();
        // First of all we check if application started with external file
        String property = "applicationConfig: [file:" + PROPERTY_NAME + "]";
        PropertySource<?> appConfigPsOp = propertySources.get(property);
        configPath = Paths.get(PROPERTY_NAME).toAbsolutePath();
        if (appConfigPsOp == null) {
            // If not we check properties file from resources folder
            property = "class path resource [" + PROPERTY_NAME + "]";
            configPath = Paths.get("src/main/resources/" + PROPERTY_NAME).toAbsolutePath();
        }
        appConfigPsOp = propertySources.get(property);
        appConfigPropertySource = appConfigPsOp;
    }

    // This method can be called for reloading all properties after change application.properties file
    public void reload() {
        try {
            long currentModTs = Files.getLastModifiedTime(configPath).toMillis();
            if (currentModTs > lastModTime) {
                lastModTime = currentModTs;
                Properties properties = new Properties();
                @Cleanup InputStream inputStream = Files.newInputStream(configPath);
                properties.load(inputStream);
                String property = appConfigPropertySource.getName();
                PropertiesPropertySource updatedProperty = new PropertiesPropertySource(property, properties);
                environment.getPropertySources().replace(property, updatedProperty);
                log.info("Configs {} were reloaded", property);
            }
        } catch (Exception e) {
            log.error("Can't reload config file " + e);
        }
    }

}