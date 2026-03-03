public class PetManager extends InventoryManager<Pet> {

    public Pet findById(String id) {
        for (Pet p : list) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public boolean removeById(String id) {
        Pet pet = findById(id);
        if (pet != null) {
            list.remove(pet);
            return true;
        }
        return false;
    }
}