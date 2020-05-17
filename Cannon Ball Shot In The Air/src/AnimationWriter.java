import java.awt.*;
import javax.swing.*;

/** AnimationWriter displays a box with a ball in it. */
public class AnimationWriter extends JPanel {
	
    private static final long serialVersionUID = 1L;      
	private BallWriter ball_writer;                      
	static JPanel panel ;
              @SuppressWarnings("unused")
              private final JLabel label;
              private JFrame frame;
              private Image background;
             //private Image cannon;
	
/**  Constructor AnimationWriter constructs the view of box and ball
	 * @param l    - the ball's writer
	 * @param size - the frame's size  */
	
          public AnimationWriter(BallWriter l, int size) {
		this.label = new JLabel();
		ball_writer = l;
		frame = new JFrame("Zenit's Cannon Ball");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //JFrame after closing               doesn’t work in background .
	    frame.setSize(size + 600, size+40);
	    frame.setLocationRelativeTo(null); // In order to set JFrame in the center of Window
		
   
 Toolkit t=Toolkit.getDefaultToolkit();  
      frame.setResizable(false);
      background = t.getImage("C:\\Users\\Albania\\Desktop\\background.png"); //Background image 
      frame.getContentPane().add(this);
      repaint();                                                             
      try { Thread.sleep(1000); }                                           //1000 millisec delay 
      catch (InterruptedException e) { }
      frame.setVisible(true);                                             //Make Visible frame 
     }   
	
	/** paintComponent paints the box and ball
	 *  @param g - the graphics pen .*/
	
public void paintComponent(Graphics g) {
      
      g.drawImage(background,0,0,this);      //Background position 
       ball_writer.paint(g);                   
      
	}
}