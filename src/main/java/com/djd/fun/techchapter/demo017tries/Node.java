package com.djd.fun.techchapter.demo017tries;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/** A representation of a node in a {@link Trie}. */
public class Node {
  private final String value;
  private final int deapth;
  private final Map<String, Node> children = new HashMap<>();

  public Node(String value, int deapth) {
    this.value = value;
    this.deapth = deapth;
  }

  public String getValue() {
    return value;
  }

  /**
   * Returns a deapth of this node in the trie
   *
   * @return deapth of this node relative to the root node
   */
  public int getDeapth() {
    return deapth;
  }

  /**
   * Finds the node for a given value.
   *
   * @param childValue to find for
   * @return {@link Node} represents the specified value. {@code null} if not found.
   */
  public @Nullable Node findChild(String childValue) {
    return children.get(childValue);
  }

  /**
   * Returns all children nodes.
   *
   * @return all children nodes
   */
  public ImmutableList<Node> getChildren() {
    return ImmutableList.copyOf(children.values());
  }

  /**
   * Adds the child node to this node.
   *
   * @param childValue
   * @return newly created child {@link Node}
   */
  public Node addChild(String childValue) {
    Node childNode = new Node(childValue, deapth + 1);
    children.put(childValue, childNode);
    return childNode;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("value", value)
        .add("deapth", deapth)
        .add("children", children)
        .toString();
  }
}
