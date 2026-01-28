import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bt3 {
    public static void main(String[] args) {
        List<String> transactions = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            transactions.add("LIB-" + String.format("%04d", i) + "-S | 2026-01-28");
        }

        long start1 = System.currentTimeMillis();
        String report1 = "Thời gian hệ thống: " + LocalDateTime.now() + "\n";
        for (String t : transactions) {
            report1 += t + "\n";
        }
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("Thời gian hệ thống: ").append(LocalDateTime.now()).append("\n");
        for (String t : transactions) {
            sb.append(t).append("\n");
        }
        String report2 = sb.toString();
        long end2 = System.currentTimeMillis();

        System.out.println("Thời gian dùng String: " + (end1 - start1) + " ms");
        System.out.println("Thời gian dùng StringBuilder: " + (end2 - start2) + " ms");
    }
}
