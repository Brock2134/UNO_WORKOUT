/**
 * unoworkout contains all the methods used in playing UNO and returning a workout regimen.
 */
// Authors: Macky McWhirter & Dylan Stuart
package unoworkout;


import java.io.PrintWriter;


/**
 * This class is in charge of setting the exercises and printing the final workout.
*/
public class Workout {
    
    
    /**
    * @param pushups pushup current amount
    * @param squats squat current amount
    * @param situps situp current amount
    * @param lunge lunge current amount
    * @param burpees burpee current amount
    * @param breakCount Counts the number of breaks in minutes
    * @param pushupTotal total amount of pushups
    * @param squatTotal total amount of squats
    * @param situpTotal total amount of situps
    * @param lungeTotal total amount of lunges
    * @param burpeeTotal total amount of burpees
    * @param CB Another variable for burpees
    * @param Ssk situps skipped
    * @param Psk pushups skipped
    * @param Lsk lunges skipped
    * @param Sqsk squats skipped
    * @param regcard card used for reverse method
    */
    
    // Encapsulation
    private int count = -1;
    public int pushups, squats, situps, lunges, burpees, breakCount = 0;
    public int pushupTotal, squatTotal, situpTotal, lungeTotal, burpeeTotal = 0, CB, Ssk, Psk, Lsk, Sqsk;
    private NumberCard regcard;
    private NumberCard Z[] = new NumberCard[7];
    
    
    
    /**
    * Default constructor used to set all situps, pushups, lunges, squats, burpees, etc.
    */
    public Workout(){
        // Sets all exercises and break times to 0
        situps = 0;
        pushups = 0;
        lunges = 0;
        squats = 0;
        breakCount = 0;
    }
    
    /**
    * Takes a card and an UnoStack object and sets the proper exercise for each card.
    * 
    * @param regcard The card object that's taken
    * @param A The UnoStack object that's taken
    */
    public void setExercise(NumberCard regcard,UnoStack A){
        // Color and number set
        String color = regcard.getColor();
        int number = regcard.getNumber();
     
        // Count iteration for reverse
        count++;
         if(count == 7){
            count = 0;
        }
        
        Z[count] = regcard;
        
        // Tests for each color case
        if(null != color)switch (color) {
            case "Red":
                if(regcard.getNumber() == 0){
                    // Counts the number of breaks
                    breakCount++;
                }
                // Looks for the skip action
                if("Skip".equals(regcard.getAction())){
                Ssk = Ssk + situps;
                situpTotal = situpTotal - situps;
                situps = 0;
                
                }
                // Looks for the Draw 2 action 
               else if("Draw 2".equals(regcard.getAction())){
                  situps = situps *2;
                  situpTotal = situps + situpTotal;
                }
                // Looks for the reverse action
               else if("Reverse".equals(regcard.getAction())){
                   situpTotal = situpTotal - situps;
                   situps = 0;
                    for(int d = 0; d <= count; d++ ){
                        // iterates and removes each other card of the same color
                        if("Red".equals(Z[d].getColor()) && !"Reverse".equals(Z[d].getAction())){
                            A.Push(Z[d]);
                            A.Shuffle();
                            
                        }
                    }
                }
                
                else{
                // adds to the total exercise and current exercise
                situps = number + situps;
                situpTotal = number + situpTotal;
                }
                break;
            case "Blue":
                if(regcard.getNumber() == 0){
                    breakCount++;
                }
                 if("Skip".equals(regcard.getAction())){
                Psk = Psk + pushups;
                pushupTotal = pushupTotal - pushups;
                pushups = 0;
                
                }
                
               else if("Draw 2".equals(regcard.getAction())){
                  pushups = pushups *2;
                  pushupTotal = pushups + pushupTotal;
                }
                
               else if("Reverse".equals(regcard.getAction())){
                   pushupTotal = pushupTotal - pushups;
                   pushups = 0;
                    for(int d = 0; d <= count; d++ ){
                        
                       
                       
                        if("Blue".equals(Z[d].getColor()) && !"Reverse".equals(Z[d].getAction())){
                            A.Push(Z[d]);
                            A.Shuffle();
                            
                        }
                    }
                }
                    
                
                
                else{
                pushups = number+pushups;
                pushupTotal = number + pushupTotal;
               }
                 
                break;
            case "Green":
                if(regcard.getNumber() == 0){
                    breakCount++;
                }
                 if("Skip".equals(regcard.getAction())){
                Lsk = Lsk + lunges;
                lungeTotal = lungeTotal - lunges;
                situps = 0;
                
                }
                
               else if("Draw 2".equals(regcard.getAction())){
                  lunges = lunges *2;
                  lungeTotal = lungeTotal + lunges;
                }
                
               else if("Reverse".equals(regcard.getAction())){
                   lungeTotal = lungeTotal - lunges;
                   lunges = 0;
                    for(int d = 0; d <= count; d++ ){
                        
                        if("Green".equals(Z[d].getColor()) && !"Reverse".equals(Z[d].getAction())){
                          A.Push(Z[d]);
                          A.Shuffle();
                          
                            
                        }
                    }
                }
                    
                
                
                else{
                lunges = number+lunges;
                lungeTotal = number + lungeTotal;
               }
                break;
            case "Yellow":
                if(regcard.getNumber() == 0){
                    breakCount++;
                }
                if("Skip".equals(regcard.getAction())){
                Sqsk = Sqsk + squats;
                squatTotal = squatTotal - squats;
                squats = 0;
                
                }
                
               else if("Draw 2".equals(regcard.getAction())){
                  squats=squats * 2;
                  squatTotal = squatTotal +squats;
                }
                
               else if("Reverse".equals(regcard.getAction())){
                   squatTotal = squatTotal - squats;
                   squats = 0;
                    for(int d = 0; d <= count; d++ ){
                      
                        if("Yellow".equals(Z[d].getColor()) && !"Reverse".equals(Z[d].getAction())){
                            A.Push(Z[d]);
                            A.Shuffle();
                            
                        }
                    }
                }
                    
                
                
                else{
                squats = number + squats;
                squatTotal = number + squatTotal;
               }
                 
                break;
            case "Black":
                    // Wild Card case
                    // Adds all burpees together 
                    burpees = burpees + 4;
                    burpeeTotal = burpeeTotal + burpees;
                    CB = burpees;
                    burpees = 0;
                if("wild".equals(regcard.getAction())){
                    // If wild, draw 4 is skipped
                }
                else if ("Wild Draw 4".equals(regcard.getAction())){
                    // All totals multiplied by 4 and added to totals and current
                    
                    squatTotal = squatTotal - squats;
                    squats = squats *4;
                    squatTotal = squatTotal + squats;
                    
                    lungeTotal = lungeTotal - lunges;
                    lunges = lunges *4;
                    lungeTotal = lungeTotal + lunges;
                    
                    pushupTotal = pushupTotal - pushups;
                    pushups = pushups *4 ;
                    pushupTotal = pushupTotal + pushups;
                    
                    situpTotal = situpTotal - situps;
                    situps = situps *4;
                    situpTotal = situpTotal +situps;
                    
                    
                }
                break;
            default:
                break;
                    
                }
        
        
       
         
        }
    
