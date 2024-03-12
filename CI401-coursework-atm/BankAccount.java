import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileWriter;
import java.io.IOException;

// BankAccount class
// This class has instance variables for the account number, password and balance, and methods
// to withdraw, deposit, check balance etc.

// This class contains methods which you need to complete to make the basic ATM work.
// Tutors can help you get this part working in lab sessions. 

// If you choose the ATM for your project, you should make other modifications to 
// the system yourself, based on similar examples we will cover in lectures and labs.
public class BankAccount
{
    public int accNumber = 0;
    public int accPasswd = 0;
    public int balance = 0;
    
    public BankAccount()
    {
    }
    
    public BankAccount(int a, int p, int b)
    {
        accNumber = a;
        accPasswd = p;
        balance = b;
    }
    
    // withdraw money from the account. Return true if successful, or 
    // false if the amount is negative, or less than the amount in the account 
    public boolean withdraw( int amount ) 
    { 
        Debug.trace( "BankAccount::withdraw: amount =" + amount ); 
        int[] balancedArray ={0,0,0,0,0,0,0,0,0};

        // CHANGE CODE HERE TO WITHDRAW MONEY FROM THE ACCOUNT
        if (amount < 0 || balance < amount) {
            return false;
        } else {
            balance = balance - amount;  // subtract amount from balance
            balancedArray = depWitFile(balancedArray); // calls method to read text file and give back an array with all values
            depwithwrite(balancedArray); // calls method to change the balance and write it to text file
            return true; 
        }
    }
    
    // deposit the amount of money into the account. Return true if successful,
    // or false if the amount is negative 
    public boolean deposit( int amount )
    { 
        Debug.trace( "LocalBank::deposit: amount = " + amount ); 
        int[] balancedArray ={0,0,0,0,0,0,0,0,0};
        // CHANGE CODE HERE TO DEPOSIT MONEY INTO THE ACCOUNT
        if (amount < 0) {
            return false;
        } else {
            balance = balance + amount;  // add amount to balance
            balancedArray = depWitFile(balancedArray); // calls method to read text file and give back an array with all values
            depwithwrite(balancedArray); // calls write it to text file
            return true; 
        }
    }

    // Return the current balance in the account
    public int getBalance() 
    { 
        Debug.trace( "LocalBank::getBalance" ); 

        // CHANGE CODE HERE TO RETURN THE BALANCE
        return balance;
    }
    
    public  int[] depWitFile(int[] balanceArray) // method reads text file then puts all its contents into an array as well as updating balance
    {
            FileRead t = new FileRead();
            try {
                File myObj =new File("bankdetailstxt.txt"); //finds the file 
                Scanner myReader = new Scanner(myObj); // scanner is used to read fike
                balanceArray =t.readFile();
                for (int i=0; i<9; i++)
                {
                    if (balanceArray[i] ==accNumber)
                    {
                        balanceArray[i+2] = balance;// updates the text file to new balance
                    }
                }
                myReader.close();
            }
            catch(Exception e){
                Debug.trace("error reading file");//lets me know it the debug menu if an error occurred
            }
            return balanceArray;// returns array to send to the depwithwrite function
    }
    
    public static void depwithwrite(int[] balanceArray)
    {
        try {
            FileWriter myWriter = new FileWriter("bankdetailstxt.txt");
            myWriter.write("");// resets the file so it can be written to
            myWriter.close();
            FileWriter newWriter = new FileWriter("bankdetailstxt.txt", true);// true just lets me append to the file instead of resetting it each time
            for(int i=0; i<9; i++)
            {
                newWriter.write(balanceArray[i] + "\n"); // adds the contents back into the array
            }
            newWriter.close();
        }
        catch(IOException e){
            Debug.trace("file Write error"); // debug menu gives an error if it cant write 
            e.printStackTrace();
        }
    }
}
