package com.studen1.presenttation;

import com.studen1.model.Student1;
import com.studen1.service.StudentService1;

import java.util.Scanner;

public class MainStudent1 {
    public static void main(String[] args) {
       StudentService1 studentService1 = new StudentService1();
        try {
            studentService1.loadData();
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
                   try {
                       addStudent();
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                   break;
               case 2:
                   try {
                       deleteStudent();
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                   break;
               case 3:
                   try {
                       printStudents();
                   } catch (Exception e) {
                       e.printStackTrace();
                   }break;
               case 4:
                   try {
                       editStudent();
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                   break;
               case 5:
                   exit();
               default:
                   System.out.println("Nhap lai:");
                   break;
           }
       }while (choose!=5);
    }
    
    public static void creatMenu(){
        System.out.println("----------Menu---------");
        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Print Students");
        System.out.println("4. Edit Student");
        System.out.println("5.Exit");
    }

    public static void printStudents() throws Exception {
        StudentService1 studentService1 = new StudentService1();
        studentService1.print();
    }

    public static void deleteStudent() throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentService1 studentService1 = new StudentService1();
        System.out.println("Nhap ID muon xoa:");
        int id = sc.nextInt();
        sc.nextLine();
        studentService1.remove(id);
    }

    public static void addStudent() throws Exception {
      Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten:");
        String name = sc.nextLine();
        System.out.println("Nhap tuoi:");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap gioi tinh:");
        String gender = sc.nextLine();
        Student1 student1 = new Student1(name,0,age,gender);
        StudentService1 studentService1 = new StudentService1();
        studentService1.add(student1);
    }

    public static void editStudent() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ID can chinh sua:");
        int id = sc.nextInt();
        sc.nextLine();
        StudentService1 studentService1 = new StudentService1();
        Student1 student1 = studentService1.find(id);
        if (student1 == null){
            System.out.println("Not found");
        }else {
            System.out.println(student1.toString());
            System.out.println("Nhap ten:");
            String name = sc.nextLine();
            System.out.println("Nhap tuoi:");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("Nhap gioi tinh:");
            String gender = sc.nextLine();
            student1.setName(name);
            student1.setAge(age);
            student1.setGender(gender);
            studentService1.updateFile();
        }
    }

    public static void exit(){
        System.out.println("Da thoat ung dung.");
        System.exit(0);
    }
}
