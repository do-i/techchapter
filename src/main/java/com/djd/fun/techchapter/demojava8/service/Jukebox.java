package com.djd.fun.techchapter.demojava8.service;

import com.djd.fun.techchapter.demojava8.model.Album;
import com.djd.fun.techchapter.demojava8.model.Musician;
import com.djd.fun.techchapter.demojava8.model.Song;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Jukebox {

  Predicate<Song> SHORT_SONG = song -> song.getLength() < 60;

  List<String> findAlbumNamesForMusician(Musician musician);

  List<Song> skipFirst2Songs(Album album);

  Optional<Song> findOneSong(List<Album> albums);

  List<Song> findAllSongsForAlbums(List<Album> albums);

  List<Song> findAllSongsForMusicians(List<Musician> musicians);

  List<Song> findShortSongs(List<Musician> musicians);

  List<Song> findStarSongs(List<Album> albums, int star);
}
