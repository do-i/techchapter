package com.djd.fun.techchapter.demojava8.service;

import com.djd.fun.techchapter.demojava8.model.Album;
import com.djd.fun.techchapter.demojava8.model.Musician;
import com.djd.fun.techchapter.demojava8.model.Song;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Jukebox {

  private static final Predicate<Song> SHORT_SONG = song -> song.getLength() < 60;

  public List<String> findAlbumNamesForMusician(Musician musician) {
    return musician.getAlbums().stream()
        .map(Album::getTitle)
        .collect(Collectors.toUnmodifiableList());
  }

  public List<Song> skipFirst2Songs(Album album) {
    return album.getSongs().stream()
        .skip(2)
        .collect(Collectors.toUnmodifiableList());
  }

  public Optional<Song> findOneSong(List<Album> albums) {
    return albums.stream()
        .map(Album::getSongs)
        .flatMap(Collection::stream)
        .findFirst();
  }

  public List<Song> findAllSongsForAlbums(List<Album> albums) {
    return albums.stream()
        .map(Album::getSongs)
        .flatMap(Collection::stream)
        .collect(Collectors.toUnmodifiableList());
  }

  public List<Song> findAllSongsForMusicians(List<Musician> musicians) {
    return musicians.stream()
        .map(Musician::getAlbums)
        .flatMap(Collection::stream)
        .map(Album::getSongs)
        .flatMap(Collection::stream)
        .collect(Collectors.toUnmodifiableList());
  }


  public List<Song> findShortSongs(List<Musician> musicians) {
    return musicians.stream()
        .map(Musician::getAlbums)
        .flatMap(Collection::stream)
        .map(Album::getSongs)
        .flatMap(Collection::stream)
        .filter(SHORT_SONG)
        .collect(Collectors.toUnmodifiableList());
  }

  public List<Song> findStarSongs(List<Album> albums, int star) {
    return albums.stream()
        .map(Album::getSongs)
        .flatMap(Collection::stream)
        .filter(song -> song.getStars() == star)
        .collect(Collectors.toUnmodifiableList());
  }
}
