import java.util.Scanner;

public class Btth{
    static void main(String[] args) {

//        int[] ids: Lưu mã sách (duy nhất).
//        String[] titles: Lưu tên sách.
//        int[] quantities: Lưu số lượng tồn kho.
        int[] ids=new int[100];
        String[] titlles=new String[100];
        int[] quantities=new int[100];
        int choice;
        int current=0;
        do{
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm sách mới");
            System.out.println("3. Cập nhật số lượng");
            System.out.println("4. Xóa sách");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Sắp xếp theo số lượng");
            System.out.println("7. Thoát");
            Scanner sc=new Scanner(System.in);
            System.out.println("Nhập lựa chọn : ");
            choice=Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    if(current ==0){
                        System.out.println("Chưa có sách...");
                        break;
                    }
                    for(int i=0;i<current;i++){
                        System.out.println(ids[i]+" "+titlles[i]+" "+quantities[i]);
                    }
                    break;
                case 2:
                    if(current==100){
                        System.out.println("Mảng đã đầy...");
                        break;
                    }
                    System.out.println("Nhập Id mới cho sách");
                    int curId=Integer.parseInt(sc.nextLine());
                    System.out.println("Nhập tiêu đề sách");
                    String curTitle=sc.nextLine();
                    System.out.println("Nhập số lượng sách");
                    int curQuantity=Integer.parseInt(sc.nextLine());
                    ids[current]=curId;
                    titlles[current]=curTitle;
                    quantities[current]=curQuantity;
                    current++;
                    System.out.println("Thêm thành công");


                    break;
                case 3:
                    System.out.println("Chọn ID sách cần cập nhật");
                    int udId=Integer.parseInt(sc.nextLine());
                    System.out.println("Nhập số lượng bạn muốn sửa");
                    int newQuantity=Integer.parseInt(sc.nextLine());
                    quantities[udId]=newQuantity;
                    break;
                case 4:
                    System.out.println("Nhập ID sách bạn muốn xóa");
                    int dltId=Integer.parseInt(sc.nextLine());
                    for(int i=dltId;i<current-1;i++){
                        ids[i]=ids[i+1];
                        titlles[i]=titlles[i+1];
                        quantities[i]=quantities[i+1];
                    }
                    System.out.println("Xóa thành công");
                    break;

                case 5:
                    System.out.println("Nhập ID sách muốn tìm kiếm");
                    int searchID=Integer.parseInt(sc.nextLine());
                    for(int i=0;i<current;i++){
                        if(ids[i]==searchID){
                            System.out.println(ids[i]+" "+titlles[i]+" "+quantities[i]);
                            break;
                        }
                    }
                    break;
                case 6:
                    for(int i=0;i<current;i++){
                        for(int j=0;j<current;j++){
                            if(ids[i]>ids[j]){
                                int temp1=ids[j];
                                ids[j]=ids[i];
                                ids[i]=temp1;
                                String temp2=titlles[j];
                                titlles[j]=titlles[i];
                                titlles[i]=temp2;
                                int  temp3=quantities[j];
                                quantities[j]=quantities[i];
                                quantities[i]=temp3;

                            }
                        }
                    }
                    break;
                case 7:
                    return;

                default:
            }
        }while(true);


    }
}