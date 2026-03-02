package bt1;

import java.util.Stack;

public class MedicalRecordHistory {

    private Stack<EditAction> history;

    public MedicalRecordHistory() {
        history = new Stack<>();
    }


    public void addEdit(EditAction action) {
        history.push(action);
        System.out.println("Đã thêm chỉnh sửa vào lịch sử.");
    }


    public EditAction undoEdit() {
        if (history.isEmpty()) {
            System.out.println("Không có chỉnh sửa nào để hoàn tác!");
            return null;
        }
        return history.pop();
    }


    public EditAction getLatestEdit() {
        if (history.isEmpty()) {
            System.out.println("Chưa có chỉnh sửa nào!");
            return null;
        }
        return history.peek();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public void displayHistory() {
        if (history.isEmpty()) {
            System.out.println("Lịch sử chỉnh sửa trống.");
            return;
        }

        System.out.println("===== LỊCH SỬ CHỈNH SỬA =====");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println(history.get(i));
        }
    }
}
