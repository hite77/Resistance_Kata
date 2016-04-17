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
        base_two_counter = new Integer[1];
        base_two_counter[0]=0;
        calculate_next_path();
    }

    public Path getCurrentPath() {
        return current_path;
    }

    public void calculate_next_path() {
        current_path = new Path(grid, 1);
        if (base_two_counter[0] == 0) {
            current_path.moveSideways();
        }
        else
            current_path.moveUp();
        base_two_counter[0] = base_two_counter[0] + 1;
    }
}
