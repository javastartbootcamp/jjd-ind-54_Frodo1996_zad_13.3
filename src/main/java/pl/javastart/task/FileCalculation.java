package pl.javastart.task;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class FileCalculation {

    static BigDecimal sumProductsPriceInEuro(List<Currency> currencies, List<Product> products) {
        BigDecimal sum = BigDecimal.valueOf(0);
        if (products.size() > 0 && currencies.size() > 0) {
            sum = sumProductsPrice(currencies, products, sum);
        }
        return sum;
    }

    static BigDecimal averageValueOfAllProducts(BigDecimal costOfAllProductsInEuro, List<Product> products) {
        BigDecimal numberOfProducts = new BigDecimal(products.size());
        BigDecimal averageValue = BigDecimal.valueOf(0);
        if (products.size() > 0) {
            averageValue = costOfAllProductsInEuro.divide(numberOfProducts, RoundingMode.DOWN);
        }
        return averageValue;
    }

    public static BigDecimal theMostExpensiveProductInEuro(List<Product> products, List<Currency> currencies) {
        BigDecimal highestValue = BigDecimal.valueOf(0);
        if (products.size() > 0 && currencies.size() > 0) {
            highestValue = findHighestValueInEuro(products, currencies, highestValue);
        }
        return highestValue;
    }

    public static BigDecimal theCheapestProductInEuro(List<Product> products, List<Currency> currencies) {
        BigDecimal lowestPrice = products.get(0).getPrice().divide(currencies.get(18).value(), RoundingMode.DOWN);
        if (products.size() > 0) {
            lowestPrice = findLowestPriceInEuro(products, currencies, lowestPrice);
        }
        return lowestPrice;
    }

    private static BigDecimal sumProductsPrice(List<Currency> currencies, List<Product> products, BigDecimal sum) {
        for (Product product : products) {
            for (Currency currency : currencies) {
                BigDecimal productPrice = product.getPrice();
                if (product.getCurrency().equals(currency.name())) {
                    BigDecimal costInEuro = productPrice.divide(currency.value(), RoundingMode.DOWN);
                    sum = sum.add(costInEuro);
                }
            }
        }
        return sum;
    }

    private static BigDecimal findLowestPriceInEuro(List<Product> products, List<Currency> currencies, BigDecimal lowestPriceInEuro) {
        for (Product product : products) {
            for (Currency currency : currencies) {
                BigDecimal priceOfProductInEuro = product.getPrice().divide(currency.value(), RoundingMode.DOWN);
                if (currency.name().equals(product.getCurrency()) &&
                        priceOfProductInEuro.compareTo(lowestPriceInEuro) < 0) {
                    lowestPriceInEuro = priceOfProductInEuro;
                }
            }
        }
        return lowestPriceInEuro;
    }

    private static BigDecimal findHighestValueInEuro(List<Product> products, List<Currency> currencies, BigDecimal highestValue) {
        for (Product product : products) {
            for (Currency currency : currencies) {
                BigDecimal priceOfProductInEuro = product.getPrice().divide(currency.value(), RoundingMode.DOWN);
                if (currency.name().equals(product.getCurrency()) && priceOfProductInEuro.compareTo(highestValue) > 0) {
                    highestValue = priceOfProductInEuro;
                }
            }
        }
        return highestValue;
    }
}