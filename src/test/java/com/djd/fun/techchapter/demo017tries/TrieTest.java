package com.djd.fun.techchapter.demo017tries;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class TrieTest {

  @Test
  public void add() {
    assertThat(createTrieWithHostnames()).isNotNull();
  }

  @Test
  public void exists_full_true() {
    Trie trie = createTrieWithHostnames();
    assertThat(trie.exists("www.abc.com")).isTrue();
    assertThat(trie.exists("www.abc.net")).isTrue();
    assertThat(trie.exists("www.abc.io")).isTrue();
    assertThat(trie.exists("www.x.com")).isTrue();
    assertThat(trie.exists("www.x.oom")).isTrue();
  }

  @Test
  public void exists_partial_true() {
    Trie trie = createTrieWithHostnames();
    assertThat(trie.exists("www.abc")).isTrue();
    assertThat(trie.exists("www")).isTrue();
    assertThat(trie.exists("www.abc.")).isTrue();
    assertThat(trie.exists("www.x")).isTrue();
  }

  @Test
  public void exists_false() {
    Trie trie = createTrieWithHostnames();
    assertThat(trie.exists("www.abc.com.jp")).isFalse();
    assertThat(trie.exists("www.abc.co")).isFalse();
    assertThat(trie.exists("www.x.net")).isFalse();
    assertThat(trie.exists("")).isFalse();
    assertThat(trie.exists("x.com")).isFalse();
    assertThat(trie.exists("www.oom")).isFalse();
  }

  @Test
  public void exists_withPath() {
    Trie trie = createTrieWithURLs();
    assertThat(trie.exists("www.abc.com/a/b/c")).isTrue();
    assertThat(trie.exists("www.abc.com/a/b")).isTrue();
    assertThat(trie.exists("www.abc.com/a/")).isTrue();
    assertThat(trie.exists("www.abc.com/a/c/d/e")).isFalse();
  }

  @Test
  public void print() {
    createTrieWithHostnames().print();
  }

  private Trie createTrieWithHostnames() {
    Trie trie = new Trie();
    trie.add("www.abc.com");
    trie.add("www.abc.net");
    trie.add("www.abc.io");
    trie.add("www.x.com");
    trie.add("www.x.oom");
    return trie;
  }

  private Trie createTrieWithURLs() {
    Trie trie = new Trie();
    trie.add("www.abc.com/a/b/c");
    trie.add("www.abc.com/a/");
    trie.add("www.abc.com/a/b/c/d");
    return trie;
  }
}