package Toy_Robot_Simulation;

import Toy_Robot_Simulation.model.Position;
import Toy_Robot_Simulation.model.Robot;
import Toy_Robot_Simulation.model.ToyBoard;

public class Game {

    ToyBoard toyBoard;
    Robot robot;

    public Game(ToyBoard toyBoard, Robot robot) {
        this.toyBoard = toyBoard;
        this.robot = robot;
    }

    public boolean placeRobot(Position position) throws Exception{
        if(toyBoard == null){
            throw new Exception("Invalid ToyBoard");
        }

        robot.setNewPosition(position);

        return true;
    }

    public String displayResult(){

        if(robot.getPosition == null)
            return null;

        return robot.getPosition().get
    }

    public String evaluateMove(String input){
        return ;
    }

}
