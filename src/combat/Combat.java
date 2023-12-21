/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package combat;

import entity.monsters.Goblin;
import entity.Monster;
import entity.Player;
import gui.prototype.Game;
import gui.prototype.Print;
import java.util.Random;

/**
 *
 * @author Anas Mohammad 23055727
 */
public class Combat {
    static Game window;
    static Goblin g;
    static Monster enemy;
    static Player player;
    public static boolean isDefending, isBlocking;
    public static int defendCD, healCD;
    
    public static void setWindow (Game e) {
        window = e;
    }
    
    public static void initiateCombat(int monster, Player p) {
        String monsterName;
        player = p;
        
        switch (monster) {
            case 2 -> {
                monsterName = "goblin";
                g = Game.g;
                enemy = g;
            }
            default -> {
                monsterName = "";
                enemy = null;
            }
        }
        Game.setProgress("Starting Combat");
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
        Game.setProgress("Attacking");
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
        
        if (isBlocking) {
            dmg = 0;
        }
        player.hp -= dmg;
        
        if (isDefending) {
            isDefending = false;
            player.defense = Player.chosenMajor.defense;
        }
            
        
        Print.displayMonsterAction(dmg);
    }
    
    public static void playerAction (String action) {
        if (Game.progress.equals("Attacking")) {
            playerAttacks();
        } else if (Game.progress.equals("Defending")) {
            playerDefends();
        } else if (Game.progress.equals("Healing")) {
            playerHeals();
        } else if (Game.progress.equals("Running")){
            playerRuns();
        } else if (Game.progress.equals("Casting Spell")){
            playerCastsSpell(action);
        }
        
    }
    
    public static void playerCastsSpell(String name){
        for (int i = 0; i < 2; i++)
            if (Player.chosenMajor.availableSpells[i].name.equalsIgnoreCase(name) || Character.toString('a' + i).equalsIgnoreCase(name)){
                castSpell(Player.chosenMajor.availableSpells[i]);
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
            Game.setProgress("Running Failed");
        else
            Game.setProgress("Running Successful");
        
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
    
    public static void castSpell(Spells spell) {
        switch (spell.type) {
            case "status" -> {
                Game.setProgress("Status Spell");
                enemy.attack = (int) (enemy.attack * spell.multiplier);
                enemy.defense = (int) (enemy.defense * spell.multiplier);
                spell.countdown = spell.cd;
                Print.displayEffects((int)(spell.multiplier));
            }
            case "defend" -> {
                Game.setProgress("Defend Spell");
                isBlocking = true;
                spell.countdown = spell.cd;
                Print.displayEffects(0);
            }
            case "attack" -> {
                Game.setProgress("Attack Spell");
                spell.countdown = spell.cd;
                int dmg = (int) (player.attack * spell.multiplier);
                enemy.hp -= dmg;
                spell.countdown = spell.cd;
                Print.displayEffects(dmg);
            }
            default -> {
            }
        }
    }
    
    
}
