package bt1;

import java.util.*;

public class ReceptionDesk {

    public static void main(String[] args) {

        List<String> input = Arrays.asList(
                "Nguyễn Văn A – Yên Bái",
                "Trần Thị B – Thái Bình",
                "Nguyễn Văn A – Yên Bái",
                "Lê Văn C – Hưng Yên"
        );

        Set<String> patients = new LinkedHashSet<>(input);

        System.out.println("Danh sách gọi khám:");
        patients.forEach(System.out::println);
    }
}
