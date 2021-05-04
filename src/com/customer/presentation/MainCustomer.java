package com.customer.presentation;

import com.customer.model.Customer;
import com.customer.service.CustomerService;

import java.util.Scanner;

public class MainCustomer {

    private static Customer customer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerService customerService = new CustomerService();
        try {
            customerService.loadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int choose;
        do {
            creatMenu();
            choose = scanner.nextInt();
            switch (choose){
                case 1:
                    try {
                        addCustomer();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    findCustomer();
                    break;
                case 3:
                    printCustomer();
                    break;
                case 4:
                    printCustomerList();
                    break;
                case 5:
                    try {
                        increaseOrder();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 0:
                    exit();
                default:
                    System.out.println("Nhập lại:");
                    break;
            }

        }while (choose != 0);
    }

    public static void creatMenu(){
        System.out.println("---------Menu--------");
        System.out.println("Bấm 1. Để nhập khách hàng");
        System.out.println("Bấm 2. Để tìm kiếm khách hàng");
        System.out.println("Bấm 3. Để in thông tin khách hàng");
        System.out.println("Bấm 4. Để in toàn bộ danh sách khách hàng");
        System.out.println("Bấm 5. Để tăng số đơn hàng cho khách");
        System.out.println("Bấm 0. Để thoát");
        System.out.println("---------------------");
    }

    public static void addCustomer() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin khách hàng:");

        System.out.println("Nhập tên:");
        String name = scanner.nextLine();

        System.out.println("Nhập địa chỉ:");
        String address = scanner.nextLine();

        System.out.println("Nhập email:");
        String email = scanner.nextLine();

        System.out.println("Nhập số điện thoại:");
        String phoneNumber = scanner.nextLine();

        System.out.println("Giới tính:");
        String gender = scanner.nextLine();

        Customer customer = new Customer(name, address, phoneNumber, email, gender);
        CustomerService customerService = new CustomerService();
        Customer customer1 = customerService.find(phoneNumber);
        if (customer.equals(customer1)) {
            System.out.println("Khách hàng đã tồn tại.");
        } else {
            customerService.addCustomer(customer);
            System.out.println("Bạn vừa thêm mới khách hàng " + customer.getName() + " thành công.");
        }
    }
    public static void findCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại khách hàng:");
        String phoneNumber = scanner.nextLine();

        CustomerService customerService = new CustomerService();
        Customer customer = customerService.find(phoneNumber);

        if (customer == null){
            System.out.println("Khách hàng không tồn tại");
        }else {
            System.out.println(customerService.find(phoneNumber).toStringMid());
        }
    }

    public static void printCustomer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại khách hàng:");
        String phoneNumber = scanner.nextLine();

        CustomerService customerService = new CustomerService();
        customer = customerService.find(phoneNumber);
        if (customer == null){
            System.out.println("Không tìm thấy");
        }else {
            System.out.println(customerService.find(phoneNumber).toString());
        }
    }

    public static void printCustomerList(){
        CustomerService customerService = new CustomerService();
        customerService.printData();
        System.out.println("Tổng có " + customerService.size() + " khách hàng trong hệ thống.");
    }

    public static void increaseOrder() throws Exception{
        Scanner scanner = new Scanner(System.in);
        CustomerService customerService = new CustomerService();

        System.out.println("Nhập số điện thoại cần tăng");
        String phoneNumber = scanner.nextLine();

        if (customerService.find(phoneNumber) == null){
            System.out.println("Khách hàng không tồn tại");
        }else {
            customerService.find(phoneNumber).setOrderNumber(customerService.find(phoneNumber).getOrderNumber()+1);
            System.out.println("Tăng đơn hàng thành công !");
            System.out.println("Khách hàng " + customerService.find(phoneNumber).getName() + " " + customerService.find(phoneNumber).toString());
        }
        customerService.updateFile();
    }

    public static void exit(){
        System.out.println("Đã thoát hệ thống quản lý khách hàng.");
        System.exit(0);
    }
}
