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
class TitleScreenHandler implements KeyListener {
    
    int press = 0;
    GUIPrototype window;
    String recentInput;
    Document document;
    public static ArrayList<String> availableMajors = new ArrayList<>(Arrays.asList("ai", "csn", "mmc"));
    
    public TitleScreenHandler(GUIPrototype a) {
        window = a;
        
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
            System.out.println(press);
            if (press == 1)

                window.titleToCreateCharacter();
            
            if (!window.progress.equals("Map")) {
                getRecentInput();
            }
            
            
            
        
            window.commandLine.setText("> ");
            window.commandLine.setCaretPosition(window.commandLine.getText().length());
            window.commandLine.setPreferredSize(new Dimension(800, 100));
            //window.commandLine.setBounds(0, 650, 800, 150);
            
            
        }
        
        
        
    }
    
    public void getRecentInput(){
        document = window.commandLine.getDocument();
        try {
            int length = document.getLength();
            recentInput = document.getText(2, length-3);
            System.out.println(recentInput);

                checkInput();
        } catch (BadLocationException e) {
            System.out.println("oopsies");
        }
        
        
    }
    
    public void checkInput(){
  
        if (GUIPrototype.progress.equals("Choosing")){
            System.out.println("oop");
            if (recentInput.equals("y")){
                System.out.println("hi");
                GUIPrototype.setProgress("Choosing Name");
                window.chooseName();
                
            }
                
                
            else if (recentInput.equals("")){
                System.out.println("bye");
                
                GUIPrototype.setProgress("Create Character");
                Print.showMajors();
               
                
            }
        }
        else if (GUIPrototype.progress.equals("Create Character") && availableMajors.contains(recentInput) ){
            if (recentInput.equalsIgnoreCase("ai")) {
                Print.showMajorsInfo(recentInput);
                
                GUIPrototype.setProgress("Choosing");
                window.setMajor("ai");
            }
            else if (recentInput.equalsIgnoreCase("csn")) {
                Print.showMajorsInfo(recentInput);
                
                GUIPrototype.setProgress("Choosing");
                window.setMajor("csn");
            }

            
            
            System.out.println(GUIPrototype.progress);
            
        }
        
        else if (GUIPrototype.progress.equals("Choosing Name")){
            if (recentInput.equals("")){
                Print.showMajorsInfo(GUIPrototype.major);
                
                GUIPrototype.setProgress("Choosing");
            } else {
            Player.setName(recentInput);
            window.createMap();
            GUIPrototype.setProgress("Map");
            }
        }
        
        else if (GUIPrototype.progress.equals("Starting Combat")) {
            if (recentInput.equalsIgnoreCase("Fight")) {
                System.out.println("heard fight");
                Combat.startCombat();
                GUIPrototype.setProgress("In Combat");
            } else if (recentInput.equals("")) {
                window.hideStuff();
                window.showMap();
                window.textArtArea.setForeground(Color.white);
                
                GUIPrototype.setProgress("Map");
            }
        }
        
        else if (GUIPrototype.progress.equals("In Combat")) {
            if (recentInput.equalsIgnoreCase("attack") || recentInput.equals("1")) {
                GUIPrototype.setProgress("Attacking");
                Combat.playerAttacks();
        }
    }
}

class choiceHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
            }

    @Override
    public void keyPressed(KeyEvent e) {
    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
