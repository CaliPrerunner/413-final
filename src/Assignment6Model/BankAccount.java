/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment6Model;

import java.text.DecimalFormat;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author karunmehta
 */
public abstract class BankAccount implements Comparable<BankAccount> {
    
    // Create instance variables
    public int accountNum;
    public LocalDate createDate;
    public LocalDate lastUpdatedDate;
    public double balance;
    public String accType;
    public int custID;
    public int odLimit;
    public double intRate;
    public List transactions = new ArrayList<BankAccountTransaction>();


    static String bankName = "DefaultBankName";
    private int currentNumber = 0;

    // Fully parameterized constructor
    BankAccount(int accountNum,int custID, double balance,LocalDate createDate, String accType, int odLimit, int intRate, List transactions) {
        this.accountNum = accountNum;
        this.createDate = createDate;
        this.balance = balance;
        this.accType = accType;
        this.custID = custID;
        this.odLimit = odLimit;
        this.intRate = intRate;
        this.transactions = transactions;
    }

    public BankAccount() {

    }

    public void setAccType(String s){
        this.accType = s;
    }

    public void setAccountNum(int accountNum){
        this.accountNum = accountNum;
    }

    public void setCustID(int custID){
        this.custID = custID;
    }
    public void setLastUpDate(LocalDate d){
        this.lastUpdatedDate=d;
    }

    public void setOdLimit(int odLimit){
        this.odLimit = odLimit;
    }

    public void setIntRate(double intRate){
        DecimalFormat df = new DecimalFormat("0.00");
        this.intRate = Double.valueOf(df.format(intRate));
    }

    public void setTransactions(List transactions){
        this.transactions = transactions;
    }

    public LocalDate getCreateDate(){
        return this.createDate;
    }

    public void setBalance(double b){
        this.balance =b;
    }

    public void setCreateDate(LocalDate d){
        this.createDate = d;
    }

    public int getAccountNum(){
        return accountNum;
    }
    public int getCustID(){
        return custID;
    }
    public String getAccType(){
        return accType;
    }
    public double getBalance(){
        return balance;
    }
    public double getIntRate(){
        return intRate;
    }
    public int getOverD(){
        return odLimit;
    }
    public ArrayList getTransactions(){return (ArrayList)transactions;}

    public void deposit(double d){
        this.balance += d;
    }
    public void withdraw(double d){
        this.balance -= d;
    }
    public void transfer(BankAccount destination, double ammount) {
        if(ammount < balance){
            destination.deposit(ammount);
        }else{
            System.out.println("Transaction failed");
        }

    }
    public String getAccString(){
        if(accType.equals("Checking")){
            return "Checking";
        }else{
            return "Savings";
        }
    }
    public String toString(){
        return "Account Number: " + accountNum+ " Account Type: " + this.getAccString() +" Balance: " + balance
                + " Interest Rate: " + intRate+ "%";
    }

}