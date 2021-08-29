/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navigationfx;

/**
 *
 * @author s01164417
 */
public class TruckFX {
    private double maxFuelCap, currentFuel, milesPerGallon;
    private locationFX currentLocation;
    
    
    public TruckFX(locationFX start, double maxFuelCap, double currentFuel, double milesPerGallon) {
        this.currentLocation = start;
        this.maxFuelCap = maxFuelCap;
        this.currentFuel = currentFuel;
        this.milesPerGallon = milesPerGallon;
    }
    
    String getLocationInfo(){
        return currentLocation.getLocation();
        
    }
    
    double getRange(){
        double result = (currentFuel * milesPerGallon); 
        return result;
    }
    
    String getStringRange(){
        double result = (currentFuel * milesPerGallon);
        return result + "";
    }
   
    
    void setFuel(double newRange){
        currentFuel = (newRange / milesPerGallon);
    }
    
    void driveToLocation(locationFX destination, double newRange){
        destination.getLocation(); 
        currentFuel = (newRange / milesPerGallon);
        currentLocation = destination;
    }
    
    void refuel(){
        if(currentLocation.gasCheck()){
            currentFuel = maxFuelCap;
        }
        else if (currentLocation.gasCheck() != true){
            currentFuel = currentFuel;
        }
    }
    
    double getCurrentFuel(){
        return currentFuel;
    }
    
    double getMPG(){
        return milesPerGallon;
    }
    
    locationFX currentLocation(){
        return currentLocation;
    }
}
