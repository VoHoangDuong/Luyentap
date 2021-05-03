package com.student.dal;

import com.student.model.Student;
import com.student.service.StudentService;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StudentDB {
    public static Map<Integer , Student> studentList  ;
    public static int count;
    static {
        studentList = new HashMap<>();
        count = 0;
    }
    public void saveFile() throws IOException {
        File file = new File("Data.csv");
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream("Data.csv");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        for (Map.Entry<Integer, Student> entry : studentList.entrySet()) {
//            System.out.println(entry.getKey() + " - " + entry.getValu
            bos.write(entry.getValue().toStringCSV().getBytes());
        }
        bos.flush();
        bos.close();
        fos.close();
    }
    public void readFile()throws Exception{
        File file = new File("Data.csv");
        if(!file.exists()){
          return ;
        }
        FileReader fis = new FileReader("Data.csv");
        BufferedReader bis = new BufferedReader(fis);
        String line;

        while ((line = bis.readLine()) != null){
            String[] arr = line.split(",");
            Student st = new Student(arr[0],Integer.parseInt(arr[1]) , Integer.parseInt(arr[2]),arr[3]);
            add(st);
        }
    }

    public void add(Student student) throws IOException {
        count++;
        student.setId(count);
        studentList.put(count , student);

    }
    public boolean remove(int id) throws IOException {
        boolean result = studentList.remove(id) == null;
        return result;
    }
}
