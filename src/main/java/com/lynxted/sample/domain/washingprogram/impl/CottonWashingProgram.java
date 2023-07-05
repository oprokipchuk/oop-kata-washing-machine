package com.lynxted.sample.domain.washingprogram.impl;

import com.lynxted.sample.domain.washingprogram.AbstractWashingProgram;
import com.lynxted.sample.domain.washingprogram.WashingProgramDefinition;

public class CottonWashingProgram extends AbstractWashingProgram {

    public CottonWashingProgram(int speed, int temperature) {
        super(speed, temperature);
    }

    @Override
    public WashingProgramDefinition getDefinition() {
        return WashingProgramDefinition.COTTON;
    }
}
