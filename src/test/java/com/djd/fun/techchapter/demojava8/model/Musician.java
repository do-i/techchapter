package com.djd.fun.techchapter.demojava8.model;

import java.util.List;

public class Musician {

  private final String name;
  private final List<Album> albums;

  public Musician(String name, List<Album> albums) {
    this.name = name;
    this.albums = albums;
  }

  public String getName() {
    return name;
  }

  public List<Album> getAlbums() {
    return albums;
  }
}
