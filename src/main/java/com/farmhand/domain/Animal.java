package com.farmhand.domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public abstract class Animal {
    private final String id;
    private final String name;
    private final LocalDate birthDate;
    private double weight;

    public Animal(String name, LocalDate birthDate, double weight) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public abstract String makeSound();

    public int getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 0) {
            throw new IllegalArgumentException("O peso deve ser positivo!");
        }
        this.weight = weight;
    }
}
