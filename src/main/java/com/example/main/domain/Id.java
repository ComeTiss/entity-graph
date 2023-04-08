package com.example.main.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Id {
    private final UUID value;

    public Id() {
        this.value = UUID.randomUUID();
    }
}
