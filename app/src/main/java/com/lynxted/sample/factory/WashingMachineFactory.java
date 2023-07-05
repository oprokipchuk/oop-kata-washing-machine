package com.lynxted.sample.factory;

import com.lynxted.sample.washer.WasheableElement;
import com.lynxted.sample.washer.WashingMachine;

public interface WashingMachineFactory {

    <W extends WasheableElement> WashingMachine<W> defaultWashingMachine();
}
