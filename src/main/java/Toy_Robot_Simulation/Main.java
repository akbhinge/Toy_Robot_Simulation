package Toy_Robot_Simulation;

import Toy_Robot_Simulation.model.Robot;
import Toy_Robot_Simulation.model.ToyBoard;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ToyBoard board = new ToyBoard(5, 5);
        Robot robot = new Robot();
        Game new_Game = new Game(board, robot);

        Scanner in = new Scanner(System.in);

        System.out.println("Toy Robot Simulator: ");
        System.out.println("Please enter a valid command: ");
        System.out.println("Valid Commands: ");

        System.out.println("\'PLACE X,Y,NORTH|SOUTH|EAST|WEST\', MOVE, LEFT, RIGHT, REPORT or EXIT");

        boolean moveRobot = true;

        while(moveRobot){

            String getInput = in.next();

            if(getInput.equalsIgnoreCase("EXIT")){
                moveRobot = false;
            }
            else{
                try{

                    String outputStr = new_Game.evaluateMove(getInput);
                    System.out.println(outputStr);


                }catch (Exception exp){
                    System.out.println(exp.getMessage());
                }
            }

        }
        System.out.println(new_Game);


    }
}
