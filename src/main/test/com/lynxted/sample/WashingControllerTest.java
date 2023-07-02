package com.lynxted.sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class WashingControllerTest {

    private WashingController washingController;

    private WashingService washingService;

    private WashingMachine washingMachine;

    @BeforeEach
    void setUp() {
        washingService = new WashingService();
        washingController = new WashingController(washingService);
        washingMachine = new WashingMachine();
    }

    @Test
    void washing_without_laundry_runs_correctly() {
        Collection<LaundryElement> washedLaundry = washingController.wash(
                Fabric.WOOL, new ArrayList<>(), 100, 100);

        assertThat(washedLaundry).isEmpty();
    }

    @Test
    void only_selected_fabric_laundry_is_washed() {
        Collection<LaundryElement> laundryToWash = LaundryPackUtils.defaultLaundryPack();
        Collection<LaundryElement> laundryToBeWashed = LaundryPackUtils.ofFabricAndWeight(laundryToWash, Fabric.COTTON, BigDecimal.valueOf(7));

        Collection<LaundryElement> washedLaundry = washingController.wash(Fabric.COTTON, laundryToWash, 100, 100);

        assertThat(washedLaundry).isEqualTo(laundryToBeWashed);
        assertThat(LaundryPackUtils.isWashed(washedLaundry)).isTrue();
    }

    @Test
    void only_laundry_up_to_max_weight_is_washed() {
        Collection<LaundryElement> laundryToWash = LaundryPackUtils.defaultLaundryPack();
        Collection<LaundryElement> woolLaundryToWash = LaundryPackUtils.ofFabric(laundryToWash, Fabric.WOOL);
        BigDecimal maxWeight = BigDecimal.valueOf(7);

        Collection<LaundryElement> washedLaundry = washingController.wash(Fabric.WOOL, laundryToWash, 100, 100);

        assertThat(LaundryPackUtils.weightOf(woolLaundryToWash)).isGreaterThan(maxWeight);
        assertThat(LaundryPackUtils.weightOf(washedLaundry)).isLessThan(maxWeight);
    }
}