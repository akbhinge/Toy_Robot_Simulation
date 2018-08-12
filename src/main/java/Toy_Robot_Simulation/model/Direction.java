package Toy_Robot_Simulation.model;

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

     Direction(int direction) {
        this.directionIndex = direction;
    }

    public static Direction valueOf(int directionNum) {
        return map.get(directionNum);
    }


    public Direction leftDirection() {
        return rotate(-1);
    }


    public Direction rightDirection() {
        return rotate(1);
    }

    private Direction rotate(int place) {

        int newIndex = (this.directionIndex + place) < 0 ?
                map.size() - 1 :
                (this.directionIndex + place) % map.size();

        return Direction.valueOf(newIndex);
    }

}

