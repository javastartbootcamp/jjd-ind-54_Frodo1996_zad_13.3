package pl.javastart.task;

import java.math.BigDecimal;

public class Currency {
    String name;
    BigDecimal value;

    public Currency(String name, BigDecimal value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Nazwa waluty: " + name + ", wartość w stosunku do 1 euro: " + value;
    }
}