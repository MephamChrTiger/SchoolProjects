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
public class Circle extends ellipse {

    public Circle(double diameter) {
        super(diameter, diameter);
    }
    
    @Override
    double getArea(){
        //circle area calc
        double radiusA = (height / 2);
        double answer = Math.PI * (Math.pow(radiusA, 2));
        return answer;
    }
    
    @Override
    double getPerimeter(){
        double radiusA = (height / 2);
        double answer = (2 * (Math.PI * radiusA));
        return answer;
    }

}
