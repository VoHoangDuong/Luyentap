package com.customer.model;

import com.customer.service.CustomerService;

import java.util.Objects;

public class Customer {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String gender;
    private int orderNumber;

    public Customer(){

    }

    public Customer(String name, String address, String phoneNumber, String email, String gender){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
    }

    public Customer(String name, String address, String phoneNumber, String email, String gender, int orderNumber){
        this.name = name;
        this.address= address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.orderNumber = orderNumber;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setOrderNumber(int orderNumber){
        this.orderNumber = orderNumber;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getGender(){
        return gender;
    }

    public int getOrderNumber(){
        return orderNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Customer){
            Customer customer1 = (Customer) o;
            if (customer1.getEmail().equals(this.email) && customer1.getPhoneNumber().equals(this.phoneNumber)){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Th??ng tin kh??ch h??ng: | " + " T??n: " + String.format("%-8s|",name) + "  ?????a ch???: " + String.format("%-7s|",address) + " S??? ??i???n tho???i: " + phoneNumber + " | Email: " + String.format("%-20s|",email) + " Gi???i t??nh: " + String.format("%-5s|",gender) + " S??? ????n h??ng: " + orderNumber + " |";
    }

    public String toStringMid() {
        return "Th??ng tin kh??ch h??ng: " + "| "+ "T??n: " + name + " | ?????a ch???: " + address + "| S??? ??i???n tho???i: " + phoneNumber + " | Email: " + email + " | Gi???i t??nh: " + gender + "|";
    }

    public String toStringCSV(){
        return name+","+address+","+phoneNumber+","+email+","+gender+","+orderNumber+"\n";
    }
}
