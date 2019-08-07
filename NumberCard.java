/**
 * unoworkout contains all the methods used in playing UNO and returning a workout regimen.
 */
// Authors: Macky McWhirter & Dylan Stuart
package unoworkout;



/**
 * Takes a color, a number, and an action and assigns it to a card.
*/
// Inheritance ~ Parent Class
public class NumberCard {
    
    // Color, Number, and action variables
    // Encapsulation
    private String color;
    private int number;
    private String action;
   

    /**
     * This is the main constructor for the NumberCard class.
     * NumberCard takes the color, number, and action and assigns
     * it to a card.
     * 
     * @param color color of the card
     * @param number number of the card
     * @param action action of the card
     */
    public NumberCard(String color,int number, String action){
        this.color = color;
        this.number = number;
        this.action = action;
    }
    
    

    /**
     * Prints out the color and the number of the card.
     */
    public void printCard(){
        System.out.println("Color:  " + color);
        System.out.println("Number: " + number);
        System.out.println("Action: " + action);
        System.out.println();
    }
    

    /**
     * @return Color of the card.
     */
    public String getColor(){
            return color;
    }
    

    /**
     * @return Number of the card.
     */
    public int getNumber(){
            return number;
    }
    

    /**
     * @return Action of the card.
     */
    public String getAction(){
            return action;
    }

}





