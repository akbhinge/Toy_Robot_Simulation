package simulateRobot.model;

public class Position {

    private int x, y;

    Direction direction;

    /**
     *
     * @param position - get co-ordiates and direction of the robot
     */

    private Position(Position position) {
        this.x = position.getXCoordinate();
        this.y = position.getYCoordinate();
        this.direction = position.getDirection();
    }

    /**
     *
     * @param x - set x co-ordinate
     * @param y - set y co-ordinate
     * @param direction - set robot direction
     */
    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getXCoordinate() {
        return this.x;
    }

    public int getYCoordinate() {
        return this.y;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    private void moveRobot(int x, int y) {
        this.x += x;
        this.y += y;
    }


    /**
     *
     * @return  - position of robot after moving in a particular direction
     * @throws Exception - if invalid position
     */
    public Position getNextPosition() throws Exception {
        if (this.direction == null)
            throw new Exception("Invalid robot direction");

        // new position to validate
        Position newPosition = new Position(this);
        switch (this.direction) {
            case NORTH:
                newPosition.moveRobot(0, 1);
                break;
            case SOUTH:
                newPosition.moveRobot(0, -1);
                break;
            case EAST:
                newPosition.moveRobot(1, 0);
                break;

            case WEST:
                newPosition.moveRobot(-1, 0);
                break;
        }
        return newPosition;
    }

}
