package pl.javastart.task;

import java.math.BigDecimal;

public class Product {
    private final String name;
    private final BigDecimal price;
    private final String currency;

    public Product(String name, BigDecimal price, String currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Nazwa produktu: " + name + ", cena: " + price + ", waluta: " + currency;
    }
}