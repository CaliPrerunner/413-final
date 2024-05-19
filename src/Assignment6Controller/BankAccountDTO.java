package Assignment6Controller;

import Assignment6Model.BankAccount;
import Assignment6Model.BankAccountTransaction;
import Assignment6Model.BankCustomer;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankAccountDTO {
    public int accountNum;
    public int custID;
    public double balance;
    public LocalDate createDate;
    public LocalDate lastUpdatedDate;
    public String accType;
    public int odLimit;
    public double intRate;
  static BankAccountDAO cd = new BankAccountDAO();

  public BankAccountDTO(){

  }
    public static BankAccount BankAccountByID(int anId) {

        BankAccount account = null;

        try {
            account = cd.get(anId);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        if(account != null){
            System.out.println(account.toString());
        }

        System.out.println("\nFetched Customer with ID: " + anId + " Customer Details:\n" + account.toString());
        return account;
    }
    //returns an array list of with bank accounts
    public static ArrayList BankAccountByCustID(int anId) {

        ArrayList AccList = new ArrayList();

        try {
            AccList = cd.getList(anId);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        if(AccList != null){
            for(int x=1; AccList.size() > x ; x++)
            System.out.println(AccList.get(x).toString());
        }else{
            System.out.println("none found");
        }
        return AccList;
    }

    public static void updateAccType(String a, BankAccount acc){

      try{
          cd.updateAccType(a, acc);
      }catch (SQLException se){
          System.out.println(se.getMessage());
      }


    }




}
