package com.customer.service;

import com.customer.dal.CustomerDB;
import com.customer.model.Customer;

import java.util.Map;

public class CustomerService {
    CustomerDB customerDB = new CustomerDB();

    public void addCustomer(Customer customer) throws Exception{
        customerDB.add(customer);
        customerDB.saveFile();
    }

    public Customer find(String phoneNUmber){
        return CustomerDB.customerList.get(phoneNUmber);
    }

    public void updateFile() throws Exception{
        customerDB.saveFile();
    }

    public void printData(){
        for (Map.Entry<String, Customer> entry : CustomerDB.customerList.entrySet()){
            System.out.println(entry.getKey()+" | "+entry.getValue().toString());
        }
    }

    public void loadData(){
        customerDB.readFile();
    }

    public int size(){
        return CustomerDB.customerList.size();
    }

    public void sortCustomer(){
        customerDB.sort();
    }
}
