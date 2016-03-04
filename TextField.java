import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * A program that, when you type a key or word, says it out loud.
 * 
 * @author seo 
 * @version 0.2
 */
public class TextField extends World
{
    StringBuilder word = new StringBuilder();
    GreenfootImage screen;
    /**
     * Constructor for objects of class Typer.
     * 
     */
    public TextField()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1095, 30, 1); 
        screen = getBackground();
        screen.setFont(screen.getFont().deriveFont(18.0f));
        Greenfoot.playSound("intro2.wav");  
    }
    
    public void act()
    {
       String key = Greenfoot.getKey();
       if(null!=key) {
           if (key.equals("space") || key.equals("enter")) // Or "enter"
           {
               playWord();
           } else {
               playKey(key);
           }
       
           // Draw text box
           screen.setColor(Color.WHITE);
           screen.fillRect(5,5,290,25);
           
           // Draw text
           screen.setColor(Color.BLACK);
           screen.drawString(word.toString(),5,20);
        }
    } 
    
    
    void playKey(String key)
    {           
        String sound = key + ".wav";
        try{
             Greenfoot.playSound("letters/" + sound);
             // Add letter to word.  Only gets here if sound file was found
             word.append(key); 
        } catch (Exception e){
             Greenfoot.playSound("unknown.wav");            
        }
        // Greenfoot.delay(100);
    }
    
    void playWord() {
        String w = word.toString().trim().toLowerCase();
        try{
            Greenfoot.playSound("words/" + w + ".wav");
        } catch (Exception e){
            Greenfoot.playSound("unknown.wav");            
        }
        
        word.delete(0,word.length());
        Greenfoot.delay(100);
    }
}
