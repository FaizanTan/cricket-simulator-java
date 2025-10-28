package com.practice.interfaces;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;

public interface DataLoader<T> {
    void loadData(TypeReference<T> typeRef) throws IOException;
}
