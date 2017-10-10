import objectdraw.*; 
public class PointSlopeEQ
{
    private int myH, myK, myM; 
    private DrawingCanvas myCanvas;

    public PointSlopeEQ(int h, int m, int k, DrawingCanvas canvas)
    {
        myH= h; 
        myM= m; 
        myK= k; 
        myCanvas= canvas;
    }

    public int solveInt(double x)
    {
        int desired= ((int)(myM*(x-myH)+myK)); 
        return desired; 
    }
    
    public double solveDouble(double x)
    {
        double desired= myM*(x-myH)+myK;
        return desired; 
    }
    
    public void graph (int fix) 
    {
        double graphM= myM * Math.pow(fix, -1); 
        double graphH= myH * fix; 
        double graphK= myK * fix; 
        for (int x=0; x <myCanvas.getWidth()/2; x+=.01)
        { 
            double graphX= myCanvas.getWidth()/2+x;
            double graphY= myCanvas.getWidth()/2-(graphM*(x-graphH)+graphK);
            new FilledOval (graphX-1, graphY-1, 2, 2, myCanvas); 
        } 
        for (int x=0; x >-myCanvas.getWidth()/2; x-=.01)
        { 
            double graphX= myCanvas.getWidth()/2+x;
            double graphY= myCanvas.getWidth()/2-(graphM*(x-graphH)+graphK);
            new FilledOval (graphX-1, graphY-1, 2, 2, myCanvas); 
        }
    }
}
