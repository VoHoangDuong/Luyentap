package com.student2.dal;

import com.student2.model.Student2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StudentDB2 {
    public static Map<Integer,Student2> student2List;
    public static int count;

    static {
        student2List = new HashMap<>();
        count = 0;
    }

    public void saveFile() throws Exception{
        File file = new File("StudentData.csv");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream("StudentData.csv");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        for (Map.Entry<Integer,Student2> entry : student2List.entrySet()){
            bos.write(entry.getValue().toStringCSV().getBytes());
        }
        bos.flush();
        bos.close();
        fos.close();
    }

    public void add(Student2 student2){
        count++;
        student2.setId(count);
        student2List.put(count,student2);
    }
    public void readFile() throws Exception{
        File file = new File("StudentData.csv");
        if (!file.exists()){
            return;
        }else {
            FileReader fileReader = new FileReader("StudentData.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] str = line.split(",");
                Student2 student2 = new Student2(Integer.parseInt(str[0]),str[1],str[2],str[3],Double.parseDouble(str[4]),Double.parseDouble(str[5]),Double.parseDouble(str[6]),Double.parseDouble(str[7]),Double.parseDouble(str[8]));
                add(student2);
            }
        }
    }

    public boolean remove(int id){
        boolean result = student2List.remove(id) == null;
        return result;
    }
}
