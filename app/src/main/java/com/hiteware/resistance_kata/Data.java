package com.hiteware.resistance_kata;

/**
 * Created on 4/18/16.
 */
public class Data {
    public static Integer[][] setup_condition_one() {
        int rows = 5;
        int columns = 6;
        Integer [][] grid = new Integer[rows][columns];
        grid[0][0]=3 ;
        grid[0][1]=4 ;
        grid[0][2]=1 ;
        grid[0][3]=2 ;
        grid[0][4]=8 ;
        grid[0][5]=6 ;
        grid[1][0]=6 ;
        grid[1][1]=1 ;
        grid[1][2]=8 ;
        grid[1][3]=2 ;
        grid[1][4]=7 ;
        grid[1][5]=4 ;
        grid[2][0]=5 ;
        grid[2][1]=9 ;
        grid[2][2]=3 ;
        grid[2][3]=9 ;
        grid[2][4]=9 ;
        grid[2][5]=5 ;
        grid[3][0]=8 ;
        grid[3][1]=4 ;
        grid[3][2]=1 ;
        grid[3][3]=3 ;
        grid[3][4]=2 ;
        grid[3][5]=6 ;
        grid[4][0]=3 ;
        grid[4][1]=7 ;
        grid[4][2]=2 ;
        grid[4][3]=8 ;
        grid[4][4]=6 ;
        grid[4][5]=4 ;
        return grid;
    }

    public static Integer[][] setup_condition_two() {
        int rows = 5;
        int columns = 6;
        Integer [][] grid = new Integer[rows][columns];
        grid[0][0]=3 ;
        grid[0][1]=4 ;
        grid[0][2]=1 ;
        grid[0][3]=2 ;
        grid[0][4]=8 ;
        grid[0][5]=6 ;
        grid[1][0]=6 ;
        grid[1][1]=1 ;
        grid[1][2]=8 ;
        grid[1][3]=2 ;
        grid[1][4]=7 ;
        grid[1][5]=4 ;
        grid[2][0]=5 ;
        grid[2][1]=9 ;
        grid[2][2]=3 ;
        grid[2][3]=9 ;
        grid[2][4]=9 ;
        grid[2][5]=5 ;
        grid[3][0]=8 ;
        grid[3][1]=4 ;
        grid[3][2]=1 ;
        grid[3][3]=3 ;
        grid[3][4]=2 ;
        grid[3][5]=6 ;
        grid[4][0]=3 ;
        grid[4][1]=7 ;
        grid[4][2]=2 ;
        grid[4][3]=1 ;
        grid[4][4]=2 ;
        grid[4][5]=3 ;
        return grid;
    }

    public static Integer[][] setup_condition_three() {
        int rows = 3;
        int columns = 5;
        Integer[][] grid = new Integer[rows][columns];
        grid[0][0]=19 ;
        grid[0][1]=10 ;
        grid[0][2]=19 ;
        grid[0][3]=10 ;
        grid[0][4]=19 ;
        grid[1][0]=21 ;
        grid[1][1]=23 ;
        grid[1][2]=20 ;
        grid[1][3]=19 ;
        grid[1][4]=12 ;
        grid[2][0]=20 ;
        grid[2][1]=12 ;
        grid[2][2]=20 ;
        grid[2][3]=11 ;
        grid[2][4]=10 ;
        return grid;
    }
}
