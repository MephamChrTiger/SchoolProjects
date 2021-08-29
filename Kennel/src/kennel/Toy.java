/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kennel;

import java.util.Random;

/**
 *
 * @author s01164417
 */
public class Toy
{
    private boolean squeeky, squishy, edible;
    private int durability = 100;
    private String sound;

    public Toy(boolean squeeky, boolean squishy, boolean edible, int durability)
    {
        this.squeeky = squeeky;
        this.squishy = squishy;
        this.edible = edible;
        this.durability = durability;
    }
    
    public Toy(){
        Random rnd = new Random();
        this.squeeky = rnd.nextBoolean();
        this.squishy = rnd.nextBoolean();
        this.edible = rnd.nextBoolean();
        this.durability = rnd.nextInt(10) + 15;
    }
    
    int getDurability(){
        return durability;
    }
    
    String bitten(){
        durability -= 25;
        if(squeeky){
            sound = "*makes squeeky noise*";
        }
        else if (edible){
            sound = "*Crunch*";
        }
        return sound;
    }
    
    String shaken() {
        durability -= 10;
        if(squishy) {
            sound = "*Makes no noise*";
        }
        else if (squeeky) {
            sound = "*Makes squeeky noises*";
        }
        return sound;
    }
    
    int durabilityCheck(){
        return durability;
    }
}
