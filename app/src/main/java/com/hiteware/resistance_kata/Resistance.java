package com.hiteware.resistance_kata;

import java.util.List;

/**
 * Created on 4/14/16.
 */
public class Resistance {
    private final Path bestPath;

    public Resistance(Integer[][] grid) {
        ComputeAllPaths allPaths = new ComputeAllPaths(grid);
        while (!allPaths.done()) {
            allPaths.calculate_next_path();
        }
        bestPath = allPaths.getBestPath();
    }

    public int leastResistanceCount() {
        return bestPath.resistance();
    }

    public boolean pathComplete() {
        return !bestPath.resistance_too_high();
    }

    public List<Integer> path() {
        return bestPath.recallPositions();
    }
}
