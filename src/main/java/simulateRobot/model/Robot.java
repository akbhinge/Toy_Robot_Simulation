package simulateRobot.model;

public class Robot {

    private Position position;

    public Robot() {
    }

    public Robot(Position position){
        this.position = position;
    }


    public boolean setPosition(Position position) {
        if (position == null)
            return false;

        this.position = position;
        return true;
    }

    public boolean move() throws Exception{

        return move(position.getNextPosition());
    }


    /**
     * Moves the robot one place forward in current direction
     *
     * @return true if moved successfully
     */
    public boolean move(Position newPosition) {
        if (newPosition == null)
            return false;

        // change position
        this.position = newPosition;
        return true;
    }

    public Position getPosition() {
        return this.position;
    }

    /**
     * Rotates the robot LEFT
     *
     * @return true if rotated successfully
     */
    public boolean rotateLeft() {
        if (this.position.direction == null)
            return false;

        this.position.direction = this.position.direction.leftDirection();
        return true;
    }

    /**
     * Rotates the robot RIGHT
     *
     * @return true if rotated successfully
     */
    public boolean rotateRight() {
        if (this.position.direction == null)
            return false;

        this.position.direction = this.position.direction.rightDirection();
        return true;
    }

}