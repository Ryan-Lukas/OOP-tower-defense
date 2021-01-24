/**
 * author:Ryan Lukas
 */
package game;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

public abstract class Effect implements Animatable 
{
	//creating variables
	protected Point position;
	protected BufferedImage image;
	protected GameState game;
	
	/**
	 * creating super constructor
	 * @param game
	 * @param position
	 */
	Effect( GameState game,Point position)
	{
		this.position = position;
		this.game = game;
		
		
	}
	/**
	 * returns the position as a point
	 * @return
	 */
	public Point getLocation()
	{
		return position;
	}
	
	/**
	 * draws image
	 * @param g
	 */
	public void draw(Graphics2D g)
	{
		Point a = getLocation();
		
		g.drawImage(image,a.x-image.getWidth()/2,a.y-image.getHeight(),null);
	}
}
