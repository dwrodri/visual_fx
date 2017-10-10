
import objectdraw.*;
import java.awt.*;

public class Button
{ 
    private FilledRect piece;
    private FramedRect frame;
    private Text words, myText; 
    private boolean pressed, working;
    private double myX, myY, myW, myH;
    private DrawingCanvas myCanvas; 
    private Color myColor, disable;
    private String myWords;
    
    public Button (double x, double y, double w, double h, Color c, DrawingCanvas canvas)
    {
        myX= x;
        myY= y;
        myW= w;
        myH= h;
        myCanvas= canvas;
        myColor= c;
        piece= new FilledRect (x, y, w, h, canvas);
        piece.setColor (c); 
        frame= new FramedRect (x, y, w, h, canvas);
        words= new Text ("words", x, y, canvas); 
        words.move ((frame.getWidth()-words.getWidth())/2, (frame.getHeight() - words.getHeight())/2);
        frame.sendToFront();
        pressed = false; 
        working = true;
    }
    
    public boolean pressCheck (Location referenceLoc)
    {
              
        if (frame.contains (referenceLoc) && working)
        {
            pressed = true;
        }
        
        else
        { 
            pressed=false;
        } 
        
        return pressed;
    }
    
    public void setText (String goesHere) 
    { 
        words.setText (goesHere);
        words.moveTo (frame.getX() + (frame.getWidth()-words.getWidth())/2, frame.getY() + (frame.getHeight() - words.getHeight())/2);
    }
    
    public void subText (Text anyText)
    { 
        anyText.moveTo (words.getX(), words.getY());
        words= anyText;
        words.moveTo (frame.getX() + (frame.getWidth()-words.getWidth())/2, frame.getY() + (frame.getHeight() - words.getHeight())/2);
    }
    
    public double getX()
    {
        return frame.getX(); 
    } 
    
    public double getY()
    { 
        return frame.getY();
    } 
    
    public double getWidth()
    { 
        return frame.getWidth();
    } 
    
    public double getHeight()
    { 
        return frame.getHeight();
    } 
    
    public void hide()
    { 
        piece.hide();
        frame.hide();
        words.hide();
    }
    
    public void show()
    { 
        piece.show();
        frame.show();
        words.show();
    }
        
    public void removeFromCanvas()
    { 
        piece.removeFromCanvas();
        frame.removeFromCanvas(); 
        words.removeFromCanvas(); 
    } 
    
    public void setTextColor (Color newWordColor)
    { 
        words.setColor (newWordColor);
    }
    
    public void enable ()
    { 
        piece.setColor(myColor); 
        setTextColor(Color.WHITE); 
        working = true; 
    } 
    
    public void disable()
    {
        disable= new Color (80,80,80);
        piece.setColor(disable);
        setTextColor(disable); 
        working = false; 
    } 
    
    public void setColor (Color c)
    { 
        piece.setColor(c);
    } 
    
    public Color getColor()
    { 
        return piece.getColor();
    }
    
    public String getText()
    { 
        return words.getText();
    } 
    
    
    
    
        
}