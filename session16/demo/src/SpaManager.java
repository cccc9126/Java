import java.util.LinkedList;
import java.util.Queue;

public class SpaManager {

    private Queue<Pet> spaQueue = new LinkedList<>();

    public void addToQueue(Pet pet) {
        spaQueue.offer(pet);
    }

    public Pet processNextPet() {
        return spaQueue.poll();
    }

    public Pet viewNextPet() {
        return spaQueue.peek();
    }

    public boolean isEmpty() {
        return spaQueue.isEmpty();
    }
}