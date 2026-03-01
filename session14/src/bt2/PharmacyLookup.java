package bt2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PharmacyLookup {

    public static void main(String[] args) {

        Map<String, String> medicineMap = new HashMap<>();

        medicineMap.put("T01", "Paracetamol");
        medicineMap.put("T02", "Ibuprofen");
        medicineMap.put("T03", "Amoxicillin");
        medicineMap.put("T04", "Aspirin");
        medicineMap.put("T05", "Vitamin C");

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã thuốc: ");
        String code = sc.nextLine().trim();

        if (medicineMap.containsKey(code)) {
            System.out.println("Tên thuốc: " + medicineMap.get(code));
        } else {
            System.out.println("Thuốc không tồn tại.");
        }

        sc.close();
    }
}
