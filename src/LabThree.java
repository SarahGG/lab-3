import java.util.Scanner;
import java.lang.Math;

/**
 * Displays a number of powers for
 * each integer starting from 1 to
 * the integer indicated by the
 * user
 *
 * @author Sarah Guarino
 * @author Marin Bizbiqi
 * @version 1.1
 */
public class LabThree {
    private static Scanner scnr = new Scanner(System.in);
    private static boolean doAgain = false;
    private static boolean correctInput;
    private static char userContinueCheck = 'z';
    
    private static void checkInput() {
        boolean correctInput;
        char userContinueCheck = 'z';
        
        do {
            // collects input the first character (a-z regardless of case)
            // switches to lowercase
            userContinueCheck = Character.toLowerCase(scnr.next("[a-zA-Z]").charAt(0));
            
            if (userContinueCheck == 'y') {
                correctInput = true;
                doAgain = true;
            }
            else if (userContinueCheck == 'n') {
                correctInput = true;
                doAgain = false;
                System.out.println("Goodbye!");
            }
            else if (userContinueCheck == 'z') {
                // this is my initialized test value - if I get this, I messed something up
                System.out.println("Something went wrong with your switch!");
                correctInput = false;
            }
            else {
                System.out.println("Incorrect input, please try again!");
                correctInput = false;
            }
        }
        // only repeats if user input y or n
        while(!correctInput);
    }

    public static void main(String[] args) {
        int userInput = -1;
        int baseNum;
        int[][] myPowerArray;
        
        do {
            // collects the integer from the user
            System.out.print("Please enter an integer: ");
            userInput = scnr.nextInt();
            System.out.println();

            // converts last column's cube to a string
            String lastCube = Integer.toString((int)Math.pow((double)userInput, 3.0));
            // gets that string's length
            int lastCubeLength;
            // if strings length is shorter than my longest title item, make it that instead
            if (lastCube.length() < 8) {
                lastCubeLength = 8;
            }
            else {
                lastCubeLength = lastCube.length();
            }

            // prints the header to the table
            System.out.printf("%-" + lastCubeLength + "s\t\t%-" + lastCubeLength + "s\t\t%-" + lastCubeLength + "s\n", "Base", "Squared", "Cubed");
            System.out.printf("%-" + lastCubeLength + "s\t\t%-" + lastCubeLength + "s\t\t%-" + lastCubeLength + "s\n", "========", "========", "========");

            // initializes my array
            myPowerArray = new int[userInput][3];

            // prints the base number, square, and cube
            for(int i = 0; i < userInput; i++) {

                // baseNum will increment along with i, but will start at 1 and not 0
                baseNum = i + 1;

                // defines column i, row 1
                myPowerArray[i][0] = baseNum;
                //defines column i, row 2
                //takes baseNum, explicitly converts this to a double using the (double) prefix
                //uses Math.pow(double, double) to bring baseNum to the power of 2.0
                //converts this "square" back to an integer with (int) prefix
                myPowerArray[i][1] = (int)Math.pow((double)baseNum, 2.0);
                //repeats this process with exponent 3.0 to create a "cube"
                myPowerArray[i][2] = (int)Math.pow((double)baseNum, 3.0);

                //prints my base, square, and cube in the appropriate formatting
                System.out.printf("%-" + lastCubeLength + "d\t\t%-" + lastCubeLength + "d\t\t%-" + lastCubeLength + "d\n", myPowerArray[i][0], myPowerArray[i][1], myPowerArray[i][2]);
            }
            
            System.out.println();
            System.out.print("Do you want to go again?: ");
            checkInput();
        }
        // only repeats if user input y
        while(doAgain);
    }
}
