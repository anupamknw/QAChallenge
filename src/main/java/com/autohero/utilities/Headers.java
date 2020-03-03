package com.autohero.utilities;

import java.util.HashMap;
import java.util.Map;

public class Headers {

    public static Map<String, String> getHeaders()
    {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("authority", "www.autohero.com");
        headerMap.put("accept", "application/json, text/plain, */*");
        headerMap.put("sec-fetch-dest", "empty");
        headerMap.put("content-type", "application/json");
        headerMap.put("origin", "https://www.autohero.com");
        headerMap.put("sec-fetch-site", "same-origin");
        headerMap.put("sec-fetch-mode", "cors");
        headerMap.put("referer", "https://www.autohero.com/de/search/");
        headerMap.put("accept-language", "en-GB,en-US;q=0.9,en;q=0.8");
        headerMap.put("cookie", "sl=de-DE; userHash=ae2952bd86984da7273687932ab7e71b; classifiedLastEvent=1582554716; scid=8e2c62e3cca1de573fb370cd8f84dc9d; irp=true; lsat=[\"metallic\",\"color-Schwarz\",\"opel\",\"insignia\",\"2.0\",\"sidi\",\"turbo\",\"sport\",\"door-5\"]");

        return headerMap;
    }
}

