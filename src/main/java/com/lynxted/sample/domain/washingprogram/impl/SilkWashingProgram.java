package com.lynxted.sample.domain.washingprogram.impl;

import com.lynxted.sample.domain.washingprogram.AbstractWashingProgram;
import com.lynxted.sample.domain.washingprogram.WashingProgramDefinition;

public class SilkWashingProgram extends AbstractWashingProgram {

    public SilkWashingProgram(int speed, int temperature) {
        super(speed, temperature);
    }

    @Override
    public WashingProgramDefinition getDefinition() {
        return WashingProgramDefinition.SILK;
    }
}
