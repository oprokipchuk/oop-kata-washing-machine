package com.lynxted.sample.washingprogram.impl;

import com.lynxted.sample.washingprogram.AbstractWashingProgram;
import com.lynxted.sample.washingprogram.WashingProgramDefinition;

public class WoolWashingProgram extends AbstractWashingProgram {

    public WoolWashingProgram(int speed, int temperature) {
        super(speed, temperature);
    }

    @Override
    public WashingProgramDefinition getDefinition() {
        return WashingProgramDefinition.WOOL;
    }
}
