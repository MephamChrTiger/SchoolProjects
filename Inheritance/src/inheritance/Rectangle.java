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
public class Rectangle extends Shape {

    public Rectangle(double length, double height) {
        super(length, height);
    }
    
    @Override
    double getArea(){
        double answer = (length * height);
        return answer;
    }
    
    double getPerimeter(){
        double answer = ((length * 2) + (height * 2));
        return answer;
    }

}
