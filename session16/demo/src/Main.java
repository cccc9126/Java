import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PetManager petManager = new PetManager();
        CustomerManager customerManager = new CustomerManager();
        SpaManager spaManager = new SpaManager();
        ActivityLogManager logManager = new ActivityLogManager();

        while (true) {
            System.out.println("\n===== PET KINGDOM =====");
            System.out.println("1. Thêm thú cưng");
            System.out.println("2. Hiển thị thú cưng");
            System.out.println("3. Thêm khách hàng");
            System.out.println("4. Đưa thú cưng vào Spa");
            System.out.println("5. Xử lý Spa");
            System.out.println("6. Undo");
            System.out.println("0. Thoát");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Loài: ");
                    String species = scanner.nextLine();
                    System.out.print("Tuổi: ");
                    int age = scanner.nextInt();
                    System.out.print("Giá: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    Pet pet = new Pet(id, name, species, age, price);
                    petManager.add(pet);
                    logManager.logAction("Đã thêm thú cưng " + id);
                    break;

                case 2:
                    for (Pet p : petManager.getAll()) {
                        System.out.println(p);
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID khách: ");
                    String cid = scanner.nextLine();
                    System.out.print("Tên: ");
                    String cname = scanner.nextLine();
                    System.out.print("SĐT: ");
                    String phone = scanner.nextLine();

                    Customer customer = new Customer(cid, cname, phone, 0);
                    if (customerManager.addCustomer(customer)) {
                        logManager.logAction("Đã thêm khách hàng " + cid);
                    } else {
                        System.out.println("Khách hàng đã tồn tại!");
                    }
                    break;

                case 4:
                    System.out.print("Nhập ID thú cưng: ");
                    String petId = scanner.nextLine();
                    Pet found = petManager.findById(petId);
                    if (found != null) {
                        spaManager.addToQueue(found);
                        logManager.logAction("Đưa thú cưng vào Spa " + petId);
                    } else {
                        System.out.println("Không tìm thấy thú cưng!");
                    }
                    break;

                case 5:
                    Pet serving = spaManager.processNextPet();
                    if (serving != null) {
                        System.out.println("Đang xử lý: " + serving);
                        logManager.logAction("Đã xử lý Spa cho " + serving.getId());
                    } else {
                        System.out.println("Không có thú cưng nào trong hàng chờ.");
                    }
                    break;

                case 6:
                    System.out.println(logManager.undo());
                    break;

                case 0:
                    System.out.println("Tạm biệt!");
                    return;
            }
        }
    }
}