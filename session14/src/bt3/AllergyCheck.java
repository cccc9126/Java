package bt3;

import java.util.HashSet;
import java.util.Set;

public class AllergyCheck {

    public static void main(String[] args) {

        Set<String> drugComponents = new HashSet<>();
        drugComponents.add("Aspirin");
        drugComponents.add("Caffeine");
        drugComponents.add("Paracetamol");

        Set<String> allergyList = new HashSet<>();
        allergyList.add("Penicillin");
        allergyList.add("Aspirin");

        Set<String> warning = new HashSet<>(drugComponents);
        warning.retainAll(allergyList);

        Set<String> safeComponents = new HashSet<>(drugComponents);
        safeComponents.removeAll(allergyList);

        System.out.println("Cảnh báo dị ứng: " + warning);
        System.out.println("Thành phần an toàn: " + safeComponents);
    }
}
