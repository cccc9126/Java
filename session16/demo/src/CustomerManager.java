import java.util.HashMap;
import java.util.Map;

public class CustomerManager {

    private Map<String, Customer> customerMap = new HashMap<>();

    public boolean addCustomer(Customer customer) {
        if (customerMap.containsKey(customer.getCustomerId())) {
            return false;
        }
        customerMap.put(customer.getCustomerId(), customer);
        return true;
    }

    public Customer findCustomer(String id) {
        return customerMap.get(id);
    }

    public boolean removeCustomer(String id) {
        return customerMap.remove(id) != null;
    }
}