    /**
    * Prints out the current workout set based on actionChoice.
    * If choice is true, burpees are printed also.
    * @param choice Action Choice used for printing out burpees
    */
    public void printCurrent(Boolean choice){
        System.out.println("-------------------------");
        System.out.println("UNO Workout");
        System.out.println("");
        System.out.println("Pushups:  " + pushups);
        System.out.println(" Squats:  " + squats);
        System.out.println(" Situps:  " + situps);
        System.out.println(" Lunges:  " + lunges);
        
        if(choice == true){
            System.out.println("Burpees:  " + CB);
            CB = 0;
        }
        System.out.println();
        if(breakCount > 0){
            System.out.println("Take a " + breakCount + " minute break.");
        }
        
        System.out.println("-------------------------");
        
        situps = 0;
        pushups = 0;
        lunges = 0;
        squats = 0;
        breakCount = 0;
        
    }
    
    /**
    * Prints out the current workout set based on actionChoice.
    * If choice is true, burpees are printed also.
    * @param choice Action Choice used for printing out burpees
    * @param W workout class used for text file stuff.
    * @param writer File passed to be modified.
    * @param textChoice Decides whether output to a text is printed.
    */
    // Polymorphism
    public void printCurrent(Boolean choice, Workout W, PrintWriter writer, Boolean textChoice){
        if(textChoice == true){
            
        
            writer.println("-------------------------");
            writer.println("UNO Workout");
            writer.println("");
            writer.println("Pushups:  " + pushups);
            writer.println(" Squats:  " + squats);
            writer.println(" Situps:  " + situps);
            writer.println(" Lunges:  " + lunges);
            
            if(choice == true){
                writer.println("Burpees:  " + CB);
                CB = 0;
            }
            writer.println();
            if(breakCount > 0){
                writer.println("Take a " + breakCount + " minute break.");
            }
            
            System.out.println("-------------------------");
        }
        
        W.printCurrent(choice);
        
    }
    
    /**
    * Takes the action choice and prints out the final workout.
    * This method also prints the final amount of skipped exercises.
    * @param choice Action Choice used for Action Card prints.
    */
    public void printFinal(Boolean choice){
        System.out.println("-------------------------");
        System.out.println("UNO Final Workout");
        System.out.println("");
        System.out.println("Pushup Total:  " + pushupTotal);
        System.out.println(" Squat Total:  " + squatTotal);
        System.out.println(" Situp Total:  " + situpTotal);
        System.out.println(" Lunge Total:  " + lungeTotal);
        
        if(choice == true){
            System.out.println("Burpee Total:  " + burpeeTotal);
            System.out.println();
            System.out.println("Pushups Skipped: "+ Psk);
            System.out.println(" Squats Skipped: "+ Sqsk);
            System.out.println(" Situps Skipped: "+ Ssk);
            System.out.println(" Lunges Skipped: "+ Lsk);
        }
        
        System.out.println("-------------------------");
    }
    
    /**
    * Takes the action choice and prints out the final workout.
    * This method also prints the final amount of skipped exercises.
    * @param choice Action Choice used for Action Card prints.
    * @param W workout class used for text file stuff.
    * @param writer File passed to be modified.
    * @param textChoice Decides whether output to a text is printed.
    */
    // Talk about use of Polymorphism for this function and other Print Final
    public void printFinal(Boolean choice, Workout W, PrintWriter writer, Boolean textChoice){
        if(textChoice == true){
            
        
            writer.println("-------------------------");
            writer.println("UNO Final Workout");
            writer.println("");
            writer.println("Pushup Total:  " + pushupTotal);
            writer.println(" Squat Total:  " + squatTotal);
            writer.println(" Situp Total:  " + situpTotal);
            writer.println(" Lunge Total:  " + lungeTotal);
        
            if(choice == true){
                writer.println("Burpee Total:  " + burpeeTotal);
                writer.println();
                writer.println("Pushups Skipped: "+ Psk);
                writer.println(" Squats Skipped: "+ Sqsk);
                writer.println(" Situps Skipped: "+ Ssk);
                writer.println(" Lunges Skipped: "+ Lsk);
            }
            
            writer.println("-------------------------");
        
        }
        
        W.printFinal(choice);
    }
    
}

    
   