/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.sınıf2.proje;

/**
 *
 * @author İrem Serra
 */
public class Song {
   private String  songName,artistName,genre,ID,year;

    public Song(String songName, String artistName, String genre, String ID, String year) {
        this.songName = songName;
        this.artistName = artistName;
        this.genre = genre;
        this.ID = ID;
        this.year = year;
    }

    public String getSongName() {
        return songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getGenre() {
        return genre;
    }

    public String getID() {
        return ID;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString(){
          return "Song Name: " + songName + ","+ artistName + "," + genre + "," + ID + "," + year;
    } 
}
