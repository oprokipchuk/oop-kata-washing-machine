package com.lynxted.sample.washingprogram.impl;

import com.lynxted.sample.washingprogram.AbstractWashingProgram;
import com.lynxted.sample.washingprogram.WashingProgramDefinition;

public class SilkWashingProgram extends AbstractWashingProgram {

    public SilkWashingProgram(int speed, int temperature) {
        super(speed, temperature);
    }

    @Override
    public WashingProgramDefinition getDefinition() {
        return WashingProgramDefinition.SILK;
    }
}
