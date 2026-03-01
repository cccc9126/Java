package btth;

import java.util.*;

public class PatientService implements Manageable<Patient> {

    private Set<Patient> patients = new HashSet<>();
    private Map<String, List<MedicalRecord>> recordMap = new HashMap<>();
    private Scanner sc = new Scanner(System.in);



    @Override
    public void add(Patient p) {
        if (patients.contains(p)) {
            System.out.println("ID đã tồn tại!");
        } else {
            patients.add(p);
            System.out.println("Thêm thành công!");
        }
    }

    @Override
    public void update(String id) {
        for (Patient p : patients) {
            if (p.getId().equals(id)) {
                System.out.print("Tên mới: ");
                p.setName(sc.nextLine());
                System.out.print("Tuổi mới: ");
                p.setAge(Integer.parseInt(sc.nextLine()));
                System.out.print("SĐT mới: ");
                p.setPhone(sc.nextLine());
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân!");
    }

    @Override
    public void delete(String id) {
        patients.removeIf(p -> p.getId().equals(id));
        recordMap.remove(id);
        System.out.println("Xóa thành công!");
    }

    @Override
    public void displayAll() {
        patients.forEach(Patient::displayInfo);
    }



    public void addRecord(String patientId) {
        if (!recordMap.containsKey(patientId)) {
            recordMap.put(patientId, new ArrayList<>());
        }

        System.out.print("Mã hồ sơ: ");
        String recordId = sc.nextLine();
        System.out.print("Chẩn đoán: ");
        String diagnosis = sc.nextLine();
        System.out.print("Ngày khám: ");
        String date = sc.nextLine();

        recordMap.get(patientId)
                .add(new MedicalRecord(recordId, diagnosis, date));

        System.out.println("Thêm hồ sơ thành công!");
    }

    public void viewRecords(String patientId) {
        List<MedicalRecord> list = recordMap.get(patientId);
        if (list == null || list.isEmpty()) {
            System.out.println("Không có hồ sơ!");
            return;
        }
        list.forEach(MedicalRecord::display);
    }

    public void deleteRecord(String patientId, String recordId) {
        List<MedicalRecord> list = recordMap.get(patientId);
        if (list != null) {
            list.removeIf(r -> r.getRecordId().equals(recordId));
            System.out.println("Xóa hồ sơ thành công!");
        }
    }

    // ================== SEARCH ==================

    public void searchById(String id) {
        patients.stream()
                .filter(p -> p.getId().equals(id))
                .forEach(Patient::displayInfo);
    }

    public void searchByName(String keyword) {
        patients.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .forEach(Patient::displayInfo);
    }



    public void sortDefault() {
        List<Patient> list = new ArrayList<>(patients);
        Collections.sort(list);
        list.forEach(Patient::displayInfo);
    }

    public void sortByAge() {
        List<Patient> list = new ArrayList<>(patients);
        list.sort((a, b) -> Integer.compare(a.getAge(), b.getAge()));
        list.forEach(Patient::displayInfo);
    }

    public void sortById() {
        List<Patient> list = new ArrayList<>(patients);
        list.sort(Comparator.comparing(Patient::getId));
        list.forEach(Patient::displayInfo);
    }
}
