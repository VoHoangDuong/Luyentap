package com.student.service;

import com.student.dal.StudentDB;
import com.student.model.Student;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StudentService {
    public StudentDB sd = new StudentDB();

    public  void add(Student student) throws IOException {
        sd.add(student);
        sd.saveFile();
    }

    public Student find(int id){
        return StudentDB.studentList.get(id);
    }

    public void updateFile(){
        try {
            sd.saveFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  boolean remove(int id) throws IOException {
        boolean result = sd.remove(id);
        sd.saveFile();
        return result;
    }
    public  void print(){
        for (Map.Entry<Integer, Student> entry : StudentDB.studentList.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().toString());
        }
    }

    public void loadData() throws Exception {
        sd.readFile();
    }
}
