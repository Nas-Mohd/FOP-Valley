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

/**
 *
 * @author Anas Mohammad 23055727
 */
public class Combat {
    static GUIPrototype window;
    static Goblin g;
    static Monster enemy;
    static Player player;
    
    public static void setWindow (GUIPrototype e) {
        window = e;
    }
    
    public static void initiateCombat(int monster, Player p) {
        String monsterName;
        player = p;
        
        switch (monster) {
            case 2 -> {
                monsterName = "goblin";
                g = new Goblin(window);
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
        Print.monsterStartCombat(enemy);
    }
    
    public static void playerAttacks() {
        int dmg;
        if (player.attack >= enemy.defense) {
            dmg = player.attack * 2 - enemy.defense;
        } else
            dmg = player.attack*player.attack - enemy.defense;
        
        enemy.hp -= dmg;
        
        Print.displayEffects(dmg);
    }
    
}
