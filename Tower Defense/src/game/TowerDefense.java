/**
 * Ryan Lukas
 * April 10, 2017
 */

package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * A path test panel is a GUI panel that displays a tower
 * defense path on the screen, and animates a small object
 * moving along the path.
 * 
 * This class won't be part of the final project - we're just
 * using it for testing.
 * 
 * @author Peter Jensen and Ryan Lukas
 * @version March 22, 2017  (Update this)
 */
public class TowerDefense extends JPanel implements ActionListener, Runnable, MouseListener,MouseMotionListener
{
    // This constant avoids an obnoxious warning, but it is totally unused by us.
    //   It would only be relevant if we were using object serialization.
    
    private static final long serialVersionUID = 42L;
    
    // Fields (object variables) 
    
    // the background image
    
        // Students will add a few more fields (object variables) to keep
        //   track of their path object, the circle position (as a percentage),
        //   and possibly a Timer object.
    
    
    
    private GameState game;
    
    public static void main (String[] args)
    {
        // Main runs in the 'main' execution thread, and the GUI
        //   needs to be built by the GUI execution thread.
        //   Ask the GUI thread to run our 'run' method (at some
        //   later time).
        
    	 SwingUtilities.invokeLater(new TowerDefense(1));

        // Done.  Let the main thread of execution finish.  All the
        //   remaining work will be done by the GUI thread.
        
        
    }
    
    /**
     * Builds the GUI for this application.  This method must
     * only be called/executed by the GUI thread. 
     */
   
    
    public TowerDefense (int i)
    {
    	// ClassLoader myLoader = this.getClass().getClassLoader();
    } 
    
   /**
    * creates a gui and sets the size to it
    */
    public void run ()
    {
        
    	Dimension panelSize = new Dimension(800,600);
       
    	
    	this.setMinimumSize(panelSize);
        this.setPreferredSize(panelSize);
        this.setMaximumSize(panelSize);
         
        JFrame f = new JFrame("Path Tester");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
        
        
        f.setContentPane(this);
        
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
        game = new GameState();
        
        Timer time = new Timer(17 , this);
        time.start();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    
    
    /**
     * Draws the image, path, and the animating ball.
     * 
     * (The background is not cleared, it is assumed the backdrop
     * fills the panel.)
     * 
     * @param g the graphics object for drawing on this panel
     */
    public void paint (Graphics g)
    {
        game.draw((Graphics)g);
    }
    
    /**
     * The actionPerformed method is called (from the GUI event loop)
     * whenever an action event occurs that this object is lisening to.
     * 
     * For our test panel, we assume that the Timer has expired, so
     * we advance our small sphere along the path.
     * 
     * @param e the event object 
     */
    public void actionPerformed (ActionEvent e)
    {
    	//updating and repainting the GUI
    	game.update();
        repaint();
    	
    }
    public void mouseDragged(MouseEvent e)
	{
	    game.setMousePos(e.getPoint());
	}

	public void mouseMoved(MouseEvent e)
	{
	    game.setMousePos(e.getPoint());
	}
	
	public void mousePressed(MouseEvent e)
	{
	    game.setMousePressed();
	}
	
    public void mouseClicked (MouseEvent e) {}
    public void mouseEntered (MouseEvent e) {}
    public void mouseExited  (MouseEvent e) {} 
    public void mouseReleased(MouseEvent e) {}
	
    
}
