package com.SteffenHo;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[][] N ={
                {-1,  8, 14, 10},
                {13, -1,  6,  2},
                { 7, 15, -1, 12},
                {11, 19,  9, -1}
        };
        Schulze s = new Schulze(N, 4);
    }
}
