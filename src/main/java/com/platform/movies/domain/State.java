package com.platform.movies.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum State {

    ACTIVE(true), INACTIVE(false);

    private final boolean value;

    public static State fromBoolean(boolean value) {
        return value ? ACTIVE : INACTIVE;
    }

}
