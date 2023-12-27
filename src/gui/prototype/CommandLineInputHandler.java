/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.prototype;

import combat.Combat;
import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author Anas Mohammad 23055727
 */
class CommandLineInputHandler implements KeyListener {
    
    int press = 0;
    Game window;
    String recentInput;
    Document document;
    public static ArrayList<String> availableMajors = new ArrayList<>(Arrays.asList("ai", "csn", "mmc"));
    public static Player player;
    
    public CommandLineInputHandler(Game a) {
        window = a;
        
    }
    public static void setPlayer(Player p) {
        player = p;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        
        // Perform actions you want when Enter key is pressed
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Unused, but required by KeyListener interface
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Unused, but required by KeyListener interface
        
        if (e.getKeyCode() == KeyEvent.VK_ENTER && e.getSource() == window.commandLine && window.commandLine.isFocusOwner()) {
            press++;
            System.out.println(Game.progress + " - PROGRESS BEFORE GETTING USER INPUT");
            
            if (!Game.progress.equals("Map")) {
                getRecentInput();
            }
            
            
            System.out.println(Game.progress + " - PROGRESS AFTER GETTING USER INPUT AND CHECKING");
        
            window.commandLine.setText("> ");
            window.commandLine.setCaretPosition(window.commandLine.getText().length());
            window.commandLine.setPreferredSize(new Dimension(800, 100));
            
            
        }
        
        
        
    }
    
    public void getRecentInput(){
        document = window.commandLine.getDocument();
        try {
            int length = document.getLength();
            recentInput = document.getText(2, length-3);
            System.out.println(recentInput + " - oop?");

                checkInput();
        } catch (BadLocationException e) {
            System.out.println("oopsies");
        }
        
        
    }
    
    public void checkInput(){
        System.out.println(Game.progress + " - STRING USED FOR CHECKING");
        if (Game.progress.equals("Start Game"))
            window.titleToMenuScreen();
        else if (Game.progress.equals("Menu Screen")) {
            if (recentInput.equalsIgnoreCase("new game") || recentInput.equalsIgnoreCase("new") || recentInput.equals("1"))
            window.createCharacterScreen();  
            else if (recentInput.equalsIgnoreCase("help") || recentInput.equals("3")){
                Print.showHelp();
            }
        }
        else if (Game.progress.equals("Help Screen1")){
            Print.showHelp1();
        }
        else if (Game.progress.equals("Help Screen")){
            window.createMenuScreen();
        }

        else if (Game.progress.equalsIgnoreCase("Create Character")){
                System.out.println("heard input during create character");
            if (recentInput.equalsIgnoreCase("ai")) {
                Print.showMajorsInfo(recentInput);
                
                Game.setProgress("Choosing");
                window.setMajor("ai");
            }
            else if (recentInput.equalsIgnoreCase("csn")) {
                Print.showMajorsInfo(recentInput);
                
                Game.setProgress("Choosing");
                window.setMajor("csn");
            }
            System.out.println(Game.progress);
        }              
        else if (Game.progress.equals("Choosing")){
            System.out.println("oop");
            if (recentInput.equals("y")){
                System.out.println("hi");
                Game.setProgress("Choosing Name");
                window.chooseName();
                
            }
                
                
            else if (recentInput.equals("")){
                System.out.println("bye");
                
                Game.setProgress("Create Character");
                Print.showMajors();
               
                
            }
        }

        
        else if (Game.progress.equals("Choosing Name")){
            if (recentInput.equals("")){
                Print.showMajorsInfo(Game.major);
                
                Game.setProgress("Choosing");
            } else {
            Player.setName(recentInput);
            //window.createMap();
            window.createPlayer();
            Print.showStory1();
            }
        }
        else if (Game.progress.equals("Story1")){
            Print.showStory2();
        }
        else if (Game.progress.equals("Story2")){
            Print.showStory3();
        }
        else if (Game.progress.equals("Story3")){
            Print.showStory4();
        }
        else if (Game.progress.equals("Story4")){
            Print.showStory();
        }
        else if (Game.progress.equals("Story")){
            window.createMap();
        }
        
        else if (Game.progress.equals("Starting Combat")) {
            if (recentInput.equalsIgnoreCase("Fight")) {
                System.out.println("heard fight");
                Combat.startCombat();
                Game.setProgress("In Combat");
            } else if (recentInput.equals("")) {
                
                window.hideStuff();
                window.showMap();
                window.textArtArea.setForeground(Color.white);
                
                Game.setProgress("Map");
            }
        }
        
        else if (Game.progress.equals("In Combat")) {
            if (recentInput.equalsIgnoreCase("attack") || recentInput.equals("1")) {
                Game.setProgress("Attacking");
                Combat.playerAction(recentInput);
            }
            else if (recentInput.equalsIgnoreCase("defend") || recentInput.equals("2") && Combat.defendCD == 0) {
                Game.setProgress("Defending");
                Combat.playerAction(recentInput);
            }
            else if (recentInput.equalsIgnoreCase("heal") || recentInput.equals("3") && Combat.healCD == 0) {
                Game.setProgress("Healing");
                Combat.playerAction(recentInput);
            }
            else if (recentInput.equalsIgnoreCase("run") || recentInput.equals("4")) {
                Game.setProgress("Running");
                Combat.playerAction(recentInput);
            }
            for (int i = 0; i < 3; i++)
                if ((recentInput.equalsIgnoreCase(Player.chosenMajor.availableSpells[i].name) || recentInput.equalsIgnoreCase(Character.toString('a' + i))) && Player.chosenMajor.availableSpells[i].countdown==0 && player.credits >= Player.chosenMajor.availableSpells[i].credits){
                     Game.setProgress("Casting Spell");
                     Combat.playerAction(recentInput);
                }
                   
        }
        else if (Game.progress.equals("Displaying Effects") && recentInput.equals("")) {
            Game.setProgress("Displaying Monster");
            Combat.enemyAttacks();
        }
        else if (Game.progress.equals("Displaying Monster") && recentInput.equals("")) {
            Game.setProgress("In Combat");
            Combat.startCombat();
        }
        
        else if (Game.progress.equals("Game Win") || Game.progress.equals("Game Lose")) {
                window.hideStuff();
                window.startGame();
            }
        else if (Game.progress.equals("Running Successful") && recentInput.equals("")){
            window.hideStuff();
            window.showMap();
            window.textArtArea.setForeground(Color.white);
            
            Game.setProgress("Map");
        }
        
}
}



