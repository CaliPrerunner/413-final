/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Controller;

import Assignment6Model.*;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author karunmehta
 */

public class CustomerAddressDAO implements DAOInterface<CustomerAddress> {

    static Connection connection = null;
    PreparedStatement pStatement;
    ResultSet result;
    
    public CustomerAddressDAO() {

            connection = DataConnection.getDBConnection();
            int x =0;

    }
       
    
    // Method to disconnect from the database
    public static void disconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    // Method to insert a user into the database
    @Override
    public int create(CustomerAddress addr) throws SQLException {
        
        int res = -1;
        pStatement = connection.prepareStatement(AddressDataConnection.getInsert());
        pStatement.setInt(1, addr.getStreetNum());
        pStatement.setString(2, addr.getStreetName());
        pStatement.setString(3, addr.getCity());
        pStatement.setString(4, addr.getState());
        pStatement.setInt(5, addr.getZip());
      
        res = pStatement.executeUpdate();
        disconnect();
        
        return res;
    }

    // Method to retrieve a cuscustomeraddress from the database by ID
    @Override
    public CustomerAddress get(int custID) throws SQLException {

        pStatement = connection.prepareStatement(AddressDataConnection.getSelect());
        pStatement.setInt(1,custID);
        result = pStatement.executeQuery();
        
        CustomerAddress addr = null;
        if (result.next()) {
            addr = new CustomerAddress( result.getInt("custid"),result.getInt("streetnum"), result.getString("streetname"), result.getString("city"), result.getString("state"), result.getInt("zip"));
        }

        return addr;
    }
    // ADDED PERSONAL, TO GET  the customer ID's from when searched for a city
    //******************************************************

    public ArrayList getAddyID(String cityAddy) throws SQLException {

        pStatement = connection.prepareStatement(AddressDataConnection.getCitySearch());
        pStatement.setString(1, cityAddy);
        result = pStatement.executeQuery();
        CustomerAddress addr = null;
        ArrayList custID = new ArrayList();
        //will loop through the results and get the custID values form searching via the city
        while (result.next()) {
            custID.add(result.getInt("custid"));
        }
        result.close();
        return custID;
    }

    // Method to update a customeraddress in the database
    @Override
    public int update(CustomerAddress addr) throws SQLException {
        
        int result = -1;
        
        pStatement = connection.prepareStatement(AddressDataConnection.getUpdate());
        pStatement.setInt(1, addr.getStreetNum());
        pStatement.setString(2, addr.getStreetName());
        pStatement.setString(3, addr.getCity());
        pStatement.setString(4, addr.getState());
        pStatement.setInt(5, addr.getZip());
        pStatement.setInt(6, addr.getID());
        pStatement.setInt(6, addr.getID());
        result = pStatement.executeUpdate();
        
        return result;
    }

    // Method to delete a customeraddress from the database
    @Override
    public int delete(CustomerAddress addr) throws SQLException {
        
        int res = -1;
        
        pStatement = connection.prepareStatement(AddressDataConnection.getDelete());
        pStatement.setInt(1, addr.getID());
        res = pStatement.executeUpdate();
        
        return res;
    }
    
}

