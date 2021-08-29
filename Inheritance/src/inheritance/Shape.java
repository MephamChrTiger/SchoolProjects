/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

/**
 *
 * @author s01164417
 */
public abstract class Shape {
    double length, height;

    public Shape(double length, double height) {
        this.length = length;
        this.height = height;
    }
    
    abstract double getArea();
    
    abstract double getPerimeter();
}
