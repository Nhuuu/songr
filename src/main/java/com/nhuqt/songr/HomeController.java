package com.nhuqt.songr;

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

//  Write a unit test for the word reversing functionality of the above route.
//  (Note that this will be easiest if you write a helper method for the word reversing, so that you can call that method for testing.)
  @GetMapping("/reverse")
  public String reverseWords(@RequestParam(required = false, defaultValue = "Hello world!") String sentence, Model m){
    m.addAttribute("sentence", sentence);
    return "reversewords";
  }

  // reverse helper method
//  public String reverse(String sentence){
////    sentence.split(" ")
//  }

}
