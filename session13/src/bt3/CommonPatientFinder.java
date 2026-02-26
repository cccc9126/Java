package bt3;

import java.util.ArrayList;
import java.util.List;

public class CommonPatientFinder {

    public static <T> List<T> findCommonPatients(List<T> listA, List<T> listB) {

        List<T> result = new ArrayList<>();

        for (T item : listA) {
            if (listB.contains(item) && !result.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // Test Case 1 - Integer
        List<Integer> khoaNoi = new ArrayList<>();
        khoaNoi.add(101);
        khoaNoi.add(102);
        khoaNoi.add(105);

        List<Integer> khoaNgoai = new ArrayList<>();
        khoaNgoai.add(102);
        khoaNgoai.add(105);
        khoaNgoai.add(108);

        List<Integer> commonInt = findCommonPatients(khoaNoi, khoaNgoai);
        System.out.println("Test Case 1 Output: " + commonInt);

        // Test Case 2 - String
        List<String> bhytNoi = new ArrayList<>();
        bhytNoi.add("DN01");
        bhytNoi.add("DN02");
        bhytNoi.add("DN03");

        List<String> bhytNgoai = new ArrayList<>();
        bhytNgoai.add("DN02");
        bhytNgoai.add("DN04");

        List<String> commonString = findCommonPatients(bhytNoi, bhytNgoai);
        System.out.println("Test Case 2 Output: " + commonString);
    }
}
