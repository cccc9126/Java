package bt2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedicineManager {

    public static List<String> processMedicines(List<String> inputList) {

        List<String> uniqueList = new ArrayList<>();

        for (String medicine : inputList) {
            if (!uniqueList.contains(medicine)) {
                uniqueList.add(medicine);
            }
        }

        Collections.sort(uniqueList);

        return uniqueList;
    }

    public static void main(String[] args) {

        List<String> input = new ArrayList<>();
        input.add("Paracetamol");
        input.add("Ibuprofen");
        input.add("Panadol");
        input.add("Paracetamol");
        input.add("Aspirin");
        input.add("Ibuprofen");

        System.out.println("Input: " + input);

        List<String> result = processMedicines(input);

        System.out.println("Output: " + result);
    }
}