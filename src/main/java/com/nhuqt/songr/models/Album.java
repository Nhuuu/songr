package com.nhuqt.songr.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;
  String title;
  String artist;
  int songCount;
  int length;
  String imageUrl;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "album")
  List<Song> songs;

  public Album(){}

  public Album(String title, String artist, int songCount, int length, String imageUrl){
    this.title = title;
    this.artist = artist;
    this.songCount = songCount;
    this.length = length;
    this.imageUrl = imageUrl;
  }

  public String getTitle() {
    return title;
  }

  public String getArtist() {
    return artist;
  }

  public long getId() {
    return id;
  }

  public List<Song> getSongs() {
    return songs;
  }

  public int getSongCount() {
    return songCount;
  }

  public int getLength() {
    return length;
  }

  public String getImageUrl() {
    return imageUrl;
  }
}
