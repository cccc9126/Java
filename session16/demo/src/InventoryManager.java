import java.util.ArrayList;
import java.util.List;

public class InventoryManager<T> {
    protected List<T> list = new ArrayList<>();

    public void add(T obj) {
        list.add(obj);
    }

    public void remove(T obj) {
        list.remove(obj);
    }

    public List<T> getAll() {
        return list;
    }
}