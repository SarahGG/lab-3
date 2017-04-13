import java.util.Scanner;
import java.lang.*;

/**
 * Displays a number of powers for
 * each integer starting from 1 to
 * the integer indicated by the
 * user
 *
 * @author Sarah Guarino
 * @version 1.0
 */
public class LabThree {
    private static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        int userInput = -1;
        int baseNum;
        int[][] myPowerArray;
        boolean doAgain = false;
        boolean correctInput;
        char startOver = 'z';


        do {
            System.out.print("Please enter an integer: ");
            userInput = scnr.nextInt();
            System.out.println();

            System.out.println("Number\t\tSquared\t\tCubed");
            System.out.println("======\t\t======\t\t======");

            myPowerArray = new int[userInput][3];

            for(int i = 0; i < userInput; i++) {
                baseNum = i + 1;
                myPowerArray[i][0] = baseNum;
                myPowerArray[i][1] = (int)Math.pow((double)baseNum, 2.0);
                myPowerArray[i][2] = (int)Math.pow((double)baseNum, 3.0);
                System.out.println(myPowerArray[i][0] + "\t\t\t" + myPowerArray[i][1] + "\t\t\t" + myPowerArray[i][2]);
            }

            System.out.println();
            System.out.print("Do you want to go again?: ");
            do {
                // collects input the first character (a-z regardless of case), and switches to lowercase
                startOver = Character.toLowerCase(scnr.next("[a-zA-Z]").charAt(0));

                switch (startOver) {
                    case 'y':
                        correctInput = true;
                        doAgain = true;

                        break;
                    case 'n':
                        correctInput = true;
                        doAgain = false;
                        System.out.println("Goodbye!");

                        break;
                    case 'z':
                        System.out.println("Something went wrong with your switch!");
                        correctInput = false;
                        break;

                    default:
                        System.out.println("Incorrect input, please try again!");
                        correctInput = false;

                        break;
                }
            }
            while(!correctInput);
        }
        while(doAgain);
    }
}
