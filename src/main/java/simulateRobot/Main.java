package simulateRobot;

import simulateRobot.model.Robot;
import simulateRobot.model.ToyBoard;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ToyBoard board = new ToyBoard(5, 5);
        Robot robot = new Robot();
        Simulation new_Simulation = new Simulation(board, robot);

        Scanner in = new Scanner(System.in);

        System.out.println();
        System.out.println("Toy Robot Simulator ");
        System.out.println();
        System.out.println("(FORMAT: PLACE X,Y,Direction)");
        System.out.println("(X, Y: Co-ordinates, Direction: NORTH,SOUTH,EAST,WEST)");
        System.out.println("After a valid PLACE command, other available commands: MOVE, LEFT, REPORT, REPORT, EXIT");
        System.out.println();
        System.out.println("Enter Command: ");
        boolean moveRobot = true;

        while(moveRobot){

            String getInput = in.nextLine();

            if(getInput.equalsIgnoreCase("EXIT")){
                moveRobot = false;
            }
            else{
                try{

                    String outputStr = new_Simulation.evaluateMove(getInput);
                    System.out.println(outputStr);


                }catch (Exception robotException){
                    System.out.println(robotException.getMessage());
                }
            }

        }
    }
}
