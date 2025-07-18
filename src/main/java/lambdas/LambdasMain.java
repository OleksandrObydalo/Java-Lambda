package lambdas;

import java.util.Arrays;
import java.util.Comparator;

public class LambdasMain {
    public static void main(String[] args) {
        String[] colours = {"red", "orange", "yellow", "green", "blue"};

        Player player1 = new Player("Alex", 100);
        Player player2 = new Player("Igor", 80);
        Player player3 = new Player("Victor", 80);
        Player player4 = new Player("John", 91);

        Player[] players = {player1, player2, player3, player4};


        Arrays.sort(players, (p1, p2) -> {
            if(p2.score - p1.score != 0){
                return p2.score - p1.score;
            } else{
                return p1.name.compareTo(p2.name);
            }
        });

        for(Player player: players){
            System.out.println(player);
        }

        Arrays.sort(colours, (s1, s2) -> {
            System.out.println(s1 + " " + s2 + " compare = " + (s1.length() - s2.length()) );
            return s1.length() - s2.length();
        }
        );

        Thread thread = new Thread(() -> {
            System.out.println("Hello world!");
        });

        thread.run();

    }
}
