package bt4;
import java.util.*;

public class EpidemiologyReport {

    public static void main(String[] args) {

        List<String> cases = Arrays.asList(
                "Cúm A",
                "Sốt xuất huyết",
                "Cúm A",
                "Covid-19",
                "Cúm A",
                "Sốt xuất huyết"
        );

        Map<String, Integer> report = new TreeMap<>();

        for (String disease : cases) {
            if (report.containsKey(disease)) {
                report.put(disease, report.get(disease) + 1);
            } else {
                report.put(disease, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : report.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " ca");
        }
    }
}
