package com.nhuqt.songr;

import org.junit.Test;

import static org.junit.Assert.*;

public class HomeControllerTest {

  @Test
  public void reverse() {
    String str = "Hello world!";
    assertEquals("This should reverse words", "world! Hello", HomeController.reverse(str));
  }
}