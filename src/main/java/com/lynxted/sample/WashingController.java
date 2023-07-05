package com.lynxted.sample;

import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
public class WashingController {

    private final WashingService washingService;

    public Collection<LaundryElement> wash(Fabric fabricType, Collection<LaundryElement> laundry, Integer spinSpeed, Integer temperature) {
        if (fabricType != null) {
            return washingService.washFabric(laundry, spinSpeed, temperature, fabricType);
        }
        return Collections.emptyList();
    }
}
