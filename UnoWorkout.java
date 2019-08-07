/**
 * unoworkout contains all the methods used in playing UNO and returning a workout regimen.
 */

// Authors: Macky McWhirter & Dylan Stuart
package unoworkout;

// Import packages
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Main input for the UNO workout class.
*/
public class UnoWorkout {

    // Scan input
    static Scanner scan = new Scanner(System.in);
    
    /**
     * The main method allows the user to play the game.
     * This allows the user to set game settings such as
     * allowing action cards, amount of decks to be used,
     * and how the user wants those decks shuffled.
     * 
     * @param args Basic command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        
       
       // Variable initialization
       UnoStack A = new UnoStack();
       Player B = new Player();
       Workout C = new Workout();
       int deckAmt;
       int shuffleChoice;
       Boolean actionChoice, textChoice;
       
       // Checks for text file output
       System.out.println("Would you like to save output to a text file? (y/n)");
       char text = Character.toLowerCase(scan.next().charAt(0));
      
       String fileName = "UNO-output.txt";
       PrintWriter outputStream = new PrintWriter(fileName);

       if(text == 'y'){
           textChoice = true;
           outputStream.println("UNO Workout Game Text File");
       }
       
       else{
           textChoice = false;
       }
       
       // Deck amount
       System.out.println("How many Decks : 1, 2 ,3?");
       deckAmt = scan.nextInt();
       
       // Action card choice
       System.out.println("Do you want the action cards included? (y/n)");
       char act = Character.toLowerCase(scan.next().charAt(0));
        
       if(act == 'y'){
          actionChoice = true;
       }
       else{
          actionChoice = false;
       }
       
       // Shuffle options
       System.out.println("Shuffle Together(1) or Individually(2) or No shuffle(any other number)" );
       shuffleChoice = scan.nextInt();
        
       if(deckAmt == 1 || deckAmt == 2 || deckAmt == 3){
            for(int w = 0; w < deckAmt; w++){
            
        
                A.MakeDeck(A, actionChoice);
                    if(shuffleChoice == 2){
                        A.Shuffle();
                    }
            }
            
                    if(shuffleChoice == 1){
                        A.Shuffle();
                    }
       }
       else{
             System.out.println("ERROR DID NOT CHOOSE 1, 2, 3");
       }
       
       
        // returns size of the deck
        A.sizeCount(A.rCount());
        
        
        // Iterates through each hand and prints the current workout for each one
        while(A.sizeCount(A.rCount()) != 0){
            // Gets the hand
            B.getHand(A, C, B);
            
            // Displays the hand
            B.displayHand(textChoice, outputStream);
            
            // Prints the current workout
            C.printCurrent(actionChoice,C,outputStream,textChoice);
            
            // Prints out cards left in the deck
            System.out.println(A.sizeCount(A.rCount()) + " Cards left in the deck!");
            
            // prints to text file if true
            if(textChoice == true){
                outputStream.println(A.sizeCount(A.rCount()) + " Cards left in the deck!");
            }
                
        }
       // Prints the final UNO workout
       C.printFinal(actionChoice,C,outputStream,textChoice);
       
       // Closes the print file
       outputStream.close();
    }
    
}
