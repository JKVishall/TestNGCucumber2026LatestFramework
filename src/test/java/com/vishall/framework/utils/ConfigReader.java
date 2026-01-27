package com.vishall.framework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static{
        try{
            //FileInputStream input = new FileInputStream("src/test/resources/config.properties");
            //instead of hard coding the config.properties file path, we use classLoaded to get the file itself
            InputStream input = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");
            prop = new Properties();
            prop.load(input);
            //input.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }

    public static String getProp(String key) {

        //if data sent via CLI override (-D)
        String sysValue = System.getProperty(key);
        if (sysValue != null && !sysValue.isBlank()) {
            return sysValue;
        }

        //if data needed from config.properties
        String propertiesFileValue = prop.getProperty(key);
        if (propertiesFileValue != null && !propertiesFileValue.isBlank()) {
            return propertiesFileValue;
        }

        //framework hardcoded default
        return getDefaultValue(key);
    }

    private static String getDefaultValue(String key){
        return switch(key){
            case "browser" -> "chrome";
            case "headless" -> "false";
            case "env" -> "local";
            case "url" ->"https://www.amazon.in";
            default -> null;
        };
    }

}
