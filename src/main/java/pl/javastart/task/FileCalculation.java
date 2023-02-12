package pl.javastart.task;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class FileCalculation {

    static BigDecimal sumProductsPriceInEuro(List<Currency> currencies, List<Product> products) {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Product product : products) {
            BigDecimal productPrice = product.getPrice();
            for (Currency currency : currencies) {
                if (product.getCurrency().equals(currency.name())) {
                    BigDecimal costInEuro = productPrice.divide(currency.value(), RoundingMode.DOWN);
                    sum = sum.add(costInEuro);
                }
            }
        }
        return sum;
    }

    static BigDecimal averageValueOfAllProducts(BigDecimal costOfAllProductsInEuro, List<Product> products) {
        BigDecimal numberOfProducts = new BigDecimal(products.size());
        return costOfAllProductsInEuro.divide(numberOfProducts, RoundingMode.DOWN);
    }

    public static BigDecimal theMostExpensiveProductInEuro(List<Product> products, List<Currency> currencies) {
        BigDecimal highestValue = BigDecimal.valueOf(0);
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

    public static BigDecimal theCheapestProductInEuro(List<Product> products, List<Currency> currencies) {
        BigDecimal lowestPriceInEuro = products.get(0).getPrice().divide(currencies.get(18).value(), RoundingMode.DOWN);
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
}
