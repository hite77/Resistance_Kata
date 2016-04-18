package com.hiteware.resistance_kata;

/**
 * Created on 4/17/16.
 */
public class ComputeAllPaths {

    private BaseTwoCounter base_two_counter;
    private Integer[][] grid;
    private Path current_path;
    private boolean done = false;
    private Path bestPath;

    public ComputeAllPaths(Integer[][] grid) {
        this.grid = grid;
        bestPath = new Path(grid,1);
        base_two_counter = new BaseTwoCounter(grid.length, grid[0].length);
        calculate_next_path();
    }

    public ComputeAllPaths(Integer[][] grid, Integer[] counter_initial) {
        this(grid);
        base_two_counter = new BaseTwoCounter(grid.length, counter_initial);
        calculate_next_path();
    }

    public Path getCurrentPath() {
        return current_path;
    }

    public void calculate_next_path() {
        Integer[] movementCounter = base_two_counter.currentCount();
        current_path = new Path(grid, movementCounter[0]);

        int current_column=1;

        while (current_column < movementCounter.length)
        {
            if (movementCounter[current_column] == 0) {
                current_path.moveSideways();
            }
            else if (movementCounter[current_column] == 1)
                current_path.moveUp();
            else
                current_path.moveDown();
            current_column += 1;
        }
        base_two_counter.increment();
        done = base_two_counter.isDone();

        if (current_path.recallPositions().size() > bestPath.recallPositions().size() ||
                (current_path.recallPositions().size() == grid[0].length && current_path.resistance() < bestPath.resistance()))
            bestPath = new Path(current_path);
    }

    public boolean done() {
        return done;
    }

    public Path getBestPath() {
        return bestPath;
    }
}
