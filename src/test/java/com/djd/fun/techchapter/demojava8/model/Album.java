package com.djd.fun.techchapter.demojava8.model;

import java.util.List;

public class Album {

  private final String title;
  private final List<Song> songs;

  public Album(String title, List<Song> songs){
    this.title = title;
    this.songs = songs;
  }

  public String getTitle() {
    return title;
  }

  public List<Song> getSongs() {
    return songs;
  }
}
