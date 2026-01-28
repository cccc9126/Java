import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bt5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pattern pattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2}) \\| User: ([^|]+) \\| Action: (BORROW|RETURN) \\| BookID: (\\w+)");

        int borrowCount = 0;
        int returnCount = 0;

        while (sc.hasNextLine()) {
            String log = sc.nextLine();
            if (log.isEmpty()) break;

            Matcher matcher = pattern.matcher(log);
            if (matcher.find()) {
                String date = matcher.group(1);
                String user = matcher.group(2).trim();
                String action = matcher.group(3);
                String bookId = matcher.group(4);

                if (action.equals("BORROW")) borrowCount++;
                if (action.equals("RETURN")) returnCount++;
            }
        }

        System.out.println("Số lượt mượn: " + borrowCount);
        System.out.println("Số lượt trả: " + returnCount);
    }
}
