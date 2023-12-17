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
    String[] actions = {"Attack", "Defend", "Heal", "Exit the game"}; 
    public Entity (String n) {
        name = n;
        health = 100;
    }
    
    
    
}
