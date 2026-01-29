import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{
    static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int choice;
        String[] studentId=new String[100];
        int index=0;
        do{
            System.out.println("==========MENU==========");
            System.out.println("1. Hiển thị");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xoá");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Thoát");
            System.out.println("=======================");
            System.out.println("Nhập lựa chọn: ");
            choice=Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    if(index==0){
                        System.out.println("Chưa tồn tại sinh viên nào !");
                        break;
                    }
                    System.out.println("====Danh sách mã sinh viên====");
                    for(int i=0;i<index;i++){
                        System.out.printf("|%-3d | %-22s |\n", i, studentId[i]);
                    }
                    System.out.println("==============================");
                    break;
                case 2:
                    if(index==100){
                        System.out.println("Mảng đã đầy, không thể thêm !");
                        break;
                    }

                    Pattern pattern = Pattern.compile("B\\d{7}");


                    do{
                        System.out.println("Nhập mã sinh viên mới: ");
                        String newStudent=sc.nextLine();
                        Matcher matcher = pattern.matcher(newStudent);
                        boolean result=matcher.matches();

                        if(result){
                            int flag=0;
                            for(int i=0;i<index;i++){
                                if(studentId[i].equals(newStudent)){
                                    System.out.println("Mã sinh viên đã tồn tại!");
                                    flag=1;
                                    break;
                                }
                            }
                            if(flag==0){
                                studentId[index++]=newStudent;
                                break;
                            }
                        }else{
                            System.out.println("Mã sinh viên không hợp lệ, vui lòng nhập lại! ");
                        }
                    }while(true);
                    break;
                case 3:
                    if(index==0){
                        System.out.println("Chưa tồn tại sinh viên nào !");
                        break;
                    }
                    int repairIndex;
                    do{
                        System.out.println("Nhập số thứ tự sinh viên bạn muốn sửa");
                         repairIndex=Integer.parseInt(sc.nextLine());
                        if(repairIndex<index&& repairIndex>=0){
                            break;
                        }else{
                            System.out.println("Số thứ tự sinh viên không tồn tại.");
                        }
                    }while(true);
                    Pattern pattern1 = Pattern.compile("B\\d{7}");


                    do{
                        System.out.println("Nhập mã sinh viên bạn muốn cập nhật: ");
                        String repairStudent=sc.nextLine();
                        Matcher matcher = pattern1.matcher(repairStudent);
                        boolean result=matcher.matches();

                        if(result){
                            int flag=0;
                            for(int i=0;i<index;i++){
                                if(studentId[i].equals(repairStudent)){
                                    System.out.println("Mã sinh viên đã tồn tại!");
                                    flag=1;
                                    break;
                                }
                            }
                            if(flag==0){
                                studentId[repairIndex]=repairStudent;
                                System.out.println("Cập nhật thành công");
                                break;
                            }
                        }else{
                            System.out.println("Mã sinh viên không hợp lệ, vui lòng nhập lại! ");
                        }
                    }while(true);
                    break;
                case 4:
                    if(index==0){
                        System.out.println("Chưa tồn tại sinh viên nào !");
                        break;
                    }

                    Pattern pattern2 = Pattern.compile("B\\d{7}");
                    String dltStudent;
                    int dltIndex = -1;

                    do{
                        System.out.println("Nhập mã sinh viên cần xoá: ");
                        dltStudent = sc.nextLine();
                        Matcher matcher = pattern2.matcher(dltStudent);

                        if(!matcher.matches()){
                            System.out.println("Mã sinh viên không hợp lệ, vui lòng nhập lại!");
                            continue;
                        }

                        for(int i=0;i<index;i++){
                            if(studentId[i].equals(dltStudent)){
                                dltIndex = i;
                                break;
                            }
                        }

                        if(dltIndex == -1){
                            System.out.println("Không tìm thấy mã sinh viên trong danh sách!");
                        }

                    } while(dltIndex == -1);

                    for(int i = dltIndex; i < index - 1; i++){
                        studentId[i] = studentId[i + 1];
                    }
                    index--;
                    System.out.println("Xoá thành công!");
                    break;

                case 5:
                    if(index==0){
                        System.out.println("Chưa tồn tại sinh viên nào !");
                        break;
                    }

                    Pattern pattern3 = Pattern.compile("B\\d{7}");
                    System.out.println("Nhập mã sinh viên cần tìm: ");
                    String searchStudent = sc.nextLine();
                    Matcher matcher3 = pattern3.matcher(searchStudent);

                    if(!matcher3.matches()){
                        System.out.println("Mã sinh viên không hợp lệ!");
                        break;
                    }

                    int foundIndex = -1;
                    for(int i=0;i<index;i++){
                        if(studentId[i].equals(searchStudent)){
                            foundIndex = i;
                            break;
                        }
                    }

                    if(foundIndex == -1){
                        System.out.println("Không tìm thấy sinh viên!");
                    } else {
                        System.out.println("Tìm thấy sinh viên tại vị trí: " + foundIndex);
                    }
                    break;

                case 6:
                    System.out.println("ĐANG THOÁT CHƯƠNG TRÌNH.....");
                    break;
                    default:
                        System.out.println("Lựa chọn không phù hợp !");

            }
        } while(true);
    }
}