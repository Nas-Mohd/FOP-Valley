/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gui.prototype;

import combat.Combat;
import entity.Goblin;
import entity.Player;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Anas Mohammad 23055727
 */
public class GUIPrototype {
    
    public ProjectFoP map;
    JFrame window;
    Container con;
    JPanel titleGamePanel,  commandLinePanel, mainTextPanel, textArtPanel, headingPanel;
    JLabel headingLabel;
    public JTextArea commandLine, mainTextArea, textArtArea;
    JTextArea titleGameText;
    JScrollPane commandLineScroll;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 96);
    Font textFont = new Font("Sylfaen", Font.PLAIN, 20);
    Font cliFont = new Font ("Sylfaen", Font.PLAIN, 24);
    Font headingFont = new Font("Sylfaen", Font.BOLD, 52);
    Font textArtFont = new Font("Monospaced", Font.PLAIN, 8);
    TitleScreenHandler titleScreenHandler;
    int createCharacter = 0;
    static public String progress, major;
    public static Goblin g;
    public static Player p;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new GUIPrototype();
    }
    
    public GUIPrototype(){
        
        window = new JFrame();
        window.setSize(800, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        
        con = window.getContentPane();
        
        titleGamePanel = new JPanel();
        titleGamePanel.setBounds(0,0,800,600);
        titleGamePanel.setBackground(Color.black);
        
        titleGameText = new JTextArea();
        titleGameText.setText("In Another World As A First Semester UM Computer Science Student: The Game");
        titleGameText.setBounds(25, 25, 775, 575);
        titleGameText.setFocusable(false);
        titleGameText.setEditable(false);
        titleGameText.setForeground(Color.white);
        titleGameText.setBackground(Color.black);
        titleGameText.setFont(titleFont);
        titleGameText.setLineWrap(true);
        titleGameText.setWrapStyleWord(true);
        
        
        commandLinePanel = new JPanel();
        commandLinePanel.setBounds(0, 650, 800, 150);
        commandLinePanel.setBackground(Color.black);
        con.add(commandLinePanel);
        
        commandLine = new JTextArea("Press ENTER to start");
        commandLine.setCaretPosition(commandLine.getText().length());
        commandLine.setBackground(Color.black);
        commandLine.setBounds(0, 650, 800, 150);

        commandLine.setForeground(Color.white);
        commandLine.setLineWrap(true);
        commandLine.setFont(cliFont);
        titleScreenHandler = new TitleScreenHandler(this);
        commandLine.addKeyListener(titleScreenHandler);
        
        
        commandLineScroll = new JScrollPane(commandLine);
        
        
        commandLinePanel.add(commandLineScroll);
        titleGamePanel.add(titleGameText);
        con.add(titleGamePanel);
        
        window.setVisible(true);
        Combat.setWindow(this);
        
        
        
    }
    
    public void createCharacterScreen(){
        
        progress = "Create Character";
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(25,125,500,475);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);
        
        mainTextArea = new JTextArea();
        mainTextArea.setBounds(25,125,500,475);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(textFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);
        
        textArtPanel = new JPanel();
        textArtPanel.setBounds(550, 150, 200, 450);
        textArtPanel.setBackground(Color.black);
        con.add(textArtPanel);
        
        textArtArea = new JTextArea("");
        textArtArea.setBounds(550,150,200,450);
        textArtArea.setBackground(Color.black);
        textArtArea.setForeground(Color.white);
        textArtArea.setFont(textArtFont);
        textArtArea.setLineWrap(true);
        textArtArea.setEditable(false);
        textArtPanel.add(textArtArea);
        
        headingPanel = new JPanel();
        headingPanel.setBounds(25, 25, 725, 75);
        headingPanel.setBackground(Color.black);
        con.add(headingPanel);
        
        headingLabel = new JLabel("Choose Your Major");
        headingLabel.setForeground(Color.white);
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);
        
        mainTextArea.setText(Print.getMajors(this));
        
        
        
        
        
    }
    
    public void titleToCreateCharacter() {
        createCharacter++;
        if (createCharacter == 1){
            titleGamePanel.setVisible(false);
            titleGameText.setVisible(false);
            createCharacterScreen();
        }
        
    }
    
    public void createMap() {
        hideStuff();
        
        g = new Goblin(this);
        
        map = new ProjectFoP();
        
        window.add(map);
        window.setVisible(true);
       
        map.thread();
       
    }
    
    public void hideMap() {
        map.setVisible(false);
    }
    
    public void showMap() {
        
        map.setVisible(true);
        
    }
    
    public void hideStuff() {
        headingPanel.setVisible(false);
        textArtPanel.setVisible(false);
        commandLinePanel.setVisible(false);
        mainTextPanel.setVisible(false);
    }
    public void showStuff() {
        headingPanel.setVisible(true);
        textArtPanel.setVisible(true);
        commandLinePanel.setVisible(true);
        mainTextPanel.setVisible(true);
        commandLine.requestFocus();
        commandLine.setCaretPosition(commandLine.getDocument().getLength());
    }
    
    public static void setProgress(String s) {
        progress = s;
    }
    
    public static void setPlayer(Player x) {
        p = x;
        p.setMajor(major);
    }
    
    public void setMajor (String s) {
        major = s;
    }
    
    public void chooseName(){
        headingLabel.setText("Please Enter a Name");
        mainTextArea.setText("Type your character's name in the command line and hit ENTER"
                + "\nOr just hit ENTER to go back");
    }
}


