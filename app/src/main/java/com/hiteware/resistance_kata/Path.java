package com.hiteware.resistance_kata;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 4/14/16.
 */
public class Path {
    private List<Integer> positions = new ArrayList<>();

    public void setStartPosition(int row) {
        positions.add(row);
    }

    public List<Integer> recallPositions() {
        return positions;
    }

    public void moveUp() {
        positions.add(4);
    }
}
