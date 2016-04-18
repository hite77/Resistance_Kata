package com.hiteware.resistance_kata;

/**
 * Created on 4/17/16.
 */
public class ComputeAllPaths {

    private BaseTwoCounter base_two_counter;
    private Integer[][] grid;
    private Path current_path;

    public ComputeAllPaths(Integer[][] grid) {
        this.grid = grid;
        base_two_counter = new BaseTwoCounter(grid.length, grid[0].length);
        calculate_next_path();
    }

    public Path getCurrentPath() {
        return current_path;
    }

    public void calculate_next_path() {
        Integer[] movementCounter = base_two_counter.currentCount();
        current_path = new Path(grid, movementCounter[0]);
        if (movementCounter[1] == 0) {
            current_path.moveSideways();
        }
        else if (movementCounter[1] == 1)
            current_path.moveUp();
        else
            current_path.moveDown();
        base_two_counter.increment();
    }
}
