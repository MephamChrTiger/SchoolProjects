
package navigation;
import java.util.Scanner;
/**
 *
 * @author s01164417
 */
public class Navigation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Location[] locationArray = new Location[7]; 
        boolean trigger = true; //need this for while loop 
        Location placeH = new Location("",0,0,true); //Random placeholder I need
        locationArray[0] = new Location("Cleveland", 0, 0, true);
        locationArray[1] = new Location("North Pole", 500, -100, true);
        locationArray[2] = new Location("Campbell Hill", -50, -50, false);
        locationArray[3] = new Location("Tokyo", -100, 1000, true);
        locationArray[4] = new Location("Chicago", -200, 75, true);
        locationArray[5] = new Location("Erie PA", 150, 0, true);
        locationArray[6] = new Location("Allegheny Nation Forest", 300, -75, false);
        
        System.out.println("Welcome to truck driving simulator! Create a new truck below: \n Enter Max Fuel Capacity: ");
        double maxFuel = input.nextDouble(); 
        
        System.out.println("Max fuel is now: " + maxFuel + " gallons");
        System.out.println("Enter your truck's MPG: ");
        double mpg = input.nextDouble();
        System.out.println("You have a current range of: " + (maxFuel * mpg));

        Truck t1 = new Truck(locationArray[0],maxFuel,maxFuel,mpg);
        System.out.println("New truck has been created!");
        
        while(trigger == true){
            System.out.println("What would you like to do? \n 1) Drive to new location \n 2) Refuel \n 3) Get information on location");
            System.out.println(" 4) Quit"); 
            int choice = input.nextInt();
            
            if(choice == 1){
                System.out.println("Where would you like to go?: \n 0.Cleveland, 1.North Pole, 2.Campbell Hill, 3.Tokyo, 4.Chicago, 5.Erie PA, or 6.Allegheny Nation Forest" );
                int goTo = input.nextInt();
            
                //is distance > or < range
                if(placeH.calcLocation(t1.currentLocation(), locationArray[goTo]) < t1.getRange()){
                    double newRange = t1.getRange() - placeH.calcLocation(t1.currentLocation(), locationArray[goTo]);
                    t1.driveToLocation(locationArray[goTo], newRange); 
                    System.out.println("You've arrived at: " + locationArray[goTo].locationTitle());
                    System.out.println("Current Range: " + newRange);
                    
                }
                //if range < needed distance
                else if (placeH.calcLocation(t1.currentLocation(), locationArray[goTo]) > t1.getRange()){
                    System.out.println("Oops! You don't have enough gas! Current Range: " + t1.getRange() + " miles.");
                    System.out.println(placeH.calcLocation(t1.currentLocation(), locationArray[goTo]) + " miles required.");
                }
            }
            else if (choice == 2){
                if(t1.currentLocation().gasCheck()){ //fuel check
                    t1.refuel();
                    System.out.println("Your truck has been refueled!");
                    System.out.println("Current Fuel: " + t1.getCurrentFuel() + " gallons");
                    System.out.println("Current Range: " + t1.getRange() + " miles");
                }
                else if(t1.currentLocation().gasCheck() != true){
                    System.out.println("OOPS! This location does not have a gas station!");
                    System.out.println("Current range: " + t1.getRange() + " miles");
                }
            }
            
            else if (choice == 3){ //location information
                System.out.println("You are currently at: " + t1.currentLocation().locationTitle());
                System.out.println(t1.currentLocation().locationTitle() + " is located at: " + t1.currentLocation().getLocation());
                System.out.println("Does " + t1.currentLocation().locationTitle() + " have a gas station?: " + t1.currentLocation().gasCheck());
            }
            
            else if (choice == 4){ //Quit
                System.out.println("--Thank you for playing!--");
                break;
            }
            
        }  
        
    }
    
}
