package com.nhuqt.songr.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
  public List<Song> findByAlbum(Album album);
}
