/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.prototype;

import entity.Goblin;
import entity.Major;
import entity.Monster;
import entity.Player;
import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author Anas Mohammad 23055727
 */
public class Print {
    static GUIPrototype window;
    public static String heading;
    public static String mainText;
    public static String textArt;
    static Goblin g;
    static Major chosenMajor;
    static Player player;
    static String separator = "+----------------------------------------------------+\n";
    
    public static String getMajors(GUIPrototype e){
        window = e;
        String majors = "| Artificial Intelligence (AI)\n"
                + "| Computer Systems & Network(CSN)";
        return majors;
    }
    
    public static void setPlayer(entity.Player p) {
        player = p;
    }
    
    public static void showMajors(){
        heading = "Choose Your Major";
        mainText = getMajors(window);
        textArt = Print.getAsciiArt("book_ascii.txt");
        
        printDisplay();
                
                
    }
    
    public static void showMajorsInfo(String s) {

            chosenMajor = new Major(s);
            heading = chosenMajor.name;
            mainText = chosenMajor.desc + "\nType 'y' to choose this class"
                    + "\nHit ENTER to go back";
            textArt= chosenMajor.ascii;
                
                
                printDisplay();
        
    }
    
    public static void printDisplay(){
        window.textArtArea.setText(textArt);
        window.mainTextArea.setText(mainText);
        window.headingLabel.setText(heading);
    }
    
    public static String getAsciiArt( String filename){
        try {
                textArt =  String.join("\n", Files.readAllLines(Paths.get("src/resource/" + filename )));
                } catch (IOException e) {
                    textArt = "";
                    System.out.println("Problem with image");
        }
        return textArt;
    }
    
    public static void printMonsterEncounter(String monsterName){
        g = window.g;
        heading = "You have encountered a " + monsterName;
        if (monsterName.equals("goblin")){
            mainText = g.getDesc() + "\nType \"Fight\" to initiate combat \nHit ENTER to go back";
            textArt = g.getAscii();
            window.textArtArea.setForeground(Color.green);
        }
        printDisplay();
    }
    
    public static void monsterStartCombat (Monster enemy) {
        System.out.println(player.hp);
        System.out.println(GUIPrototype.progress);
        if (player.hp > 0 && enemy.hp > 0) {
            player.credits = 30; // REMOVE THIS AFTERTESTING
            heading = "Defeat the " + enemy.getName();
            mainText = getPlayerCombatInfo();
            printDisplay();
        }

    }
    
    public static String getPlayerCombatInfo() {
        String info;
        
        
        info = "Your Stats: \nHP: " + player.hp + "   " 
                + "MP: " + player.mp + "   "
                + "Attack: " + player.attack + "   "
                + "Defense: " + player.defense + "   "
                + "Credits: " + player.credits + "\n"+ separator
                + "Basic Moves:\n" + "1. Attack - Deal basic damage to your opponent" 
                + "\n2. Defend - Reduce incoming damage once by increasing your defense (2 cd)"
                + "\n3. Heal - Heal 20% of your Max HP (-15 MP, 4 cd)"
                + "\n4. Run - Leave combat (has a chance for failure)\n" + separator 
                + "Spells: ";
        for (int i = 0; i < 3; i++)
            if (player.credits >= Player.chosenMajor.availableSpells[i].credits){
                info += "\n" + Player.chosenMajor.availableSpells[i].name;
                if (Player.chosenMajor.availableSpells[i].rounds < Player.chosenMajor.availableSpells[i].cd && Player.chosenMajor.availableSpells[i].inCooldown) {
                    info += " ----- " + Player.chosenMajor.availableSpells[i].rounds + " / " + Player.chosenMajor.availableSpells[i].cd;
                } else {
                    info += " - " + Player.chosenMajor.availableSpells[i].desc + " (" +Player.chosenMajor.availableSpells[i].cd + " cd)";
                }
            } else {
                info += "\n" + "SPELL LOCKED: " + Player.chosenMajor.availableSpells[i].credits + " credits required to unlock";
            }
        
        return info;
    }
    
    public static void displayEffects (int value) {
        if (GUIPrototype.progress.equalsIgnoreCase("Attacking")) {
            mainText = "";
        }
    }
}
