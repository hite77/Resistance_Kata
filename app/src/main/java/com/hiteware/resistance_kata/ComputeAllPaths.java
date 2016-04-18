package com.hiteware.resistance_kata;

/**
 * Created on 4/17/16.
 */
public class ComputeAllPaths {

    private Integer[] base_two_counter;
    private Integer[][] grid;
    private Path current_path;

    public ComputeAllPaths(Integer[][] grid) {
        this.grid = grid;
        base_two_counter = new Integer[2];
        base_two_counter[1]=0;
        base_two_counter[0]=1;
        calculate_next_path();
    }

    public Path getCurrentPath() {
        return current_path;
    }

    public void calculate_next_path() {
        current_path = new Path(grid, base_two_counter[0]);
        if (base_two_counter[1] == 0) {
            current_path.moveSideways();
        }
        else if (base_two_counter[1] == 1)
            current_path.moveUp();
        else
            current_path.moveDown();
        base_two_counter[1] = base_two_counter[1] + 1;
        if (base_two_counter[1] > 2) {
           base_two_counter[1] = 0;
           base_two_counter[0] = 2;
        }
    }
}
