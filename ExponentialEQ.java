import java.awt.*;
import objectdraw.*;
public class ExponentialEQ extends ActiveObject
{ 
    private int myBase;
    private int myA, myB;
    private DrawingCanvas myCanvas;
    private double myFix;
    public ExponentialEQ (int base, int a, int b, DrawingCanvas canvas)
    {
        myBase=base; 
        myA=a;
        myB=b;
        myCanvas= canvas;
    }

    public int solveInt(int x)
    {
        int desired= (int)(Math.pow(myBase,x+myA)+myB); 
        return desired;
    } 

    public double solveDouble(double x) 
    {
        double desired= Math.pow(myBase, x+myA)+myB; 
        return desired; 
    }

    public void graph (double fix) 
    {
        myFix=fix;
        start();        
    }  

    public void run() 
    {
        for (double x=0;x<myCanvas.getWidth()/2;x+=.01)
        {
            double graphX=  myCanvas.getWidth()/2+x;
            double graphY= myCanvas.getWidth()/2-(myFix*Math.pow(myBase,(x+myA)/10)+myB*myFix);  
            new FilledOval (graphX, graphY-1,2,2,myCanvas);
        }
        for (double x=0;x>-myCanvas.getWidth()/2;x-=.01) 
        { 
            double graphX= myCanvas.getWidth()/2+x;
            double graphY= myCanvas.getWidth()/2-(myFix*Math.pow(myBase,(x+myA)/10)+myB*myFix);
            new FilledOval (graphX,graphY-1,2,2,myCanvas);
        }
    }
}
 


    

