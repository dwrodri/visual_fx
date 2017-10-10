
import objectdraw.*;
import java.awt.*;
public class Numpad
{
    private DrawingCanvas myCanvas;
    private int myPressed, nextCount, powerCounter;
    private Button[] numpad= new Button [12]; 
    private FramedRect border; 
    private double adjust; 
    public Numpad (double x, double y, DrawingCanvas canvas)
    { 
        myCanvas = canvas;
        border= new FramedRect (x,y,canvas.getWidth()-2*x, canvas.getHeight()-2*y, canvas);
        adjust= border.getHeight()/5;
        border.hide();
        for (int i = 0;  i < numpad.length-2; i++)
        { 
            if (i==0)
            { 
                numpad[i]= new Button (border.getX(), border.getY()+adjust*3, adjust*2, adjust, Color.CYAN, canvas); 
                numpad[i].setText (""+i);               
            } 
            else if (i==1 || i==4 || i==7)
            {
                numpad[i]= new Button (border.getX(), numpad[i-1].getY()-adjust, adjust, adjust, Color.CYAN, myCanvas); 
                numpad[i].setText (""+i);
            }
            else 
            { 
                numpad[i]= new Button (numpad[i-1].getX()+ numpad[i-1].getWidth(), numpad[i-1].getY(), adjust, adjust, Color.CYAN, myCanvas); 
                numpad[i].setText(""+i); 
            }
        }
        numpad[10]= new Button (numpad[0].getX()+numpad[0].getWidth(), numpad[0].getY(), adjust, adjust, Color.RED, myCanvas);
        numpad[10].setText ("NEG");
        numpad[11]= new Button (numpad[0].getX(), numpad[0].getY()+adjust, adjust*3, adjust, Color.YELLOW, canvas); 
        numpad[11].setText ("NEXT");   
        nextCount= 0; 
        powerCounter=0;
    }

    public int getValue(Location n)
    { 
        for (int i = 0;  i < numpad.length-2; i++)
        { 
            if (numpad[i].pressCheck(n) == true)
            { 
                myPressed+= i*Math.pow(10,powerCounter);
                powerCounter++;
            } 
        } 
        if (numpad[10].pressCheck(n) == true)
        { 
            int x= -myPressed;
            myPressed= x;
        } 
        return myPressed;               
    }

    public boolean checkNext(Location n)
    {
        if(numpad[11].pressCheck(n)==true)
        {
            powerCounter=0;
            myPressed=0;
        }
        return numpad[11].pressCheck(n);       
    }

    
    public void prep()
    { 
        numpad[11].setColor(Color.GREEN); 
        numpad[11].setText ("RUN");
    } 
}

