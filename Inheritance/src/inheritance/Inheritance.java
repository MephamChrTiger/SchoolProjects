/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritance;

import java.util.ArrayList;

/**
 *
 * @author s01164417
 */
public class Inheritance {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //outputting surface areas and perimeter
        //add 6 shapes, should be different 
 
        ArrayList<Shape> shapeList = new ArrayList();
        shapeList.add(new ellipse(100,50));
        shapeList.add(new Rectangle(20,10));
        shapeList.add(new Circle(5));
        shapeList.add(new Square(10));
        shapeList.add(new ellipse(30,10));
        shapeList.add(new Rectangle(30,5));
        //ellipse
        System.out.println("Perimeter of ellipse 1 is about: " + shapeList.get(0).getPerimeter());
        System.out.println("Perimeter of ellipse 2 is about: " + shapeList.get(4).getPerimeter());
        System.out.println("Area of ellipse 1: " + shapeList.get(0).getArea() + "\nArea of Ellipse 2: " + shapeList.get(4).getArea());
        //circle
        System.out.println("Perimeter of the circle: " + shapeList.get(2).getPerimeter());
        System.out.println("Area of the circle: " + shapeList.get(2).getArea());
        //rectangle
        System.out.println("Perimeter of rectangle 1: " + shapeList.get(1).getPerimeter());
        System.out.println("Perimeter of rectangle 2: " + shapeList.get(5).getPerimeter());
        System.out.println("Area of rectangle 1: " + shapeList.get(1).getArea() + "\nRectangle 2: " + shapeList.get(5).getArea());
        //square
        System.out.println("Perimeter of the square: " + shapeList.get(3).getPerimeter());
        System.out.println("Area of the square: " + shapeList.get(3).getArea());
    } 
    
}
