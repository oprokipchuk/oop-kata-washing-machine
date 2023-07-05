package com.lynxted.sample.domain.washingmachine;

import com.lynxted.sample.domain.washeable.WasheableElement;

public interface WashingMachineFactory {

    <W extends WasheableElement> WashingMachine<W> defaultWashingMachine();
}
