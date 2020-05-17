//* MovingBall is a model class who models a moving ball that moves in two dimensional space  */

public class MovingBall
{ private int x_pos;                    // ball's center x-position
  private int y_pos;                   // ball's center y-position
  private int radius;                 // ball's radius
  private double time_units = 0;     // Time units for the ball
  private int initialVelocity;      //Intitial Velocity of the ball
  private int angle;               //Angle in wich ball gets its trajectory
  private double gravity;         //Pull of gravity
  private double bottom;            //Frame's bottom
  private int x;                //X - position
  private int y;               //Y - position

 
  /** Constructor MovingBall constructs the ball.
  * @param initialVelocity - Initial Velocity wich ball moves 
  * @param angle - angle in wic ball moves on his trajectory .
  * @param gravity - Pul of gravity while ball moves .
  * @param bottom - frame's bottom .
  * @param r - the ball's radius
  * @param x - the center of the ball's starting horizontal position
  * @param y - the center of the ball's starting vertical position */
  
  public MovingBall(int initialVelocity, int angle, double gravity, double bottom, int r,int x,int y)
  { this.initialVelocity = initialVelocity; //Initial Velocity
    this.angle = angle;                    //Moving angle 
    this.gravity = gravity;               //Pull of gravity
    this.bottom = bottom;                //frame's bottom
    x_pos = this.x=x;                   //ball's x position
    y_pos = this.y=y;                  //ball's y position
    radius = r;                       //ball's radius
  }

  /** xPosition returns the ball's current horizontal position */
  public int xPosition()
  { return x_pos; }

  
  /** yPosition returns the ball's current vertical position */
  public int yPosition()
  { return y_pos; }

  
  /** radiusOf returns the ball's radius */
  public int radiusOf()
  { return radius; }
  
  
 
/** move method – implements X_pos and Y_pos by given formulas */

  public boolean move()
  {
  if(y_pos > bottom){
   return false;
  }
  else{
   x_pos = x + (int)(initialVelocity * Math.cos(angle * Math.PI / 180) * time_units);
   y_pos = y + (int)((gravity * time_units * time_units / 2) - (50 * Math.sin(angle *   Math.PI / 180) * time_units));
   time_units += 0.1;
   return true;
  }
  }
}