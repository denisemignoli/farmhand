package com.farmhand.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HorseTest {

    private Horse horse;

    @BeforeEach
    void setUp() {
        LocalDate birthDate = LocalDate.now().minusYears(5);
        this.horse = new Horse("Spirit", birthDate, 550.0, "Palomino");
    }

    @Test
    @DisplayName("Constructor should set all properties correctly")
    void constructor_ShouldSetAllProperties() {
        assertNotNull(horse.getId());
        assertEquals("Spirit", horse.getName());
        assertEquals(5, horse.getAge());
        assertEquals(550.0, horse.getWeight());
        assertEquals("Palomino", horse.getCoatColor());
    }

    @Test
    @DisplayName("Constructor should throw exception for null name")
    void constructor_WhenNameIsNull_ShouldThrowException() {
        Class<IllegalArgumentException> expectedExceptionType = IllegalArgumentException.class;

        assertThrows(expectedExceptionType, () -> {
            new Horse(null, LocalDate.now(), 500.0, "Black");
        });
    }

    @Test
    @DisplayName("makeSound should return 'iiirrrrí!'")
    void makeSoundShouldReturnIiirrrrí() {
        String actual = horse.makeSound();
        String expected = "iiirrrrí";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("getCoatColor should return the correct color")
    void getCoatColorShouldReturnCoatColor() {
        String actual = horse.getCoatColor();
        String expected = "Palomino";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("setWeight should update weight")
    void setWeightShouldUpdateWeight() {
        double newWeight = 555.5;

        horse.setWeight(newWeight);
        double expected = 555.5;

        assertEquals(expected, horse.getWeight());
    }

    @Test
    @DisplayName("setWeight should throw exception for zero or negative weight")
    void setWeightShouldThrowExceptionForZeroOrNonPositiveWeight() {
        double invalidWeight = 0.0;
        Class<IllegalArgumentException> expectedExceptionType = IllegalArgumentException.class;

        assertThrows(expectedExceptionType, () -> {
            horse.setWeight(invalidWeight);
        });
    }
}
