package pl.javastart.task;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

public class FileCalculation {

    static BigDecimal sumProductsPrice(List<Currency> currencies, List<Product> products) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Product product : products) {
            Currency currency = getCurrency(currencies, product);
            BigDecimal euroPrice = calculatePriceToEuro(product, Objects.requireNonNull(currency));
            sum = sum.add(euroPrice);
        }
        return sum;
    }

    static BigDecimal averageValueOfAllProductsInEuro(List<Currency> currencies, List<Product> products) {
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal numberOfProducts = new BigDecimal(products.size());
        for (Product product : products) {
            Currency currency = getCurrency(currencies, product);
            BigDecimal euroPrice = calculatePriceToEuro(product, Objects.requireNonNull(currency));
            sum = sum.add(euroPrice);
        }
        return sum.divide(numberOfProducts, RoundingMode.DOWN);
    }

    public static BigDecimal theMostExpensiveProductInEuro(List<Product> products, List<Currency> currencies) {
        BigDecimal highestValue = BigDecimal.valueOf(0);
        for (Product product : products) {
            Currency currency = getCurrency(currencies, product);
            BigDecimal euroPrice = calculatePriceToEuro(product, Objects.requireNonNull(currency));
            if (euroPrice.compareTo(highestValue) > 0) {
                highestValue = euroPrice;
            }
        }
        return highestValue;
    }

    public static BigDecimal theCheapestProductInEuro(List<Product> products, List<Currency> currencies) {
        BigDecimal cheapestProduct = firstProductValueCalculatedToEuro(currencies, products);
        for (Product product : products) {
            Currency currency = getCurrency(currencies, product);
            BigDecimal euroPrice = calculatePriceToEuro(product, Objects.requireNonNull(currency));
            if (euroPrice.compareTo(cheapestProduct) < 0) {
                cheapestProduct = euroPrice;
            }
        }
        return cheapestProduct;
    }

    private static BigDecimal firstProductValueCalculatedToEuro(List<Currency> currencies, List<Product> products) {
        String firstProduct = products.get(0).getCurrency();
        for (Currency currency : currencies) {
            if (currency.getName().equals(firstProduct)) {
                return products.get(0).getPrice().divide(currency.getValue(), RoundingMode.DOWN);
            }
        }
        return null;
    }

    private static Currency getCurrency(List<Currency> currencies, Product product) {
        String currencyName = product.getCurrency();
        for (Currency currency : currencies) {
            if (currency.getName().equals(currencyName)) {
                return currency;
            }
        }
        return null;
    }

    private static BigDecimal calculatePriceToEuro(Product product, Currency currency) {
        return product.getPrice().divide(currency.getValue(), RoundingMode.DOWN);
    }
}