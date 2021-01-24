/**
 * author:Ryan Lukas
 */
package game;

import java.awt.Graphics;
import java.awt.Point;

public class DefenseTowerMenu extends Effect
{
	/**
	 * creating main method for defesnse tower menu
	 * @param game
	 * @param position
	 */
	public DefenseTowerMenu(GameState game, Point position)
	{
		super(game, position);
		//pulls image
		image = ResourceLoader.getLoader().getImage("tower.png");


	}
	/**
	 * going to create a image on the menu area
	 */
	public void update()
	{
        
		//if the mose is pressed then it will create a moving tower image
		if (game.getMousePressed() && game.getMousePos().distance(position) < 50)
        {
        	game.addAnimatable(new DefenseTowerMoving(game, position));
        	game.clearMousePressed();
        }
        		
	}

	/**
	 * creates new image
	 */
	public void draw(Graphics g) {
		g.drawImage(image,650 ,100 , null);		
	}
	
	
	

}