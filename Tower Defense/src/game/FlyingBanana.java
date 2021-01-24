/**
 * author:Ryan Lukas
 */
package game;

import java.awt.Graphics;
import java.awt.Point;

public class FlyingBanana extends Effect
{
	//creating variables
	int deltaX, deltaY;
	private int frameCounter;
	
	/**
	 * creates constructor of flyingbanana objext
	 * @param game
	 * @param position
	 * @param deltaX
	 * @param deltaY
	 */
	public FlyingBanana(GameState game, Point position, int deltaX, int deltaY)
	{
		super(game, new Point(position));
		this.image = ResourceLoader.getLoader().getImage("banana.png");
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
