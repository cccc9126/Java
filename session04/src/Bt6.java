import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bt6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String review = sc.nextLine();

        List<String> blacklist = Arrays.asList("xấu", "tệ", "ngu", "dở");

        String regex = "\\b(" + String.join("|", blacklist) + ")\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(review);

        StringBuilder filtered = new StringBuilder();
        int lastEnd = 0;

        while (matcher.find()) {
            filtered.append(review, lastEnd, matcher.start());
            filtered.append("*".repeat(matcher.group().length()));
            lastEnd = matcher.end();
        }
        filtered.append(review.substring(lastEnd));

        String result = filtered.toString();

        if (result.length() > 200) {
            int cut = result.lastIndexOf(" ", 200);
            if (cut == -1) cut = 200;
            StringBuilder shortText = new StringBuilder();
            shortText.append(result.substring(0, cut)).append("...");
            result = shortText.toString();
        }

        System.out.println(result);
    }
}
