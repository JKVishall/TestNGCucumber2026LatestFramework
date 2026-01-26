package com.vishall.framework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static{
        try{
            FileInputStream input = new FileInputStream("src/test/resources/config.properties");
            prop = new Properties();
            prop.load(input);
            input.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }

    public static String getProp(String key){
        return prop.getProperty(key);
    }

}
