package com.lynxted.sample;

import com.lynxted.sample.domain.washeable.WasheableElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.MessageFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaundryElement implements WasheableElement {

    private Fabric type;

    private String color;

    private BigDecimal weight;

    private Boolean dirty;

    @Override
    public void wash(int speed, int temperature) {
        System.out.println(MessageFormat.format("Washing laundry element at speed: [{0}] and temperature [{1}]",
                speed, temperature));
        dirty = false;
    }
}
