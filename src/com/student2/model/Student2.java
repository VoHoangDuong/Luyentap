package com.student2.model;

public class Student2 {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private double diem11;
    private double diem12;
    private double diem2;
    private double diem3;
    private double diemTB;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getDiem11() {
        return diem11;
    }

    public void setDiem11(double diem11) {
        this.diem11 = diem11;
    }

    public double getDiem12() {
        return diem12;
    }

    public void setDiem12(double diem12) {
        this.diem12 = diem12;
    }

    public double getDiem2() {
        return diem2;
    }

    public void setDiem2(double diem2) {
        this.diem2 = diem2;
    }

    public double getDiem3() {
        return diem3;
    }

    public void setDiem3(double diem3) {
        this.diem3 = diem3;
    }

    public void setDiemTB(double diemTB){
        this.diemTB = diemTB;
    }
    public Student2(){

    }

    public Student2(int id, String name, String address, String phoneNumber, double diem11, double diem12, double diem2, double diem3, double diemTB) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.diem11 = diem11;
        this.diem12 = diem12;
        this.diem2 = diem2;
        this.diem3 = diem3;
        this.diemTB = diemTB;
    }

    public Student2(int id, String name, String address, String phoneNumber){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Student2(double diem11, double diem12, double diem2, double diem3, double diemTB){
        this.diem11 = diem11;
        this.diem12 = diem12;
        this.diem2 = diem2;
        this.diem3 = diem3;
        this.diemTB = diemTB;
    }
    @Override
    public String toString() {
        return "Thông tin:" +
                " | MSSV: " + id +
                " | Tên: " + name +
                " | Địa chỉ: " + address +
                " | Số điện thoại: " + phoneNumber + "|";
    }

    public String toStringCSV(){
        return id+","+name+","+address+","+phoneNumber+","+diem11+","+diem12+","+diem2+","+diem3+","+diemTB+"\n";
    }

    public String toStringScore(){
        return "| " +name + " | " + "Điểm hệ số 1: " + diem11 + " | " + "Điểm hệ số 1: " + diem12 + " | " +
                "Điểm hệ số 2: " + diem2 + " | " + "Điểm hệ số 3: " + diem3 + " | " + "Điểm TB: " + String.format("%.2f",diemTB)+ "|";
    }
}
