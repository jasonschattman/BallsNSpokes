
import java.awt.Color;
import java.awt.Graphics;


public class Ball {
    double x, y, theta, distFromCentre, phaseShift;
    int radius, diameter;
    boolean isTracerBall;
    Color colour;
    
    public Ball(double angle, int r, boolean isTracer, Color c) {
        this.theta = angle;
        this.radius = r;
        this.diameter = 2*r;
        this.isTracerBall = isTracer;
        if (isTracer)
            this.colour = Color.red;
        else
            this.colour = c;
    }
    
    public void draw( Graphics g ) {
        g.setColor(colour);
        g.fillOval( (int)x-radius, (int)y-radius, diameter, diameter);
    }
    
    public void drawSpoke( Graphics g ) {
        g.setColor(colour);
        g.drawLine(300, 300, (int)x, (int)y);
    }
    
}
