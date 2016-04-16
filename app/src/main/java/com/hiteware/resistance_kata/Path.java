package com.hiteware.resistance_kata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 4/14/16.
 */
public class Path {
    private final Integer[][] resistance_grid;
    private List<Integer> positions = new ArrayList<>();
    private int bottomPosition;
    private int resistance = 0;
    private int currentColumn = 2;

    public Path(Integer[][] grid) {
        resistance_grid = grid;
        bottomPosition = resistance_grid.length;
    }

    public Path(Path original) {
        this.resistance_grid = original.resistance_grid;
        this.positions = new ArrayList<>(original.recallPositions());
        bottomPosition = resistance_grid.length;
        this.resistance = original.resistance;
        this.currentColumn = original.currentColumn;
    }

    public void setStartPosition(int row) { //refactor start position as part of initializer...
        positions.add(row);
        resistance = resistance_grid[row-1][0];
    }

    public List<Integer> recallPositions() {
        return positions;
    }

    private void add_new_resistance() {
       resistance += resistance_grid[get_last_moved_to_position_on_path()-1][currentColumn-1];
       ++currentColumn;
    }

    private int get_last_moved_to_position_on_path() {
        return positions.get(positions.size()-1);
    }

    public void moveUp() {
        int nextPosition = (get_last_moved_to_position_on_path() == 1) ? bottomPosition
                                                                         : get_last_moved_to_position_on_path()-1;
        positions.add(nextPosition);
        add_new_resistance();
    }

    public void moveDown() {
        int nextPosition = (get_last_moved_to_position_on_path() == bottomPosition) ? 1
                                                                                      : get_last_moved_to_position_on_path()+1;
        positions.add(nextPosition);
        add_new_resistance();
    }

    public void moveSideways() {
        positions.add(get_last_moved_to_position_on_path());
        add_new_resistance();
    }

    public int resistance() {
        return resistance;
    }
}
