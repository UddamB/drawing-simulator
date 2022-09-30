package MiniAdventures;

public class Pacman {

    //Creating 2-D array for pacman
    public static String fillArray(){
        String[][]arr = new String[10][25];

        for(int i = 0; i < arr.length; i++){
            for (int x = 0; x < arr[i].length; x++){
                arr[i][x] = "*";
            }
        }

        for(int i = 0; i < arr.length; i++){
            for (int x = 0; x < arr[i].length; x++){
                System.out.print(arr[i][x]);
            }
            System.out.println();
        }
        return "";
    }
}