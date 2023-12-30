/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.prototype;

import combat.Combat;
import entity.Player;
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
        switch (Game.progress){
            case "Start Game" -> window.titleToMenuScreen();
            case "Menu Screen" -> {
                if (recentInput.equalsIgnoreCase("new game") || recentInput.equalsIgnoreCase("new") || recentInput.equals("1"))
            window.createCharacterScreen();  
                else if (recentInput.equalsIgnoreCase("help") || recentInput.equals("3")){
                Print.showHelp();
                }
            }
            case "Help Screen1" -> Print.showHelp1();
            case "Help Screen" -> window.createMenuScreen();
            case "Create Character" -> { 
                switch (recentInput.toLowerCase()){
                    case "ai" -> {
                        Print.showMajorsInfo(recentInput.toLowerCase());
                        Game.setProgress("Choosing");
                        window.setMajor("ai");
                    }
                    case "se" -> {
                        Print.showMajorsInfo(recentInput.toLowerCase());
                        Game.setProgress("Choosing");
                        window.setMajor("se");
                    }
                    case "is" -> {
                        Print.showMajorsInfo(recentInput.toLowerCase());
                        Game.setProgress("Choosing");
                        window.setMajor("is");
                    }
                    case "mmc" -> {
                        Print.showMajorsInfo(recentInput.toLowerCase());
                        Game.setProgress("Choosing");
                        window.setMajor("mmc");
                    }
                    case "csn" -> {
                        Print.showMajorsInfo(recentInput.toLowerCase());
                        Game.setProgress("Choosing");
                        window.setMajor("csn");
                    }
                    default -> System.out.println("invalid input");
                }
            }
            case "Choosing" -> {
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
            case "Choosing Name" -> {
                if (recentInput.equals("")){
                    Print.showMajorsInfo(Game.major);
                
                    Game.setProgress("Choosing");
                } else {
                Player.setName(recentInput);
                window.createPlayer();
                Print.showStory1();
                }
            }
            case "Story1" -> Print.showStory2();
            case "Story2" -> Print.showStory3();
            case "Story3" -> Print.showStory4();
            case "Story4" -> Print.showStory();
            case "Story" -> window.createMap();
            case "Starting Combat" -> {
                if (recentInput.equalsIgnoreCase("Fight") || recentInput.equals("1")) {
                    Combat.startCombat();
                    Game.setProgress("In Combat");
                } else if (recentInput.equals("")) {
                    window.hideStuff();
                    window.showMap();
                    Game.setProgress("Map");
                }
            }
            case "In Combat" -> {
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
            case "Displaying Effects" ->{
                if (recentInput.equals("")){
                    Game.setProgress("Displaying Monster");
                    Combat.enemyAttacks();
                }
            }
            case "Displaying Monster" -> {
                if (recentInput.equals("")){
                    Game.setProgress("In Combat");
                    Combat.startCombat();
                }
            }
            case "Game Win" -> {
                Print.credits();
            }
            case "Game Lose" -> {
                Print.credits();
            }
            case "Running Successful" -> {
                if (recentInput.equals("")){
                window.hideStuff();
                window.showMap();
            
                Game.setProgress("Map");
                }
            }
            case "Level Up" -> {
                window.hideStuff();
                window.showMap();
            
                Game.setProgress("Map");
            }
            case "Epilogue0" -> Print.epilogue1();
            case "Epilogue1" -> Print.epilogue2();
            case "Epilogue2" -> {
                if (recentInput.equalsIgnoreCase("y") || recentInput.equalsIgnoreCase("yes"))
                    Print.epilogue3y();
                else if (recentInput.equalsIgnoreCase("n")|| recentInput.equalsIgnoreCase("no"))
                    Print.epilogue3n();
            }
            case "Epilogue3" -> Print.epilogue4();
            case "Credits" ->{
                window.hideStuff();
                window.startGame();
            }
            default -> {}
        }
    }
}
 