import objectdraw.*;
import java.awt.*; 
import java.awt.event.*;

public class Display_Driver extends WindowController implements MouseMotionListener//, MouseListener
{ 
    private Start_Menu menu;
    private Numpad keys;
    private Text equationText, zeroDisplay, yIntercept, solvedEQ, vertexDisplay, vaDisplay, haDisplay;
    private Text varDisplay[];
    private int inputVars[], driverCount;
    private boolean menuOff, numpadOff; 
    private Location myLoc;
    private QuadraticEquation quaddy;
    private ExponentialEQ expy;
    private LogarithmEQ loggy;
    private FrameCanvas graphCanvas;
    private Graph grid;
    private boolean picker, once;
    private String buttonID;
    private DrawingCanvas myCanvas;

    public static void main (String []args)
    { 
        new Display_Driver().startController(1200,600);
    } 

    public void begin()
    {
        menu= new Start_Menu (canvas);
        menuOff= false; 
        numpadOff= true;
        myCanvas= canvas;
    }

    public void onMousePress (Location here)
    { 
        myLoc = here;
        if (!menuOff)
        {
            buttonID= menu.getEquation(myLoc);
        }
         if (buttonID.equals("Standard") && !menuOff)
        { 
            canvas.clear();
            menuOff= true;
            numpadOff= false;
            keys= new Numpad (10, 10, canvas);
            varDisplay= new Text [3];
            inputVars= new int [varDisplay.length];
            equationText= new Text ("__x^2+__x+__", canvas.getWidth()*.65, canvas.getHeight()/2, canvas);
            equationText.setFontSize ((int)(canvas.getHeight()/16));
            varDisplay [0]= new Text (""+inputVars[0], equationText.getX(), equationText.getY(), canvas);
            varDisplay [0].setFontSize ((int)(canvas.getHeight()/24));
            varDisplay[0].moveTo(equationText.getX(), equationText.getY()+5);
            varDisplay [1]= new Text (""+inputVars[1], equationText.getX()+equationText.getWidth()/2, equationText.getY(), canvas);
            varDisplay [1].setFontSize ((int)(canvas.getHeight()/24));
            varDisplay[1].moveTo(equationText.getX()+equationText.getWidth()/2, equationText.getY()+5);
            varDisplay [2]= new Text (""+inputVars[2], equationText.getX()+equationText.getWidth()-equationText.getWidth()/6, equationText.getY(), canvas);
            varDisplay [2].setFontSize ((int)(canvas.getHeight()/24));  
            varDisplay[2].moveTo(equationText.getX()+equationText.getWidth()-equationText.getWidth()/6, equationText.getY()+5);
            varDisplay[1].hide();
            varDisplay[2].hide();
            varDisplay[0].setColor (Color.RED);
            driverCount= 0;
            picker= true; 
            graphCanvas= new FrameCanvas (400,400); 
            grid= new Graph (graphCanvas);
            graphCanvas.addMouseMotionListener(this); 
            setFocusable(true);
        }
        else if (buttonID.equals("Zero") && !menuOff) 
        { 
            canvas.clear();
            menuOff= true;
            numpadOff= false;
            keys= new Numpad (10, 10, canvas);
            varDisplay= new Text [3];
            inputVars= new int [varDisplay.length];
            equationText= new Text ("_(x+_)(x+_)", canvas.getWidth()*.65, canvas.getHeight()/2, canvas);
            equationText.setFontSize ((int)(canvas.getHeight()/16));
            varDisplay [0]= new Text (""+inputVars[0], equationText.getX(), equationText.getY(), canvas);
            varDisplay [0].setFontSize ((int)(canvas.getHeight()/24));
            varDisplay[0].moveTo(equationText.getX(), equationText.getY()+5);
            varDisplay [1]= new Text (""+inputVars[1], equationText.getX()+equationText.getWidth()/2, equationText.getY(), canvas);
            varDisplay [1].setFontSize ((int)(canvas.getHeight()/24));
            varDisplay[1].moveTo(equationText.getX()+equationText.getWidth()*.4, equationText.getY()+5);
            varDisplay [2]= new Text (""+inputVars[2], equationText.getX()+equationText.getWidth()-equationText.getWidth()/6, equationText.getY(), canvas);
            varDisplay [2].setFontSize ((int)(canvas.getHeight()/24));  
            varDisplay[2].moveTo(equationText.getX()+equationText.getWidth()-equationText.getWidth()/5, equationText.getY()+5);
            varDisplay[1].hide();
            varDisplay[2].hide();
            varDisplay[0].setColor (Color.RED);
            driverCount= 0;
            picker= false; 
            graphCanvas= new FrameCanvas (500,500); 
            grid= new Graph (graphCanvas);
            graphCanvas.addMouseMotionListener(this);
            setFocusable(true);
        }
        else if (buttonID.equals("Exponential") && !menuOff) 
        { 
            canvas.clear();
            menuOff= true;
            numpadOff= false;
            keys= new Numpad (10, 10, canvas);
            varDisplay= new Text [3];
            inputVars= new int [varDisplay.length];
            equationText= new Text ("_^(x+_)+_", canvas.getWidth()*.65, canvas.getHeight()/2, canvas);
            equationText.setFontSize ((int)(canvas.getHeight()/16));
            varDisplay [0]= new Text (""+inputVars[0], equationText.getX(), equationText.getY(), canvas);
            varDisplay [0].setFontSize ((int)(canvas.getHeight()/24));
            varDisplay[0].moveTo(equationText.getX(), equationText.getY()+5);
            varDisplay [1]= new Text (""+inputVars[1], equationText.getX()+equationText.getWidth()/2, equationText.getY(), canvas);
            varDisplay [1].setFontSize ((int)(canvas.getHeight()/24));
            varDisplay[1].moveTo(equationText.getX()+equationText.getWidth()*.55, equationText.getY()+5);
            varDisplay [2]= new Text (""+inputVars[2], equationText.getX()+equationText.getWidth()-equationText.getWidth()/9, equationText.getY(), canvas);
            varDisplay [2].setFontSize ((int)(canvas.getHeight()/24));  
            varDisplay[2].moveTo(equationText.getX()+equationText.getWidth()-equationText.getWidth()/9, equationText.getY()+5);
            varDisplay[1].hide();
            varDisplay[2].hide();
            varDisplay[0].setColor (Color.RED);
            driverCount= 0;
            picker= false; 
            graphCanvas= new FrameCanvas (500,500); 
            grid= new Graph (graphCanvas);
            graphCanvas.addMouseMotionListener(this);
            setFocusable(true);
        }
        else if (buttonID.equals("Logarithm")&&!menuOff)
        { 
            canvas.clear();
            menuOff= true;
            numpadOff= false;
            keys= new Numpad (10, 10, canvas);
            varDisplay= new Text [3];
            inputVars= new int [varDisplay.length];
            equationText= new Text ("log_(x+_)+_", canvas.getWidth()*.65, canvas.getHeight()/2, canvas);
            equationText.setFontSize ((int)(canvas.getHeight()/16));
            varDisplay [0]= new Text (""+inputVars[0], equationText.getX(), equationText.getY(), canvas);
            varDisplay [0].setFontSize ((int)(canvas.getHeight()/24));
            varDisplay[0].moveTo(equationText.getX()+(equationText.getWidth()*.26), equationText.getY()+5);
            varDisplay [1]= new Text (""+inputVars[1], equationText.getX()+equationText.getWidth()/2, equationText.getY(), canvas);
            varDisplay [1].setFontSize ((int)(canvas.getHeight()/24));
            varDisplay[1].moveTo(equationText.getX()+(equationText.getWidth()*.63), equationText.getY()+5);
            varDisplay [2]= new Text (""+inputVars[2], equationText.getX()+equationText.getWidth()-equationText.getWidth()/9, equationText.getY(), canvas);
            varDisplay [2].setFontSize ((int)(canvas.getHeight()/24));  
            varDisplay[2].moveTo(equationText.getX()+equationText.getWidth()-equationText.getWidth()/11, equationText.getY()+5);
            varDisplay[1].hide();
            varDisplay[2].hide();
            varDisplay[0].setColor (Color.RED);
            driverCount= 0;
            graphCanvas= new FrameCanvas (500,500); 
            grid= new Graph (graphCanvas);    
            graphCanvas.addMouseMotionListener(this);
            setFocusable(true); 
        }
        
        else if (buttonID.equals("Point-Slope")&&!menuOff) 
        { 
            canvas.clear();
            menuOff= true;
            numpadOff= false;
            keys= new Numpad (10, 10, canvas);
            varDisplay= new Text [2];
            inputVars= new int [varDisplay.length];
            equationText= new Text ("_x+_", canvas.getWidth()*.65, canvas.getHeight()/2, canvas);
			equationText.setFontSize ((int)(canvas.getHeight()/16));
            varDisplay[0]= new Text (""+inputVars[0], equationText.getX(), equationText.getY(), canvas); 
			varDisplay [0].setFontSize ((int)(canvas.getHeight()/24));
			varDisplay[1]= new Text (""+inputVars[1], equationText.getX()+ (equationText.getWidth()*.75), equationText.getY(), canvas); 
			varDisplay [1].setFontSize ((int)(canvas.getHeight()/24));
			varDisplay[0].setColor (Color.RED); 
			varDisplay[1].hide();
        }
        	
            
        else if (numpadOff == false)
        { 
            numpadToVars();
        }
    }

