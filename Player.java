package DC;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * This class creates and controls the player and its characteristics.
 * How the player moves, detects and any other roles.
 * @author Scott Lewis
 */
public class Player{


    private static Board board = new Board();
    
    private static int speed;
    private static Rectangle user = new Rectangle(500, 500, 20, 20);
    private static double health; //number used to determine the player's health. From 0.5 to 3.0

    private static Shape playerYBox;//the vertical hit box for user
    private static Shape playerXBox;//the horizontal hit box for user
    //Creates default player

    public Player() 
    {
    }

    /**
     * @return int speed
     */
    public static int getSpeed()
    {
	return speed;
    }

    /**
     * <pre>{@code s = speed}</pre>
     * @param s - int to set speed to
     */
    public static void setSpeed(int s)
    {
	speed = s;
    }

    /**
     * Sets the speed based on difficulty
     * @since 0.8
     */
    public static void setSpeed()
    {
	int difficulty = board.getDifficulty();
	switch(difficulty){
	case 1:{
	    speed = 6;
	}break;
	case 2:{
	    speed = 5;
	}break;
	case 3:{
	    speed = 4;
	}break;
	}
    }
    
    /**
     * @return The rectangle user
     */
    public static Rectangle getPlayer(){
	return user;
    }

    /**
     * @return The shape of the player's horizontal hit box
     */
    public static Shape getXHitBox() {
	playerXBox = new Ellipse2D.Float(user.x-16f, user.y+1f, 50f, 18f);
	return playerXBox;
    }

    /**
     * @return The shape of the player's vertical hit box
     */
    public static Shape getYHitBox() {
	playerYBox = new Ellipse2D.Float(user.x-2f, user.y-8f, 22f, 30f);
	return playerYBox;
    }
    
    /**
     * @return health
     */
    public static double getHealth(){
	return health;
    }

    /**
     * {@code health = h}
     * @param h - double to set health to
     */
    public static void setHealth(double h){
	health = h;
    }

    /**
     * Sets health based on difficulty.
     * @since 0.8
     */
    public static void setHealth(){
	int difficulty = board.getDifficulty();
	switch(difficulty){
	case 1:{
	    health = 3;
	}break;
	case 2:{
	    health = 2.5;
	}break;
	case 3:{
	    health = 1.5;
	}break;
	}

    }

    /**
     * {@code health -= h;}
     * @param h - double to decrease health by
     * @since 0.8
     */
    public void decreaseHealth(double h){
	health -= h;
    }
    
    /**
     * Checks if health is less than or equal to 0. 
     * @return True if player has no health left
     */
    public boolean lost(){
	if(health <= 0)
	    return true;
	else
	    return false;
    }
    


}
