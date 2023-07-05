package com.lynxted.sample.domain.washeable;

import java.math.BigDecimal;

public interface WasheableElement {

    BigDecimal getWeight();

    void wash(int speed, int temperature);
}
