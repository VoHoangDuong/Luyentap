package com.studen1.service;

import com.studen1.dal.StudentDB1;
import com.studen1.model.Student1;

import java.util.Map;

public class StudentService1 {
    StudentDB1 studentDB1 = new StudentDB1();

    public void add(Student1 student1) throws Exception{
        studentDB1.add(student1);
        studentDB1.saveFile();
    }

    public Student1 find(int id)throws Exception{
        return StudentDB1.student1List.get(id);
    }

    public void updateFile(){
        try {
            studentDB1.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean remove(int id) throws Exception {
        boolean result = studentDB1.remove(id);
        studentDB1.saveFile();
        return result;
    }

    public void print() throws Exception{
        for (Map.Entry<Integer, Student1> entry : StudentDB1.student1List.entrySet()){
            System.out.println(entry.getKey() + "-----------------" + entry.getValue().toString());
        }
    }

    public void loadData()throws Exception{
        studentDB1.readFile();
    }


}
