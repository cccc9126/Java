package exam;

import java.util.*;


public class ProductRepository implements IRepository<Product> {
    ArrayList<Product> products=new ArrayList<Product>();
    HashMap<String,Product> productMap=new HashMap<String,Product>();

    @Override
    public boolean add(Product item) {
        if (item == null) return false;

        if (productMap.containsKey(item.getId())) {
            return false;
        }
        products.add(item);
        productMap.put(item.getId(), item);
        return true;
    }

    @Override
    public boolean removeById(String id) {
        Product removed = productMap.remove(id);
        if (removed == null) {
            return false;
        }
        products.remove(removed);
        return true;
    }

    @Override
    public Product findById(String id) {
        return productMap.get(id);
    }

    @Override
    public java.util.List<Product> findAll() {
        return new ArrayList<>(products);
    }
    public List<Product> sortByPriceAsc() {
        List<Product> sorted = new ArrayList<>(products);
        Collections.sort(sorted, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });
        return sorted;
    }
    public Map<String, Integer> countByType() {
        Map<String, Integer> result = new HashMap<>();
        for (Product p : products) {
            String type;
            if (p instanceof ElectronicProduct) {
                type = "Electronic";
            } else if (p instanceof FoodProduct) {
                type = "Food";
            } else {
                type = "Other";
            }

            int oldCount = result.getOrDefault(type, 0);
            result.put(type, oldCount + 1);
        }
        return result;
    }

}
