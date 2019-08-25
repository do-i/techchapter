package com.djd.fun.techchapter.demo014swing.canvas;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 * Created by acorn on 8/2/17.
 */
public class SmileCanvas extends Canvas implements CommandResponder {

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(Color.YELLOW);
    g2.fillOval(100, 100, 100, 100); // (int x, int y, int width, int height)
    int x = 115;
    int y = 115;
    int width = 70;
    int height = 70;
    /*
     * A startAngle of 0º points horizontally to the right (like the unit circle in math).
     * Positive is a counterclockwise rotation starting at 0º.
     */
    int startAngle = -20;
    int arcAngle = -140;
    g2.setColor(Color.BLACK);
    g2.drawArc(x, y, width, height, startAngle, arcAngle);
    g2.fillOval(125, 130, 10, 15);
    g2.fillOval(165, 130, 10, 15);
  }

  @Override
  public Component getComponent() {
    return this;
  }

  @Override public Document getDocument() {
    return new PlainDocument();
  }
}
