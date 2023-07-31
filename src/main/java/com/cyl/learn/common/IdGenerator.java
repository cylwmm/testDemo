package com.cyl.learn.common;

public class IdGenerator {
    private static final SnowFlakeIdGenerator SNOW_FLAKE_ID_GENERATOR = new SnowFlakeIdGenerator();

    public static String randomId() {
        return String.valueOf(SNOW_FLAKE_ID_GENERATOR.nextId());
    }
}
