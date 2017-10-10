import objectdraw.*;
import java.awt.*;

public class QuadraticEquation extends ActiveObject
{ 

    private int myA, myB, myC, i;
    private DrawingCanvas myCanvas;   
    private double y, adjust, myFix, zero1, zero2, graphA, graphZ1, graphZ2;    
    private Color graphColor;
    private FilledOval equationLine;
    private boolean standardPicker;
    public QuadraticEquation (int a, int b, int c, boolean f, DrawingCanvas canvas)
    { 
        myA= a;
        myB = b;
        myC = c;
        standardPicker = f;
        myCanvas = canvas;
        adjust= myCanvas.getWidth()/2;
        if (f == true)
        { 
            zero1= (-b - (Math.sqrt(Math.pow(b,2)-4*a*c)))/(2*a);
            zero2= (-b + (Math.sqrt(Math.pow(b,2)-4*a*c)))/(2*a);
        }
        else 
        { 
            zero1= -b;
            zero2= -c;
        }
    }   

    public double getSmallZero()
    {
        return zero1;
    }

    public double getBigZero()
    { 
        return zero2;
    }

    public void graph(double fix)
    { 
        if (standardPicker == true)
        {
            graphA = myA * Math.pow (fix , -1);
            graphZ1= -zero1 * fix;
            graphZ2= -zero2 * fix;  
            myFix= fix;
        }
        else 
        { 
            graphA= myA*Math.pow(fix, -1);
            graphZ1= -zero1*fix;
            graphZ2= -zero2*fix;
        }
        start();
    }   

    public void run()
    {         

        for (double x=0;x<myCanvas.getWidth()/2;x+=.05)
        { 
            double graphX= myCanvas.getWidth()/2+x;
            double y= myCanvas.getWidth()/2 - (graphA* (x+graphZ1)* (x+graphZ2));
            equationLine= new FilledOval (graphX, y, 2, 2, myCanvas);            
        } 
        for (double x=0;x>-myCanvas.getWidth()/2;x-=.05)
        { 
            double graphX= myCanvas.getWidth()/2+x;
            double y= myCanvas.getWidth()/2 - (graphA* (x+graphZ1)* (x+graphZ2));
            equationLine= new FilledOval (graphX, y, 2, 2, myCanvas);            
        } 

    }

    public double solve(int x)
    { 
        double y=myA * (x-zero1)*(x-zero2);
        return y;
    }
}
