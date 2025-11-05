package com.farmhand.domain;

import java.time.LocalDate;

public class Horse extends Animal {
    private String coatColor;

    public Horse(String name, LocalDate birthDate, double weight, String coatColor) {
        super(name, birthDate, weight);
        this.coatColor = coatColor;
    }

    @Override
    public String makeSound() {
        return "iiirrrrí";
    }

    public void run() {
        System.out.println(this.getName() + " está correndo...");
    }

    public String getCoatColor() {
        return coatColor;
    }
}
