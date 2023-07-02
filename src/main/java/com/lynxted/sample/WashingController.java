package com.lynxted.sample;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import static com.lynxted.sample.Fabric.COTTON;
import static com.lynxted.sample.Fabric.SILK;

@RequiredArgsConstructor
class WashingController {

    private final WashingService washingService;

    Collection<LaundryElement> wash(Fabric fabricType) {
        Collection<LaundryElement> laundry = getAllLaundry();
        Integer spinSpeed = getRequestedSpinSpeed();
        Integer temperature = getRequestedTemperature();
        return wash(fabricType, laundry, spinSpeed, temperature);
    }

    Collection<LaundryElement> wash(Fabric fabricType, Collection<LaundryElement> laundry, Integer spinSpeed, Integer temperature) {
        WashingMachine washingMachine = new WashingMachine();
        if (fabricType == Fabric.WOOL) {
            return washingService.washWool(washingMachine, laundry, spinSpeed, temperature);
        } else if (fabricType == COTTON) {
            return washingService.washCotton(washingMachine, laundry, spinSpeed, temperature);
        } else if (fabricType == SILK) {
            return washingService.washSilk(washingMachine, laundry, spinSpeed, temperature);
        }
        return Collections.emptyList();
    }

    private Collection<LaundryElement> getAllLaundry() {
        Collection<LaundryElement> allLaundry = new ArrayList<>();
        // fill the allLaundry collection with available laundry by any way, e.g. obtaining it from repositories, providers, services
        return allLaundry;
    }

    private Integer getRequestedSpinSpeed() {
        return new Random().nextInt(1200);
    }

    private Integer getRequestedTemperature() {
        return new Random().nextInt(95);
    }
}
