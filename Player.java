/**
 * unoworkout contains all the methods used in playing UNO and returning a workout regimen.
 */
// Authors: Macky McWhirter & Dylan Stuart
package unoworkout;

// Import packages
import java.io.PrintWriter;


/**
 * All methods regarding the Player's Hand.
*/
// Inheritance 
public class Player {
    
    // Encapsulation
    private static final int MAXX = 7;
    private int popcount = 0;
    private int popcount2 = 0;
    private int POPPERS = 0;
    private int popcount4 = 1;
    private NumberCard Hand[]= new NumberCard[MAXX];
    private int count = 0;
    
    
    /**
    * Creates the Hand for the player.
    * 
    * 
    * @param A An object of the deck class.
    * @param B An object of the workout class.
    * @param C An object of the player class.
    */
    public void getHand(UnoStack A, Workout B, Player C){
        
        for(int i = 0; i < MAXX; i++ ){ 
            if(A.rCount() != 0){
                Hand[i] = A.pop();
                popcount++;
                popcount2++;
                popcount4++;  
            }
            else{
                i = MAXX;
            }
        }
        
        POPPERS = popcount4;
        popcount4 = 1;
        
        C.sortRank();
        C.sortColor();
       
        for(int k = 0; k < MAXX; k++){
                
            if(popcount != 0){
                B.setExercise(Hand[k],A);
                popcount--;
            }
                
            else{
                k = MAXX;
            }
        }       
    }
   
     
    /**
    * Displays the Hand.
     * @param textChoice Decides whether to print output to text 
     * @param writer File where everything gets printed out
    */
    public void displayHand(Boolean textChoice,PrintWriter writer) {
        
            for(int j = 0; j < MAXX; j++){
                if(popcount2 != 0){
                
                    popcount2--;
                    System.out.println("-------------------------");
                    System.out.println(Hand[j].getColor());
                    
                    if(textChoice == true){
                        writer.println("-------------------------");
                        writer.println(Hand[j].getColor());
                    }
                    
                
                    if("none".equals(Hand[j].getAction())){
                        System.out.println(Hand[j].getNumber());
                        if(textChoice == true){
                            writer.println(Hand[j].getNumber());
                        }
                        
                    }
                    else{
                        System.out.println(Hand[j].getAction());
                        if(textChoice == true){
                            writer.println(Hand[j].getAction());
                        } 
                    }
                }   
            
                else{
                    j = MAXX;
                }
                
            }   
        
        
        
    }
    
    
    /**
    * Sorts the cards by rank.
    */
    public void sortRank(){
        
        NumberCard temp;
        int j;
    
        for (int i=1; i<POPPERS-1; i++) {
             
            for (j = i; j > 0; j--) {
           
                if (Hand[j].getNumber() < Hand[j - 1].getNumber()) {
                    temp = Hand[j];
                    Hand[j] = Hand[j - 1];
                    Hand[j - 1] = temp;
                }
            }
        }
    }
    
        
    /**
    * Sorts the cards by color.
    */
    public void sortColor(){
        NumberCard temp;
        int j;
        
        for (int i=1; i<POPPERS-1; i++) {

            for (j = i; j > 0; j--) {
        
                if (Hand[j].getColor().compareTo(Hand[j - 1].getColor()) > 0 ) {
                    temp = Hand[j];
                    Hand[j] = Hand[j - 1];
                    Hand[j - 1] = temp;
                }
            }
        
        }
    }    
}