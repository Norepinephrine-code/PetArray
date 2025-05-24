import java.util.*;
import java.lang.*;

public class PetArray
{
    public static void main(String[] args)
    {
        int[][] ages; // 2D array where ages will be stored. human age is rows. dog age is columns
        Scanner sc = new Scanner(System.in);
        int i, j, human, dog;
        
        System.out.print("Enter the total number of humans: ");
        human = sc.nextInt();
        ages = new int[human][]; // instantiated the row with scanned number of humans

        for (i = 0; i < human; i++)
        {

            System.out.print("Enter total number of dogs for Human " + (i+1) + ": ");
            dog = sc.nextInt() + 1; // +1 is added to make up enough space for dog age since human age is in the first column
            ages[i] = new int[dog]; // instantiated the column with scanned number of dogs per human

            do{ //
                System.out.print("Enter age of Human " + (i+1) + ": ");
                ages[i][0] = sc.nextInt();

                if (ages[i][0] < 1) // Input checking
                    System.out.println("Invalid age.");

            } while(ages[i][0] < 1);


            
            for (j = 1; j < dog; j++) {
                do{
                System.out.println("Enter age of dog " + j + " (in human years)" + " for Human " + (i+1) + ": ");
                ages[i][j] = sc.nextInt();

                if (ages[i][j] < 1) // Input checking
                    System.out.println("Invalid age.");

                }while(ages[i][j] < 1);
            }
        }
        sc.close();
            /*
                   1. Display Logic
                   2. Dog Age calculation
             */

        if (human>0) { // Check if there are humans to display
            System.out.println("============ Displaying Human and Dogs Table ============");
            for (i = 0; i<human;i++) {                          // Loop through all the humans
                System.out.println("Human "+ (i+1)+", age " + ages[i][0]);

                if (ages[i].length>1) {                         // Check if human has dogs. Length == 1 is human age.
                    for (j = 1; j<ages[i].length;j++) {

                        int dogAge = (int)Math.round(16 * Math.log(ages[i][j]) + 31);

                        if (ages[i][0] == dogAge) {
                            System.out.print("\t= ");
                        } else if (ages[i][0] < dogAge) {
                            System.out.print("\t< ");
                        } else if (ages[i][0] > dogAge) {
                            System.out.print("\t> ");
                        }

                        System.out.println(ages[i][j]);
                    }

                } else {
                    System.out.print("\tThis human has no dogs :("); // If none, display this.
                }
                System.out.print("\n");
            }
        } else {
            System.out.println("There are no humans.");
        }
        System.out.println("=========================================================");


    }
}
