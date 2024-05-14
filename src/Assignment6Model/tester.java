package Assignment6Model;

import Assignment6Controller.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class tester {
    public static void main(String args[]) {
        CustomerDTO setter = new CustomerDTO();
        BankCustomer n = new BankCustomer();
        n.email = "NEWNEW";
        //n.phone = "iphone";
        n.customerID=  1;
        int end ;
        end =  setter.performUpdate(n);
        System.out.println(end);

//        try {
//
//        }catch( SQLException y){
//            System.out.println(y);
//        }
//        System.out.println(end.toString());
    }
// have to edit transaction logic bc not all data is entered/filled
    //from sql database

}
