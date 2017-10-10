import objectdraw.*;
import java.awt.*;

public class Graph
{ 
    private Line[] verticalLines= new Line [40];    
    private Line[] horizontalLines= new Line [40];
    private FramedRect border; 
    private Line xAxis, yAxis; 
    private int graphInput;
    private double horizontalSpacer, verticalSpacer;
    private DrawingCanvas myCanvas;
    
    public Graph (DrawingCanvas canvas)
    {
        myCanvas=canvas;
        border= new FramedRect (10,10, canvas.getWidth()-20, canvas.getHeight()-20, canvas);
        horizontalSpacer= border.getWidth()/40;
        for (int i = 0; i < horizontalLines.length; i++)
        {            
            horizontalLines[i]= new Line (border.getX(), border.getY()+horizontalSpacer*i, border.getX()+ border.getWidth(), border.getY()+horizontalSpacer*i, canvas);
            horizontalLines[i].setColor (new Color (150,150,150)); 
            
        }
        verticalSpacer= border.getWidth()/40;
        for (int i = 0; i < verticalLines.length; i++)
        { 
            verticalLines[i]= new Line (border.getX() + verticalSpacer*i, border.getY() , border.getX()+verticalSpacer*i, border.getY()+border.getHeight(), canvas);
            verticalLines[i].setColor (new Color (150,150,150)); 
        }
        xAxis = new Line (border.getX(),canvas.getHeight()/2, border.getX()+border.getWidth(), canvas.getHeight()/2, canvas);
        xAxis.setColor (Color.RED);
        yAxis = new Line (border.getX()+border.getWidth()/2, border.getY(),border.getX()+border.getWidth()/2, border.getY()+border.getHeight(), canvas); 
        yAxis.setColor(Color.RED); 
    }
    
    public double fix()
    {
        double spacer= border.getWidth()/horizontalLines.length;
        return horizontalSpacer;
    } 
   
}
