package com.lynxted.sample;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LaundryPackUtils {

    public static Collection<LaundryElement> defaultLaundryPack() {
        LaundryElement wool1 = new LaundryElement(Fabric.WOOL, "red", BigDecimal.valueOf(2), true);
        LaundryElement wool2 = new LaundryElement(Fabric.WOOL, "red", BigDecimal.valueOf(3), true);
        LaundryElement wool3 = new LaundryElement(Fabric.WOOL, "red", BigDecimal.valueOf(4), true);

        LaundryElement cotton1 = new LaundryElement(Fabric.COTTON, "red", BigDecimal.valueOf(2), true);
        LaundryElement cotton2 = new LaundryElement(Fabric.COTTON, "red", BigDecimal.valueOf(2), true);

        LaundryElement silk1 = new LaundryElement(Fabric.SILK, "red", BigDecimal.valueOf(2), true);
        return Arrays.asList(wool1, wool2, cotton1, silk1, cotton2, wool3);
    }

    public static Collection<LaundryElement> ofFabricAndWeight(
            Collection<LaundryElement> laundry, Fabric fabricType, BigDecimal maxWeight) {
        return ofWeight(ofFabric(laundry,fabricType), maxWeight);
    }

    public static Collection<LaundryElement> ofFabric(Collection<LaundryElement> laundry, Fabric fabricType) {
        return laundry.stream()
                .filter(laundryElement -> fabricType.equals(laundryElement.getType()))
                .collect(Collectors.toList());
    }

    public static Collection<LaundryElement> ofWeight(Collection<LaundryElement> laundry, BigDecimal maxWeight) {
        List<LaundryElement> result = new ArrayList<>();
        BigDecimal currentWeight = BigDecimal.ZERO;
        for (LaundryElement laundryElement : laundry) {
            if (currentWeight.add(laundryElement.getWeight()).compareTo(maxWeight) < 0) {
                result.add(laundryElement);
                currentWeight = currentWeight.add(laundryElement.getWeight());
            }
        }
        return result;
    }

    public static BigDecimal weightOf(Collection<LaundryElement> laundry) {
        BigDecimal weight = BigDecimal.ZERO;
        for (LaundryElement laundryElement : laundry) {
            weight = weight.add(laundryElement.getWeight());
        }
        return weight;
    }

    public static boolean isWashed(Collection<LaundryElement> laundry) {
        return laundry.stream()
                .noneMatch(LaundryElement::getDirty);
    }


}
