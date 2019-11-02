package com.djd.fun.techchapter.demo003threads.procon;

import static java.lang.Thread.sleep;

import com.google.common.collect.Queues;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jdoi
 * @since 2019-08-08
 */
public class ChannelDemo {

  public static final int MAX_NUM_OF_TASKS = 180;
  public static final int PRODUCER_COUNT = 2;
  public static final int CONSUMER_COUNT = 3;
  public static final int Q_CAPACITY = 100;

  public static void main(String[] args) throws InterruptedException {
    Random random = new Random(0);
    BlockingQueue<Task> queue = Queues.newArrayBlockingQueue(Q_CAPACITY);
    ExecutorService service = Executors.newFixedThreadPool(PRODUCER_COUNT + CONSUMER_COUNT);
    CountDownLatch countDownLatch = new CountDownLatch(PRODUCER_COUNT);
    /*
    service.execute(); // if no need a Future
    service.submit(); // if you want a Future
    */
    for (int consumerId = 0; consumerId < CONSUMER_COUNT; consumerId++) {
      service.submit(new Consumer(queue, countDownLatch, random, consumerId));
    }
    for (int producerId = 0; producerId < PRODUCER_COUNT; producerId++) {
      service.submit(new Producer(queue, random, producerId));
    }
    countDownLatch.await(); // blocks until all NUL tasks are consumed
    System.out.println("service is stopping");
    service.shutdownNow();
    System.out.println("main thread ends.");
  }

  private static class Producer implements Runnable {

    private static final AtomicInteger sequence = new AtomicInteger();
    private final BlockingQueue<Task> queue;
    private final Random random;
    private final int producerId;

    Producer(BlockingQueue<Task> queue, Random random, int producerId) {
      this.queue = queue;
      this.random = random;
      this.producerId = producerId;
    }

    @Override
    public void run() {
      try {
        while (true) {
          int taskId = sequence.getAndIncrement();
          if (taskId > MAX_NUM_OF_TASKS) {
            break;
          }
          int currentQueueSize = queue.size();
          if (currentQueueSize == Q_CAPACITY) {
            System.out.println("queue is full ++++++++++++++++++++++++++++");
          }
          queue.put(new MyTask(String.format("P%dT%d", producerId, taskId)));
          sleep(random.nextInt(30));
        }
        queue.put(Task.NUL);
        System.out.println("NUL Task is queued by producer_" + producerId);
      } catch (InterruptedException e) {
        System.out.println("Interrupted");
        throw new RuntimeException(e);
      }
      System.out.println(String.format("Producer %d is done.", producerId));
    }
  }

  private static class Consumer implements Runnable {

    private final BlockingQueue<Task> queue;
    private final CountDownLatch countDownLatch;
    private final Random random;
    private final int consumerId;

    Consumer(
        BlockingQueue<Task> queue, CountDownLatch countDownLatch, Random random, int consumerId) {
      this.queue = queue;
      this.countDownLatch = countDownLatch;
      this.random = random;
      this.consumerId = consumerId;
    }

    @Override
    public void run() {

      try {
        while (true) {
          int currentQueueSize = queue.size();
          if (currentQueueSize == 0) {
            System.out.println("queue is empty --------------------");
          }
          Task task = queue.take();
          if (task == Task.NUL) {
            countDownLatch.countDown();
          } else {
            task.doSomething(consumerId);
          }
          sleep(random.nextInt(100));
        }
      } catch (InterruptedException e) {
        System.out.println(String.format("Consumer %d is interrupted.", consumerId));
      }
    }
  }

  interface Task {
    Task NUL = (id) -> new UnsupportedOperationException();

    void doSomething(int id);
  }

  static class MyTask implements Task {

    private final String name;

    MyTask(String name) {
      this.name = name;
    }

    @Override
    public void doSomething(int id) {
      System.out.println("consumerId: " + id + "; task:" + name);
    }
  }
}
