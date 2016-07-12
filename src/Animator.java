
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;


public class Animator implements Runnable {
    JPanel drawingPanel;
    int numBalls;
    Ball[] balls;
    int numCrests;
    double xCentre, yCentre;
    double cycleFreq;
    double amplitude;
    double middleRadius;
    int minRadius, maxRadius;
    double phaseShiftPerSpoke;
    double deltaTheta;
    boolean showSpokes, showInnerRing, showOuterRing, showTracerBalls;
    int ballRadius;
    int sleepTime;
    int frameNumber;
    Color defaultBallColour, backgroundColour;
    
    Thread runner;
    
    public Animator( JPanel jp, int nb, int nc, int rMin, int rMax, int speed, boolean ss, boolean sir, boolean sor, boolean st, int frameStart, Color c ){
        this.drawingPanel = jp;
        this.numBalls = nb;
        this.numCrests = nc;
        this.minRadius = rMin;
        this.maxRadius = rMax;
        this.showSpokes = ss;
        this.showInnerRing = sir;
        this.showOuterRing = sor;
        this.showTracerBalls = st;
        this.defaultBallColour = c;
        this.xCentre = 300;
        this.yCentre = 300;
        this.frameNumber = frameStart;
        this.cycleFreq = 0.09;
        
        recalculateValues( speed );
       }
    
    
    public void recalculateValues( int speed ) {
        
        phaseShiftPerSpoke = numCrests * 2 * Math.PI / (cycleFreq * numBalls);
        amplitude = (maxRadius - minRadius)/2;
        middleRadius = (maxRadius + minRadius)/2 + ballRadius;
        deltaTheta = 2*Math.PI/numBalls;
        ballRadius = Math.min( Math.max( 440/numBalls, 4 ) , 20);
        sleepTime = -4*(speed-1) + 36;  //ranges from 0 to 36
        
        if( this.defaultBallColour == Color.black) 
            this.backgroundColour = Color.white;
        else
            this.backgroundColour = Color.black;
        
        setBalls();
    }
    
    
    public void setBalls() {
        balls = new Ball[numBalls];
        
        boolean isTracer;
        
        int n = numBalls/numCrests;
        
        for (int i = 0; i < balls.length; i++) {
            double angle = i * deltaTheta;
            
            if( showTracerBalls ) 
                if( i % n == 0  && i <= numBalls - numCrests)
                    isTracer = true;
                else
                    isTracer = false;
            else   
                isTracer = false;
                
            balls[i] = new Ball(angle, ballRadius, isTracer, defaultBallColour);            
        }
    }
    
    
    public static void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } 
        catch (Exception e) {
        }
    }
    
    public void drawScreen() {
        Image img = createImage();
        Graphics g = drawingPanel.getGraphics();
        g.drawImage(img, 0, 0 , drawingPanel);
    }
    
    public Image createImage() {
        BufferedImage bi = new BufferedImage(drawingPanel.getWidth(),drawingPanel.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) bi.getGraphics();
        
        g.setColor(backgroundColour);
        g.fillRect(0,0,600,600);        
        
        for (int i = 0; i < balls.length; i++) 
            balls[i].draw(g);

        if( showSpokes ) 
            for (int i = 0; i < balls.length; i++) 
                balls[i].drawSpoke(g);              
                    
                
        if( showInnerRing ) {
            int r = minRadius;
            if( this.defaultBallColour == Color.black) 
                g.setColor(Color.black);
            else
                g.setColor(Color.white);
            g.fillOval((int)(xCentre - r), (int)(yCentre-r), 2*r, 2*r);
        }
        
        if( showOuterRing ) {
            int r = maxRadius + 2*ballRadius;
            if( this.defaultBallColour == Color.black) 
                g.setColor(Color.black);
            else
                g.setColor(Color.white);
            g.drawOval((int)(xCentre - r), (int)(yCentre-r), 2*r, 2*r);
        }
               
        return bi;
    }
    
    public void updateBallPositions(int f) {
        for (int i = 0; i < balls.length; i++) {
            Ball b = balls[i];
            b.phaseShift = phaseShiftPerSpoke * i;
            b.distFromCentre = amplitude * Math.sin( cycleFreq * (f - b.phaseShift)) + middleRadius + ballRadius;
            b.x = xCentre + b.distFromCentre * Math.cos( b.theta );
            b.y = yCentre - b.distFromCentre * Math.sin( b.theta );
            
        }
    }
    
    public void run() {
        
        while( Thread.currentThread() == runner ) {           
            updateBallPositions( frameNumber ); 
            drawScreen();
            sleep( sleepTime );
            frameNumber++;
        }
    }
    
}
