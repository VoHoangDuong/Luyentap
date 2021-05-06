package com.phonebook.model;

import com.customer.model.Customer;

public class PhoneBook {
    private String phoneNumber;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String dateOfBirth;
    private String email;

    public PhoneBook(String phoneNumber, String group, String name, String gender, String address, String dateOfBirth, String email) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public PhoneBook(){

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof PhoneBook){
            PhoneBook phoneBook = (PhoneBook) o;
            if (phoneBook.getPhoneNumber().equals(this.phoneNumber)){
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
        return "Thông tin: " + "| Số điện thoại: " + String.format("%-12s|",phoneNumber) + " Nhóm của danh bạ: " + String.format("%-10s|",group) + " Tên: " + String.format("%-8s|",name) + " Giới tính: " + String.format("%-6s|",gender) + " Địa chỉ: " + String.format("%-10s|",address)  + " Ngày sinh: " + String.format("%-10s|",dateOfBirth) + " Email: " + String.format("%-10s |",email);
    }

    public String toStringCSV(){
        return phoneNumber+","+group+","+name+","+gender+","+address+","+dateOfBirth+","+email+"\n";
    }
}
