/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Kristi
 */
public class Account {
    //instance variables
    private int balance;
    private int previousTransaction;
    private String customerName;
    private String customerID;
    
    //constructor
    public Account(String cname, String cid){
        customerName = cname;
        customerID = cid;
    }
    
    //function to deposit money
    public void deposit(int amount){
        if(amount > 0) {
            balance += amount;
            previousTransaction = amount;
        } else {
            System.out.println("Error, cannot deposit negative or zero amount.");
        }
    }
    
    //function for withdrawing money
    public void withdraw(int amount) {
        if(amount > 0) {
            balance -= amount;
            previousTransaction = -amount;
        } else {
            System.out.println("Error, cannot withdraw negative or zero amount.");
        }
    }
    
    //recall the previous transaction
    public void getPreviousTransaction() {
        if(previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred.");
        }     
    }
    
    //calculates the accrued interest over a number of years
    public void calculateInterest(int years) {
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is: " + (100 * interestRate));
        System.out.println("After " + years + "years, your balance will be: " + newBalance);
    } 
    
    //shows a menu of possible transactions
    public void showMenu() {
        char option = '\0';
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");
        
        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char inValue = in.next().charAt(0);
            option = Character.toUpperCase(inValue);
            System.out.println();
            
            switch(option) {
                //option A will return a user's balance
                case 'A' :
                    System.out.println("=============================");
                    System.out.println("Balance: $" + balance);
                    System.out.println("=============================");
                    System.out.println();
                    break;
                //option B will allow a user to make a deposit to their account
                case 'B' :
                    System.out.println("Enter the amount you will deposit: ");
                    int toDeposit = in.nextInt();
                    deposit(toDeposit);
                    System.out.println();
                    break;
                //option C will allow a user to make a withdrawal from their account
                case 'C' :
                    System.out.println("Enter the amount you will withdraw: ");
                    int toWithdraw = in.nextInt();
                    withdraw(toWithdraw);
                    System.out.println();
                    break;
                //option D will show a user the previous transaction
                case 'D' :
                    System.out.println("=============================");
                    getPreviousTransaction();
                    System.out.println("=============================");
                    System.out.println();
                    break;
                //will prompt for a number of years and return accrued interest for that time frame
                case 'E' :
                    System.out.println("Enter number of years of accrued interest: ");
                    int yearsAccrued = in.nextInt();
                    calculateInterest(yearsAccrued);
                    break;
                //will exit the application
                case 'F' :
                    System.out.println("=============================");
                    break;
                //default: invalid character error message
                default :
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E, or F to exit.");
                    break;
            }
        } while(option != 'F');
        
        System.out.println("Thank you for banking with us!");
    }
}
