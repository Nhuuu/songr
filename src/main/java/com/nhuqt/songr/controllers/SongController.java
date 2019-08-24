package com.nhuqt.songr.controllers;

import com.nhuqt.songr.models.Album;
import com.nhuqt.songr.models.AlbumRepository;
import com.nhuqt.songr.models.Song;
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
public class SongController {

  @Autowired
  SongRepository songRepository;

  @Autowired
  AlbumRepository albumRepository;

  @GetMapping("/songs")
  public String getAllSongs(Model m) {
    List<Song> songs = songRepository.findAll();
    m.addAttribute("songs", songs);
    return "allSongs";
  }

  @PostMapping("/album/{id}/songs")
  public RedirectView addSong(String title, int length, int trackNumber, @PathVariable long id) {
    Album a = albumRepository.findById(id).get();
    Song s = new Song(title, length, trackNumber, a);
    songRepository.save(s);
    return new RedirectView("/album/" + id);
  }

}