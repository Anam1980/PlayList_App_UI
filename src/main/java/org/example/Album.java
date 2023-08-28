package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Album {

    private String artist;
    private String name;
    private List<Song>songs;

    public Album() {
    }

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    //functionalities in album

    public boolean findSong(String name){
        //search song by name in Album present or not
        for(Song s : this.songs){
            if(s.getTitle().equals(name))return true;
        }
        return false;
    }

    public String addSongToAlbum(String title, double duration){
        //add the new song in Album
       if(findSong(title)){
           return "Song already exist";
       }
       Song newSong = new Song(title, duration);
       this.songs.add(newSong);
       return  "Song has been added to album";
    }

    public String addtoPlayListfromAlbum(String title, LinkedList<Song>Playlist){

        //find the given song in album then add to playlist
       for(Song song : this.songs){
           if(song.getTitle().equals(title)) {
               Playlist.add(song);


               return "Song added to list Successfully";
           }
       }
       return "Song doesn't present in Album";
    }

    /**
     * Polymorphism->Method Overloading
     * @param songNo
     * @param Playlist
     * @return
     */

    public String addtoPlayListfromAlbum(int songNo, LinkedList<Song>Playlist){
        //user starts from 123
        int index = songNo-1;
        if(index>=0 && index<songs.size()){
            Playlist.add(songs.get(index));
            return "Song Added Successfully";
        }

        return "Incorrect song number";
    }


}
