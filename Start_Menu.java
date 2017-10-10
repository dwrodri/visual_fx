import objectdraw.*;
import java.awt.*;
public class Start_Menu
{
    private DrawingCanvas myCanvas;
    private Text introWords;
    private Button standForm, zeroForm, exponential, log, slopeInt, pointSlope;
    private String myWords;
    public Start_Menu (DrawingCanvas canvas)
    {
        myCanvas= canvas;
        introWords= new Text ("Visual f(x)", 0, 0, myCanvas); 
        introWords.setFont ("Times New Roman"); 
        introWords.setFontSize (myCanvas.getWidth()/8); 
        introWords.setColor (Color.ORANGE); 
        introWords.setItalic (true); 
        introWords.setBold (true); 
        introWords.move ((myCanvas.getWidth()-introWords.getWidth())/2, myCanvas.getHeight()/20);          
        standForm= new Button (0, myCanvas.getHeight()/2, myCanvas.getWidth()/6, myCanvas.getHeight()/8, Color.BLUE, myCanvas); 
        standForm.setText ("Standard");
        standForm.setTextColor(Color.WHITE);
        zeroForm= new Button (0, standForm.getY() + standForm.getHeight(), myCanvas.getWidth()/6, myCanvas.getHeight()/8, Color.BLUE, myCanvas);
        zeroForm.setText ("Zero"); 
        zeroForm.setTextColor (Color.WHITE);
        exponential= new Button (standForm.getX()+standForm.getWidth()+canvas.getWidth()/12,standForm.getY(),canvas.getWidth()/6,canvas.getHeight()/8,Color.BLUE,canvas); 
        exponential.setText("Exponential"); 
        exponential.setTextColor (Color.WHITE); 
        log= new Button (standForm.getX()+2*standForm.getWidth()+2*canvas.getWidth()/12,standForm.getY(),canvas.getWidth()/6,canvas.getHeight()/8,Color.BLUE,canvas); 
        log.setText("Logarithm"); 
        log.setTextColor (Color.WHITE);
        slopeInt= new Button (standForm.getX()+3*standForm.getWidth()+3*canvas.getWidth()/12, standForm.getY(),canvas.getWidth()/6,  canvas.getHeight()/8, Color.BLUE, canvas);
        slopeInt.setText("Slope-Intercept"); 
        slopeInt.setTextColor (Color.WHITE);
        pointSlope= new Button (standForm.getX()+3*standForm.getWidth()+3*canvas.getWidth()/12, standForm.getY()+standForm.getHeight(), canvas.getWidth()/6, canvas.getHeight()/8, Color.BLUE, canvas);
        pointSlope.setText("Point-Slope"); 
        pointSlope.setTextColor (Color.WHITE);
    }

    public String getEquation(Location fromDriver)
    {         
        if (standForm.pressCheck(fromDriver)) 
        { 
            myWords= standForm.getText(); 
        }
        else if (zeroForm.pressCheck(fromDriver))
        { 
            myWords= zeroForm.getText();
        }
		else if (exponential.pressCheck(fromDriver)) 
		{ 
			myWords= exponential.getText();
		}
		else if (log.pressCheck(fromDriver)) 
		{ 
			myWords= log.getText();
		}
		else if (slopeInt.pressCheck(fromDriver))
		{ 
		    myWords= slopeInt.getText(); 
		} 
		else if (slopeInt.pressCheck(fromDriver))
		{ 
		    myWords= slopeInt.getText(); 
		} 
		else if (pointSlope.pressCheck(fromDriver))
		{ 
		    myWords= pointSlope.getText();
		}
        return myWords;
    }
}
