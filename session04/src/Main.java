import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(" ");
        boolean result = matcher.matches();
                System.out.println(result);


    }
}