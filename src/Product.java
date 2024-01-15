import Prog1Tools.IOTools;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
public class Product {
    public enum Category {
        A, B, C, D, E, F;

    }
    private final String name;
    private final Category category;
    private final int price;

    // "Private" Konstruktor. Aufgabe가 시킨 거니까 바꾸면 안됨.
    private Product(String name, Category category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public static Product createProduct(String name, Category category, int price){
        return new Product(name, category, price);
    }

    // Getter 이것도 바꾸지 마셈.
    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + "(" + category + "): " + String.format("%.2f", price / 100.0);
    }

    public static Product[] getRandomProducts(int numb) {
        if (numb <= 0 || numb % 2 != 0 || numb > 26) {
            return null;
        }

        Random random = new Random(); //무작위로 생선된 상품의 카테고리 Produktkategorie der zufaellig erzeugten Produkte
        ArrayList<String> produktnames = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            produktnames.add(String.valueOf(c));
        }
        Collections.shuffle(produktnames);

        Product[] products = new Product[numb];
        for (int i = 0; i < numb; i++) {
            String zufpname = produktnames.get(i);
            Category category = Category.values()[random.nextInt(Category.values().length)];//category가 a부터f 까지니까 여기서 또 무작위로 뽑음.
            int price = 100 + random.nextInt(900);
            products[i] = new Product(zufpname, category, price);
        }

        return products;
    }

}
