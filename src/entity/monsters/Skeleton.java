package entity.monsters;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import entity.Monster;
import gui.prototype.Game;
import gui.prototype.Map;
import gui.prototype.Print;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author chris
 */
public class Skeleton extends Monster{
    public static BufferedImage img;
    public static boolean hasSpawned;
    
    
    public Skeleton(Game e, Map f) {
        hasSpawned = false;
        isDead = false;
        game = e;
        map = f;
        id = "skeleton";
        skeletonImage();      
        ascii = Print.getAsciiArt(id);
        name = "Smart Skeleton";
        getStats("Skeleton");
        skeletonSpawn();
    
    }
    

    
    public void skeletonImage() {

        try {
            img = ImageIO.read(getClass().getResourceAsStream("/resource/skeleton.png"));
        } catch (IOException e) {
            System.out.println("Problem with image");
        }
    }
    public void skeletonSpawn(){
        while (!hasSpawned) {
            // Generate random coordinates for the skeleton's position
             Random rd = new Random();
             X = rd.nextInt(40);
             Y = rd.nextInt(40);
            // Check if the randomly chosen position is valid (not a solid tile)
            if (map.tilemap[Y][X] == 1) {
                map.tilemap[Y][X] = 4;
                hasSpawned = true;
            }
        }
    
    }
}
