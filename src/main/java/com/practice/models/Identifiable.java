package com.practice.models;

import lombok.Getter;
import com.practice.utils.identity.IdGenerator;

@Getter
abstract public class Identifiable {
    private final Long id;

    protected Identifiable() {
        String context = this.getClass().getSimpleName();
        this.id = IdGenerator.generateIdFor(context);
    }
}
