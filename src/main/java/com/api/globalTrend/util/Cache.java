package com.api.globalTrend.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Cache {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void save(String filename, Object data) {
        try {
            mapper.writeValue(new File(filename), data);
        } catch (IOException e) {
            System.out.println("couldn't save failed: " + e.getMessage());
        }
    }

}
