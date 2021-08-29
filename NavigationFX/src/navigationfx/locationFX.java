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
public class locationFX {
    private final String locationName;
    private final double locationX;
    private final double locationY;
     boolean hasGas;

    public locationFX(String locationName, double locationX, double locationY, boolean hasGas) {
        this.locationName = locationName;
        this.locationX = locationX;
        this.locationY = locationY;
        this.hasGas = hasGas;
    }
    
    double calcLocation(locationFX current, locationFX target){
        //a^2 + b^2 = c^2 c = miles
        current.getLocationX();
        current.getLocationY();
        target.getLocationX();
        target.getLocationY();
        
        double aSquared = target.locationX - current.locationX;
        double bSquared = target.locationY - current.locationY;
        double cSquared = Math.sqrt(Math.pow(aSquared, 2) + Math.pow(bSquared, 2));
        return cSquared;
        
    }
    
    boolean gasCheck(){
        return hasGas;
    }
    
    
    
    String getLocation(){
        String result = (locationX + "," + locationY);
        return result;
    }
    
    double getLocationX(){
        return locationX;
    }
    
    double getLocationY(){
        return locationY;
    }
    
    String locationTitle(){
        return locationName;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return locationName + "";
    }
}
