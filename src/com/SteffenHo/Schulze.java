package com.SteffenHo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Schulze {

    private int count;

    private int[][] N;

    private int [][] P;

    private int [][]pred;

    private Boolean [] winners;

    public Schulze(int[][] pN, int pCount){
        count = pCount;
        N = pN;
        SchulzeHelper.printN(N, count);

        init();
        findStrongesPath();
        calculatingWinners();
    }

    /**
     * Initialize the Array which contains the duel of all alternatives.
     * A bit different to the naiv implementation save in P only winnig Ways
     */
    public void init() {
        P = SchulzeHelper.init2DArray(count);
        pred = SchulzeHelper.init2DArray(count);
        for(int i = 0; i < count; i++){
            for(int j = 0; j < count; j++){
                if(i != j){
                    if(N[i][j] > N[j][i]) { // alternative i wins against j
                        P[i][j] = N[i][j];
                    }else {
                        P[i][j] = 0; // alternative i lose
                    }
                    pred[i][j] = i;
                }
            }
        }
        SchulzeHelper.printP(P, count);
    }

    private void findStrongesPath(){
        for(int i = 0; i < count; i++){
            for(int j = 0; j < count; j++){
                if(i != j){
                    for(int k = 0; k < count; k++){
                        if(i != k && j != k){
                            if(P[j][k] < Math.min(P[j][i], P[i][k])){ // calculate the critical link in the strongest path
                                P[j][k] = Math.min(P[j][i], P[i][k]);
                                pred[j][k] = pred[i][k];
                            }
                        }
                    }
                }
            }
        }

        SchulzeHelper.printP(P, count);
    }

    private void calculatingWinners(){
        winners = SchulzeHelper.initWinnerArray(count);
        for(int i = 0; i < count; i++){
            winners[i] = true;
            for(int j = 0; j < count; j++){
                if(i != j){
                    if(P[j][i] > P[i][j]){
                        winners[i] = false; // ji is not in the relation O and the winner muss be in relation O
                    }
                }
            }
        }
        SchulzeHelper.printWinner(winners, count);
    }

}
