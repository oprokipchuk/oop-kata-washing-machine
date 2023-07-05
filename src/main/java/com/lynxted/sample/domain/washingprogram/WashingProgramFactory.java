package com.lynxted.sample.domain.washingprogram;

import com.lynxted.sample.Fabric;

public interface WashingProgramFactory {

    WashingProgram programForFabricType(Fabric fabricType, int speed, int temperature);
}
