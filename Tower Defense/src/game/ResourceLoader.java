package game;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ResourceLoader 
{
	//creating variables
	Map<String, BufferedImage> imageMap;
	Map<String, Path> pathMap;
	static private ResourceLoader instance;
	
	/**
	 * constructor of a resourceloader
	 */
	private ResourceLoader()
	{
		//assigning variables to new hashmaps
		imageMap = new HashMap<String, BufferedImage>();
		pathMap = new HashMap<String, Path>();
		
	}
		
	static public ResourceLoader getLoader()
     {
        
		if (instance == null)
           instance = new ResourceLoader ();

         return instance;
     }
	/**
	 * Checks to see if the image was already loaded, if not it will pull the image and put it into the array list
	 * @param imageName
	 * @return
	 */
	public BufferedImage getImage(String imageName)
	{
		//checking to see if the image has already been pulled, if so it returns it
		if(imageMap.containsKey(imageName))
		{
			return imageMap.get(imageName);
		}
		//pulling the image and returning it
		
		try
        {
            
            
            ClassLoader myLoader = this.getClass().getClassLoader();
            
            
            InputStream imageStream = myLoader.getResourceAsStream("resources/" + imageName);
           
            BufferedImage result;
            result = javax.imageio.ImageIO.read(imageStream);  // A handy helper method
           
            imageMap.put(imageName, result);
           
            return result;
            
        }
        catch (Exception e)
        {
            // On error, just print a message and exit.  
            //   (You should make sure the files are in the correct place.)
            
            System.err.println ("Could not load one of the files.");
            
            System.exit(0);
            return null;// Bail out.
        }   
		
		
		
	}
	
	public Path getPath(String pathName)
	{
		//checking to see if the image has already been pulled, if so it returns it
		if(pathMap.containsKey(pathName))
			return pathMap.get(pathName);
		//pulling the image and returning it
		
		try
		{
			ClassLoader myLoader = this.getClass().getClassLoader();
			InputStream pointStream = myLoader.getResourceAsStream("resources/"+ pathName);
            Path path;
            path = new Path(new Scanner(pointStream));
            pathMap.put(pathName, path);
            
            return path;
		}
		catch(Exception e)
		{
			System.err.println ("Could not load one of the files.");
            
            System.exit(0);
            return null;// Bail out.
		}

	}
	
}
