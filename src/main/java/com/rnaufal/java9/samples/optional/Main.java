package com.rnaufal.java9.samples.optional;

import com.rnaufal.java9.samples.optional.car.Car;
import com.rnaufal.java9.samples.optional.person.People;
import com.rnaufal.java9.samples.optional.person.Person;

import java.util.List;

/**
 * Created by rnaufal on 19/10/2017.
 */
public class Main {

    public static void main(String[] args) {
        final Person mark = Person
                .builder()
                .withName("Mark")
                .build();

        final Person john = Person
                .builder()
                .withName("John")
                .withCars(List.of(new Car("Corvette")))
                .build();

        final Person paul = Person
                .builder()
                .withName("Paul")
                .withCars(List.of(new Car("Cadillac"), new Car("Mustang")))
                .build();

        final People people = new People();
        people.addAll(List.of(mark, john, paul));

        System.out.println(people.findCarsBy(person -> "Mark".equals(person.getName())));
        System.out.println(people.findCarsBy(person -> "Paul".equals(person.getName())));
        System.out.println(people.findAllCars());
    }
}