    private void numpadToVars()
    { 
        if (keys.checkNext (myLoc)  ==  true && driverCount < inputVars.length)
        {             
            driverCount++;
            if (driverCount == inputVars.length)
            {
                varDisplay[driverCount-1].setColor(Color.BLACK);
                keys.prep();
            }
            else
            {
                varDisplay[driverCount].show();
                varDisplay[driverCount].setColor (Color.RED); 
                varDisplay[driverCount-1].setColor(Color.BLACK);
            }
        } 
        else if (driverCount < inputVars.length)
        { 
            inputVars[driverCount]=keys.getValue(myLoc);
            varDisplay[driverCount].setText(""+inputVars[driverCount]); 
        }  
        else if (buttonID.equals("Standard")&&keys.checkNext(myLoc) && driverCount == inputVars.length && picker)
        { 
            canvas.clear();
            numpadOff= true;
            quaddy= new QuadraticEquation (inputVars[0], inputVars[1], inputVars[2], picker, graphCanvas);
            solvedEQ= new Text (inputVars[0] + "x^2+" + inputVars[1] + "x+" + inputVars[2], 0,0, canvas);            
            solvedEQ.setFontSize((int)canvas.getWidth()/16);
            solvedEQ.setFont ("Times New Roman");
            solvedEQ.setColor (Color.GREEN);
            solvedEQ.move ((canvas.getWidth()-solvedEQ.getWidth())/2,0);     
            zeroDisplay= new Text ("X-Intercepts @ " + "(" + quaddy.getSmallZero() + ",0) & (" + quaddy.getBigZero() + ",0)", solvedEQ.getX(), solvedEQ.getY()+ solvedEQ.getHeight(), canvas);
            zeroDisplay.setFontSize ((int)canvas.getWidth()/24);
            zeroDisplay.setBold(true);
            zeroDisplay.move ((solvedEQ.getWidth()-zeroDisplay.getWidth())/2,0);
            yIntercept= new Text ("Y-Intercept @ " +"("+quaddy.solve(0)+",0)", zeroDisplay.getX(), zeroDisplay.getY()+zeroDisplay.getHeight(), canvas);
            yIntercept.setFontSize ((int)canvas.getWidth()/24);
            yIntercept.setBold(true);
            yIntercept.move((zeroDisplay.getWidth()-yIntercept.getWidth())/2,0);
            vertexDisplay= new Text ("Vertex @ ("+(-inputVars[1]/(2*inputVars[0]))+","+quaddy.solve((-inputVars[1]/(2*inputVars[0])))+")",solvedEQ.getX(), yIntercept.getY()+yIntercept.getHeight(), canvas); 
            vertexDisplay.setFontSize((int)canvas.getWidth()/24);
            vertexDisplay.move((yIntercept.getWidth()-vertexDisplay.getWidth())/2,0);
            quaddy.graph (grid.fix());
        }
         if (buttonID.equals("Zero")&&keys.checkNext(myLoc) && driverCount == inputVars.length && !picker)
        { 
            canvas.clear();
            numpadOff= true;
            quaddy= new QuadraticEquation (inputVars[0], inputVars[1], inputVars[2], picker, graphCanvas);
            solvedEQ= new Text (inputVars[0] + "(x+" + inputVars[1] + ")(x+" + inputVars[2]+")", 0,0, canvas);            
            solvedEQ.setFontSize((int)canvas.getWidth()/16);
            solvedEQ.setFont ("Times New Roman");
            solvedEQ.setColor (Color.GREEN);
            solvedEQ.move ((canvas.getWidth()-solvedEQ.getWidth())/2,0);     
            zeroDisplay= new Text ("X-Intercepts @ " + "(" + quaddy.getSmallZero() + ",0) & (" + quaddy.getBigZero() + ",0)", solvedEQ.getX(), solvedEQ.getY()+ solvedEQ.getHeight(), canvas);//DYSFUNCTIONAL
            zeroDisplay.setFontSize ((int)canvas.getWidth()/24);
            zeroDisplay.setBold(true);
            zeroDisplay.move ((solvedEQ.getWidth()-zeroDisplay.getWidth())/2,0);
            yIntercept= new Text ("Y-Intercept @ " +"("+quaddy.solve(0)+",0)", zeroDisplay.getX(), zeroDisplay.getY()+zeroDisplay.getHeight(), canvas);
            yIntercept.setFontSize ((int)canvas.getWidth()/24);
            yIntercept.setBold(true);
            yIntercept.move((zeroDisplay.getWidth()-yIntercept.getWidth())/2,0);
            quaddy.graph (grid.fix());
        }
         else if (buttonID.equals("Exponential")&&keys.checkNext(myLoc) && driverCount == inputVars.length)
        { 
            canvas.clear();
            numpadOff= true;
            expy= new ExponentialEQ (inputVars[0], inputVars[1], inputVars[2], graphCanvas);
            solvedEQ= new Text (inputVars[0] + "^(x+"+inputVars[1] + ")+" + inputVars[2], 0,0, canvas); 
            solvedEQ.setFontSize((int)canvas.getWidth()/16);
            solvedEQ.setFont ("Times New Roman");
            solvedEQ.setColor (Color.GREEN);
            solvedEQ.move ((canvas.getWidth()-solvedEQ.getWidth())/2,0);
            yIntercept= new Text ("Y-Intercept @ " +"("+expy.solveInt(0)+",0)", solvedEQ.getX(), solvedEQ.getY()+solvedEQ.getHeight(), canvas);
            yIntercept.setFontSize ((int)canvas.getWidth()/24);
            yIntercept.setBold(true);
            yIntercept.move((yIntercept.getWidth()-yIntercept.getWidth())/2,0);
            haDisplay= new Text ("Horizontal Asympote @ y="+expy.solveInt(-100), solvedEQ.getX(),yIntercept.getY()+solvedEQ.getHeight(),canvas); 
            haDisplay.setFontSize ((int)canvas.getWidth()/24);
            haDisplay.setBold(true);
            haDisplay.move((solvedEQ.getWidth()-haDisplay.getWidth())/2,0); 
            expy.graph(grid.fix()); 
        }
        else if (buttonID.equals("Logarithm")&&keys.checkNext(myLoc) && driverCount == inputVars.length)
        { 
            canvas.clear();
            numpadOff= true;
            loggy= new LogarithmEQ (inputVars[0], inputVars[1], inputVars[2], graphCanvas);
            solvedEQ= new Text ("log"+inputVars[0] + "(x+"+inputVars[1] + ")+" + inputVars[2], 0,0, canvas); 
            solvedEQ.setFontSize((int)canvas.getWidth()/16);
            solvedEQ.setFont ("Times New Roman");
            solvedEQ.setColor (Color.GREEN);
            solvedEQ.move ((canvas.getWidth()-solvedEQ.getWidth())/2,0);
            zeroDisplay= new Text ("Zero @ ("+ loggy.getZero()+",0)", solvedEQ.getX(), solvedEQ.getY()+solvedEQ.getHeight(), canvas);
            zeroDisplay.setFontSize ((int)canvas.getWidth()/24);
            zeroDisplay.setBold(true);
            zeroDisplay.move((zeroDisplay.getWidth()-zeroDisplay.getWidth())/2,0);
            haDisplay= new Text ("vertical Asympote @ y="+(-inputVars[1]), solvedEQ.getX(),zeroDisplay.getY()+solvedEQ.getHeight(),canvas); 
            haDisplay.setFontSize ((int)canvas.getWidth()/24);
            haDisplay.setBold(true);
            haDisplay.move((solvedEQ.getWidth()-haDisplay.getWidth())/2,0); 
            loggy.graph(grid.fix()); 
        }
        /**else if (buttonID.equals("Point-Slope")&&keys.checkNext(myLoc) && driverCount == inputVars.length) 
        { 
            canvas.clear();
            numpadOff= true;
            loggy= new PointSlopeEQ (inputVars[0], inputVars[1], inputVars[2], graphCanvas);
            solvedEQ= new Text (inputVars[0] + "(x+"+inputVars[1] + ")+" + inputVars[2], 0,0, canvas); 
            solvedEQ.setFontSize((int)canvas.getWidth()/16);
            solvedEQ.setFont ("Times New Roman");
            solvedEQ.setColor (Color.GREEN);
            solvedEQ.move ((canvas.getWidth()-solvedEQ.getWidth())/2,0);
            zeroDisplay= new Text ("Zero @ ("+ loggy.getZero()+",0)", solvedEQ.getX(), solvedEQ.getY()+solvedEQ.getHeight(), canvas);
            zeroDisplay.setFontSize ((int)canvas.getWidth()/24);
            zeroDisplay.setBold(true);
            zeroDisplay.move((zeroDisplay.getWidth()-zeroDisplay.getWidth())/2,0);
            haDisplay= new Text ("vertical Asympote @ y="+(-inputVars[1]), solvedEQ.getX(),zeroDisplay.getY()+solvedEQ.getHeight(),canvas); 
            haDisplay.setFontSize ((int)canvas.getWidth()/24);
            haDisplay.setBold(true);
            haDisplay.move((solvedEQ.getWidth()-haDisplay.getWidth())/2,0); 
            loggy.graph(grid.fix()); */
            
    }
    
    public void mouseExited (MouseEvent e)
    { 
    } 
    
    public void mouseEntered (MouseEvent e) 
    {
    }
    
    public void mousePressed (MouseEvent e) 
    {
    }
    
    public void mouseReleased (MouseEvent e)
    { 
    } 
        
    public void mouseClicked (MouseEvent e) 
    {
    }    
    
    public void mouseMoved (MouseEvent e) 
    { 
    }
    
    public void mouseDragged (MouseEvent e) 
    {
    }
    
}