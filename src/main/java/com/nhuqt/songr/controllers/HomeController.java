package com.nhuqt.songr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

  @GetMapping("/hello")
  public String getRoot() {
    System.out.println("Somebody got the root");
    return "helloworld";
  }

  @GetMapping("/capitalize/{words}")
  public String capitalizeWords(@PathVariable String words, Model m){
    m.addAttribute("words", words);
    return "capitalize";
  }

  @GetMapping("/reverse")
  public String reverseWords(@RequestParam(required = false, defaultValue = "Hello world!") String sentence, Model m){
    m.addAttribute("sentence", reverse(sentence));
    return "reversewords";
  }

  // Reverse helper method
  public static String reverse(String sentence){
    String[] str = sentence.split(" ");
    StringBuilder reverse = new StringBuilder();
    for(int i = str.length - 1; i >= 0; i--){
      reverse.append(str[i]).append(" ");
    }
    return reverse.toString().trim();
  }

}
