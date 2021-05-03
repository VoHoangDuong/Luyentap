package com.student2.service;

import com.student2.dal.StudentDB2;
import com.student2.model.Student2;

import java.util.Map;

public class Student2Service {
    StudentDB2 studentDB2 = new StudentDB2();

    public void  add(Student2 student2) throws Exception{
        studentDB2.add(student2);
        studentDB2.saveFile();
    }

    public Student2 find(int id){
        return StudentDB2.student2List.get(id);
    }

    public void updateFile() throws Exception{
        studentDB2.saveFile();
    }

    public boolean remove(int id) throws Exception{
        boolean result = studentDB2.remove(id);
        studentDB2.saveFile();
        return result;
    }

    public void print(){
        for (Map.Entry<Integer,Student2> entry : StudentDB2.student2List.entrySet()){
            System.out.println(entry.getKey()+"-"+entry.getValue().toString());
        }
    }

    public void loadData() throws Exception{
        studentDB2.readFile();
    }

    public int size(){
       return StudentDB2.student2List.size();
    }
}
