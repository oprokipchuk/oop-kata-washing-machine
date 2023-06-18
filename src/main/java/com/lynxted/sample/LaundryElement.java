package com.lynxted.sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
class LaundryElement {

    private Fabric type;

    private String color;

    private BigDecimal weight;

    private Boolean dirty;
}
