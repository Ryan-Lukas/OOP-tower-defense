/**
 * author:Ryan Lukas
 */
package game;

import java.awt.Point;

public class MonkeyTower extends Tower 
{
	private int frameCounter;
	/** 
	 * Main method for a monkey tower, loading image and seeing if there are enough credits to place a tower, if so take away certain credits
	 * @param position
	 * @param game
	 */
	MonkeyTower(Point position, GameState game) {
		//calling super class for variables
		super(position, game);
		//loads image
		this.image = ResourceLoader.getLoader().getImage("monkeyTower.png");
		//checking credits and seeing if you have enough to place a tower
		if(game.getCredits() == 0)
			game.removeAnimatable(this);
		game.adjustCredits(-50);
		
	}

	/**
	 * update method will find nearest enemy and add a new effect 
	 */
	public void update() 
	{
		//creates nearest enemy to find
		Enemy c = game.findNearestEnemy(position);
        if (c == null)
            return;
        
      //if the enemey is near, create a new effect
        if (c.getLocation().distance(position) < 75)
        {
        	//creating new effect
        	Effect e = new FlyingBanana(game, position, c.getLocation().x-position.x, c.getLocation().y-position.y);
        	game.addAnimatable(e);
        	frameCounter++;
        	if(frameCounter% 50!=0)
        		return;
        	//removes effect and adds credit
        	game.removeAnimatable(c);
        	game.adjustCredits(25);
        }
       
	}

}
