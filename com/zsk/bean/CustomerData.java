package com.zsk.bean;

import com.zsk.bean.Customer;

import java.util.ArrayList;
import java.util.List;
// 使用单例模式 ,把 客户 初始化了
public class CustomerData {
    private static CustomerData ourInstance = new CustomerData();
    private List<Customer> customerList;
    public static CustomerData getInstance() {
        return ourInstance;
    }
    private CustomerData() {
        // 在构造中 初始话 数据
        customerList = new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            // 每循环一次,诞生一个 customer 对象, 放入到 集合当中
            Customer customer = new Customer();
            customer.setAccount("12345678"+i);
            customer.setPassword("123");
            customer.setCname("球球"+i+"号");
            customer.setMoney(10000);
            customer.setPhoneNum("123456789"+i);
            customerList.add(customer);
        }
    }
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
