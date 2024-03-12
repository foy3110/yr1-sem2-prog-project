
/**
 * Write a description of class encryption here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class encryption
{
    // instance variables - replace the example below with your own
    private int x;
    public int loops = 2;
    public int loopsArray =5;
    /**
     * Constructor for objects of class encryption
     */
    public encryption()
    {
        // initialise instance variables
        x = 0;
        String[] X ={"10001","11111","300"};
        sampleMethod(X);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(String[] y)
    {
        for (int i = 0; i<y.length ;i++)
        {
            System.out.println("y[i] = " + y[i]);
        } 
        return 0;

    }
}

