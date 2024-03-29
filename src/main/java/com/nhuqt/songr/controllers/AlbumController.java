package com.nhuqt.songr.controllers;

import com.nhuqt.songr.models.Song;
import com.nhuqt.songr.models.Album;
import com.nhuqt.songr.models.AlbumRepository;
import com.nhuqt.songr.models.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {

  @Autowired
  AlbumRepository albumRepository;

  @Autowired
  SongRepository songRepository;

  @GetMapping("/albums")
  public String getAllAlbums(Model m) {
    List<Album> albums = albumRepository.findAll();
    m.addAttribute("albums", albums);
    return "allAlbums";
  }

  @GetMapping("/album/{id}")
  public String getOneAlbum(@PathVariable long id, Model m){
    Album a = albumRepository.findById(id).get();
    m.addAttribute("album", a);
    List<Song> songs = songRepository.findByAlbum(a);
    m.addAttribute("songs", songs);
    return "oneAlbum";
  }

  @PostMapping("/albums")
  public RedirectView addAlbum(String title, String artist, int songCount, int length, String imageUrl) {
    Album a = new Album(title, artist, songCount, length, imageUrl);
    albumRepository.save(a);
    return new RedirectView("/albums");
  }

}
