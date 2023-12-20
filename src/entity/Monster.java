/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import gui.prototype.Reader;

/**
 *
 * @author Anas Mohammad 23055727
 */
public class Monster {
    
    public String ascii, name, desc;
    public int hp, mp, attack, defense, credits;
    public String[] attackDialogues;
    
    public void getStats (String monsterName) {
        String[] e = Reader.readMonsterFile(monsterName);
        desc = e[0];
        hp = Integer.parseInt(e[1]);
        mp = Integer.parseInt(e[2]);
        attack = Integer.parseInt(e[3]);
        defense = Integer.parseInt(e[4]);
        credits = Integer.parseInt(e[5]);
        attackDialogues = new String[]{e[6], e[7], e[8],e[9]};
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
