package pl.javastart.task;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        printStatsAboutProductsFromList();
    }

    private static void printStatsAboutProductsFromList() {
        try {
            List<Product> products = FileUtils.readProducts();
            List<Currency> currencies = FileUtils.readCurrencies();
            System.out.println(products);
            System.out.println(currencies);
            BigDecimal costOfAllProductsInEuro = FileCalculation.sumProductsPriceInEuro(currencies, products);
            System.out.println("Suma wszystkich produktów w euro: " + costOfAllProductsInEuro + "€");
            BigDecimal averageCost = FileCalculation.averageValueOfAllProducts(costOfAllProductsInEuro, products);
            System.out.println("Średnia wartość produktu w euro: " + averageCost + "€");
            BigDecimal mostExpensiveProductInEuro = FileCalculation.theMostExpensiveProductInEuro(products, currencies);
            System.out.println("Najdroższy produkt w przeliczeniu na euro kosztuje: " + mostExpensiveProductInEuro + "€");
            BigDecimal cheapestProductInEuro = FileCalculation.theCheapestProductInEuro(products, currencies);
            System.out.println("Najtańszy produkt z listy po przeliczeniu na euro kosztuje: " + cheapestProductInEuro + "€");
        } catch (FileNotFoundException e) {
            System.err.println("Nie udało się wczytać pliku.");
        }
    }
}
