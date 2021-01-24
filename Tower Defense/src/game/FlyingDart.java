/**
 * author:Ryan Lukas
 */
package game;

import java.awt.Graphics;
import java.awt.Point;

public class FlyingDart extends Effect
{
	//creating variables
	int deltaX, deltaY;
	private int frameCounter;
	/**
	 * creates constructor of flying dart objext
	 * @param game
	 * @param position
	 * @param deltaX
	 * @param deltaY
	 */
	public FlyingDart(GameState game, Point position, int deltaX, int deltaY)
	{
		super(game, new Point(position));
		this.image = ResourceLoader.getLoader().getImage("dart.png");
		this.deltaX = deltaX;
		this.deltaY = deltaY;
		this.frameCounter = 0;
		
	}
	
	/**
	 * updates position and then deletes object
	 */
	public void update()
	{
		position.x += deltaX /30;
		position.y += deltaY/30;
		frameCounter++;
		if( frameCounter == 30)
		{
			game.removeAnimatable(this);
			
		}
	}
	
	/**
	 * draws image
	 */
	public void draw(Graphics g) 
	{
		g.drawImage(image, position.x, position.y, null);
		
	}
	
}
