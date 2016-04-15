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

    private int get_last_moved_to_position_on_path() {
        return positions.get(positions.size()-1);
    }

    public void moveUp() {
        int nextPosition = (get_last_moved_to_position_on_path() == 1) ? resistence_grid.length : get_last_moved_to_position_on_path()-1;
        positions.add(nextPosition);
    }

    public void moveDown() {
        int nextPosition = (get_last_moved_to_position_on_path() == resistence_grid.length) ? 1 : get_last_moved_to_position_on_path()+1;
        positions.add(nextPosition);
    }
}
