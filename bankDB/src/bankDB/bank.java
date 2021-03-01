package bankDB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.io.*;

public class bank {

    private String customer;
    private double totalLoan;
    private double interest;
    private double years;


    public bank(String customer, double totalLoan, double interest, double yeras){
        this.customer = customer;
        this.totalLoan = totalLoan;
        this.interest = interest;
        this.years = yeras;
    }


    public String getCustomer(){
        return customer;
    }

    public double getTotalLoan(){
        return totalLoan;
    }

    public double getInterest(){
        return interest;
    }

    public double getYears(){
        return years;
    }

    public static double pow(double a, double b){

        double total = 1.0;
        for(int i = 0; i < b; i++){
            total *= a;
        }

        return total;
    }


    public static String printProspect(double inter, double loan, double year){
        double months = year * 12;
        double interMont = (inter/12) / 100 ;      

        double payment = loan * ((interMont* pow((1+ interMont), months)) / (pow(1+interMont,months) - 1));

        int i = (int) payment;
        
        


       

        return " wants to borrow " + loan +  "€ for a period of " + year + " years and pay "  + i + "€ each month"; 

    }

    

    public static void main(String[] args) throws Exception {    
    	
    	String st = "";
    	
        bankMain ba = new bankMain();
        
        ba.getConnection(); 
        
        JFrame frame = new JFrame("Bank");
        frame.setSize(600,200);
        frame.setVisible( true );
        JTextArea  label1 = new JTextArea ();
        label1.setLineWrap(true);
        frame.add(label1);
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        
        for(bank b :ba.getArr()) {
        	String s =  (b.getCustomer() + " " + printProspect(b.getInterest(), b.getTotalLoan(), b.getYears()));     	
        	
        	st += s + "\n";
        	
        	
        }
        
        label1.setText( st );
       
       
    }

    
}
