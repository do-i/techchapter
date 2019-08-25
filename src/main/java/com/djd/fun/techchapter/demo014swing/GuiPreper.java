package com.djd.fun.techchapter.demo014swing;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by acorn on 8/3/17.
 */
public class GuiPreper {

  private static final Logger log = LoggerFactory.getLogger(GuiPreper.class);

  public static void createAndShowGUI() {
    JFrame jFrame = new JFrame("Demo 014"); // Foundation of all graphical components on screen
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    MyPanel myPanel = new MyPanel();
    jFrame.setJMenuBar(new MyMenuBar(myPanel)); // add Menu
    jFrame.add(myPanel); // Add myPanel to content pane in the JRootPane in JFrame
    jFrame.pack(); // This will use myPanel.getPreferredSize() to decide the size of JFrame
    jFrame.setVisible(true);
  }
}
