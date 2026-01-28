import java.util.Scanner;

public class Bt1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String bookName = sc.nextLine();
        String author = sc.nextLine();
        String category = sc.nextLine();

        bookName = cleanSpaces(bookName).toUpperCase();
        author = formatAuthor(cleanSpaces(author));

        String result = bookName + " - Tác giả: " + author;
        System.out.println(result);
    }

    static String cleanSpaces(String s) {
        return s.trim().replaceAll("\\s+", " ");
    }

    static String formatAuthor(String s) {
        String[] words = s.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(Character.toUpperCase(w.charAt(0)))
                    .append(w.substring(1))
                    .append(" ");
        }
        return sb.toString().trim();
    }
}
