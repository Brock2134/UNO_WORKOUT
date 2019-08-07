/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unoworkouttest;

// Import packages
import java.io.FileNotFoundException;
import unoworkout.NumberCard;
import unoworkout.UnoStack;
import unoworkout.Player;
import unoworkout.Workout;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * This class is used to test both the Player and Workout classes.
 * Output is sent to a text file. 
 */
public class PlayerWorkoutTest {
    public static void main(String args[]) throws FileNotFoundException{
        
        // Sends all print output to a text file
        PrintStream fileOut = new PrintStream("PlayerWorkoutTest.txt");
        System.setOut(fileOut);
        
        // PrintWriter test
        String test = "writertest.txt";
        PrintWriter writer = new PrintWriter(test);
        
        // Constructor declaration test
        NumberCard redCard = new NumberCard("red",3,"none");
        NumberCard blueCard = new NumberCard("blue",5,"none");
        NumberCard greenCard = new NumberCard("green",9,"none");
        NumberCard yellowCard = new NumberCard("yellow",7,"none");
        
        
        // Variable declaration
        UnoStack A = new UnoStack();
        Workout B = new Workout();
        Player C = new Player();
        
        // Makes the deck
        A.MakeDeck(A, true);
        
        
        
        // iterates through the hand and prints out the current Hand
        while(A.sizeCount(A.rCount()) != 0){
            // Gets the hand
            C.getHand(A, B, C);
            
            // Displays the hand
            C.displayHand(false,writer);
            
            // Prints out the current workout
            B.printCurrent(true);
        
            // Prints out the cards left in the deck
            System.out.println(A.sizeCount(A.rCount()) + " Cards left in the deck!");
               
        }
        
        // Prints the final workout
        B.printFinal(true);
    }
}
