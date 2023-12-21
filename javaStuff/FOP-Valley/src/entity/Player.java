/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import combat.Combat;
import gui.prototype.GUIPrototype;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import gui.prototype.Keypress;
import gui.prototype.Print;
import gui.prototype.ProjectFoP;

/**
 *
 * @author ikmal
 */
public class Player extends Character {

    public BufferedImage img;

    ProjectFoP game;
    Keypress keypress;



    //constructor
    public Player(ProjectFoP game, Keypress keypress) {
        this.game = game;
        this.keypress = keypress;
        playerImage();
        Print.setPlayer(this);
        
    }//end constructor

    //reload image
    public void playerImage() {
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/resource/boy_down_1_1.png"));
        } catch (IOException e) {
            System.out.println("Problem with image");
        }
    }

    //character movement when key is press
    public void position() {
        int prevX = x;
        int prevY = y;
        
        if (GUIPrototype.progress.equals("Map")) {
        if (keypress.up == true) {
            y -= speed;
        }
        if (keypress.down == true) {
            y += speed;
        }
        if (keypress.left == true) {
            x -= speed;
        }
        if (keypress.right == true) {
            x += speed;
        }
        }
        
        if (isColliding(game.tilemap)) {
            // If a collision occurs, revert to the previous position
                        int monster = isCollidingWithMonster(game.tilemap);
            
                x = prevX;
                y = prevY;
                
                if ( monster > 0) {
                    
                    System.out.println("monster" + monster);
                    keypress.stopMovement();
                    Combat.initiateCombat(monster, this);
                    monster = 0;
                    System.out.println(monster);
            }
            
            

        }
        
        //limit the movement of character inside the frame only
        if (x < 0) {
            x = 0;
        } else if (x > game.gameScreenWidth - game.tilesize) {
            x = game.gameScreenWidth - game.tilesize;
        } else if (y < 0) {
            y = 0;
        } else if (y > game.gameScreenHeight - game.tilesize) {
            y = game.gameScreenHeight - game.tilesize;
        }
    }
    //end position method

    //colliding detection
    public boolean isColliding(int[][] tilemap) {
        int playerLeft = x + 5;
        int playerRight = x + game.tilesize - 5;
        int playerTop = y + 5;
        int playerBottom = y + game.tilesize - 5;
        for (int i = 0; i < tilemap.length; i++) {
            for (int j = 0; j < tilemap[0].length; j++) {
                if (tilemap[i][j] != 1) { //tilemap value 0 represents a solid tile
                    int tileLeft = j * game.tilesize;
                    int tileRight = (j + 1) * game.tilesize;
                    int tileTop = i * game.tilesize;
                    int tileBottom = (i + 1) * game.tilesize;

                    // Check for collision
                    if (playerRight > tileLeft && playerLeft < tileRight
                            && playerBottom > tileTop && playerTop < tileBottom) {
                        return true; // Collision detected
                    }
                }
               
            }
        }
        return false; // No collision detected
    
        }//end isColliding method
    //colliding detection
    public int isCollidingWithMonster(int[][] tilemap) {
        int playerLeft = x;
        int playerRight = x + game.tilesize;
        int playerTop = y;
        int playerBottom = y + game.tilesize;
        for (int i = 0; i < tilemap.length; i++) {
            for (int j = 0; j < tilemap[0].length; j++) {

                 if (tilemap[i][j] == 2) { //tilemap value 2 represents a goblin
                    int tileLeft = j * game.tilesize;
                    int tileRight = (j + 1) * game.tilesize;
                    int tileTop = i * game.tilesize;
                    int tileBottom = (i + 1) * game.tilesize;
                    // Check for collision
                    if (playerRight > tileLeft && playerLeft < tileRight
                            && playerBottom > tileTop && playerTop < tileBottom) {

                        return tilemap[i][j]; // Collision detected
                    }
            }
        }
        }
        return 0; // No collision detected
    
        }//end isColliding method
    

    //draw player character
    public void draw(Graphics g) {
        BufferedImage image = null;
        image = img;
        g.drawImage(image, x, y, game.tilesize, game.tilesize, null);
    }
    
    // set player name
    public static void setName(String s) {
        name = s;
    }
    
    // set major/class
    public void setMajor (String m) {
        System.out.println("Has Chosen major");
        chosenMajor = new Major(m);
        hp = chosenMajor.hp;
        mp = chosenMajor.mp;
        attack = chosenMajor.attack;
        defense = chosenMajor.defense;
        
        
    }
    

}