package com.lynxted.sample.domain.washingprogram;

import com.lynxted.sample.Fabric;
import com.lynxted.sample.domain.washingprogram.impl.CottonWashingProgram;
import com.lynxted.sample.domain.washingprogram.impl.SilkWashingProgram;
import com.lynxted.sample.domain.washingprogram.impl.WoolWashingProgram;

import java.util.Objects;

public class WashingProgramFactoryImpl implements WashingProgramFactory {

    @Override
    public WashingProgram programForFabricType(Fabric fabricType, int speed, int temperature) {
        Objects.requireNonNull(fabricType);
        switch (fabricType) {
            case WOOL:
                return new WoolWashingProgram(speed, temperature);
            case COTTON:
                return new CottonWashingProgram(speed, temperature);
            case SILK:
                return new SilkWashingProgram(speed, temperature);
        }
        return null;
    }
}
