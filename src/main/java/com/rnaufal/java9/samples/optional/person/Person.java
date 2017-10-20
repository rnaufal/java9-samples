package com.rnaufal.java9.samples.optional.person;

import com.rnaufal.java9.samples.optional.car.Car;

import java.util.Collection;
import java.util.Optional;

/**
 * Created by rnaufal on 19/10/2017.
 */
public class Person {

    private final String name;

    private final Collection<Car> cars;

    private Person(final String name,
                   final Collection<Car> cars) {
        this.name = name;
        this.cars = cars;
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public String getName() {
        return name;
    }

    public Optional<Collection<Car>> getCars() {
        return Optional.ofNullable(cars);
    }

    public static class PersonBuilder {

        private String name;

        private Collection<Car> cars;

        public PersonBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder withCars(Collection<Car> cars) {
            this.cars = cars;
            return this;
        }

        public Person build() {
            return new Person(this.name, this.cars);
        }
    }
}
