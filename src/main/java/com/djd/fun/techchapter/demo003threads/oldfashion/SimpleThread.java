package com.djd.fun.techchapter.demo003threads.oldfashion;

import com.google.common.collect.ImmutableList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SimpleThread {
  public static void main(String[] params) {
    ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue();
    new Market(ImmutableList.of(new Auditor(queue), new Producer(queue), new Consumer(queue)))
        .start();
  }
}
