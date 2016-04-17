package com.hiteware.resistance_kata;

/**
 * Created on 4/17/16.
 */
public class ComputeAllPaths {

    private Integer[][] grid;

    public ComputeAllPaths(Integer[][] grid) {
        this.grid = grid;
    }

    public Path getCurrentPath() {
        Path current = new Path(grid, 1);
        current.moveSideways();
        return current;
    }
}
