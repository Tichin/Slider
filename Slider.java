/*  Slider.java
 * 
 *  
 *  To draw an equation ax2(x square)+bx+c while a,b,c are set by sliders  
 *
 *  @author   TICHIN WU
 *  @version  1.8.0
 */

import java.awt.*;
import javax.swing.*;

public class Slider  
{
   public static void main(String[] args)
   {
   
       JFrame frame= new JFrame("Graph of ax2(x square)+bx+c");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(800,800);
       frame.getContentPane().add(new SliderPanel());
       frame.pack();
       frame.setVisible(true);     
   } 

}