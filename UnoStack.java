/**
 * unoworkout contains all the methods used in playing UNO and returning a workout regimen.
 */
// Authors: Macky McWhirter & Dylan Stuart
package unoworkout;

// Import packages
import java.util.*; 


/**
 * All methods regarding the card deck.
*/
// inheritance ~ Sub class (Stacks of cards)
public class UnoStack {
    /**
    * @param top Top of the stack
    * @param MAX max stack amount
    * @param count used for calculating size of the deck
    * @param a stack used for the deck
    */
    // Encapsulation
    private static final int MAX = 1000;
    private int top;
    public static int count = 0;
    private NumberCard a[]= new NumberCard[MAX];

    /**
    * Default Constructor for UnoStack.
    * 
    * Sets a negative value for the Stack.
    */
    public UnoStack(){
        top = -1;   
    }

    /**
    * Pushes a card onto the deck.
    * 
    * @param x NumberCard object
    */
    public void Push(NumberCard x){
        sizeCount(count++);
        a[++top]= x;
    }
    
    /**
    * Removes a card from the deck.
    */
    public NumberCard pop(){
        NumberCard x;
    
        if(top < 0){
            return null;
        }
        else{
   
            x = a[top--];
            sizeCount(count--);
            return x;
        }
    
    }

    /**
     * Shuffles the deck.
    */
    public void Shuffle(){
        
	Random rgen = new Random();  		
 
	for (int i=0; i<top; i++) {
            int R = rgen.nextInt(top);
            NumberCard temp = a[i];
            a[i] = a[R];
            a[R] = temp;
	}
    }
  

    /**
    * Creates a standard UNO deck.
    * The deck that is generated is based on whether or not
    * the user decides to include action cards.
    * 
    * @param A An object of the UnoStack class.
    * @param actionChoice Boolean choice for action cards.
    */
    public void MakeDeck(UnoStack A, Boolean actionChoice){
      
        int i = 0;
            
        NumberCard Card1 = new NumberCard( "Red", 0, "none");
        A.Push(Card1); 
            
        NumberCard Card2 = new NumberCard( "Green", 0, "none");
        A.Push(Card2); 
            
        NumberCard Card3 = new NumberCard( "Yellow", 0, "none");
        A.Push(Card3); 
            
        NumberCard Card4 = new NumberCard( "Blue", 0, "none");
        A.Push(Card4); 
            
            
            
        for(i = 1; i < 39; i++){
            if(i < 10){
                NumberCard Card = new NumberCard( "Red", i, "none");
                A.Push(Card);
                A.Push(Card); 
            }
                
            else if(i < 19){
                if(i-9 == 0){
                }
                
                
                NumberCard Card5 = new NumberCard( "Blue", i-9, "none");
                A.Push(Card5);
                A.Push(Card5);
                }       
                        
            else if( i < 29 ){
                if(i-19==0){
                    
                }
                else{
                    NumberCard Card6 = new NumberCard( "Yellow", i-19, "none");
                    A.Push(Card6);
                    A.Push(Card6);
                }
            }   
            else{
                if(i-29==0){
                    
                }
                else {
                    NumberCard Card7 = new NumberCard( "Green", i-29, "none");
                    A.Push(Card7);
                    A.Push(Card7);
                }
                    
            }
        }
            
        if(actionChoice == true){
                 
            NumberCard Card9 = new NumberCard( "Blue", 11, "Skip");
            A.Push(Card9);
            A.Push(Card9);
            NumberCard Card10 = new NumberCard( "Blue", 10, "Draw 2");
            A.Push(Card10);
            A.Push(Card10);
            NumberCard Card11 = new NumberCard( "Blue", 12, "Reverse");
            A.Push(Card11);
            A.Push(Card11);
                
            NumberCard Card12 = new NumberCard( "Red", 11, "Skip");
            A.Push(Card12);
            A.Push(Card12);
            NumberCard Card13 = new NumberCard( "Red", 10, "Draw 2");
            A.Push(Card13);
            A.Push(Card13);
            NumberCard Card14 = new NumberCard( "Red", 12, "Reverse");
            A.Push(Card14);
            A.Push(Card14);
                
            NumberCard Card15 = new NumberCard( "Yellow", 11, "Skip");
            A.Push(Card15);
            A.Push(Card15);
            NumberCard Card16 = new NumberCard( "Yellow", 10, "Draw 2");
            A.Push(Card16);
            A.Push(Card16);
            NumberCard Card17 = new NumberCard( "Yellow", 12, "Reverse");
            A.Push(Card17);
            A.Push(Card17);
                
            NumberCard Card18 = new NumberCard( "Green", 11, "Skip");
            A.Push(Card18);
            A.Push(Card18);
            NumberCard Card19 = new NumberCard( "Green", 10, "Draw 2");
            A.Push(Card19);
            A.Push(Card19);
            NumberCard Card20 = new NumberCard( "Green", 12, "Reverse");
            A.Push(Card20);
            A.Push(Card20);
                
            NumberCard Card21 = new NumberCard( "Black", -6, "Wild");
            A.Push(Card21);
            A.Push(Card21);
            A.Push(Card21);
            A.Push(Card21);
            NumberCard Card22 = new NumberCard( "Black", -5, "Wild Draw 4");
            A.Push(Card22);
            A.Push(Card22);
            A.Push(Card22);
            A.Push(Card22);       
        }
    }

    /**
    * Used to control the size of the deck.
    */
    public int sizeCount(int x){
        return x;
    }
    
    /**
    * Used to control the sorting of the deck.
    */
    public int rCount(){
        return count;
    }
    
    /**
    * Used to print the deck for testing purposes.
    * 
    * @param actionChoice Used to determine whether action cards are used
    * @param A UnoStack used to make and print the deck
    * 
    */
    public void printDeck(Boolean actionChoice,UnoStack A){
        A.MakeDeck(A, actionChoice);
        
        if(actionChoice == true){
            for(int i = 0; i < top; i++){
               a[i].printCard(); 
            }
        }
        else{
            for(int i = 0; i < top; i++){
                a[i].printCard();
            }
        }
        
    }
    
}
    

    

