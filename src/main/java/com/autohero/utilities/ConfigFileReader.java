package com.autohero.utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath= "src/main/resources/config.properties";


    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }


    public String getBaseURL()
    {
        String url = properties.getProperty("baseurl");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the config.properties file.");
    }

    public String getSearchURL()
    {
        String url = properties.getProperty("searchUrl");
        if(url != null) return url;
        else throw new RuntimeException("searchurl not specified in the config.properties file.");
    }

    public String getBrowser()
    {
        String url = properties.getProperty("browser");
        if(url != null) return url;
        else throw new RuntimeException("browser not specified in the config.properties file.");
    }
}
