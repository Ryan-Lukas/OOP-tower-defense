/**
 * Author: Ryan Lukas
 */
package game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

abstract public class Tower implements Animatable
{
	protected Point position;
	protected BufferedImage image;
	protected GameState game;
	
	public Tower(Point position, GameState game)
	{
		this.position = position;
		this.game = game;
		
		
	}
	public Point getLocation()
	{
		return position;
	}
	public void draw(Graphics g)
	{
		Point c = getLocation();
		g.drawImage(image,c.x-image.getWidth()/2, c.y-image.getHeight()/2, null); 
	}
	
}
