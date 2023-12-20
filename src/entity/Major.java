/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import combat.Spells;
import gui.prototype.Print;
import gui.prototype.Reader;

/**
 *
 * @author Anas Mohammad 23055727
 */
public class Major {
    public String name, ascii, desc;
    public int hp, mp, attack, defense;
    public Spells[] availableSpells = new Spells[3];
    
    public Major (String s) {
        ascii = Print.getAsciiArt(s +"_ascii.txt");
        getStats(s);
        
        
    }
    
    public void getStats (String majorName) {
        String[] e = Reader.readMajorsFile(majorName);
        name = e[0];
        desc = e[1];
        hp = Integer.parseInt(e[2]);
        mp = Integer.parseInt(e[3]);
        attack = Integer.parseInt(e[4]);
        defense = Integer.parseInt(e[5]);
        availableSpells[0] = new Spells(e[6]);
        availableSpells[1] = new Spells(e[7]);
        availableSpells[2] = new Spells(e[8]);
    }
    
    
}
