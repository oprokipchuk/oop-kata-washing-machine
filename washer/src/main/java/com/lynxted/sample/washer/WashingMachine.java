package com.lynxted.sample.washer;

import com.lynxted.sample.washer.WashingProgram;

import java.util.Collection;

public interface WashingMachine<W extends WasheableElement> {

    boolean tryAddLaundry(W laundryElement);

    boolean canFit(W laundryElement);

    void clear();

    void wash();

    Collection<W> getLaundry();

    WashingProgram getWashingProgram();

    void setWashingProgram(WashingProgram washingProgram);
}
