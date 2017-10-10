import objectdraw.*; 
public class SlopeIntEQ
{
    private int myM, myB;
    private DrawingCanvas myCanvas; 
    public SlopeIntEQ(int m, int b, DrawingCanvas canvas)
    {
        myM= m; 
        myB=b; 
        myCanvas=canvas;
    }    
    
    public int solveInt(double x)
    {
        int desired= ((int)(myB*x+myM)); 
        return desired; 
    }
    
    public double solveDouble(double x)
    {
        double desired= myB*x+myM; 
        return desired; 
    }
    
    public void graph (int fix) 
    {
        double graphM= myM * Math.pow(fix, -1); 
        double graphB= myB * fix; 
        for (int x=0; x <myCanvas.getWidth()/2; x+=.01)
        { 
            double graphX= myCanvas.getWidth()/2+x;
            double graphY= myCanvas.getWidth()/2-(graphM*x+graphB); 
            new FilledOval (graphX-1, graphY-1, 2, 2, myCanvas); 
        } 
        for (int x=0; x >-myCanvas.getWidth()/2; x-=.01)
        { 
            double graphX= myCanvas.getWidth()/2+x;
            double graphY= myCanvas.getWidth()/2-(graphM*x+graphB); 
            new FilledOval (graphX-1, graphY-1, 2, 2, myCanvas); 
        }
    }
        
}
