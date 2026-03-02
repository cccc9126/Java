package bt3;

import java.util.Stack;

public class MedicationProcessChecker {

    private Stack<String> stack;

    public MedicationProcessChecker() {
        stack = new Stack<>();
    }

    public boolean checkProcess(String[] actions) {

        for (String action : actions) {

            if (action.equals("PUSH")) {
                stack.push(action);
            }
            else if (action.equals("POP")) {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public void reset() {
        stack.clear();
    }
}
