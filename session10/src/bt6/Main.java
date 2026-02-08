package bt6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Chuột", 150));
        products.add(new Product("Bàn phím", 300));
        products.add(new Product("Tai nghe", 200));
        products.add(new Product("Màn hình", 250));


        Collections.sort(products, new Comparator<Product>() {



            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });

        System.out.println("Sắp xếp theo giá tăng dần:");
        for (Product p : products) {
            System.out.println(p);
        }


        System.out.println("\nSắp xếp theo tên A-Z:");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}

