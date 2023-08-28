package org.example;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Album alb1 = new Album("Arijit", "Soulful");
        Album alb2 = new Album("Billie Ellish", "Peaceful");

        alb1.addSongToAlbum("Meri Aashiqui", 3.56);
        alb1.addSongToAlbum("Kesariya", 4.56);
        alb2.addSongToAlbum("Lovely", 4.5);
        alb2.addSongToAlbum("Alone", 3.3);

        LinkedList<Song> AnamPlaylist = new LinkedList<>();

        System.out.println(alb1.addtoPlayListfromAlbum("Meri Aashiqui", AnamPlaylist));
        System.out.println(alb2.addtoPlayListfromAlbum(2, AnamPlaylist));

        play(AnamPlaylist);

    }
        public static void play(LinkedList<Song>Playlist){
            if(Playlist.size()==0){
                System.out.println("List is Empty");
                return;
            }
            boolean wasnext = true;//next selected
            ListIterator<Song> itr= Playlist.listIterator();
            System.out.println("Now Playing Song"+ itr.next());

            Scanner sc = new Scanner(System.in);
             printMenu();
            boolean quit = false;
            while(!quit){
                System.out.println("Please enter your choice");
                int choice = sc.nextInt();

                switch(choice){
                    case 1 : printMenu();
                        break;
                    case 2 :
                        if(wasnext = false){//selecting after previous
                            itr.next();
                            wasnext = true;//now next selected
                        }
                        if(!itr.hasNext()){
                            System.out.println("You have reached the end of the playlist");
                        }
                        else{
                            System.out.println("Currently playing" + itr.next());
                            wasnext = true;//now next selected
                        }
                        break;
                    case 3 :
                        if(wasnext=true){// selected after next
                            itr.previous();
                            wasnext = false;//now previous selcted
                        }
                        if(!itr.hasPrevious()){
                            System.out.println("You are at the start of the playlist");
                        }
                        else{
                            System.out.println("Currently playing" + itr.previous());
                            wasnext = false;//now previous selcted
                        }
                        break;
                    case 4 :
                        if(wasnext == true){
                            System.out.println("Playing again the song: "+itr.previous());
                            wasnext = false;
                        }
                        else{
                            System.out.println("Playing again the song: "+itr.next());
                            wasnext = true;
                        }

                        break;

                    case 5:
                        if (wasnext=true) {
                            itr.previous(); // Move the iterator back to the current song
                            Song songToDelete = itr.next(); // Get the current song

                            System.out.println("Deleted the song: " + songToDelete);
                            itr.remove(); // Remove the song from the playlist
                        } else {
                            Song songToDelete = itr.previous(); // Get the current song

                            System.out.println("Deleted the song: " + songToDelete);
                            itr.remove(); // Remove the song from the playlist
                        }
                        break;

                    case 6 : printSongs(Playlist);
                        break;
                    case 7 : quit=true;
                        break;
                    default:
                        System.out.println("Wrong choice, Please select proper option!");


                }
            }
            return;
        }

    private static void printSongs(LinkedList<Song> playlist) {
        for(Song song:playlist){
            System.out.println(song);
        }
        return;
    }

    private static  void printMenu(){
               System.out.println("1. Show the menu again");
               System.out.println("2. Play next song");
               System.out.println("3. Play previous song");
               System.out.println("4. Play current song again");
               System.out.println("5. Delete current song from playlist");
               System.out.println("6. Print all songs in the playlist");
               System.out.println("7. Quit application");
           }
}