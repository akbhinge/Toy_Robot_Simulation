package simulateRobot;

import simulateRobot.model.*;

public class Simulation {

    ToyBoard toyBoard;
    Robot robot;

    public Simulation(ToyBoard toyBoard, Robot robot) {
        this.toyBoard = toyBoard;
        this.robot = robot;
    }

    public boolean placeRobot(Position position) throws Exception{
        if(toyBoard == null){
            throw new Exception("Invalid ToyBoard");
        }

        if(position == null){
            throw new Exception("Invalid position");
        }

        if(position.getDirection() == null){
            throw new Exception("Cannot move in this direction");
        }

        if(toyBoard.checkValidPosition(position)){
            return true;
        }

        robot.setPosition(position);

        return true;
    }

    /**
     *
     * @param input -
     * @return -
     * @throws Exception -
     */

    public String evaluateMove(String input) throws Exception{

        String[] inputCommands = input.split(" ");

        Commands issueCommand;

        try{
            issueCommand = Commands.valueOf(inputCommands[0]);
        }
        catch (IllegalArgumentException exp){
            throw new Exception("Invalid Command, cannot move Robot!");
        }

        if(issueCommand == Commands.PLACE && inputCommands.length < 2){
            throw new Exception("Invalid Command");
        }

        String[] validateMoves;

        int x=0, y=0;

        Direction assignDirection = null;

        if(issueCommand == Commands.PLACE){
            validateMoves = inputCommands[1].split(",");
            try{
                x = Integer.parseInt(validateMoves[0]);
                y = Integer.parseInt(validateMoves[1]);
                assignDirection = Direction.valueOf(validateMoves[2]);
                if(x > 5 || y > 5){
                    throw new Exception();
                }
            }
            catch(Exception exp){
                throw new Exception("Invalid Co-ordinates, command cannot be executed!");
            }
        }

        String output;

        switch (issueCommand) {
            case PLACE:
                output = String.valueOf(placeRobot(new Position(x, y, assignDirection)));
                break;
            case MOVE:
                Position newPosition = robot.getPosition().getRobotPosition();
                if (!toyBoard.checkValidPosition(newPosition))
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
                output = displayReport();
                break;
            default:
                throw new Exception("Invalid command");
        }

        return output;
    }

    public String displayReport(){

        if(robot.getPosition() == null)
            return null;

        return robot.getPosition().getXPosition() + ','
                + robot.getPosition().getYPosition() + ','
                + robot.getPosition().getDirection().toString();
    }

}
