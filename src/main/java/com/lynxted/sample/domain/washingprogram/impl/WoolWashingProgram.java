package com.lynxted.sample.domain.washingprogram.impl;

import com.lynxted.sample.domain.washingprogram.AbstractWashingProgram;
import com.lynxted.sample.domain.washingprogram.WashingProgramDefinition;

public class WoolWashingProgram extends AbstractWashingProgram {

    public WoolWashingProgram(int speed, int temperature) {
        super(speed, temperature);
    }

    @Override
    public WashingProgramDefinition getDefinition() {
        return WashingProgramDefinition.WOOL;
    }
}
