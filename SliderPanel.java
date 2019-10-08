import java.awt.*;
import javax.swing.*;
import javax.swing.JComponent;
import javax.swing.event.*;

public class SliderPanel extends JPanel
{
   private JPanel controls;
   private JSlider aSlider, bSlider, cSlider;
   private JLabel aLabel, bLabel, cLabel, graphLabel;
   private int a,b,c;
   public SliderPanel()
   {
      //set initial values
      a=3;
      b=3;
      c=3;
      
      // Slider to set velau of a.
      aSlider = new JSlider (JSlider.HORIZONTAL,1,5,3);
      aSlider.setMajorTickSpacing (5);
      aSlider.setMinorTickSpacing (1);
      aSlider.setPaintTicks (true);
      aSlider.setPaintLabels (true);
      aSlider.setAlignmentX (Component.RIGHT_ALIGNMENT);
      
      // Slider to set velau of b.
      bSlider = new JSlider (JSlider.HORIZONTAL, 1,5,3);
      bSlider.setMajorTickSpacing (5);
      bSlider.setMinorTickSpacing (1);
      bSlider.setPaintTicks (true);
      bSlider.setPaintLabels (true);
      bSlider.setAlignmentX (Component.RIGHT_ALIGNMENT);
      
      //Slider to set velau of c.
      cSlider = new JSlider (JSlider.HORIZONTAL, 1,5,3);
      cSlider.setMajorTickSpacing (5);
      cSlider.setMinorTickSpacing (1);
      cSlider.setPaintTicks (true);
      cSlider.setPaintLabels (true);
      cSlider.setAlignmentX (Component.RIGHT_ALIGNMENT);
     
      // Listeners for sliders
      SliderListener listener = new SliderListener();
      aSlider.addChangeListener (listener);
      bSlider.addChangeListener (listener);
      cSlider.addChangeListener (listener);
     
      //labels to show the initial values of a,b,and c.
      aLabel = new JLabel ("a: 3");
      aLabel.setAlignmentX (Component.RIGHT_ALIGNMENT);
      bLabel = new JLabel ("b: 3");
      bLabel.setAlignmentX (Component.RIGHT_ALIGNMENT);
      cLabel = new JLabel ("c: 3");
      cLabel.setAlignmentX (Component.RIGHT_ALIGNMENT);
     
      // controls panel to display sliders and labels. 
      controls = new JPanel();
      BoxLayout layout = new BoxLayout (controls, BoxLayout.Y_AXIS);
      controls.setLayout (layout);
      controls.add (aLabel);
      controls.add (aSlider);
      controls.add (Box.createRigidArea (new Dimension (0, 20)));
      controls.add (bLabel);
      controls.add (bSlider);
      controls.add (Box.createRigidArea (new Dimension (0, 20)));
      controls.add (cLabel);
      controls.add (cSlider);
     
      // manage the layout of the panel of sliders and the graph.
      setLayout(new BorderLayout());
      controls.setPreferredSize (new Dimension (200,300)); 
      graphLabel=new JLabel("                                     ");
    
      add(controls,BorderLayout.EAST);
      add(graphLabel);              
   }
   public void paintComponent(Graphics page)
   {
      super.paintComponent(page);
             
      page.setColor(Color.black);
      page.fillRect(0,0,600,600);
      
      // draw the graph.
      page.setColor(Color.red);     
      for (int x=-15;x<=15;x++)
      {
           int y=250-(a*x*x+b*x+c);           
           page.fillOval(x+65,y,5,5); 
              
      }
         
   }
                    
   //*****************************************************************
   //  Represents the listener for all three sliders.
   //*****************************************************************
   private class SliderListener implements ChangeListener
   {
      //--------------------------------------------------------------
      //  Gets the value of each slider, then updates the labels and
      //  paintComponent
      //--------------------------------------------------------------
      public void stateChanged (ChangeEvent event)
      {
         a = aSlider.getValue();
         b = bSlider.getValue();
         c = cSlider.getValue();

         aLabel.setText ("a: " + a);
         bLabel.setText ("b: " + b);
         cLabel.setText ("c: " + c);
         
         repaint();
      }
    } 
}
