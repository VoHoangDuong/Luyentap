package com.studen1.model;

public class Student1 {
    private String name;
    private int id;
    private int age;
    private String gender;

    public Student1(){

    }

    public Student1(String name, int id, int age, String gender){
        this.name = name;
        this.id = id;
        this.age = age;
        this.gender = gender;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public int getAge(){
        return age;
    }

    public String getGender(){
        return gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String toStringCSV(){
        return name+","+id+","+age+","+gender+"\n";
    }
}
