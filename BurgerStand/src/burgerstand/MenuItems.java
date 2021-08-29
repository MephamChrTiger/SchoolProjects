/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package burgerstand;

/**
 *
 * @author s01164417
 */
public class MenuItems {
    private String itemName;
    private int calories;
    private double price;

    public MenuItems(String itemName, int calories, double price) {
        this.itemName = itemName;
        this.calories = calories;
        this.price = price;
    }

    public String getItems() {
        return itemName;
    }

    public int getCalories() {
        return calories;
    }

    public double getPrice() {
        return price;
    }
    
    public String toString(){
        return itemName + ": $" + price;
    }
}
