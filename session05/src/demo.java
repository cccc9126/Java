import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Two Sum");
            System.out.println("2. Move Zeroes");
            System.out.println("3. Kiểm tra Palindrome");
            System.out.println("4. Reverse Words");
            System.out.println("5. Happy Number");
            System.out.println("0. Thoát");
            System.out.print("Chọn bài: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    twoSum();
                    break;
                case 2:
                    moveZeroes();
                    break;
                case 3:
                    checkPalindrome();
                    break;
                case 4:
                    reverseWords();
                    break;
                case 5:
                    happyNumber();
                    break;
                case 0:
                    System.out.println("Tạm biệt! ");
                    break;
                default:
                    System.out.println("Chọn sai rồi bro ");
            }
        } while (choice != 0);
    }

    // ================== 1. TWO SUM ==================
    static void twoSum() {
        System.out.print("Nhập số phần tử: ");
        int n = Integer.parseInt(sc.nextLine());
        if (n < 2) {
            System.out.println("Mảng phải có ít nhất 2 phần tử!");
            return;
        }

        int[] arr = new int[n];
        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        System.out.print("Nhập target: ");
        int target = Integer.parseInt(sc.nextLine());

        boolean found = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println("Tìm thấy: index " + i + " và " + j +
                            " (" + arr[i] + " + " + arr[j] + " = " + target + ")");
                    found = true;
                    return;
                }
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy cặp nào phù hợp.");
        }
    }

    // ================== 2. MOVE ZEROES ==================
    static void moveZeroes() {
        System.out.print("Nhập số phần tử: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];

        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }

        for (int i = index; i < n; i++) {
            arr[i] = 0;
        }

        System.out.println("Mảng sau khi xử lý:");
        System.out.println(Arrays.toString(arr));
    }

    // ================== 3. KIỂM TRA PALINDROME ==================
    static void checkPalindrome() {
        System.out.print("Nhập chuỗi: ");
        String input = sc.nextLine();

        // Làm sạch chuỗi: chỉ giữ chữ và số, chuyển về chữ thường
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int n = cleaned.length();
        boolean isPalindrome = true;

        for (int i = 0; i <= n / 2 - 1; i++) {
            if (cleaned.charAt(i) != cleaned.charAt(n - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Chuỗi là Palindrome ✔");
        } else {
            System.out.println("Chuỗi KHÔNG phải Palindrome ❌");
        }
    }

    // ================== 4. REVERSE WORDS ==================
    static void reverseWords() {
        System.out.print("Nhập chuỗi: ");
        String input = sc.nextLine();

        input = input.trim().replaceAll("\\s+", " ");
        if (input.isEmpty()) {
            System.out.println("Chuỗi rỗng.");
            return;
        }

        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) result.append(" ");
        }

        System.out.println("Chuỗi sau khi đảo từ:");
        System.out.println(result.toString());
    }

    // ================== 5. HAPPY NUMBER ==================
    static void happyNumber() {
        System.out.print("Nhập số nguyên dương n: ");
        int n = Integer.parseInt(sc.nextLine());

        if (n <= 0) {
            System.out.println("Vui lòng nhập số nguyên dương!");
            return;
        }

        while (n != 1 && n != 4) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }

        if (n == 1) {
            System.out.println("Đây là Happy Number ");
        } else {
            System.out.println("Không phải Happy Number ");
        }
    }
}
