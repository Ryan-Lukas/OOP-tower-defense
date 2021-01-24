/**
 * author:Ryan Lukas
 */
package game;


public class EnemyRedBallon extends Enemy implements Animatable
{

	/**
	 * constructor creating a enemy red ballon
	 * @param pathName
	 * @param game
	 */
	EnemyRedBallon(String pathName, GameState game) {
		//calls superclass perameters
		super(pathName, game);
	//loads image
		this.image = ResourceLoader.getLoader().getImage("redballon.png");
	//sets percentage
		percentage = 0.0;
		
	}

	/**
	 * updates percentage and once it gets to the end it deletes object plus -1 life
	 */
	public void update() 
	{
		//updates percetage on path
		percentage += 0.002;
		if(percentage >= 1)
		{
			game.removeAnimatable(this);
			game.adjustLives(-1);
		}
		
		
	}

}
