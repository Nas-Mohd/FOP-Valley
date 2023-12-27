/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import gui.prototype.GUIPrototype;
import gui.prototype.Print;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author chris
 */
public class Skeleton extends Monster{
    
    
    public static BufferedImage img;
    GUIPrototype game;
    public static boolean hasSpawned, isDead;
    
    
    public Skeleton(GUIPrototype e) {
        game = e;
        skeletonImage();      
        ascii = Print.getAsciiArt("skeleton");
        name = "Skeleton";
        getStats("skeleton");
        
    
    }
    

    
    public void skeletonImage() {

        try {
            img = ImageIO.read(getClass().getResourceAsStream("/resource/goblin.png"));
        } catch (IOException e) {
            System.out.println("Problem with image");
        }
    
    }

}
