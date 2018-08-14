package simulateRobot.model;

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

    public static Direction location(int directionNum) {
        return map.get(directionNum);
    }

    /**
     * Returns the direction on the left of the current one
     */
    public Direction leftDirection() {
        return rotateRobot(-1);
    }

    /**
     * Returns the direction on the right of the current one
     */
    public Direction rightDirection() {
        return rotateRobot(1);
    }

    /**
     *
     * @param places - specify move places
     * @return - direction of movement
     */
    private Direction rotateRobot(int places) {

        int newIndex = (this.directionIndex + places) < 0 ?
                map.size() - 1 :
                (this.directionIndex + places) % map.size();

        return Direction.location(newIndex);
    }
}

