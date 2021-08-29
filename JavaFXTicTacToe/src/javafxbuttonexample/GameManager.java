/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxbuttonexample;

/**
 *
 * @author John Ostroske
 */
public class GameManager
{
    boolean xTurn;
    
    GameManager()
    {
        xTurn = true;
    }
    
    boolean takeTurn()
    {
        xTurn = !xTurn;
        return xTurn;
    }
}
