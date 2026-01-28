import java.util.Scanner;
import java.util.regex.Matcher;

public class BTTH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String bookId = sc.nextLine().trim();
        String isbn = sc.nextLine().trim();
        String year = sc.nextLine().trim();
        String title = sc.nextLine();
        String author = sc.nextLine();

        System.out.println(validateBookId(bookId));
        System.out.println(validateISBN(isbn));
        System.out.println(validateYear(year));
        System.out.println(formatText(title));
        System.out.println(formatText(author));
        System.out.println(buildFullInfo(bookId, formatText(title), formatText(author), year));



    }

    static boolean validateBookId(String bookId) {
        return bookId.matches("LIB-\\d{4}-S");
    }

    static boolean validateISBN(String isbn) {
        return isbn.matches("\\d{10}");
    }

    static boolean validateYear(String year) {
        return year.matches("\\d{4}") && Integer.parseInt(year) <= 2026;
    }

    static String formatText(String text) {
        String[] words = text.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }
        return sb.toString().trim();
    }

    static String buildFullInfo(String id, String title, String author, String year) {
        StringBuilder sb = new StringBuilder();
        sb.append(id)
                .append(" - ")
                .append(title)
                .append(" - ")
                .append(author)
                .append(" (")
                .append(year)
                .append(")");
        return sb.toString();
    }
}
