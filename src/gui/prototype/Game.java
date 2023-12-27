/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gui.prototype;

import combat.Combat;
import entity.monsters.Goblin;
import entity.Player;
import entity.monsters.Harpy;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 *
 * @author Anas Mohammad 23055727
 */
public class Game {
    
    public Map map;
    JFrame window;
    Container con;
    JPanel titleGamePanel,  commandLinePanel, mainTextPanel, textArtPanel, headingPanel;
    public JLabel headingLabel;
    public JTextArea commandLine;
    public JTextPane mainTextArea, textArtArea;
    JTextArea titleGameText;
    JScrollPane commandLineScroll;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 96);
    Font textFont = new Font("Sylfaen", Font.PLAIN, 20);
    Font cliFont = new Font ("Sylfaen", Font.PLAIN, 24);
    Font headingFont = new Font("Sylfaen", Font.BOLD, 52);
    Font textArtFont = new Font("Monospaced", Font.PLAIN, 8);
    Dimension a = new Dimension(500,475);
    Dimension b = new Dimension(225,450);
    CommandLineInputHandler titleScreenHandler;
    static public String progress, major;
    public static Goblin goblin;
    public static Harpy harpy;
    public static Player p;
    public static boolean gameWon;
    
    public enum State {
        START_GAME, 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        new Game();
    }
    
    public Game(){
        System.out.println("Starting Game");
        window = new JFrame();
        window.setSize(800, 800);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        
        con = window.getContentPane();
        
        titleGamePanel = new JPanel();
        titleGameText = new JTextArea();
        commandLinePanel = new JPanel();
        commandLine = new JTextArea();
        commandLineScroll = new JScrollPane(commandLine);
        titleScreenHandler = new CommandLineInputHandler(this);
        
        mainTextPanel = new JPanel();
        mainTextArea = new JTextPane();
        textArtPanel = new JPanel();
        textArtArea = new JTextPane();
        headingPanel = new JPanel();
        headingLabel = new JLabel();
        
        startGame();
        
    }
    
    public void startGame() {

        progress = "Start Game";

        titleGamePanel.setBounds(0,0,800,600);
        titleGamePanel.setBackground(Color.black);
        titleGamePanel.setVisible(true);
        
        
        titleGameText.setText("In Another World As A UM Computer Science Student: The Game");
        titleGameText.setBounds(25, 25, 775, 575);
        titleGameText.setFocusable(false);
        titleGameText.setEditable(false);
        titleGameText.setForeground(Color.white);
        titleGameText.setBackground(Color.black);
        titleGameText.setFont(titleFont);
        titleGameText.setLineWrap(true);
        titleGameText.setWrapStyleWord(true);
        titleGameText.setVisible(true);
        System.out.println("Initialized titleGameText");
        
        
        
        commandLinePanel.setBounds(0, 650, 800, 150);
        commandLinePanel.setBackground(Color.black);
        commandLinePanel.setVisible(true);
        con.add(commandLinePanel);
        
        commandLine.setText("Press ENTER to start");
        commandLine.setCaretPosition(commandLine.getText().length());
        commandLine.setBackground(Color.black);
        commandLine.setBounds(0, 650, 800, 150);

        commandLine.setForeground(Color.white);
        commandLine.setLineWrap(true);
        commandLine.setFont(cliFont);
        commandLine.setVisible(true);

        commandLine.addKeyListener(titleScreenHandler);
        
        
        
        
        
        commandLinePanel.add(commandLineScroll);
        titleGamePanel.add(titleGameText);
        con.add(titleGamePanel);
        
        window.setVisible(true);
        Print.setWindow(this);
        Combat.setWindow(this);
        
    }
    
    public void createMenuScreen(){
        progress = "Menu Screen";
        
        mainTextPanel.setBounds(25,125,500,475);
        mainTextPanel.setBackground(Color.black);
        mainTextPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainTextPanel.setVisible(true);
        mainTextPanel.setPreferredSize(a);
        con.add(mainTextPanel);
        

        mainTextArea.setBounds(25,125,500,475);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(textFont);
        mainTextArea.setPreferredSize(a);
        mainTextArea.setContentType("text/html");
        mainTextArea.setEditable(false);
        
        mainTextArea.setVisible(true);
       
        mainTextPanel.add(mainTextArea);
        

        textArtPanel.setBounds(525, 150, 225,450);
        textArtPanel.setBackground(Color.black);
        textArtPanel.setVisible(true);
        con.add(textArtPanel);
        

        textArtArea.setBounds(525,150,225,450);
        textArtArea.setBackground(Color.black);
        textArtArea.setForeground(Color.white);
        textArtArea.setFont(textArtFont);
        textArtArea.setPreferredSize(b);
        textArtArea.setContentType("text/html");
        //textArtArea.setLineWrap(true);
        textArtArea.setEditable(false);
        textArtArea.setVisible(true);
        textArtArea.setText(Print.getAsciiArt("portal"));
        textArtPanel.add(textArtArea);
        

        headingPanel.setBounds(25, 25, 725, 75);
        headingPanel.setBackground(Color.black);
        headingPanel.setVisible(true);
        con.add(headingPanel);
        

        headingLabel.setForeground(Color.white);
        headingLabel.setFont(headingFont);
        headingLabel.setVisible(true);
        headingLabel.setText("MENU");
        headingPanel.add(headingLabel);
        
        String menuText = "<span style='color: lime'>1. NEW GAME\n2. LOAD GAME\n3. HELP</span>";
        mainTextArea.setText(Print.wrapWithHTML(menuText));
        
        
    }
    
    public void createCharacterScreen(){
        
        setProgress("Create Character");
        

        textArtArea.setText(Print.getAsciiArt("book"));
        headingLabel.setText("Choose Your Major");

        mainTextArea.setText(Print.getMajors());
        
        
        
        
        
    }
    
    public void titleToMenuScreen() {
            titleGamePanel.setVisible(false);
            titleGameText.setVisible(false);
            createMenuScreen();
        
        
    }
    public void createPlayer() {
        map = new Map();
                
    }
    
    public void createMap() {
        Game.setProgress("Map");
        hideStuff();


        goblin = new Goblin(this,map);
        harpy = new Harpy(this,map);
        
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
        CommandLineInputHandler.setPlayer(x);
    }
    
    public void setMajor (String s) {
        major = s;
    }
    
    public void chooseName(){
        headingLabel.setText("Please Enter a Name");
        String nameText = "Type your character's name in the command line and hit ENTER"
                + "\nOr just hit <b>ENTER</b> to go back";
        mainTextArea.setText(Print.wrapWithHTML(nameText));
    }
    
    public static void checkWin(){
        if (goblin.isDead)
            if( harpy.isDead)
                gameWon=true;
    }
}



