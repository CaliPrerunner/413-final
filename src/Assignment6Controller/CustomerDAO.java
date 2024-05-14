/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

import Assignment6Model.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author karunmehta
 */

public class CustomerDAO implements DAOInterface<BankCustomer> {

    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result;
    
    public CustomerDAO() {

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
    public int create(BankCustomer cust) throws SQLException {
        
        int res = -1;
        pStatement = connection.prepareStatement(CustomerDataConnection.getInsert());
        pStatement.setString(1, cust.getFirstName());
        pStatement.setString(2, cust.getLastName());
        pStatement.setString(3, cust.getEmail());
        pStatement.setString(4, cust.getPhone());
        pStatement.setString(5, cust.getBirthday());
        res = pStatement.executeUpdate();
        disconnect();
        
        return res;
    }


        // Method to retrieve a user from the database by ID
    @Override
    public BankCustomer get(int anID) throws SQLException {

        pStatement = connection.prepareStatement(CustomerDataConnection.getSelect());
        pStatement.setInt(1,anID);
        result = pStatement.executeQuery();
        
        BankCustomer updatedCust = null;
        if (result.next()) {
            updatedCust = new BankCustomer( result.getInt("id"), result.getString("first_name"), result.getString("last_name"),
          result.getString("email"), result.getString("phone"),
                    result.getString("sex"), result.getString("birthday"));
            CustomerAddressDAO addy = new CustomerAddressDAO();
            updatedCust.setAddress(addy.get(result.getInt("id")));
            AccountDAO acc = new AccountDAO();
            updatedCust.setAccounts(acc.getList(result.getInt("id")));

        }


        
        return updatedCust;
    }

    // Method to update a user Email and Phone only in the database
    //made for to update the customer details in the CustomerDetail.java class
    //only updates email and phone becuase the name, gender, and bday are all vital aspects
    //that should not be able to easily change by the use

    //IF IN THE CASE YOU NEED TO USE THE UPDATE AGAIN YOU
    @Override
    public int update(BankCustomer cust) throws SQLException {
        
        int result = -1;
        
        pStatement = connection.prepareStatement(CustomerDataConnection.getUpdate());
        pStatement.setString(1, cust.getEmail());
        pStatement.setString(2, cust.getPhone());
        pStatement.setInt(3, cust.getCustomerID());
        result = pStatement.executeUpdate();
        return result;
    }

    // Method to delete a user from the database
    @Override
    public int delete(BankCustomer cust) throws SQLException {
        
        int res = -1;
        
        pStatement = connection.prepareStatement(CustomerDataConnection.getDelete());
        pStatement.setInt(1, cust.getCustomerID());
        res = pStatement.executeUpdate();
        
        return res;
    }
    
    public HashMap validateLogin(String id) {
        
        HashMap hm = null;
        
        try {
            
            pStatement = connection.prepareStatement(CustomerDataConnection.getAdmin());
            pStatement.setString(1, id);
            result = pStatement.executeQuery();
            
            if (result.next()) {
                hm = new HashMap();
                hm.put("ID", result.getString("userid"));
                hm.put("PWD", result.getString("pwd"));
            }
            
        } catch( Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage() + " Try again..");
        }
        
        return hm;
    }



    public ArrayList getALlCustomers() throws SQLException {

        ArrayList IDList = new ArrayList();
        ArrayList custList = new ArrayList();
        //getting all the ID numbers
        pStatement = connection.prepareStatement("SELECT id FROM CS413.bankcustomer;");
        result = pStatement.executeQuery();
        while(result.next()){
            IDList.add(result.getInt("id"));
        }
        CustomerDAO d = new CustomerDAO();
        for(int x=0; IDList.size()>x;x++){
            custList.add(d.get((int) IDList.get(x)));
        }



        return custList;
    }
    
}
