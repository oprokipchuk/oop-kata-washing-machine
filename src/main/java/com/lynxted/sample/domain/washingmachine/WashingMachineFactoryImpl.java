package com.lynxted.sample.domain.washingmachine;

import com.lynxted.sample.domain.washeable.WasheableElement;

import java.math.BigDecimal;

public class WashingMachineFactoryImpl implements WashingMachineFactory {

    public static final BigDecimal DEFAULT_WASHING_MACHINE_MAX_WEIGHT = BigDecimal.valueOf(7);

    @Override
    public <W extends WasheableElement> WashingMachine<W> defaultWashingMachine() {
        return new WeightedWashingMachine<>(DEFAULT_WASHING_MACHINE_MAX_WEIGHT);
    }
}
