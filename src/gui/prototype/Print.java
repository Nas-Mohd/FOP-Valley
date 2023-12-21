/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.prototype;

import combat.Combat;
import entity.monsters.Goblin;
import entity.Major;
import entity.Monster;
import entity.Player;
import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

/**
 *
 * @author Anas Mohammad 23055727
 */
public class Print {
    static Game window;
    public static String heading;
    public static String mainText;
    public static String textArt;
    static Goblin g;
    static Monster enemy;
    static Major chosenMajor;
    static Player player;
    static String separator = "+----------------------------------------------------+\n";
    
    public static String getMajors(Game e){
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
        textArt = Print.getAsciiArt("book");
        
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
                textArt =  String.join("\n", Files.readAllLines(Paths.get("src/resource/ascii/" + filename + "_ascii.txt" )));
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
            enemy = g;
            window.textArtArea.setForeground(Color.green);
        }
        printDisplay();
    }
    
    public static void monsterStartCombat (Monster enemy) {
        System.out.println(player.hp);
        System.out.println(Game.progress);
        if (player.hp > 0 && enemy.hp > 0) {
            player.credits = 15; // REMOVE THIS AFTERTESTING
            heading = enemy.getName();
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
                + "\n2. Defend - Reduce incoming damage once by increasing your defense";
        if (Combat.defendCD > 0)
            info += " " + Combat.defendCD + " / 2";
        else
            info += " (2 cd)";
        info += "\n3. Heal - Heal 20% of your Max HP ";
        if (Combat.healCD > 0)
            info += Combat.healCD + " / 4";
        else
            info += " (4 cd)";
        info += "\n4. Run - Leave combat (has a chance for failure)\n" + separator 
                + "Spells: ";
        for (int i = 0; i < 3; i++)
            if (player.credits >= Player.chosenMajor.availableSpells[i].credits){
                info += "\n" + Character.toString('a' + i) + ".) " + Player.chosenMajor.availableSpells[i].name;
                if (Player.chosenMajor.availableSpells[i].countdown < Player.chosenMajor.availableSpells[i].cd && Player.chosenMajor.availableSpells[i].countdown != 0) {
                    info += " ----- " + Player.chosenMajor.availableSpells[i].countdown + " / " + Player.chosenMajor.availableSpells[i].cd;
                } else {
                    info += " - " + Player.chosenMajor.availableSpells[i].desc + " (" +Player.chosenMajor.availableSpells[i].cd + " cd)";
                }
            } else {
                info += "\n" + "SPELL LOCKED: " + Player.chosenMajor.availableSpells[i].credits + " credits required to unlock";
            }
        
        return info;
    }
    
    public static void displayEffects (int value) {
        if (Game.progress.equalsIgnoreCase("Attacking")) {
            mainText = "You have HIT the " + enemy.name + " for " + value + " dmg";
            
            System.out.println("ENEMY HP: " + enemy.hp); //TEST CODE
        }
        else if (Game.progress.equalsIgnoreCase("Defending")) {
            mainText = "You ready yourself to take the next hit, increasing your defense by " + value;
            
        }
        else if (Game.progress.equalsIgnoreCase("Healing")) {
            mainText = "You have restored your health by " + value;
            
        }
        else if (Game.progress.equalsIgnoreCase("Running Successful")) {
            mainText = """
                       You raise your fist and start charging towards the monster in front of you. Only to suddenly make a 180 and run as fast as possible.
                       You have ran away SUCCESSFULY. Congratulations, coward...
                       """;
            
        }
        else if (Game.progress.equalsIgnoreCase("Running Failed")) {
            mainText = """
                       You raise your fist and start charging towards the monster in front of you. Only to suddenly make a 180 and run as fast as possible.
                       While running as fast as you can, you trip on your shoelace :[
                       You have FAILED to run away. Better luck next time ;)
                       """;
        }
        else if (Game.progress.equals("Attack Spell")) {
                for (int i = 0; i < 3; i++)
                    if (Player.chosenMajor.availableSpells[i].type.equalsIgnoreCase("attack"))
                        mainText = "You cast " + Player.chosenMajor.availableSpells[i].name + ". Damaging your opponent greatly. You have DEALT " + value + " dmg!";
                }            
        else if (Game.progress.equals("Status Spell")) {
                for (int i = 0; i < 3; i++)
                    if (Player.chosenMajor.availableSpells[i].type.equalsIgnoreCase("status"))
                        mainText = "You cast " + Player.chosenMajor.availableSpells[i].name + ". You lower your opponent's power and stats!";
                }            
        else if (Game.progress.equals("Defend Spell")) {
                for (int i = 0; i < 3; i++)
                    if (Player.chosenMajor.availableSpells[i].type.equalsIgnoreCase("defend"))
                        mainText = "You cast " + Player.chosenMajor.availableSpells[i].name + ". Which will completely nullify your enemy's next attack!";
                }            
        
        if (Game.progress.equals("Running Successful")){
        } else {
            Game.setProgress("Displaying Effects");
            System.out.println("hi");
        }
        mainText += "\nHit ENTER to continue";

            
        printDisplay();
    }
    
    public static void displayMonsterAction(int value) {
        Random rd = new Random();

        int i = rd.nextInt(4);
        if (enemy.hp < 1)
            mainText = "You have KILLED " + enemy.name;
        else if(Combat.isBlocking){
            mainText = enemy.name + " used their ultimate special killing move, but due to the spell you have casted you took ZERO dmg!";   
            Combat.isBlocking = false;
        }
        else
                mainText = "Monster Stats: \nHP: " + enemy.hp + "   MP: "
            + enemy.mp + "   Attack: " + enemy.attack + "   Defense: " + enemy.defense 
            + "   Credits: " + enemy.credits + "\n" + separator + "\n"
            + enemy.name + enemy.attackDialogues[i] + value + " DMG" 
            + "\nHit ENTER to continue.";
        
        Combat.reduceCD();
        printDisplay();
    }
    
    
    public static void gameWin() {
        heading = "YOU WIN!";
        window.headingLabel.setForeground(Color.green);
        window.textArtArea.setForeground(Color.yellow);
        mainText = "You have defeated all the monsters and took back all of your college credits !";
        textArt = getAsciiArt("win");
        Game.setProgress("Game Win");
        
        printDisplay();
    }
    
    public static void gameLose() {
        heading = "GAME OVER";
        window.headingLabel.setForeground(Color.red);
        window.textArtArea.setForeground(Color.red);
        mainText = "Try again next time!";
        textArt = getAsciiArt("lose");
        Game.setProgress("Game Lose");
        
        printDisplay();
                
    }
}
