package com.customer.dal;

import com.customer.model.Customer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CustomerDB {
    public static Map<String, Customer> customerList;

    static {
        customerList = new HashMap<>();
    }

    public void saveFile() throws Exception{
        File file = new File("CustomerData.csv");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fos = new  FileOutputStream("CustomerData.csv");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        for (Map.Entry<String, Customer> entry : customerList.entrySet()){
            bos.write(entry.getValue().toStringCSV().getBytes());
        }
        bos.flush();
        bos.close();
        fos.close();
    }

    public void add(Customer customer) throws Exception{
        customerList.put(customer.getPhoneNumber(),customer);
    }

    public void readFile(){
        File file = new File("CustomerData.csv");
        if (!file.exists()){
            return;
        }
        try {
            FileReader fileReader = new FileReader("CustomerData.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] str = line.split(",");
                Customer customer = new Customer(str[0],str[1],str[2],str[3],str[4],Integer.parseInt(str[5]));
                add(customer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
