package com.hiteware.resistance_kata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 4/14/16.
 */
public class Path {
    private final Integer[][] resistence_grid;
    private List<Integer> positions = new ArrayList<>();

    public Path(Integer[][] grid) {
        resistence_grid = grid;
    }

    public void setStartPosition(int row) {
        positions.add(row);
    }

    public List<Integer> recallPositions() {
        return positions;
    }

    public void moveUp() {
        int lastPosition = positions.get(positions.size()-1);
        int nextPosition = (lastPosition == 1) ? resistence_grid.length: lastPosition-1;
        positions.add(nextPosition);
    }
}
