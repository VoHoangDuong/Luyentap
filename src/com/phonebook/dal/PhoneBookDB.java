package com.phonebook.dal;

import com.phonebook.model.PhoneBook;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PhoneBookDB {
    public static Map<String, PhoneBook> phoneBookList;

    static {
        phoneBookList = new HashMap<>();
    }

    public void saveFile() throws Exception{
        File file = new File("PhoneBook.csv");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream("PhoneBook.csv");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        for (Map.Entry<String, PhoneBook> entry : phoneBookList.entrySet()){
            bos.write(entry.getValue().toStringCSV().getBytes());
        }
        bos.flush();
        bos.close();
        fos.close();
    }

    public void add(PhoneBook phoneBook) throws Exception{
        phoneBookList.put(phoneBook.getPhoneNumber(), phoneBook);
        saveFile();
    }

    public void readFile() throws Exception{
        File file = new File("PhoneBook.csv");
        if (!file.exists()){
            return;
        }else {
            FileReader fileReader = new FileReader("PhoneBook.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] str = line.split(",");
                PhoneBook phoneBook = new PhoneBook(str[0],str[1],str[2],str[3],str[4],str[5],str[6]);
                add(phoneBook);
            }
        }
    }

    public boolean remove(String phone){
        boolean result = phoneBookList.remove(phone) == null;
        return result;
    }
}
