package com.djd.fun.techchapter.demo017tries;

import java.util.ArrayDeque;
import java.util.Queue;

import com.google.common.base.Splitter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A trie data structure to store urls. Each node in the trie represents
 * a segment of hostname.
 */
public class Trie {

  private static final Logger log = LoggerFactory.getLogger(Trie.class);
  private static final Splitter ON_PERIOD = Splitter.onPattern("[./]").trimResults().omitEmptyStrings();
  private Node root = new Node(null, 0);

  /**
   * Adds given url to the trie.
   *
   * @param url to be added
   */
  public void add(String url) {
    Node curNode = root;
    for (String token : ON_PERIOD.split(url)) {
      Node childNode = curNode.findChild(token);
      curNode = childNode == null ? curNode.addChild(token) : childNode;
    }
  }

  /**
   * Checks if the given url exists in the trie.
   *
   * @param url in search
   * @return {@code true} if the given url is found. {@code false} if not found.
   */
  public boolean exists(String url) {
    if (url.isEmpty()) {
      return false;
    }
    Node curNode = root;
    for (String token : ON_PERIOD.split(url)) {
      Node childNode = curNode.findChild(token);
      if (childNode == null) {
        return false;
      }
      curNode = childNode;
    }
    return true;
  }

  /**
   * Prints all values in the trie in breadth first.
   */
  public void print() {
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node node = queue.remove();
      log.info("deapth: {}, value: {}", node.getDeapth(), node.getValue());
      queue.addAll(node.getChildren());
    }
  }
}
