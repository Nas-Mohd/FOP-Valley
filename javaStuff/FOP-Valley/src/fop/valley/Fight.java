/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fop.valley;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Dummfak
 * This class is all for the round based combat mechanics. This class is dependent on
 * the other classes such as Print, Entities, and Game.
 */
public class Fight {
    Entity player;
    Entity enemy;
    int recentDamageDone;
    int blockedAmount;
    Random rd = new Random();
    ArrayList<String> validInputs = new ArrayList<String>() {{
            add("Attack");
            add("Defend");
            add("Heal");
            add("Escape");
        }};
 
        
    
    public Fight (Entity user) {
        player = user;
    }
    


    // Method for starting battle
    public Entity initiateBattle (Entity monster) {
        enemy = monster;
        Entity victor;
        startOfBattleText(enemy);
        boolean fight = fightOrFlight();
        if (fight) 
            victor = combat();
        else{
            victor = player;
            System.out.println("You have ran away!");
        }
        return victor;
    }
    
    // Prints out start of battle text
    private  void startOfBattleText(Entity encounter) {
        System.out.println("You have encountered a " + encounter.name + "!");
        System.out.println("You get ready to fight.");
    }
    
    // For user to choose whether to fight or to run away
    private  boolean fightOrFlight() {
        Scanner keyboard = new Scanner(System.in);
        int choice;
        System.out.println("1. Fight!");
        System.out.println("2. Run!");
        do {
            System.out.print("Choice: ");
            choice = keyboard.nextInt();
        } while (choice > 2 || choice < 1);
        return choice==1;
    }
    
    
    // Combat method
    private  Entity combat () {
        Entity victor = enemy;
        Print.combatStartingText();
        while (player.health >= 0 || enemy.health >= 0) {
            executeActionPlayer(getUserAction(player), enemy);
            executeActionEnemy(getRandomAction(enemy), player);
        }
        if (enemy.health <= 0)
            victor = player;
        else
            Game.gameOver();
        return victor;
    }
    
    
    // Get user action
    private  String getUserAction(Entity User) {
        
        Scanner sc = new Scanner(System.in);
        Print.printChoices(player);
        String input;
        boolean isValid = false;
        do {
            
            System.out.println("What do you choose to do?");
            System.out.print("Input: ");
            input = sc.nextLine();
            
            for (String action : validInputs){
                if (action.equalsIgnoreCase(input))
                    isValid = true;
            }
        } while (!isValid);
        return input;
    }
    
    // Get random action for enemy
    private String getRandomAction(Entity Enemy) {
        return "attack";
    }
    
    
    // After getting input execute action/spell
    private void executeActionPlayer(String input, Entity receiver){
         recentDamageDone = rd.nextInt(1,11);
        if (input.equalsIgnoreCase("attack")){
            receiver.health -= recentDamageDone;
            Print.printEffects(input, this, player);
        }
                
            
    }
    
    // After getting random action execute action/spell
    private void executeActionEnemy(String input, Entity receiver) {
        recentDamageDone = rd.nextInt(1,11);
        if (input.equalsIgnoreCase("attack")){
                receiver.health -= recentDamageDone;
                Print.printEffects(input, this, enemy);
                
                
        }
    }
    
}
