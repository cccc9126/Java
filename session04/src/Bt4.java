import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bt4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cardId = sc.nextLine();

        Pattern fullPattern = Pattern.compile("^[A-Z]{2}\\d{4}\\d{5}$");
        Matcher matcher = fullPattern.matcher(cardId);

        if (matcher.matches()) {
            System.out.println("Mã thẻ hợp lệ");
        } else {
            if (!cardId.matches("^[A-Z]{2}.*")) {
                System.out.println("Thiếu tiền tố TV");
            } else if (!cardId.matches("^[A-Z]{2}\\d{4}.*")) {
                System.out.println("Năm không hợp lệ");
            } else if (!cardId.matches("^[A-Z]{2}\\d{4}\\d{5}$")) {
                System.out.println("Phần số cuối không hợp lệ");
            } else {
                System.out.println("Định dạng không hợp lệ");
            }
        }
    }
}
