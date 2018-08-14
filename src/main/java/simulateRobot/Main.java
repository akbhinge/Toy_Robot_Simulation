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

        System.out.println("Toy Robot Simulator: ");
        System.out.println("Please enter a valid command: ");
        System.out.println("Valid Commands: ");

        System.out.println("\'PLACE X,Y,NORTH|SOUTH|EAST|WEST\', MOVE, LEFT, RIGHT, REPORT or EXIT");

        boolean moveRobot = true;

        while(moveRobot){

            String getInput = in.nextLine();

            if(getInput.equalsIgnoreCase("EXIT")){
                moveRobot = false;
            }
            else{
                try{2

                    String outputStr = new_Simulation.evaluateMove(getInput);
                    System.out.println(outputStr);


                }catch (Exception exp){
                    System.out.println(exp.getMessage());
                }
            }

        }
    }
}
