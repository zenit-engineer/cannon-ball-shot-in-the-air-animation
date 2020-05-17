
import java.awt.*;
import javax.swing.*;

/** BounceTheBall class is the controller of the all classes so contains Main method (We call all the classes here)*/
public class BounceTheBall {
	public static void main(String[] args) {

	    int box_size = 580;      //frame size 
		int balls_radius;       // ball's radius 
		int initialVelocity ;  //Initial velocity of the ball after fly
		int angle;            //angle in wich trajectory of ball will happen 
		double gravity;      // gravity pull of the ball 
		try {
			balls_radius = Integer.parseInt(JOptionPane.showInputDialog("Type ball's radius (Natural number)"));
			if (balls_radius < 0) {
				JOptionPane.showMessageDialog(null, "Ball's radius must be positive number n>0 (0<n<20)");

				while (balls_radius < 0) {
					balls_radius = Integer.parseInt(JOptionPane.showInputDialog("Please Type positive ball radius"));

				}
				if (balls_radius > 20) {

					JOptionPane.showMessageDialog(null,
							"Ball's radius must be 0<n<20 in order to be more enjoyable animation (0<n<20)");
					while (balls_radius > 20) {
						balls_radius = Integer.parseInt(JOptionPane.showInputDialog("Type ball radius (0<n<20)"));
					}
				}
			}

			if (balls_radius > 20) {

				JOptionPane.showMessageDialog(null,
						"Ball's radius must be 0<n<20 in order to be more enjoyable animation (0<n<20)");
				while (balls_radius > 20) {
					balls_radius = Integer.parseInt(JOptionPane.showInputDialog("Type ball's radius (0<n<20)"));

					if (balls_radius < 0) {
						JOptionPane.showMessageDialog(null, "Ball's radius must be positive number (0<n<20)");
						while (balls_radius > 20) {
							balls_radius = Integer.parseInt(JOptionPane.showInputDialog("Type ball's radius (0<n<20)"));
						}

					}
				}
			}
		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(null, "Ball's radius must be positive natural number (0<n<20)");

			balls_radius = Integer.parseInt(JOptionPane.showInputDialog("Type ball radius (0<n<20)"));
		}
		
		try { initialVelocity = Integer.parseInt(JOptionPane.showInputDialog("Type initial Velocity ,typically positive number "));}
	      
	      catch (NumberFormatException e){
	         JOptionPane.showMessageDialog(null, "Initial Velocity must be positive natural number (0<n<20)");
	         
	         initialVelocity = Integer.parseInt(JOptionPane.showInputDialog("Type positive initial velocity"));
	      }
		
		try {angle = Integer.parseInt(JOptionPane.showInputDialog("Type angle ,typically first Quadrant (0-90 degrees)"));}

		catch (NumberFormatException e){
               JOptionPane.showMessageDialog(null, "Angle must be a positive number 0<n<90 in order to be in first quadrant");
	         
              angle = Integer.parseInt(JOptionPane.showInputDialog("Angle ,typically first Quadrant (0-90 degrees)"));
			
		}
		
     try { gravity = Double.parseDouble(JOptionPane.showInputDialog("Type gravity (Common value 9.81)"));}
     
     catch(NumberFormatException e) {
    	 
    	 JOptionPane.showMessageDialog(null, "Gravity must be a positive value typically is 9.81 m/s^2)");
    	 gravity = Double.parseDouble(JOptionPane.showInputDialog("Type gravity (Common value 9.81)"));}
    	 
		
        //Model Class creates its own object 
        MovingBall ball = new MovingBall(initialVelocity, angle, gravity, box_size - balls_radius-12, balls_radius, 130,493);// 9 gravity, 585
																										
																										
		//View Classes creates they own objects 
        BallWriter ball_writer = new BallWriter(ball, Color.red);
		AnimationWriter writer = new AnimationWriter(ball_writer, box_size);
		
		// Construct the controller and start it:
		new BounceController(ball, writer).runAnimation();

	}
}
