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
public class ellipse extends Shape {

    public ellipse(double length, double height) {
        super(length, height);
    }
    
    @Override
    double getArea(){
        //ellipse area calc
        length = (length / 2);
        height = (height / 2);
        double answer = Math.PI * (length * height);
        return answer;
    }
    
    @Override
    double getPerimeter(){
        double num1 = ((Math.pow(length, 2)) + (Math.pow(height, 2)));
        num1 = num1 / 2;
        double answer = ((2 * Math.PI) * Math.sqrt(num1));
        return answer;
    }
    
}
