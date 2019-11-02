package com.djd.fun.techchapter.demo014swing.canvas;

import java.awt.Component;
import javax.swing.text.Document;

public interface CommandResponder {
  Component getComponent();

  Document getDocument();

  default void init() {}
}
