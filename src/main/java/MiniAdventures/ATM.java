package MiniAdventures;

import java.util.Scanner;
public class ATM {
    Scanner in = new Scanner(System.in);
    private double total = 200;
    private String counter = "";

    public String setDeposit(){
        System.out.print("Enter an amount to deposit: ");
        double amount = in.nextDouble();
        String conversion = String.valueOf(amount);
        counter+="\nInitial Balance: "+ total + "\nDeposited: "+ conversion+"\n";
        total+=amount;
        return "Payment Complete!";
    }
    public String setWithdraw(){
        System.out.print("Enter an amount to withdraw: ");
        double amount = in.nextDouble();
        String conversion = String.valueOf(amount);
        counter+="Withdrawal: "+ conversion+"\n";
        total-=amount;
        return "Payment Complete!";
    }
    public String setPayment(){
        System.out.print("Press 1 - Hydro, Press 2 - Gas: ");
        int input = in.nextInt();
        System.out.print("Enter an amount to pay bill: ");
        double amount = in.nextDouble();
        String conversion = String.valueOf(amount);
        counter+="Payment: "+ conversion+"\n";
        total-=amount;
        if(input==1){
            return "Hydro Payment Complete!";
        }
        else{
            return "Gas Payment Complete!";
        }
    }
    public String setTransfer(){
        System.out.print("Enter transfer amount: ");
        double amount = in.nextDouble();
        String conversion = String.valueOf(amount);
        counter+="Transfer: "+ conversion+"\n";
        total-=amount;
        return "Transfer complete!";
    }
    public String getReceipt(){
        return counter+"Final Balance: "+total;
    }
}