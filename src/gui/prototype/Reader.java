/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.prototype;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Anas Mohammad 23055727
 */
public class Reader {
    
    public static String[] readMonsterFile(String monsterName) {
        String[] monsterDesc = new String[10];
        try {
            Scanner reader = new Scanner(new FileInputStream(Paths.get("src/resource/monstersDesc.txt").toFile()));
            while(!reader.nextLine().equals(monsterName)){} // go through file until AFTER monster name
            monsterDesc[0] = reader.nextLine(); // monster description
            monsterDesc[1] = reader.nextLine(); // monster hp AS STRING
            monsterDesc[2] = reader.nextLine(); // monster mp AS STRING
            monsterDesc[3] = reader.nextLine(); // monster attack AS STRING
            monsterDesc[4] = reader.nextLine(); // monster defense AS STRING
            monsterDesc[5] = reader.nextLine(); // monster credits AS STRING
            monsterDesc[6] = reader.nextLine(); // monster attack dialogue
            monsterDesc[7] = reader.nextLine(); // monster attack dialogue
            monsterDesc[8] = reader.nextLine(); // monster attack dialogue
            monsterDesc[9] = reader.nextLine(); // monster attack dialogue
            reader.close();
            } catch (FileNotFoundException e) {
            System.out.println("File was not found"); 
            }

        
        return monsterDesc;
    }
    
    public static String[] readMajorsFile (String name) {
        String[] majorDesc = new String[9];
        try {
            Scanner reader = new Scanner(new FileInputStream(Paths.get("src/resource/majorsDesc.txt").toFile()));
            while(!reader.nextLine().equals(name)){} // go through file until AFTER major identifier
            majorDesc[0] = reader.nextLine(); // major name
            majorDesc[1] = reader.nextLine(); // major description
            while (true) {
                String desc = reader.nextLine();
                if (desc.equals("stats"))
                    break;
                majorDesc[1] = majorDesc[1] + "\n" + desc;
            }
            majorDesc[2] = reader.nextLine(); // major hp AS STRING
            majorDesc[3] = reader.nextLine(); // major mp AS STRING
            majorDesc[4] = reader.nextLine(); // major attack AS STRING
            majorDesc[5] = reader.nextLine(); // major defense AS STRING
            majorDesc[6] = reader.nextLine(); // major SpellName 1
            majorDesc[7] = reader.nextLine(); // major SpellName 2
            majorDesc[8] = reader.nextLine(); // major SpellName 3
            reader.close();
            } catch (FileNotFoundException e) {
            System.out.println("File was not found"); 
            }
        return majorDesc;
    }
    
    public static String[] readSpellsFile (String name) {
        String[] spellDesc = new String[5];
        try {
            Scanner reader = new Scanner(new FileInputStream(Paths.get("src/resource/spellsDesc.txt").toFile()));
            while(!reader.nextLine().equals(name)){} // go through file until AFTER spell identifier
            spellDesc[0] = reader.nextLine(); // spell desc
            spellDesc[1] = reader.nextLine(); // spell type
            spellDesc[2] = reader.nextLine(); // spell multiplier AS STRING
            spellDesc[3] = reader.nextLine(); // spell credit requirement AS STRING
            spellDesc[4] = reader.nextLine(); // spell cooldown AS STRING
            reader.close();
            } catch (FileNotFoundException e) {
            System.out.println("File was not found"); 
            }
        return spellDesc;
    }
    
}
