package com.djd.fun.techchapter.demo014swing.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CloseAction implements ActionListener {

  @Override
  public void actionPerformed(ActionEvent e) {
    System.exit(0);
  }
}
