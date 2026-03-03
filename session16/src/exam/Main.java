package exam;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductRepository productRepository = new ProductRepository();
        ElectronicProduct product1=new ElectronicProduct("P1","Điều Hòa",999.9,6);
        ElectronicProduct product2=new ElectronicProduct("P2","TV",123.45,8);
        FoodProduct product3=new FoodProduct("P3","Sữa",10,10);
        FoodProduct product4=new FoodProduct("P4","Snack",15,20);
       productRepository.add(product1);
       productRepository.add(product2);
        productRepository.add(product3);
        productRepository.add(product4);
        //cau1
        System.out.println("Câu 1");

       for (Product product:productRepository.findAll()){
           product.displayInfo();
       }
       //cau2
        System.out.println();
        System.out.println("Câu 2");
        Product search=productRepository.findById("P1");
       search.displayInfo();

        System.out.println();
        System.out.println("Câu 3");
        List<Product> sorted = productRepository.sortByPriceAsc();
        for (Product product : sorted) {
            product.displayInfo();
        }


        System.out.println();
        System.out.println("Câu 4: ");
        Map<String, Integer> stats = productRepository.countByType();
        for (String key : stats.keySet()) {
            Integer value = stats.get(key); 
            System.out.println(key + ": " + value);
        }


    }
}
