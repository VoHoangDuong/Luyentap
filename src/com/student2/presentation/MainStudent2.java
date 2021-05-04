package com.student2.presentation;

import com.student2.dal.StudentDB2;
import com.student2.model.Student2;
import com.student2.service.Student2Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class MainStudent2 {
    public static void main(String[] args) {
        Student2Service student2Service = new Student2Service();
        try {
            student2Service.loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        int choose;
        do {
            creatMenu();
            choose = scanner.nextInt();
            switch (choose){
                case 1:
                    printStudentList();
                    break;
                case 2:
                    try {
                        addStudent();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        editStudent();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        deleteStudent();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("---Vui lòng chọn---");
                    System.out.println("1. Nhập điểm hệ số 1 lần 1." + "\n" + "2. Nhập điểm hệ số 1 lần 2." +"\n" +
                                        "3. Nhập điểm hệ số 2" + "\n" + "4. Nhập điểm hệ số 3");

                    int choice = scanner.nextInt();
                    scanner.nextLine();
                        switch (choice){
                            case 1:
                                try {
                                    inputScore11();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            case 2:
                                try {
                                    inputScore12();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            case 3:
                                try {
                                    inputScore2();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            case 4:
                                try {
                                    inputScore3();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                    break;
                case 6:
                    try {
                        editScore();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    System.out.println("Xếp loại");
                    break;
                case 0:
                    exit();
                    break;
                default:
                    System.out.println("Nhập lại:");
                    break;
            }
        }while (choose != 0);

    }

    public static void creatMenu(){
        System.out.println("-------Lựa chọn-------");
        System.out.println("1. Xem danh sách học viên");
        System.out.println("2. Thêm học viên");
        System.out.println("3. Sửa thông tin học viên");
        System.out.println("4. Xóa học viên");
        System.out.println("5. Nhập điểm học viên");
        System.out.println("6. Sửa nhập điểm học viên");
        System.out.println("7. Xếp loại học viên");
        System.out.println("0. Thoát");
    }

    public static void printStudentList(){
        Student2Service ss = new Student2Service();
        ss.print();
        System.out.println("Hiện có " + ss.size() + " học viên trong danh sách");
    }

    public static void addStudent() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên:");
        String name = scanner.nextLine();
        
        System.out.println("Nhập địa chỉ:");
        String address = scanner.nextLine();
        
        System.out.println("Nhập số điện thoại:");
        String phoneNumber = scanner.nextLine();

        Student2 student2 = new Student2(0,name,address,phoneNumber);
        Student2Service ss = new Student2Service();
        ss.add(student2);
        System.out.println("Đã thêm học viên " + student2.getName() + " thành công" );
    }

    public static void editStudent() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id muốn sửa:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student2Service ss = new Student2Service();
        Student2 s2 = ss.find(id);
        if (s2 == null){
            System.out.println("Không tìm thấy");
        }else {
            System.out.println(s2.toString());
            System.out.println("Nhập tên:");
            String name = scanner.nextLine();

            System.out.println("Nhập địa chỉ:");
            String address = scanner.nextLine();

            System.out.println("Nhập số điện thoại:");
            String phoneNumber = scanner.nextLine();

            s2.setName(name);
            s2.setAddress(address);
            s2.setPhoneNumber(phoneNumber);
            ss.updateFile();
            System.out.println("Sửa thông tin thành công!");
        }
    }

    public static void deleteStudent() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id học viên muốn xóa");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student2Service student2Service = new Student2Service();
        student2Service.remove(id);
        System.out.println("Đã xóa học viên");
    }

    public static void exit(){
        System.out.println("Đã thoát ứng dụng.");
        System.exit(0);
    }

//    public static void editScore(){
//        Student2Service student2Service = new Student2Service();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Nhập ID học viên muốn sửa và nhập điểm: ");
//        int id = scanner.nextInt();
//        scanner.nextLine();
//        Student2 student2 = student2Service.find(id);
//        if (student2 == null){
//            System.out.println("Không có học viên trong danh sách");
//        }else {
//            System.out.println(student2.toStringScore());
//        }
//    }

    public static void inputScore11() throws Exception{
        Student2Service student2Service = new Student2Service();
        Scanner scanner = new Scanner(System.in);
        for (Map.Entry<Integer,Student2> entry : StudentDB2.student2List.entrySet()){
            System.out.println("Nhập điểm hệ số 1 lần 1:" + student2Service.find(entry.getKey()).getName());
            double score1 = scanner.nextDouble();
            entry.getValue().setDiem11(score1);
        }
        student2Service.updateFile();
    }

    public static void editScore() throws Exception{
        Scanner scanner = new Scanner(System.in);
        Student2Service student2Service = new Student2Service();
        System.out.println("Nhập ID học viên muốn sửa và nhập điểm");
        int id = scanner.nextInt();
        scanner.nextLine();
        Student2 student2 = student2Service.find(id);
        if (student2 == null){
            System.out.println("Học viên không có trong danh sách");
        }else {
            System.out.println(student2.toStringScore());
            System.out.println("Nhập điểm hệ số 1 lần 1:");
            double score1 = scanner.nextDouble();
            student2.setDiem11(score1);

            System.out.println("Nhập điểm hệ số 1 lần 2:");
            double score2 = scanner.nextDouble();
            student2.setDiem12(score2);

            System.out.println("Nhập điểm hệ số 2:");
            double score3 = scanner.nextDouble();
            student2.setDiem2(score3);

            System.out.println("Nhập điểm hệ số 3:");
            double score4 = scanner.nextDouble();
            student2.setDiem3(score4);


            double scoreTB = (score1+score2+score3*2+score4*3)/7;
            student2.setDiemTB(scoreTB);
            System.out.println("Thành công !");
            System.out.println(student2.toStringScore());
        }
        student2Service.updateFile();
    }

    public static void inputScore12() throws Exception{
        Student2Service student2Service = new Student2Service();
        Scanner scanner = new Scanner(System.in);
        for (Map.Entry<Integer,Student2> entry : StudentDB2.student2List.entrySet()){
            System.out.println("Nhập điểm hệ số 1 lần 2:" + student2Service.find(entry.getKey()).getName());
            double score2 = scanner.nextDouble();
            entry.getValue().setDiem12(score2);
        }
        student2Service.updateFile();
    }

    public static void inputScore2() throws Exception{
        Student2Service student2Service = new Student2Service();
        Scanner scanner = new Scanner(System.in);
        for (Map.Entry<Integer,Student2> entry : StudentDB2.student2List.entrySet()){
            System.out.println("Nhập điểm hệ số 2:" + student2Service.find(entry.getKey()).getName());
            double score3 = scanner.nextDouble();
            entry.getValue().setDiem2(score3);
        }
        student2Service.updateFile();
    }

    public static void inputScore3() throws Exception{
        Student2Service student2Service = new Student2Service();
        Scanner scanner = new Scanner(System.in);
        for (Map.Entry<Integer,Student2> entry : StudentDB2.student2List.entrySet()){
            System.out.println("Nhập điểm hệ số 3 : " + student2Service.find(entry.getKey()).getName());
            double score4 = scanner.nextDouble();
            entry.getValue().setDiem3(score4);
        }
        student2Service.updateFile();
    }
}
