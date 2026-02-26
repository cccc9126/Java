package btth;

import java.util.ArrayList;
import java.util.List;

public class PatientManager {

    private List<Patient> patientList = new ArrayList<>();

    public void addPatient(Patient patient) {
        patientList.add(patient);
        System.out.println("Them benh nhan thanh cong");
    }

    public void removePatient(int id) {
        Patient found = null;
        for (Patient p : patientList) {
            if (p.getId() == id) {
                found = p;
                break;
            }
        }

        if (found != null) {
            patientList.remove(found);
            System.out.println("Xoa benh nhan thanh cong");
        } else {
            System.out.println("Khong tim thay benh nhan");
        }
    }

    public void updatePatient(int id, Patient updatedPatient) {
        for (Patient p : patientList) {
            if (p.getId() == id) {
                p.setName(updatedPatient.getName());
                p.setAge(updatedPatient.getAge());
                p.setGender(updatedPatient.getGender());
                p.setDisease(updatedPatient.getDisease());
                System.out.println("Cap nhat thanh cong");
                return;
            }
        }
        System.out.println("Khong tim thay benh nhan");
    }

    public void searchPatientByName(String name) {
        boolean found = false;
        for (Patient p : patientList) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong tim thay benh nhan");
        }
    }

    public void displayPatients() {
        if (patientList.isEmpty()) {
            System.out.println("Danh sach trong");
            return;
        }

        for (Patient p : patientList) {
            System.out.println(p);
        }
    }
}
