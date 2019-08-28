package com.toyrobot.helper;

import java.util.HashMap;
import java.util.Map;

public enum Direction {

    NORTH(0), EAST(1), SOUTH(2), WEST(3);
    private static Map<Integer, Direction> map = new HashMap<Integer, Direction>();

    static {
        for (Direction directionEnum : Direction.values()) {
            map.put(directionEnum.directionIndex, directionEnum);
        }
    }

    private int directionIndex;

    private Direction(int direction) {
        this.directionIndex = direction;
    }

    public static Direction valueOf(int directionNum) {
        return map.get(directionNum);
    }

    /**
     * Returns the left direction
     */
    public Direction leftDirection() {
        return rotate(-1);
    }

    /**
     * Returns the right direction
     */
    public Direction rightDirection() {
        return rotate(1);
    }

    /**
     * Rotates the toy robot based on the index
     * @param step
     * @return isntance of Direction
     */
    private Direction rotate(int step) {

        int newIndex = (this.directionIndex + step) < 0 ?
                map.size() - 1 :
                (this.directionIndex + step) % map.size();

        return Direction.valueOf(newIndex);
    }



}
