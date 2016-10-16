package com.waheed.fantasy_premier_league_api;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestHelper {
    public static String loadJsonFile(String name) {
        File f = new File(name);
        if (f.exists()){
            try {
                InputStream is = new FileInputStream(name);
                return IOUtils.toString(is, "UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "{}";
    }
}
