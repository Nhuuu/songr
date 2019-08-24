# Songr
Allows user to add albums and song tracks to the albums.

## HomeController.java
* /hello - route will return an html that says Hello World!
* /capitalize/{request param} - route will return an html capitalizing all words in the request param.
* /reversewords - route will reverse and words in the request param, default is Hello World!

## AlbumController.java
* /albums - route will show all of the albums from the database as well as a form.
* /albums - route will post new album information to the database.
* /albums{id} - will show one album, all of the songs related to this album, and a form to add more songs to the album.

## SongController.java
* /songs - route will get all songs and direct to AllSongs.html.
* /songs - route will add a song to the database

## To use
* ./gradlew run

