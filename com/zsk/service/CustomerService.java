package com.zsk.service;


import com.zsk.bean.Customer;
import com.zsk.bean.CustomerData;
import com.zsk.util.TextUitl;

import java.util.List;
import java.util.Scanner;

// 此类是  完成 客户的 所有业务 (增删改查)
public class CustomerService {
    private List<Customer> customerList;
    private Customer currentCustomer;
    // 1. 查, 登录 判断账号密码是否正确
    public void  checkPwd(String cardid, String  cardPwd){
        CustomerData customerData = CustomerData.getInstance();
        customerList  = customerData.getCustomerList();
        // 1. 拿到  carid中的账户名 和 cardPwd  对  list中的数据做对比
        System.out.println("cardid = " + cardid);
        System.out.println("cardPwd = " + cardPwd);

        for (Customer customer : customerList) {
            if (customer.getAccount().equals(cardid) && customer.getPassword().equals(cardPwd)){
                // 拿出来这个人
                currentCustomer=  customer;
                // 账户正确
                System.out.println("欢迎"+customer.getCname()+"顾客登录!请注意您的安全"   );
                TextUitl.oneLeveOption();  // 界面
                Scanner scanner = new Scanner(System.in);
                String option = scanner.nextLine();
                oneOption(option);
                // 如何 保证 按了 1 3 5... 让他再此回到 此界面呢 ?
            }
        }
    }

    private void oneOption(String option) {
        switch (option){
            case "1":
                System.out.println("余额查询");

                // 查询余额外
                doSelectMoney();
                // 当按下1 之后,  回退到  1及选项
                goOneHome();

                break;
            case "2":
                do1SelectMoney();
                //TextUitl.twoLeveOption();
                goOneHome();
                break;
            case "3":
                System.out.println("转账");
                //转账
                doTuranMoney();
                goOneHome();
                break;
            case "4":
                doSaveMoney();
                System.out.println("存款");
                goOneHome();
                break;
            case "5":
                doQuitCard();
                System.out.println("退卡");
                goOneHome();
                break;
        }
    }
    //退卡
    private void doQuitCard(){
        System.out.println("您是否继续：");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.equalsIgnoreCase("y")) {
            System.out.println("退出成功");
        }
        if (s.equalsIgnoreCase("n") ) {
            TextUitl.welcome();

        }
    }


    // 查询余额
    private void doSelectMoney() {
        double money = currentCustomer.getMoney();
        System.out.println(" 余额是 " +money);
    }

        //取款
    private void do1SelectMoney(){
        TextUitl.twoLeveOption();
        //1.让客户输入
        Scanner scanner = new Scanner(System.in);
        String numIn = scanner.nextLine();
        if (numIn.equals("1")) {
            //那么 取款100 那么就应该 让顾客的钱减100
            double money = currentCustomer.getMoney();
            money = money - 100;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if(numIn.equals("2")){
            //那么 取款200 那么就应该 让顾客的钱减200
            double money = currentCustomer.getMoney();
            money = money - 200;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if(numIn.equals("3")){
            //那么 取款300 那么就应该 让顾客的钱减200
            double money = currentCustomer.getMoney();
            money = money - 300;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if(numIn.equals("4")){
            //那么 取款400 那么就应该 让顾客的钱减200
            double money = currentCustomer.getMoney();
            money = money - 400;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if(numIn.equals("5")){
            //那么 取款800 那么就应该 让顾客的钱减200
            double money = currentCustomer.getMoney();
            money = money - 800;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if(numIn.equals("6")){
            //那么 取款1000 那么就应该 让顾客的钱减200
            double money = currentCustomer.getMoney();
            money = money - 1000;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if(numIn.equals("7")){
            //那么 取款2000 那么就应该 让顾客的钱减200
            double money = currentCustomer.getMoney();
            money = money - 2000;
            System.out.println("你的余额是:" + money);
            //取完款后，更新原有存款
            currentCustomer.setMoney(money);
        }else if (numIn.equals("8")) {
            // 那么 取款100 那么就应该 让 顾客的 钱 -100
            System.out.println("请输入要取的金额");
            double money = scanner.nextDouble();
            if (money <= currentCustomer.getMoney()) {

                if ((money % 100) == 0) {
                    money = currentCustomer.getMoney() - money;
                    currentCustomer.setMoney(money);
                    System.out.println("取款成功！ 您的余额是: " + currentCustomer.getMoney());

                } else {
                    System.out.println("取款失败 ， 请输入100或100的倍数");
                }
            }else{
                System.out.println("余额不足。");
            }
        }
    }

    //转账
    private void doTuranMoney() {
        System.out.println("请输入您要转账的卡号：");
        Scanner scanner = new Scanner(System.in);
        String otherAccount = scanner.nextLine();
        System.out.println("请输入您要转账的金额：");
        String otherMoney = scanner.nextLine();
        //做计算  自己的钱 - otherMoney ,别人的钱加上 + otherMoney
        //自己减钱
        Double otherMoneyInt = Double.parseDouble(otherMoney);
        double customerMoney = currentCustomer.getMoney() - otherMoneyInt;//自己被 减去转账的 钱
        //别人加钱，根据otherAccount 本人的账户查询出 别人的余额，查询出别人的余额后，修改别人的余额
        //因为所有人都在customerList 这个集合中
        Customer other = null;
        for (Customer customer : customerList) {
            //如果 customer.getAcount 等于 otherAccount 那么这个人就被选出来了
            if (customer.getAccount().equals(otherAccount)) {
                other=customer;
            }
        }
        double otherOneMoney = other.getMoney() + otherMoneyInt; //别人的余额

        //自己和别人都跟新一下钱数
        currentCustomer.setMoney(customerMoney);
        other.setMoney(otherOneMoney); //注意：有问题？不能够创建对象了

        for (Customer customer : customerList) {
            System.out.println("customer = " + customer);
        }
    }

    //存款
    private void doSaveMoney() {
        //提示界面
        System.out.println("你想存的金额：");
        //接收钱
        Scanner scanner = new Scanner(System.in);
        String moneyIn = scanner.nextLine();
        Double moneyInInt = Double.valueOf(moneyIn);
        if ((moneyInInt % 100) == 0) {
            double newMoney = currentCustomer.getMoney() + moneyInInt;
            currentCustomer.setMoney(newMoney);
            System.out.println("你的账号余额是：" + newMoney);
        }else {
            System.out.println("存入的金额不能小于100，存入金额失败");
        }

    }

    private  void goOneHome( ){
        TextUitl.oneLeveOption();
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("option1 = " + option);
        oneOption(option);  // 递归算法
    }
}



