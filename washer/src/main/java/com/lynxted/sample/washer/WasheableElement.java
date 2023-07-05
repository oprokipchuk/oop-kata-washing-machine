package com.lynxted.sample.washer;

import java.math.BigDecimal;

public interface WasheableElement {

    BigDecimal getWeight();

    void wash(int speed, int temperature);
}
