/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unoworkouttest;

import java.io.FileNotFoundException;
import unoworkout.NumberCard;
import java.io.PrintStream;

/**
 * This class tests all the methods of the NumberCard class.
 * Output is printed to a text file.
 */
public class NumberCardTest {
    public static void main(String args[]) throws FileNotFoundException{
        
        // Sends all print output to a text file
        PrintStream fileOut = new PrintStream("NumberCardTest.txt");
        System.setOut(fileOut);
        
        // Constructor declaration test
        NumberCard redCard = new NumberCard("red",3,"none");
        NumberCard blueCard = new NumberCard("blue",5,"none");
        NumberCard greenCard = new NumberCard("green",9,"none");
        NumberCard yellowCard = new NumberCard("yellow",7,"none");
        
        // -6 used for sorting purposes in UnoStack
        NumberCard wildCard = new NumberCard("black",-6,"wild");
        
        // Get action method test
        String redcardAction = redCard.getAction();
        System.out.println(redcardAction);
        
        String bluecardAction = blueCard.getAction();
        System.out.println(bluecardAction);
        
        String greencardAction = greenCard.getAction();
        System.out.println(greencardAction);
        
        String yellowcardAction = yellowCard.getAction();
        System.out.println(yellowcardAction);
        
        String wildcardAction = wildCard.getAction();
        System.out.println(wildcardAction);
        
        // Get color method test
        String redcardColor = redCard.getColor();
        System.out.println(redcardColor);
        
        String bluecardColor = blueCard.getColor();
        System.out.println(bluecardColor);
        
        String greencardColor = greenCard.getColor();
        System.out.println(greencardColor);
        
        String yellowcardColor = yellowCard.getColor();
        System.out.println(yellowcardColor);
        
        String wildcardColor = wildCard.getColor();
        System.out.println(wildcardColor);
        System.out.println();
        
        // Print Card test
        redCard.printCard();
        blueCard.printCard();
        greenCard.printCard();
        yellowCard.printCard();
        wildCard.printCard();
        
        
        
    }
}
