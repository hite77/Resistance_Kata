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
    private boolean resistance_to_high = false;

    public Path(Integer[][] grid, int startRow) {
        resistance_grid = grid;
        bottomPosition = resistance_grid.length;
        positions.add(startRow);
        resistance = resistance_grid[startRow-1][0];
    }

    public Path(Path original) {
        this.resistance_grid = original.resistance_grid;
        this.positions = new ArrayList<>(original.recallPositions());
        bottomPosition = resistance_grid.length;
        this.resistance = original.resistance;
        this.currentColumn = original.currentColumn;
        this.resistance_to_high = original.resistance_to_high;
    }

    public List<Integer> recallPositions() {
        return positions;
    }

    private boolean add_new_resistance_when_less_than_or_equal_to_50(int position) {
        int new_resistance = resistance + resistance_grid[position-1][currentColumn-1];
        if (new_resistance <= 50)
       {
           resistance = new_resistance;
           ++currentColumn;
           return true;
       }
       else {
            resistance_to_high = true;
            return false;
        }
    }

    private int get_last_moved_to_position_on_path() {
        return positions.get(positions.size()-1);
    }

    public void moveUp() {
        int nextPosition = (get_last_moved_to_position_on_path() == 1) ? bottomPosition
                                                                         : get_last_moved_to_position_on_path()-1;
        only_update_positions_if_less_than_or_equal_to_50(nextPosition);
    }

    public void moveDown() {
        int nextPosition = (get_last_moved_to_position_on_path() == bottomPosition) ? 1
                                                                                      : get_last_moved_to_position_on_path()+1;
        only_update_positions_if_less_than_or_equal_to_50(nextPosition);
    }

    public void moveSideways() {
        only_update_positions_if_less_than_or_equal_to_50(get_last_moved_to_position_on_path());
    }

    public void only_update_positions_if_less_than_or_equal_to_50(int position) {
        if (!resistance_to_high && add_new_resistance_when_less_than_or_equal_to_50(position))
        {
            positions.add(position);
        }
    }

    public int resistance() {
        return resistance;
    }

    public boolean madeIt() {
        return !resistance_to_high;
    }
}
