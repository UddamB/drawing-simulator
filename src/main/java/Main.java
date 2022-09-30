import MiniAdventures.ATM;
import MiniAdventures.Pacman;
import jade.Window;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to MiniGame Simulator!!");
        System.out.println("This is a fun place for everyone :)");
        System.out.println("Let's choose a game to play, (ps. the drawing one rocks!)");
        System.out.println("Press 1 to play the Drawing Simulator!");
        System.out.println(Pacman.fillArray());
        int startingChoice = in.nextInt();
        while(true){
            if(startingChoice==1){
                Window window = Window.get();
                window.run();
                System.out.println("Glad you enjoyed " + "Drawing Simulator"+ "!");
                break;
            }
                while(startingChoice!=1){
                    System.out.println("Please press 1 :)");
                    startingChoice = in.nextInt();
                }
            }
        }
    }