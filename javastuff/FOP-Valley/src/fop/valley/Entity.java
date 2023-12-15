/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fop.valley;

/**
 *
 * @author Dummfak
 */
public class Entity {
    int health;
    String name;
    String[] actions = {"1. Attack", "2. Defend", "3. Heal", "4. Exit the game"}; 
    public Entity (String n) {
        name = n;
        health = 100;
    }
    
    
    
}
