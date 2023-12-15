/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import project.fop.Keypress;
import project.fop.ProjectFoP;

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
        if (isColliding(game.tilemap)) {
            // If a collision occurs, revert to the previous position
            x = prevX;
            y = prevY;
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
    }//end position method

    //colliding detection
    public boolean isColliding(int[][] tilemap) {
        int playerLeft = x;
        int playerRight = x + game.tilesize;
        int playerTop = y;
        int playerBottom = y + game.tilesize;
        for (int i = 0; i < tilemap.length; i++) {
            for (int j = 0; j < tilemap[0].length; j++) {
                if (tilemap[i][j] == 0) { //tilemap value 0 represents a solid tile
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

    //draw player character
    public void draw(Graphics g) {
        BufferedImage image = null;
        image = img;
        g.drawImage(image, x, y, game.tilesize, game.tilesize, null);
    }
}
