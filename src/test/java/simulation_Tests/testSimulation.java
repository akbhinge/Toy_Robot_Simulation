package simulation_Tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import simulateRobot.Simulation;
import simulateRobot.model.Direction;
import simulateRobot.model.Position;
import simulateRobot.model.Robot;
import simulateRobot.model.ToyBoard;

public class testSimulation {


    private final int ROWS = 5, COLUMNS = 5;


    @Test
    public void testBoardPlacement() throws Exception{
        ToyBoard board = new ToyBoard(ROWS,COLUMNS);

        Robot robot = new Robot();

        Simulation moves = new Simulation(board,robot);

        Assert.assertTrue(moves.placeToyRobot(new Position(1,1, Direction.NORTH)));
        Assert.assertTrue(moves.placeToyRobot(new Position(3,3,Direction.EAST)));
        Assert.assertFalse(moves.placeToyRobot(new Position(10,10,Direction.WEST)));
        Assert.assertFalse(moves.placeToyRobot(new Position(-2,-2,Direction.SOUTH)));
    }

    @Test(expectedExceptions = Exception.class)
    public void testRobotMoves() throws Exception {

        ToyBoard board = new ToyBoard(ROWS,COLUMNS);

        Robot robot = new Robot();

        Simulation simulateRobot = new Simulation(board,robot);

        simulateRobot.evaluateMove("PLACE 0,0,NORTH");
        Assert.assertEquals("OUTPUT: 0,0,NORTH", simulateRobot.evaluateMove("REPORT"));

        simulateRobot.evaluateMove("MOVE");
        simulateRobot.evaluateMove("RIGHT");
        simulateRobot.evaluateMove("MOVE");
        simulateRobot.evaluateMove("RIGHT");
        simulateRobot.evaluateMove("LEFT");

        Assert.assertEquals("OUTPUT: 1,1,EAST", simulateRobot.evaluateMove("REPORT"));

        simulateRobot.evaluateMove("PLACE 0,0,SOUTH");
        simulateRobot.evaluateMove("MOVE");
        simulateRobot.evaluateMove("REPORT");

        Assert.assertEquals("OUTPUT: 0,0,SOUTH", simulateRobot.evaluateMove("REPORT"));

        // Test case to check if robot ignores the command if moves out from the board

        simulateRobot.evaluateMove("PLACE 1,1,EAST");
        for (int i = 0; i < 10; i++) {
            simulateRobot.evaluateMove("MOVE");
        }
        Assert.assertEquals("OUTPUT: 5,1,EAST", simulateRobot.evaluateMove("REPORT"));

        Assert.assertEquals("Invalid command", simulateRobot.evaluateMove("PLACE 12NORTH"));

    }
}
