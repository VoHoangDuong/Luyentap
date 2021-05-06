package com.student.presentation;

import com.student.dal.StudentDB;
import com.student.model.Student;
import com.student.service.StudentService;

import java.io.IOException;
import java.util.Scanner;

public class MainStudent {

    public static void main(String[] args) {
       StudentService studentService = new StudentService();
        try {
            studentService.loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Scanner sc =new Scanner(System.in);
       int choose;
       do {
           creatMenu();
           choose= sc.nextInt();
           switch (choose){
               case 1:
                   try {
                       addStudent();
                   } catch (IOException e) {
                       System.out.println(e.getMessage());
                   }
                   break;
               case 2:
                   try {
                       deleteStudent();
                   } catch (IOException e) {
                       System.out.println(e.getMessage());
                   }
                   break;
               case 3:
                   printStudent();
                   break;
               case 4:
                   editStudent();
                   break;
               case 5:
                   System.out.println("quit");
                   break;
               default:
                   System.out.println("Moi ban nhap lai:");
                   break;
           }
       }while (choose!=5);
    }

    private static void printStudent() {
        StudentService ss = new StudentService();
        ss.print();
    }

    private static void deleteStudent() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap id muon xoa: ");
        int n = sc.nextInt();
        sc.nextLine();
        StudentService ss = new StudentService();
        ss.remove(n);
    }

    private static void addStudent() throws IOException {
        Scanner sc =new Scanner(System.in);
        System.out.println("Nhap ten:");
        String name = sc.nextLine();
        System.out.println("Nhap tuoi");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap gioi tinh:");
        String gender = sc.nextLine();
        Student std = new Student(name, 0, age,gender);
        StudentService ss = new StudentService();
        ss.add(std);
    }
    public static void editStudent(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Nhap Id can edit");
        int id = sc.nextInt();
        sc.nextLine();
        StudentService studentService = new StudentService();
        Student student = studentService.find(id);
        if (student == null){
            System.out.println("Not found");
        } else {
            System.out.println(student.toString());
            System.out.println("Nhap ten:");
            String name = sc.nextLine();
            System.out.println("Nhap tuoi");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("Nhap gioi tinh:");
            String gender = sc.nextLine();
            student.setName(name);
            student.setAge(age);
            student.setGender(gender);
            studentService.updateFile();
        }
    }
    public static void creatMenu(){
        System.out.println("-------Menu---------");
        System.out.println("1. Add Student.");
        System.out.println("2. Delete Student.");
        System.out.println("3. Print Student.");
        System.out.println("4. Edit.");
        System.out.println("5. Exit.");
    }
}
