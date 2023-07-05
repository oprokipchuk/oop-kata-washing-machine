package com.lynxted.sample;

import com.lynxted.sample.domain.washingmachine.WashingMachine;
import com.lynxted.sample.domain.washingmachine.WashingMachineFactory;
import com.lynxted.sample.domain.washingprogram.WashingProgramFactory;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class WashingService {

    private final WashingMachineFactory washingMachineFactory;

    private final WashingProgramFactory washingProgramFactory;

    public Collection<LaundryElement> washFabric(Collection<LaundryElement> laundry, Integer spinSpeed, Integer temperature, Fabric fabricType) {
        List<LaundryElement> filteredLaundry = filterLaundryElements(laundry, fabricType);

        WashingMachine<LaundryElement> washingMachine = washingMachineFactory.defaultWashingMachine();
        loadWashingMachine(washingMachine, filteredLaundry);

        washingMachine.setWashingProgram(washingProgramFactory.programForFabricType(fabricType, spinSpeed, temperature));
        washingMachine.wash();

        return washingMachine.getLaundry();
    }

    private List<LaundryElement> filterLaundryElements(Collection<LaundryElement> laundry, Fabric fabricType) {
        return laundry.stream()
                .filter(laundryElement -> laundryElement.getType().equals(fabricType))
                .collect(Collectors.toList());
    }

    private void loadWashingMachine(WashingMachine<LaundryElement> washingMachine, Collection<LaundryElement> laundry) {
        laundry.forEach(washingMachine::tryAddLaundry);
    }
}
