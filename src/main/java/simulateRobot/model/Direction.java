package simulateRobot.model;

import java.util.HashMap;
import java.util.Map;

public enum Direction {

    NORTH(0), EAST(1), SOUTH(2), WEST(3);
    private static Map<Integer, Direction> map = new HashMap<Integer, Direction>();

    static {
        for (Direction directionPosition : Direction.values()) {
            map.put(directionPosition.directionIndex, directionPosition );
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
        return changePosition(-1);
    }


    public Direction rightDirection() {
        return changePosition(1);
    }

    private Direction changePosition(int place) {

        int newIndex = (this.directionIndex + place) < 0 ?
                map.size() - 1 :
                (this.directionIndex + place) % map.size();

        return Direction.valueOf(newIndex);
    }

}

