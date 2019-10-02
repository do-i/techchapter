package com.djd.fun.techchapter.demo003threads.forkjoinpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

  private static final Logger log = LoggerFactory.getLogger(Main.class);

  public static void main(String[] params) throws ExecutionException, InterruptedException {
    int n = 7;
    ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
    Fibonacci fib = new Fibonacci(n);
    ForkJoinTask<Integer> task = forkJoinPool.submit(fib);
    log.info("fibonacci({}) = {}", n, task.get());
  }
}
