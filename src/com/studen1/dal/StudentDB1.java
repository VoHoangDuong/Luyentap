package com.studen1.dal;

import com.studen1.model.Student1;
import com.student.model.Student;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StudentDB1 {
    public static Map<Integer, Student1>student1List;
    public static int count;

    static {
        student1List = new HashMap<>();
        count = 0;
    }

    public void saveFile()throws Exception{
        File file = new File("Data1.csv");
        if (!file.exists()){
            file.createNewFile();
        }

        FileOutputStream fos = new FileOutputStream("Data1.csv");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        for (Map.Entry<Integer,Student1> entry : student1List.entrySet()){
            bos.write(entry.getValue().toStringCSV().getBytes());
        }
        bos.flush();
        bos.close();
        fos.close();
    }

    public void readFile() throws Exception{
        File file = new File("Data1.csv");
        if (!file.exists()){
            return;
        }
        try {
            FileReader fileReader = new FileReader("Data1.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line=bufferedReader.readLine())!=null){
                String[] str = line.split(",");
                Student1 student1 = new Student1(str[0],Integer.parseInt(str[1]),Integer.parseInt(str[2]),str[3]);
                add(student1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Student1 student1) throws Exception{
        count++;
        student1.setId(count);
        student1List.put(count,student1);
    }

    public boolean remove(int id) throws Exception{
        return student1List.remove(id) == null ? true :false;
    }
}
