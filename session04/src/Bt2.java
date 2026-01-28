import java.util.Scanner;

public class Bt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String description = sc.nextLine();

        if (description.contains("Kệ:")) {
            int start = description.indexOf("Kệ:") + 4;
            int endComma = description.indexOf(",", start);
            int endLine = description.length();
            int end = endComma != -1 ? endComma : endLine;

            String position = description.substring(start, end).trim();
            System.out.println(position);

            String newDescription = description.replace("Kệ:", "Vị trí lưu trữ:");
            System.out.println(newDescription);
        } else {
            System.out.println("Không tìm thấy thông tin kệ sách.");
        }
    }
}
