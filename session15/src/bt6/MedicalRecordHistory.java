package bt6;

import java.util.Stack;

public class MedicalRecordHistory {

    private Stack<EditAction> editStack;
    private String recordId;

    public MedicalRecordHistory(String recordId) {
        this.recordId = recordId;
        this.editStack = new Stack<>();
    }

    public void addEdit(EditAction action) {
        editStack.push(action);
    }

    public EditAction undoEdit() {
        if (editStack.isEmpty()) {
            return null;
        }
        return editStack.pop();
    }
}
