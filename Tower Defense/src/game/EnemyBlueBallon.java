/**
 * author:Ryan Lukas
 */
package game;

public class EnemyBlueBallon extends Enemy 
{
	
	/**
	 * enemy ballon constructor
	 * @param pathName
	 * @param game
	 */
	EnemyBlueBallon(String pathName, GameState game) {
		
		super(pathName, game);
		//pulls image
		this.image = ResourceLoader.getLoader().getImage("blueballon2.png");
		
		
	}
	
	/**
	 * updates percentage and once it gets to the end it deletes object plus -1 life
	 */
	public void update() 
	{
		
		percentage += 0.001;
		if(percentage >= 1)
		{
			game.removeAnimatable(this);
			game.adjustLives(-1);
		}
		
	}

}
