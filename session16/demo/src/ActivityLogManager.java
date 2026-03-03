import java.util.Stack;

public class ActivityLogManager {

    private Stack<String> activityStack = new Stack<>();

    public void logAction(String action) {
        activityStack.push(action);
    }

    public String undo() {
        if (!activityStack.isEmpty()) {
            return activityStack.pop();
        }
        return "Không có thao tác nào để hoàn tác.";
    }

    public String viewLastAction() {
        if (!activityStack.isEmpty()) {
            return activityStack.peek();
        }
        return "Chưa có thao tác nào.";
    }
}