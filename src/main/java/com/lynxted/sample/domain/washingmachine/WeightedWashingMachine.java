package com.lynxted.sample.domain.washingmachine;

import com.lynxted.sample.domain.washeable.WasheableElement;
import com.lynxted.sample.domain.washingprogram.WashingProgram;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
@Getter
public class WeightedWashingMachine<W extends WasheableElement> implements WashingMachine<W> {

    private final BigDecimal maxWeight;

    private final Collection<W> laundry = new ArrayList<>();

    @Setter
    private WashingProgram washingProgram;

    @Override
    public boolean tryAddLaundry(W laundryElement) {
        if (canFit(laundryElement)) {
            laundry.add(laundryElement);
            return true;
        }
        return false;
    }

    @Override
    public boolean canFit(W laundryElement) {
        return currentWeight().add(laundryElement.getWeight()).compareTo(maxWeight) <= 0;
    }

    public BigDecimal currentWeight() {
        return laundry.stream().map(WasheableElement::getWeight).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void clear() {
        laundry.clear();
    }

    @Override
    public void wash() {
        laundry.forEach(washeable -> washeable.wash(
                washingProgram.getSpeed(),
                washingProgram.getTemperature()));
    }
}
