package com.lynxted.sample.washingprogram;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum WashingProgramDefinition {

    WOOL(100,400,0,40),
    COTTON(0,1200,30,95),
    SILK(0,300,0,30);

    private final int minSpeed;
    private final int maxSpeed;
    private final int minTemperature;
    private final int maxTemperature;
}
