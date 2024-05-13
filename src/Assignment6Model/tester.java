package Assignment6Model;

import Assignment6Controller.*;

import java.sql.SQLException;

public class tester {
    public static void main(String args[]) {
        CustomerDAO getter = new CustomerDAO();
        BankCustomer end = new BankCustomer();
        try {
            end = getter.get(2);
        }catch( SQLException y){
            System.out.println(y);
        }
        System.out.println("hi");
    }

    //now i know that the getter will get
    //everything in the bank customer obj execpt accounts
    //and within the accounts the transactions list

}
