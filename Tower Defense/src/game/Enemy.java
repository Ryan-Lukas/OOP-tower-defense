/**
 * author:Ryan Lukas
 */
package game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

abstract public class Enemy implements Animatable
{
	//creating new protected variables
	protected double percentage;
	protected BufferedImage image;
	protected GameState game;
	protected Path path;
	
	/**
	 * creating super constructor
	 * @param pathName
	 * @param game
	 */
	Enemy(String pathName, GameState game)
	{
		this.percentage = 0.0;
		this.game = game;
		//getting path
		this.path = ResourceLoader.getLoader().getPath(pathName);
	}
	
	/**
	 * returns location of the enemy
	 * @return
	 */
	public Point getLocation()
	{
		return path.getPathPosition(percentage);
	}
	
	/**
	 * draws image
	 */
	public void draw(Graphics g)
	{
		Point c = getLocation();
		g.drawImage(image, c.x-image.getWidth()/2, c.y-image.getHeight()/2, null);
	}
	
	/**
	 * returns path
	 * @return
	 */
	public Path path()
	{
		return path;
	}
}
