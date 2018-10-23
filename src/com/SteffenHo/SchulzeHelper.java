package com.SteffenHo;

public class SchulzeHelper {

    /**
     * Initialize a 3 dimensional array with the given count
     * @param count
     * @return int[][][]
     */
    public static int[][][] init3DArray(int count){
        return new int[count][count][count];
    }

    /**
     * Initialize a 2 dimensional array with the given count
     * @param count
     * @return int[][][]
     */
    public static int[][] init2DArray(int count){
        return new int[count][count];
    }

    /**
     * Initialize a 1 dimensional array with the given count
     * @param count
     * @return int[][][]
     */
    public static Boolean[] initWinnerArray(int count){
        return new Boolean[count];
    }

    public static void printN(int[][] pIn, int count){
        System.out.println("Print out N");
        for(int i = 0; i < count; i++){
            for(int j = 0; j < count; j++){
                System.out.format("%4d,",pIn[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void printP(int[][] pIn, int count){
        System.out.println("Print out P");
        for(int i = 0; i < count; i++){
            for(int j = 0; j < count; j++){
                System.out.format(" %3d",pIn[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void printWinner(Boolean[] win, int count){
        int [] winner = new int[count];
        int countWinners = 0;
        for(int i = 0; i < count; i++){
            if(win[i]){
                winner[countWinners] = i;
                countWinners++;
            }
        }

        System.out.println("The election has " + countWinners + " winners");
        for(int i = 0; i < countWinners; i++){
            System.out.println("Winner " + i + " is alternative " + winner[i]);
        }
    }
}
