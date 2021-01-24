/**
 * author:Ryan Lukas
 */
package game;

import java.awt.Graphics;
import java.awt.Point;

public class MonkeyTowerMenu extends Effect
{
	/**
	 * creating main method for monkey tower menu
	 * @param game
	 * @param position
	 */
	public MonkeyTowerMenu(GameState game, Point position)
	{
		super(game, position);
		//pulls image
		image = ResourceLoader.getLoader().getImage("monkeyTower.png");


	}
	
	/**
	 * going to create a image on the menu area
	 */
	public void update()
	{
		//if the mose is pressed then it will create a moving tower image
        if (game.getMousePressed() && game.getMousePos().distance(position) < 50)
        {
        	game.addAnimatable(new MonkeyTowerMoving(game, position));
        	game.clearMousePressed();
        }
        		
	}
	@Override

	/**
	 * creates new image
	 */
	public void draw(Graphics g) {
		g.drawImage(image,650 ,300 , null);		
	}
	
	
	

}
