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
public class Square extends Rectangle {

    public Square(double length) {
        super(length, length);
    }
    
    @Override
    double getArea(){
        double answer = Math.pow(height, 2);
        return answer;
    }
    
    @Override
    double getPerimeter(){
        return (length * 4);
    }

}
