package org.example;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        Album alb1 = new Album("Arijit", "Soulful");
        Album alb2 = new Album("Billie Ellish", "Peaceful");

        alb1.addSongToAlbum("Meri Aashiqui", 3.56);
        alb1.addSongToAlbum("Kesariya", 4.56);
        alb2.addSongToAlbum("Lovely", 4.5);
        alb2.addSongToAlbum("Alone", 3.3);

        LinkedList<Song>AnamPlaylist=new LinkedList<>();

        System.out.println(alb1.addtoPlayListfromAlbum("Meri Aashiqui", AnamPlaylist));
        System.out.println(alb2.addtoPlayListfromAlbum(2, AnamPlaylist));

        for(Song song : AnamPlaylist){
            System.out.println(song.getTitle()+" "+song.getDuration());
        }

    }
}