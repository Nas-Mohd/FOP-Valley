/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fop.valley;

import java.util.Scanner;

/**
 *
 * @author Dummfak
 */
public class Fight {
    Entity player;
    Entity monster;
    Scanner keyboard = new Scanner(System.in);
    
    public Fight (Entity playerInput, Entity monsterInput) {
        player = playerInput;
        monster = monsterInput;
    }
    
    public Entity initiateBattle (Entity user, Entity enemy) {
        Entity victor;
        startOfBattleText(enemy);
        boolean fight = fightOrFlight();
        if (fight) {
            System.out.println("You choose to fight");   
        }
        
        
        System.out.println("You have ran away!");
        return user;
    }
    
    private void startOfBattleText(Entity encounter) {
        System.out.println("You have encountered a " + encounter.name + "!");
        System.out.println("What will you do?");
    }
    
    private boolean fightOrFlight() {
        int choice;
        System.out.println("1. Fight!");
        System.out.println("2. Run!");
        do {
            System.out.print("Choice: ");
            choice = keyboard.nextInt();
        } while (choice > 2 || choice < 1);
        return choice==1;
    }
    
}
