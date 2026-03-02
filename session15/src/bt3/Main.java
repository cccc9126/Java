package bt3;

public class Main {
    public static void main(String[] args) {

        MedicationProcessChecker checker = new MedicationProcessChecker();

        String[] case1 = {"PUSH", "PUSH", "POP", "POP"};
        System.out.println(checker.checkProcess(case1));
        checker.reset();

        String[] case2 = {"PUSH", "POP", "POP"};
        System.out.println(checker.checkProcess(case2));
        checker.reset();

        String[] case3 = {"PUSH", "PUSH", "POP"};
        System.out.println(checker.checkProcess(case3));
        checker.reset();
    }
}
