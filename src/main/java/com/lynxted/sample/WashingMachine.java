package com.lynxted.sample;

import lombok.Data;

import java.util.Collection;

@Data
class WashingMachine {

    private Integer temperature;
    private Integer spinSpeed;
    private Collection<LaundryElement> laundry;

    void wash() {
        laundry.forEach(laundryElement -> laundryElement.setDirty(false));
    }
}
