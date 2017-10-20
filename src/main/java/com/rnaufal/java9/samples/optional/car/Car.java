package com.rnaufal.java9.samples.optional.car;

/**
 * Created by rnaufal on 19/10/2017.
 */
public class Car {

    private final String model;

    public Car(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Car{model='" + model + "'}";
    }
}
