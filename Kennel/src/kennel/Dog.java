/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kennel;

/**
 *
 * @author s01164417
 */
public class Dog
{
    //only things that objects use for data
    private int age;
    private String breed,name;
    private double weight;
    private Toy favToy;

    public Dog(String name, String breed,int age, double weight)
    {
        //Constructor Method - must have same name as class
        //each dog has a name, breed,  age, weight.
        this.age = age;
        this.breed = breed;
        this.name = name;
        this.weight = weight;
        favToy = new Toy(); //because there are no parameters it will use random constructor
        
        //when you have another object in a class constructor it is called composition
    }
    
    double weighDog(){
        return weight;
    }
    
    void eat(double amount){ 
        //weight = weight + amount;
        weight += amount;
    }
            
    void poop(double amount){
        //weight = weight - amount;
        weight -= amount;
    }
    
    String biteToy(){
        return favToy.bitten();
    }
    
    String biteToy(Toy kennelToy){
        return kennelToy.bitten();
    }
    
    public String getBreed(){
        return breed;
    }

}

