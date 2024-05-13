package Assignment6Model;

import Assignment6Controller.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class tester {
    public static void main(String args[]) {
        CustomerDAO getter = new CustomerDAO();
        BankCustomer end = new BankCustomer();
        ArrayList IDList = new ArrayList();
        try {
            IDList = getter.getALlCustomers();
        }catch( SQLException y){
            System.out.println(y);
        }
        System.out.println(end.toString());
    }
// have to edit transaction logic bc not all data is entered/filled
    //from sql database

}
