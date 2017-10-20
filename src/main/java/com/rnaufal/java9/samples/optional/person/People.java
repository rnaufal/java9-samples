package com.rnaufal.java9.samples.optional.person;

import com.rnaufal.java9.samples.optional.car.Car;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by rnaufal on 19/10/2017.
 */
public class People {

    private final Collection<Person> people = new ArrayList<>();

    public void addAll(final Collection<Person> people) {
        Objects.requireNonNull(people);
        this.people.addAll(people);
    }

    public Collection<Car> findCarsBy(final Predicate<Person> predicate) {
        return people
                .stream()
                .filter(predicate)
                .findFirst()
                .map(Person::getCars)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .orElse(Collections.emptyList());
    }

    public Collection<Car> findAllCars() {
        return people
                .stream()
                .map(Person::getCars)
                .flatMap(Optional::stream)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
