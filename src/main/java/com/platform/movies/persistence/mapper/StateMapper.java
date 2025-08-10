package com.platform.movies.persistence.mapper;

import org.mapstruct.Named;

public class StateMapper {

    @Named("stringToBoolean")
    public static boolean stringToBoolean(String state) {
        return "D".equalsIgnoreCase(state);
    }

    @Named("booleanToString")
    public static String booleanToString(boolean value) {
        return value ? "D" : "N";
    }
}
