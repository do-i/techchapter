package com.djd.fun.techchapter.demojava8.model;

public class Song {

  private final String name;
  private final int length;
  private final int stars;

  public Song(String name, int length, int stars) {
    this.name = name;
    this.length = length;
    this.stars = stars;
  }

  public String getName() {
    return name;
  }

  public int getLength() {
    return length;
  }

  public int getStars() {
    return stars;
  }
}
