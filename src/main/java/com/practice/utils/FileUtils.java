package com.practice.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.menus.MenuItem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {

    private static ObjectMapper mapper = new ObjectMapper();

    public static <T> T readAndMapFileDataFromTo(String filePath, TypeReference<T> typeRef) {
        if (filePath == null || filePath.isBlank()) {
            throw new IllegalArgumentException("filePath cannot be null or blank");
        }

        Path path = Path.of(filePath);

        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            throw new IllegalArgumentException("File does not exist or is not a valid file: " + filePath);
        }

        try (InputStream in = Files.newInputStream(path)) {
            return mapper.readValue(in, typeRef);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse file: " + e.getMessage(), e);
        }
    }

    public static void writeDataToFile(Object obj, String filePath) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(Path.of(filePath).toFile(), obj);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write file: " + e.getMessage(), e);
        }
    }

}
