package bt6;

public class InputAction {

    private String fieldName;
    private String oldValue;
    private String newValue;
    private String actionTime;

    public InputAction(String fieldName, String oldValue, String newValue, String actionTime) {
        this.fieldName = fieldName;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.actionTime = actionTime;
    }

    @Override
    public String toString() {
        return fieldName + " | " + oldValue + " -> " + newValue + " | " + actionTime;
    }
}
