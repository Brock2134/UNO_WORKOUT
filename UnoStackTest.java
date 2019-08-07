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
import java.io.PrintStream;

/**
 * This class tests all the methods of the UnoStack class.
 * Output is printed to a text file.
 */
public class UnoStackTest {
    public static void main(String args[]) throws FileNotFoundException{
        
        // Sends all print output to a text file
        PrintStream fileOut = new PrintStream("UnoStackTest.txt");
        System.setOut(fileOut);
        
        // Constructor declaration test
        NumberCard redCard = new NumberCard("red",3,"none");
        NumberCard blueCard = new NumberCard("blue",5,"none");
        NumberCard greenCard = new NumberCard("green",9,"none");
        NumberCard yellowCard = new NumberCard("yellow",7,"none");
        
        // -6 used for sorting purposes in UnoStack
        NumberCard wildCard = new NumberCard("black",-6,"wild");
        
        // UnoStack constructor declaration test
        UnoStack A = new UnoStack();
        UnoStack B = new UnoStack();
        UnoStack C = new UnoStack();
        
        // UnoStack A manual push
        System.out.println("--------------------");
        A.Push(redCard);
        A.Push(blueCard);
        A.Push(greenCard);
        A.Push(yellowCard);
        A.Push(wildCard);
        
        // A prints deck and size
        A.printDeck(true, A);
        System.out.println("--------------------");
        int aCount = A.sizeCount(A.rCount());
        
        System.out.println(aCount);
        System.out.println("--------------------");
        // Shuffle test
        A.Shuffle();
        A.Shuffle();
        A.Shuffle();
        
        A.printDeck(true, A);
        System.out.println("--------------------");
        
        // pop test
        A.pop();
        A.pop();
        A.pop();
        A.pop();
        A.pop();
        System.out.println("--------------------");
        // size check
        A.sizeCount(A.rCount());
        System.out.println("--------------------");
        
        
        
        // make deck function test for false and true action cards
        B.MakeDeck(B, true);
        System.out.println("--------------------");
        int bCount = B.sizeCount(B.rCount());
        System.out.println(bCount);
        System.out.println("--------------------");
        B.printDeck(true, B);
        System.out.println("--------------------");
        C.MakeDeck(C, false);
        System.out.println("--------------------");
        C.sizeCount(C.rCount());
        System.out.println("--------------------");
        C.printDeck(false, C);
        System.out.println("--------------------");
        
        
    }
}
