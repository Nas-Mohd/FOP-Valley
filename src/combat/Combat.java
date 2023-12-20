/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package combat;

import entity.Goblin;
import entity.Monster;
import entity.Player;
import gui.prototype.GUIPrototype;
import gui.prototype.Print;
import java.util.Random;

/**
 *
 * @author Anas Mohammad 23055727
 */
public class Combat {
    static GUIPrototype window;
    static Goblin g;
    static Monster enemy;
    static Player player;
    public static boolean isDefending;
    public static int defendCD, healCD;
    
    public static void setWindow (GUIPrototype e) {
        window = e;
    }
    
    public static void initiateCombat(int monster, Player p) {
        String monsterName;
        player = p;
        
        switch (monster) {
            case 2 -> {
                monsterName = "goblin";
                g = GUIPrototype.g;
                enemy = g;
            }
            default -> {
                monsterName = "";
                enemy = null;
            }
        }
        GUIPrototype.setProgress("Starting Combat");
        window.hideMap();
        window.showStuff();
        Print.printMonsterEncounter(monsterName);
    }
    
    public static void startCombat() {
        System.out.println(enemy.hp);
        if (player.hp > 0 && enemy.hp > 0)
        Print.monsterStartCombat(enemy);
        else
            if(player.hp < 1){
                Print.gameLose();
            }
             
            else if(enemy.hp < 1){
               Print.gameWin();
            }
                
    }
    
    public static void playerAttacks() {
        int dmg, dif = player.attack - enemy.defense;
        Random rd = new Random();
        GUIPrototype.setProgress("Attacking");
        if (dif < 1) {
            dmg = rd.nextInt(8);
        } else
            dmg = dif + rd.nextInt(9);
        
        enemy.hp -= dmg;
        
        Print.displayEffects(dmg);
    }
    
    public static void enemyAttacks() {
        int dmg, dif = enemy.attack - player.defense;
        Random rd = new Random();
        if (dif < 1)
            dmg = rd.nextInt(5);
        else
            dmg = dif + rd.nextInt(6);
        
        player.hp -= dmg;
        
        if (isDefending) {
            isDefending = false;
            player.defense = Player.chosenMajor.defense;
        }
            
        
        Print.displayMonsterAction(dmg);
    }
    
    public static void playerAction (String action) {
        if (action.equalsIgnoreCase("attack") || action.equals("1")) {
            playerAttacks();
        } else if (action.equalsIgnoreCase("defend") || action.equals("2")) {
            playerDefends();
        } else if (action.equalsIgnoreCase("heal") || action.equals("3")) {
            playerHeals();
        } else if (action.equalsIgnoreCase("run") || action.equals("4")){
            playerRuns();
        }
        
    }
    
    public static void playerDefends() {
        int value = (int) (player.defense * 0.2);
        player.defense += value;
        isDefending = true;
        defendCD = 2;
            
        Print.displayEffects(value);
    }
    
    public static void playerHeals() {
        int value, surplus;
        value = (int) (Player.chosenMajor.hp * 0.2);
        
        player.hp += value;
        if (player.hp > Player.chosenMajor.hp) {
            surplus = player.hp - Player.chosenMajor.hp;
            player.hp -= surplus;
            value -= surplus;
        }
        healCD = 4;
        Print.displayEffects(value);
    }
    
    public static void playerRuns() {
        Random rd = new Random();
        if (rd.nextBoolean())
            GUIPrototype.setProgress("Running Failed");
        else
            GUIPrototype.setProgress("Running Success");
        
        Print.displayEffects(0);
    }
    
    public static void reduceCD() {
        if (defendCD > 0)
            defendCD--;
        if (healCD > 0)
            healCD--;
        for (int i = 0; i < 3; i++)
            if (Player.chosenMajor.availableSpells[i].countdown > 0)
                Player.chosenMajor.availableSpells[i].countdown--;
                
    }
    
    
    
}
