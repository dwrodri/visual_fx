 import java.awt.*; 
import objectdraw.*;

public class LogarithmEQ extends ActiveObject
{
   private FilledOval equationLine; 
   private int myBase, myA, myB, myC;
   private double myFix;
   private DrawingCanvas myCanvas;

   
    public LogarithmEQ(int base, int a, int b, DrawingCanvas canvas)
    {
       myBase= base;
       myA= a; 
       myB= b; 
       myCanvas= canvas; 
    }

    public int solveInt (double x)
    {
        int desired= ((int)((Math.log10(x+myA)+myB)/Math.log10(myBase)));
        System.out.println (desired);
        return desired;
    }
    
    public double getZero() 
    { 
        double desired= Math.pow(myBase, -myB)-myA;
        return desired;
    }
    
    public double solveDouble(double x)
    {
        double desired= (((Math.log10(x+myA)+myB)/Math.log10(myBase)));
        return desired;    
    } 
    
    public void graph (double fix)
    {
        myFix= fix; 
        for (double x=0;x < myCanvas.getWidth()/2;x+=.01)
        {
            double graphX= myCanvas.getWidth()/2 + x;
            double graphY= myCanvas.getWidth()/2 - (myFix*(Math.log10(((x+myA*myFix)/myFix))/Math.log10(myBase)+myB));
            equationLine= new FilledOval (graphX, graphY-1, 2,2, myCanvas);
        }
         for (double x=0;x>-myCanvas.getWidth()/2;x-=.01) 
        {
            double graphX= myCanvas.getWidth()/2 + x;
            double graphY= myCanvas.getWidth()/2 - (myFix*(Math.log10((x+myA*myFix)/myFix))/Math.log10(myBase)+myB);
            equationLine= new FilledOval (graphX, graphY-1, 2,2, myCanvas);
        }
      
    } 



}
