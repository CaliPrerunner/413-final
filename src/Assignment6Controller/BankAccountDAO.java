/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

import Assignment6Model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author karunmehta
 */
public class BankAccountDAO implements DAOInterface<BankAccount>{

    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result; 
    final String checking = "CH";
    final String saving = "SV";

    BankAccountDAO() {

        connection = DataConnection.getDBConnection();

    }
               
    // Method to disconnect from the database
    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // Method to insert a user into the database
    @Override
    public int create(BankAccount act) throws SQLException {
        
        int res = -1;
        pStatement = connection.prepareStatement(BankAccountDataConnection.getInsert());
        pStatement.setInt(1, act.getAccountNum());
        pStatement.setDouble(2, act.getBalance());
        res = pStatement.executeUpdate();
        disconnect();
        
        return res;
    }

    // Method to retrieve a user from the database by ID of customer

    public ArrayList getList(int anID) throws SQLException {

        pStatement = connection.prepareStatement(BankAccountDataConnection.getSelect());
        pStatement.setInt(1,anID);
        result = pStatement.executeQuery();

        ArrayList bankAccList = new ArrayList();

        BankAccount updatedAct = null;
        while (result.next()) {
            if(result.getString("acct_type").equalsIgnoreCase(checking))
            {updatedAct = new CheckingAccount( result.getInt("acct_num"));}
            else {
                updatedAct = new SavingsAccount(result.getInt("acct_num"));
            }
            DateTimeFormatter format = DateTimeFormatter.ofPattern("d-M-yy");

            updatedAct.setBalance(result.getFloat("balance"));
            LocalDate ld = LocalDate.parse(result.getString("create_date"), format);
            updatedAct.setCreateDate(ld);
            updatedAct.setAccountNum(result.getInt("acct_num"));
            updatedAct.setCustID(result.getInt("cust_id"));
            ld = LocalDate.parse(result.getString("last_update_date"), format);
            updatedAct.setLastUpDate(ld);
            updatedAct.setOdLimit(result.getInt("od_limit"));
            updatedAct.setIntRate(result.getFloat("int_rate"));

            AccountTransactionDAO tr = new AccountTransactionDAO();
            updatedAct.setTransactions(tr.getTransList(result.getInt("acct_num")));

            bankAccList.add(updatedAct);
        }
      
        return bankAccList;
    }

    private LocalDate createLocalDate(String dateStr) {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");

        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(dateStr, formatter);
        
        return localDate;
        
    }
    
    // Method to update a user in the database
    @Override
    public int update(BankAccount act) throws SQLException {
        
        int result = -1;
       
        pStatement = connection.prepareStatement(BankAccountDataConnection.getUpdate());
        pStatement.setInt(1, act.getCustID());
        pStatement.setDouble(1, act.getBalance());

        pStatement.setString(2, act.getCreateDate().toString());
        pStatement.setString(3, act.getAccType());
        pStatement.setInt(4, act.getAccountNum());
        result = pStatement.executeUpdate();
        
        return result;
    }

    // Method to delete a user from the database
    @Override
    public int delete(BankAccount act) throws SQLException {
        
        int res = -1;
        
        pStatement = connection.prepareStatement(BankAccountDataConnection.getDelete());
        pStatement.setInt(1, act.getAccountNum());
        res = pStatement.executeUpdate();
        
        return res;
    }
    @Override
    public BankAccount get(int anID) throws SQLException {

        pStatement = connection.prepareStatement(BankAccountDataConnection.getSelect());
        pStatement.setInt(1,anID);
        result = pStatement.executeQuery();

        BankAccount updatedAct = null;
        while (result.next()) {
            if(result.getString("acct_type").equalsIgnoreCase(checking))
            {updatedAct = new CheckingAccount( result.getInt("acct_num"));}
            else {
                updatedAct = new SavingsAccount(result.getInt("acct_num"));
            }
            DateTimeFormatter format = DateTimeFormatter.ofPattern("d-M-yy");

            updatedAct.setBalance(result.getFloat("balance"));
            LocalDate ld = LocalDate.parse(result.getString("create_date"), format);
            updatedAct.setCreateDate(ld);
            updatedAct.setAccountNum(result.getInt("acct_num"));
            updatedAct.setCustID(result.getInt("cust_id"));
            ld = LocalDate.parse(result.getString("last_update_date"), format);
            updatedAct.setLastUpDate(ld);
            updatedAct.setOdLimit(result.getInt("od_limit"));
            updatedAct.setIntRate(result.getFloat("int_rate"));

            AccountTransactionDAO tr = new AccountTransactionDAO();
            updatedAct.setTransactions(tr.getTransList(result.getInt("acct_num")));
        }

        return updatedAct;
    }


    public int updateAccType(String a, BankAccount act) throws SQLException {

        int result = -1;
        pStatement = connection.prepareStatement(BankAccountDataConnection.getAccUpdate());
        pStatement.setString(1, a);
        pStatement.setInt(2, act.getAccountNum());
        result = pStatement.executeUpdate();



        return result;
    }
    
}
