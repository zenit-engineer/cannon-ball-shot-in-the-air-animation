/** BounceController controls a moving ball within a box. */

public class BounceController

{ private MovingBall ball;           // model object
  private AnimationWriter writer;   // output-view object

  /** Constructor BounceController initializes the controller
  * @param b - the model object
  * @param w - the output-view object */
  public BounceController(MovingBall b, AnimationWriter w)
  { ball = b;
    writer = w;
  }

  /** runAnimation runs the animation by means of an internal clock */

  public void runAnimation()
  { int painting_delay = 6;       // how long to delay between repaintings
    writer.repaint();             // redisplay box and ball
    delay(2000);
    
    while ( ball.move() )
          { delay(painting_delay); 
            System.out.println(ball.xPosition() + ", " + ball.yPosition());
            writer.repaint();   // redisplay box and ball
          }
  }

 
 
/** delay pauses execution for how long milliseconds */

  private void delay(int how_long)
  { try { Thread.sleep(how_long); }    //how_long = 2000millisecs
    catch (InterruptedException e) { }
  }
}

