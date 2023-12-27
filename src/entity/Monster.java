/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import gui.prototype.Game;
import gui.prototype.Map;
import gui.prototype.Reader;

/**
 *
 * @author Anas Mohammad 23055727
 */
public class Monster {
    
    public boolean isDead;
    public String ascii, name, desc;
    public int hp, attack, defense, credits, X, Y;
    public String[] attackDialogues;
    public Game game;
    public Map map;
    
    public void getStats (String monsterName) {
        String[] e = Reader.readMonsterFile(monsterName);
        desc = e[0];
        hp = Integer.parseInt(e[1]);
        attack = Integer.parseInt(e[2]);
        defense = Integer.parseInt(e[3]);
        credits = Integer.parseInt(e[4]);
        attackDialogues = new String[]{e[5], e[6], e[7],e[8]};
    }
    public void despawn(){
        map.tilemap[Y][X] = 1;
    }
    public String getDesc() {
        return desc;
    }
    
    public String getAscii() {
        return ascii;
    }
    
    public String getName() {
        return name;
    }
    
}
