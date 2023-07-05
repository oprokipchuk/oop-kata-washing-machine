package com.lynxted.sample.domain.washingmachine;

import com.lynxted.sample.domain.washeable.WasheableElement;
import com.lynxted.sample.domain.washingprogram.WashingProgram;

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
