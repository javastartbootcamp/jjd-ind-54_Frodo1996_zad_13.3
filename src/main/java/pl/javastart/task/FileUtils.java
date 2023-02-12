package pl.javastart.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    private static final String FILE_PATH_TO_CURRENCIES = "C:\\Users\\frods\\IdeaProjects" +
            "\\jjd-ind-54_Frodo1996_zad_13.3\\src\\main\\resources\\currencies.csv";
    private static final String FILE_PATH_TO_PRODUCTS = "C:\\Users\\frods\\IdeaProjects\\" +
            "jjd-ind-54_Frodo1996_zad_13.3\\src\\main\\resources\\products.csv";

    static List<Currency> readCurrencies() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(FILE_PATH_TO_CURRENCIES));
        List<Currency> currenciesList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(";");
            Currency newCurrency = new Currency(split[0], new BigDecimal(split[1]));
            currenciesList.add(newCurrency);
        }
        return currenciesList;
    }

    static List<Product> readProducts() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(FILE_PATH_TO_PRODUCTS));
        List<Product> productsList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(";");
            Product newProduct = new Product(split[0], new BigDecimal(split[1]), split[2]);
            productsList.add(newProduct);
        }
        return productsList;
    }
}