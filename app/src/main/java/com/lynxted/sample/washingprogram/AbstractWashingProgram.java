package com.lynxted.sample.washingprogram;

import com.lynxted.sample.washer.WashingProgram;
import lombok.Getter;

@Getter
public abstract class AbstractWashingProgram implements WashingProgram {

    private final int speed;

    private final int temperature;

    public AbstractWashingProgram(int speed, int temperature) {
        this.speed = calculateFittingSpeed(speed);
        this.temperature = calculateFittingTemperature(temperature);
    }

    private int calculateFittingSpeed(int speed) {
        if (isValueBetween(speed, getMinSpeed(), getMaxSpeed())) {
            return speed;
        } else {
            return getMaxSpeed();
        }
    }

    private boolean isValueBetween(int value, int min, int max) {
        return min <= value && value <= max;
    }

    private int calculateFittingTemperature(int temperature) {
        if (isValueBetween(temperature, getMinTemperature(), getMaxTemperature())) {
            return temperature;
        } else {
            return getMaxTemperature();
        }
    }

    public int getMinSpeed() {
        return getDefinition().getMinSpeed();
    }

    public int getMaxSpeed() {
        return getDefinition().getMaxSpeed();
    }

    public int getMinTemperature() {
        return getDefinition().getMinTemperature();
    }

    public int getMaxTemperature() {
        return getDefinition().getMaxTemperature();
    }

    public abstract WashingProgramDefinition getDefinition();
}
