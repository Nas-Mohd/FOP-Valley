/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tile;

import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import project.fop.ProjectFoP;

/**
 *
 * @author ikmal
 */
public class Tile {

    public boolean collision = false;
    ProjectFoP game;
    Tiletype[] tile;

    //constructor
    public Tile(ProjectFoP game) {
        this.game = game;
        tile = new Tiletype[2];

        tileImage();
    }//end constructor

    public void tileImage() {
        try {
            tile[0] = new Tiletype();
            tile[0].img = ImageIO.read(getClass().getResourceAsStream("/resource/tile_1.png"));
        } catch (IOException e) {
            System.out.println("Problem with image");
        }
    }//end tileimage method

    public void draw(Graphics g, int[][] tilemap) {

        //draw the obstacle when tilemap is 0
        for (int i = 0; i < tilemap.length; i++) {
            for (int j = 0; j < tilemap[0].length; j++) {
                switch (tilemap[i][j]) {
                    case 0 -> {
                        g.drawImage(tile[0].img, game.tilesize * j, game.tilesize * i, game.tilesize, game.tilesize, null);
                    }
                }//end switch
            }//end loop j
        }//end loop i
    }//end draw method
}
