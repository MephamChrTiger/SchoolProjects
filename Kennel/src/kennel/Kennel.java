
package kennel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author s01164417
 */
public class Kennel {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
//        Toy[] toy = new Toy[10];
//        
//        for(int i = 0; i < toy.length; i++) {
//            toy[i] = new Toy();
//        }
        
//        for(int i = 0; i < toy.length; i++){
//            System.out.println(toy[i]);
//            System.out.println();
//        }

        ArrayList<Toy> toy = new ArrayList(); //Array Lists
        
        for(int i = 0; i < 10; i++){
            toy.add(new Toy());
        }
        
        for(int i = 0; i < toy.size();i++){
            System.out.println(toy.get(i));
            System.out.println();
        }
      
                
        Dog d1 = new Dog("Echo", "Alaskan Malamute", 5, 150); //d1 is the object created from the Dog class
        Dog d2 = new Dog("Fido", "Pug", 4, 45);
//        
        System.out.println("Dog's weight is: " + d1.weighDog());
        d1.eat(2.5);
        d1.poop(1.2);
//        
//        for(int i = 0; i < toy.length; i++){
//            System.out.println(d1.biteToy(toy[i]));
//        }
//        
//        System.out.println("Dog's Weight is: " + d1.weighDog());  

        
    }
    
}
