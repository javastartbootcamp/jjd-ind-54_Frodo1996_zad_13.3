package pl.javastart.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    private static final String FILE_PATH_TO_CURRENCIES = "src/main/resources/currencies.csv";
    private static final String FILE_PATH_TO_PRODUCTS = "src/main/resources/products.csv";

    static List<Currency> readCurrencies() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(FILE_PATH_TO_CURRENCIES));
        List<Currency> currenciesList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] split = getAndSplitLine(scanner);
            Currency newCurrency = new Currency(split[0], new BigDecimal(split[1]));
            currenciesList.add(newCurrency);
        }
        return currenciesList;
    }

    static List<Product> readProducts() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(FILE_PATH_TO_PRODUCTS));
        List<Product> productsList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] split = getAndSplitLine(scanner);
            Product newProduct = new Product(split[0], new BigDecimal(split[1]), split[2]);
            productsList.add(newProduct);
        }
        return productsList;
    }

    private static String[] getAndSplitLine(Scanner scanner) {
        String line = scanner.nextLine();
        return line.split(";");
    }
}