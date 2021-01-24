/**
 * author:Ryan Lukas
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

public class GameState 
{
	
	//creating all variables
    private java.util.List<Animatable> active;
	private java.util.List<Animatable> expired;
	private java.util.List<Animatable> pending;
	
	private ResourceLoader loader;
	
	private boolean isGameOver, isPlaying;
	
	private boolean buttonActionPending;
	
	private int credits, lives;
	
	private Point mouseLoc; 
	
	/**
	 * constructor of the gamestate
	 */
    public GameState()
	{
		//pulls resourceloader
    	loader= ResourceLoader.getLoader();
		
		restart();
		
		//sets all variables
		isGameOver = false;
		isPlaying = false;
		mouseLoc = new Point(0,0);
		
		//adds menus and backdrops to active animatable list
		active.add(new Backdrop());
		active.add(new MonkeyTowerMenu(this, new Point(700, 300)));
		active.add(new DefenseTowerMenu(this, new Point (700, 150)));
		
	}
	/**
	 * tests if game is playing or not
	 * creates new enemies randomly
	 * adds objects to lists
	 * takes away objects from expired lists
	 */
    public void update ()
	{	
		
		//checks to see if you are playing the game
		if(isGameOver || !isPlaying)
		{
			//restart();
			if(buttonActionPending){
				isGameOver= false;
				isPlaying = true;
			}
			else
				return;
		}
		
		//creating new enemies randomly
		if(Math.random() < 0.05)
		{
			
			if(Math.random() < 0.1)
				active.add(new EnemyRedBallon("points.txt", this));
			else
				active.add(new EnemyBlueBallon("points.txt", this));
		}
		//adding animatables to the active lists
		for (Animatable a : active)
			a.update();
		
		active.addAll(pending);
		pending.clear();
		
		active.removeAll(expired);
		buttonActionPending = false;
		expired.clear();

       
	}
    /**
     * drawing the side menu with lives, credits, gameover image
     * @param g
     */
	public void draw (Graphics g)
	{
		g.setColor(Color.WHITE);
        g.fillRect(600, 0, 200, 600);
          
		
		g.setColor(Color.BLACK);
		g.drawString("Lives:" + lives, 650, 450);
		g.drawString("Credits:"+ credits, 650, 400 );
		
		for(Animatable a: active)
    	{
    		a.draw(g);
    	}
		//drawing gameover image
		if(isGameOver)
			g.drawImage(ResourceLoader.getLoader().getImage("game_over.png"), 0,0,null);
		
		
    }
	/**
	 * removes animatable to expired list
	 * @param dead
	 */
	public void removeAnimatable( Animatable dead)
	{
		this.expired.add(dead);
	}
	
	/**
	 * adds animatable to pending list
	 * @param a
	 */
	public void addAnimatable(Animatable a)
	{
		this.pending.add(a);
	}
	
	/**
	 * adjusts credits
	 * @param amount
	 */
	public void adjustCredits(int amount)
	{
		credits += amount;
		
		if(credits<0)
			credits = 0;
	}
	
	
	/**
	 * adjust lives
	 * @param amount
	 */
	public void adjustLives(int amount)
	{
		lives += amount;
		
		if(lives < 0)
			lives = 0;
		if(lives ==0)
			isGameOver = true;
		
	}
	
	/**
	 * sets mouse pressed
	 */
	public void  setMousePressed()
	{
			buttonActionPending = true;
	}
	
	/**
	 * clears mouse pressed
	 */
	public void  clearMousePressed ()
	{
		buttonActionPending = false;
	}
	
	/**
	 * gets moused pressed
	 * @return
	 */
	public boolean getMousePressed () 
	{
		return buttonActionPending;
	}
	
	/**
	 * will find the nearest enemy and compare their distances 
	 * @param p
	 * @return
	 */
	public Enemy findNearestEnemy (Point p)
	{
		//creates new red and blue ballon
		Enemy blueBallon = new EnemyBlueBallon("points.txt", this);
		Enemy redBallon = new EnemyRedBallon("points.txt", this);
		
		//sets ending to first item in list
		Animatable ending = active.get(0);
		
		double previousLength, comparingLength;
		comparingLength = 10000.0;
		//for loop to check every spot in list
		for(int x = 0; x< active.size(); x++)
			{
				//checking if the object is an instance of an enemy
				if(active.get(x) instanceof Enemy )
				{
					//checking if it is an instance of it and seeing if it is a blue ballon
					if(x == 0 && active.get(x) instanceof EnemyBlueBallon)
					{
						blueBallon = (Enemy) active.get(0);
						comparingLength = p.distance(blueBallon.getLocation());
					}
					else if(x == 0 && active.get(x) instanceof EnemyRedBallon)
					{
						//checking if it is an instance of it and seeing if it is a red ballon
						redBallon = (Enemy) active.get(0);
						comparingLength = p.distance(redBallon.getLocation());
					}
					
					//checking if its larger or smaller than the previous length
					if(active.get(x) instanceof EnemyBlueBallon)
					{
						blueBallon = (Enemy) active.get(x);
						previousLength = p.distance(blueBallon.getLocation());
						
					}
					else
					{
						redBallon = (Enemy) active.get(x);
						previousLength = p.distance(redBallon.getLocation());
						
					}
					
					if(previousLength < comparingLength)
					{
						comparingLength = previousLength;
						ending= active.get(x);
					}
							
						
					
				}
			}
			return (Enemy) ending;
	}
	
	/**
	 * sets mouse position
	 * @param p
	 */
	public void  setMousePos (Point p)
	{
		mouseLoc = p;
	}
	//returns mouse position
	public Point getMousePos()
    {
	    return mouseLoc;	
	}
	/**
	 * sets all lists, lives, and credits
	 */
	public void restart()
	{
		active = new ArrayList<Animatable>();
		expired = new ArrayList<Animatable>();
		pending = new ArrayList<Animatable>();
		
		lives = 10;
		credits = 200;
	}
	/**
	 * helps return credits
	 * @return
	 */
	public int getCredits()
	{
		return credits;
	}
}

