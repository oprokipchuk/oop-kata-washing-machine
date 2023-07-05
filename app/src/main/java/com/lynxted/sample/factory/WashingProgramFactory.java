package com.lynxted.sample.factory;

import com.lynxted.sample.Fabric;
import com.lynxted.sample.washer.WashingProgram;

public interface WashingProgramFactory {

    WashingProgram programForFabricType(Fabric fabricType, int speed, int temperature);
}
