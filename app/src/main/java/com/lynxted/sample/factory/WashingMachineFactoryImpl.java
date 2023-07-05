package com.lynxted.sample.factory;

import com.lynxted.sample.washer.WasheableElement;
import com.lynxted.sample.washer.WashingMachine;
import com.lynxted.sample.washer.WeightedWashingMachine;

import java.math.BigDecimal;

public class WashingMachineFactoryImpl implements WashingMachineFactory {

    public static final BigDecimal DEFAULT_WASHING_MACHINE_MAX_WEIGHT = BigDecimal.valueOf(7);

    @Override
    public <W extends WasheableElement> WashingMachine<W> defaultWashingMachine() {
        return new WeightedWashingMachine<>(DEFAULT_WASHING_MACHINE_MAX_WEIGHT);
    }
}
