/**
 * author:Ryan Lukas
 */
package game;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class MonkeyTowerMoving extends Effect 
{
	/**
	 * creating constructor for a defense tower moving
	 * @param game
	 * @param position
	 */
	public MonkeyTowerMoving (GameState game, Point position)
	{
		super(game, position);
		//pulls image
		image = ResourceLoader.getLoader().getImage("monkeyTower.png");
	}
	/**
	 * will check to see if the tower is on the pask, and then it will create a new tower in the area you place it
	 */
	public void update()
	{
		
		BufferedImage temp = ResourceLoader.getLoader().getImage("path_2_mask.png");
		position = game.getMousePos();
		//pulling mask
		if (game.getMousePressed())
		{
			
			//testing to see if it is on the RGB of black, if it isnt, then it will create a new DefenseTower
			if(!(temp.getRGB(this.getLocation().x, this.getLocation().y) % (256*256*256) ==0))
				game.addAnimatable(new MonkeyTower(position, game));
			game.removeAnimatable(this);
			game.clearMousePressed();
		}
		
	}
	@Override
	/**
	 * draws image
	 */
	public void draw(Graphics g) {
		g.drawImage(image,game.getMousePos().x,game.getMousePos().y, null);		
	}
	
}
