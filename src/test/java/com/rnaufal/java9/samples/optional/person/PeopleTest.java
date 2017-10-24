package com.rnaufal.java9.samples.optional.person;

import com.rnaufal.java9.samples.optional.car.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

/**
 * Created by rnaufal on 23/10/2017.
 */
public class PeopleTest {

    private People people;

    @BeforeEach
    void setUp() {
        people = new People();
        people.addAll(personProvider());
    }

    @DisplayName("Should find no cars")
    @Test
    void shouldFindNoCars() {
        final Collection<Car> markCars = people.findCarsBy(person -> "Mark".equals(person.getName()));
        assertThat(markCars, hasSize(0));
    }

    @DisplayName("Should find person cars")
    @Test
    void shouldFindPersonCars() {
        final Collection<Car> markCars = people.findCarsBy(person -> "Paul".equals(person.getName()));
        assertThat(markCars, hasSize(2));
    }

    @DisplayName("Should find all people cars")
    @Test
    void shouldFindAllPeopleCars() {
        final Collection<Car> markCars = people.findAllCars();
        assertThat(markCars, hasSize(3));
    }

    private List<Person> personProvider() {
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
        return List.of(mark, john, paul);
    }
}