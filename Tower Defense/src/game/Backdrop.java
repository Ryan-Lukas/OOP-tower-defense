/**
 * author:Ryan Lukas
 */
package game;

import java.awt.Graphics;

public class Backdrop implements Animatable
{
    
	public void update(){}

	/**
	 * draws graphic for the background
	 */
	public void draw(Graphics g)
	{
       
        //drawing image
        g.drawImage(ResourceLoader.getLoader().getImage("path_2.jpg"),  0, 0, null);  
   
		
	}

}
