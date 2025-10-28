package com.practice.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.practice.interfaces.DataLoader;
import lombok.Getter;

import java.io.IOException;
import java.util.Map;

@Getter
public class FileDataLoader<T> implements DataLoader<T> {
    private String filePath;
    private T data;

    public FileDataLoader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void loadData(TypeReference<T> typeRef) throws IOException {
        data = FileUtils.readAndMapFileDataFromTo(filePath, typeRef);
    }
}

