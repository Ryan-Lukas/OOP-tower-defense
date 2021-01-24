/**Creates a path, scanning in points, telling how far objects are in within the path, drawing path
 * Ryan Lukas
 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Scanner;

public class Path 
{
	private Point[] path;
	
	/**
	 * takes in a a scanner to ready a text file all the points
	 * @param in
	 * returns a path array with variables in it
	 */
	public Path(Scanner in)
	{
		//pulling size of how many numbers there are
		int sizeOfArray = in.nextInt();
		
		//creating path array and have a loop to put points in the array
		path = new Point[sizeOfArray];
		for(int i = 0 ; i < sizeOfArray;i++ )
		{
			int x,y; // creating variables and putting the next numbers in the txt file in the variables
			Point p;
			x = in.nextInt();
			y = in.nextInt();
			
			//creating a point and putting it into the path array
			p = new Point(x,y);
			path[i]= p;
			
		}
//		System.out.println("got here"+ size);
	}
	/**
	 * getting the total length of the whole path 
	 * @return the total distance of the path
	 */
	public double getLenght()
	{
		double totalLength = 0.0;
		
		for(int i = 1; i < path.length; i++)
		{
			//creating a start and end to add the distances up between points
			Point start, end;
			start = path[i-1];
			end = path[i];
			//adding distance with a distance method
			totalLength = totalLength + start.distance(end);
		}
		
		return totalLength;
	}
	
	/**
	 * puts in a percentage and returns the position points
	 * @param percentage
	 * @return
	 */
	public Point getPathPosition(double percentage)
	{
		
		//special cases
		if(percentage <= 0.0)
			return new Point(path[0]);
		if(percentage >1.0)
			return new Point(path[path.length-1]);
		
		//calculating the distance the circle has to still travel
		double distanceToTravel = this.getLenght()*percentage;
		double totalLength = 0.0;
		
		//for loop to go through every point
		for(int i = 1; i < path.length; i++)
		{
			Point start, end;
			int startX, startY;
			
			
			start = path[i-1];
			end = path[i];
			startX = start.x;
			startY = start.y;
			// getting new point assigned to certian points 
			totalLength = totalLength + start.distance(end);
			//returning new position
			if(totalLength > distanceToTravel)
				return new Point(startX, startY);



		}
		return null;
		
	}
	/**
	 * gets points from the path array and draws the line to line
	 * @param g
	 */
	public void draw(Graphics g)
	{
		//drawing path
		g.setColor(Color.BLUE);
		for(int i = 1; i < path.length; i++)
		{
			//creating point variables to see where it starts and ends
			Point start, end;
			int startX, startY, endX, endY;
			start = path[i-1];
			end = path[i];
			
			//creating it to be simpler, 
			startX = start.x;
			startY = start.y;
			endX = end.x;
			endY = end.y;
			
			//drawing line
			g.drawLine(startX, startY, endX, endY);
		}
	}

}
