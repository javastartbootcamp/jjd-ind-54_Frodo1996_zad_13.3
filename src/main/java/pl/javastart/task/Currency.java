package pl.javastart.task;

import java.math.BigDecimal;

public record Currency(String name, BigDecimal value) {

    @Override
    public String toString() {
        return "Nazwa waluty: " + name + ", wartość w stosunku do 1 euro: " + value;
    }
}