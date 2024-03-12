import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;//used to read the text file
/**
 * Write a description of class FileRead here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FileRead
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class FileRead
     */
    public static int[] FileRead()
    {
        // initialise instance variables
        int[] accountReturn={};

        accountReturn= readFile();
        return accountReturn;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static int[] readFile()
    { 
        int[] accountArray = {0,0,0,0,0,0,0,0,0};
        try{
            File myObj = new File("bankdetailstxt.txt");
            Scanner myReader = new Scanner(myObj);
            int parsedValue;
            while (myReader.hasNextLine()){
                for (int i = 0; i<9;i++)
                {
                    String data = myReader.nextLine();
                    parsedValue = Integer.parseInt(data);
                    accountArray[i] = parsedValue;
                }                
            }
            
            
        }
        catch(FileNotFoundException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
            
        }
        return(accountArray);
    }
}
