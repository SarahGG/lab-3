import java.util.Scanner;
import java.lang.*;

/**
 * Created by Sarah Guarino on 4/12/2017.
 */
public class LabThree {
    public static Scanner scnr = new Scanner(System.in);

    public static void main(String[] args) {
        int myNumber = -1;
        boolean doAgain = false;
        boolean correctInput = false;
        char myAnswer = 'z';

        do {
            System.out.print("Please enter an integer: ");
            myNumber = scnr.nextInt();
            System.out.println(myNumber); // FIXME: delete

            System.out.println("Do you want to go again?: ");
            do {
                // collects input the first character (a-z regardless of case), and switches to lowercase
                myAnswer = Character.toLowerCase(scnr.next("[a-zA-Z]").charAt(0));

                switch (myAnswer) {
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
                        System.out.println("Something went wrong with your switch!"); // FIXME: exception
                        correctInput = false;

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
