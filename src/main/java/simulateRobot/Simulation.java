package simulateRobot;

import simulateRobot.model.*;

public class Simulation {

    private ToyBoard squareBoard;
    private Robot robot;

    public Simulation(ToyBoard squareBoard, Robot robot) {
        this.squareBoard = squareBoard;
        this.robot = robot;
    }

    /**
     * Places the robot on the squareBoard  in position X,Y and facing NORTH, SOUTH, EAST or WEST
     *
     * @param position Robot position
     * @return true if placed successfully
     */
    public boolean placeToyRobot(Position position) throws Exception {

        if (squareBoard == null)
            throw new Exception("Invalid squareBoard object");

        if (position == null)
            throw new Exception("Invalid position object");

        if (position.getDirection() == null)
            throw new Exception("Invalid direction value");

        // validate the position
        if (!squareBoard.checkValidPosition(position))
            return false;

        // if position is valid then assign values to fields
        robot.setPosition(position);
        return true;
    }

    /**
     * Ecvaluate a command
     *
     * @param inputString - string containing input command
     * @return string after executing the command
     * @throws Exception - if invalid command provided
     *
     */
    public String evaluateMove(String inputString) throws Exception {
        String[] args = inputString.split(" ");

        // validate command
        Commands command;
        try {
            command = Commands.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            throw new Exception("Invalid command");
        }
        if (command == Commands.PLACE && args.length < 2) {
            throw new Exception("Invalid command");
        }

        // validate PLA CE params
        String[] params;
        int x = 0;
        int y = 0;
        Direction commandDirection = null;
        if (command == Commands.PLACE) {
            params = args[1].split(",");
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                commandDirection = Direction.valueOf(params[2]);
            } catch (Exception e) {
                throw new Exception("Invalid command");
            }
        }

        String output;

        switch (command) {
            case PLACE:
                output = String.valueOf(placeToyRobot(new Position(x, y, commandDirection)));
                break;
            case MOVE:
                Position newPosition = robot.getPosition().getNextPosition();
                if (!squareBoard.checkValidPosition(newPosition))
                    output = String.valueOf(false);
                else
                    output = String.valueOf(robot.move(newPosition));
                break;
            case LEFT:
                output = String.valueOf(robot.rotateLeft());
                break;
            case RIGHT:
                output = String.valueOf(robot.rotateRight());
                break;
            case REPORT:
                output = report();
                break;
            default:
                throw new Exception("Invalid command");
        }

        return output;
    }

    /**
     * Returns the X,Y and Direction of the robot
     */
    private String report() {
        if (robot.getPosition() == null)
            return null;

        return "OUTPUT: " + robot.getPosition().getXCoordinate() + "," + robot.getPosition().getYCoordinate() + "," + robot.getPosition().getDirection().toString();
    }

}
