import javafx.application.Application;
import javafx.stage.Stage;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;//used to read the text file
// atm project Main class
// The code here creates the ATM GUI interface and model functionality, but the methods
// in the BankAccount class which actually do the banking functions are incomplete.
// The lab class exercise (with tutor support) is to complete the BankAccount.
// The assessment project is to add further functionality as discussed in lectures and 
// seminars. Tutors may not help directly with this but will talk you through examples and
// answer questions.
public class Main extends Application
{
    public static void main( String args[] )
    {
        // The main method only gets used when launching from the command line
        // launch initialises the system and then calls start
        // In BlueJ, BlueJ calls start itself
        launch(args);
    }
    

    public void start(Stage window) 
    {
        // set up debugging and print initial debugging message
        Debug.set(true);             
        Debug.trace("atm starting"); 
        Debug.trace("Main::start"); 
        // Create a Bank object for this ATM
        Bank b = new Bank();
        // creates an insatnce of file reader
        FileRead t = new FileRead();
        //calls the method  to read the file
        int[] accountReturn= t.readFile();
        for(int i = 0; i<9;){
        b.addBankAccount(accountReturn[i],accountReturn[i+1],accountReturn[i+2]);
        i=i+3;
    }
        // Create the Model, View and Controller objects
        Model model = new Model(b);   // the model needs the Bank object to 'talk to' the bank
        View  view  = new View();
        Controller controller  = new Controller();

        // Link them together so they can talk to each other
        // Each one has instances variable for the other two
        model.view = view;
        model.controller = controller;
        
        controller.model = model;
        controller.view = view;
        
        view.model = model;
        view.controller = controller;

        // start up the GUI (view), and then tell the model to initialise and display itself
        view.start(window);
        model.initialise("Welcome to the ATM"); 
        model.display();   

        // application is now running
        Debug.trace("atm running"); 
    }
}
