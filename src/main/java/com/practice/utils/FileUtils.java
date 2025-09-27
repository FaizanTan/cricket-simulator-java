package com.practice.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.menus.MenuItem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> T readFile(String filePath, Class<T> clazz) throws IOException {

        if (filePath == null || filePath.isBlank()) {
            System.out.println("filePath cannot be null or blank");
            return null;
        }

        if (clazz == null) {
            System.out.println("clazz cannot be null");
            return null;
        }

        File file = new File(filePath);

        if (!file.exists() || !file.isFile()) {
            System.out.println("File does not exist or is not a file: " + filePath);
            return null;
        }

        if (Files.size(file.toPath()) == 0) {
            System.out.println("File is empty: " + filePath);
            return null;
        }

        return mapper.readValue(file, clazz);
    }

}
