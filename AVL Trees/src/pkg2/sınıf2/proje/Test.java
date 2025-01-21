/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2.sınıf2.proje;

import java.io.*;
import java.util.Scanner;

public class Test {

    static AVLTreeComparable IDTree = new AVLTreeComparable();
    static AVLTreeComparable SongNameTree = new AVLTreeComparable();
    static AVLTreeComparable ArtistNameTree = new AVLTreeComparable();
    static Scanner scn = new Scanner(System.in, "ISO-8859-9");

    public static void main(String[] args) throws IOException {

        File songs = new File("songs.txt");
        FileReader song = new FileReader(songs);
        BufferedReader songR = new BufferedReader(song);

        String selection;

        Song newSong;
        int songNum = 0;
        Song[] songList = new Song[20];
        String currentLine = songR.readLine();

        while (currentLine != null) {
            String[] songInfo = currentLine.split(";");
            newSong = new Song(songInfo[0], songInfo[1], songInfo[3], songInfo[2], songInfo[4]);
            songList[songNum] = newSong;
            IDTree.put(newSong.getID(), songNum);
            SongNameTree.put(newSong.getSongName(), songNum);
            ArtistNameTree.put(newSong.getArtistName(), songNum);
            songNum++;
            currentLine = songR.readLine();
        }
        songR.close();

        System.out.println("Welcome to music recording system:");
        System.out.println("Please select an operation:");
        System.out.println("1)Search a song:");
        System.out.println("2)Delete a song:");
        System.out.println("3)Exit");
        String option = scn.nextLine();

        while (option.compareTo("0") < 3 && option.compareTo("0") > 0) {

            if (option.compareTo("0") == 1) {

                System.out.println("Please select a search method which you want:");
                System.out.println("1)Search with song name, artist name or ID: ");
                System.out.println("2)Search between a lower bound and upperbound: ");
                selection = scn.nextLine();

                if (selection.equals("1")) {
                    search(songList);
                } else if (selection.equals("2")) {
                    System.out.println("Please enter the lower and upper bound which you want to search");
                    int lowerBound = scn.nextInt();
                    int upperBound = scn.nextInt();
                    searchBetweenBoundries(IDTree.getRoot(), songList, lowerBound, upperBound);
                } else {
                    System.out.println("You entered an invalid selection");
                }
            } else if (option.compareTo("0") == 2) {
                delete(songList);
            } else {
                System.out.println("Exiting...");
            }
            option = scn.nextLine();
        }
    }

    public static void search(Song[] songlist) {
        System.out.println("Please enter name or artist name or ID of song which you want to search");
        String searched_word = scn.nextLine();

        if (searched_word != null) {

            if (SongNameTree.get(searched_word) != null) {
                int index = (int) SongNameTree.get(searched_word);
                System.out.println("The song which you searched is found");
                System.out.println(songlist[index].toString());
            } else if (ArtistNameTree.get(searched_word) != null) {
                int index = (int) ArtistNameTree.get(searched_word);
                System.out.println("The song which you searched is found");
                System.out.println(songlist[index].toString());
            } else if (IDTree.get(searched_word) != null) {
                int index = (int) IDTree.get(searched_word);
                System.out.println("The song which you searched is found");
                System.out.println(songlist[index].toString());
            } else {
                System.out.println("There is any song which contains given info!");
            }
        }
    }

    public static void searchBetweenBoundries(AVLNodeComparable focus, Song[] songList, int lowerBound, int upperBound) {

        if (focus == null) {
            return;
        }

        int ID = Integer.parseInt((String) focus.key);

        if ((ID >= lowerBound) && (ID <= upperBound)) {
            System.out.println(songList[(int) focus.index].toString());
        }

        searchBetweenBoundries(focus.left, songList, lowerBound, upperBound);
        searchBetweenBoundries(focus.right, songList, lowerBound, upperBound);

    }

    public static void delete(Song[] songList) {

        System.out.println("Enter the song ID which you want to delete:");
        String deletion = scn.nextLine();

        if (IDTree.get(deletion) != null) {
            int index = (int) IDTree.get(deletion);
            IDTree.delete(deletion);
            SongNameTree.delete(songList[index].getSongName());
            ArtistNameTree.delete(songList[index].getArtistName());
            
            System.out.println("The information of deleted song: " + "\n" + songList[index].toString() );
            
        }
        else{
            System.out.println("There is any record which have this ID");            
        }

    }
}
