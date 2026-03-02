package bt1;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        MedicalRecordHistory recordHistory = new MedicalRecordHistory();

        recordHistory.addEdit(new EditAction(
                "Cập nhật chẩn đoán",
                LocalDateTime.now().toString()
        ));

        recordHistory.addEdit(new EditAction(
                "Thêm đơn thuốc",
                LocalDateTime.now().toString()
        ));

        recordHistory.addEdit(new EditAction(
                "Chỉnh sửa tiền sử bệnh",
                LocalDateTime.now().toString()
        ));

        recordHistory.displayHistory();

        System.out.println("\nChỉnh sửa gần nhất:");
        System.out.println(recordHistory.getLatestEdit());

        System.out.println("\nUndo chỉnh sửa:");
        System.out.println(recordHistory.undoEdit());

        System.out.println("\nSau khi undo:");
        recordHistory.displayHistory();
    }
}
