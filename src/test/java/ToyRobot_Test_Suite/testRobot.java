package ToyRobot_Test_Suite;

import org.testng.Assert;
import org.testng.annotations.Test;
import simulateRobot.model.Direction;
import simulateRobot.model.Position;
import simulateRobot.model.Robot;
import simulateRobot.model.ToyBoard;

public class testRobot {

    @Test
    public void testRobotMoves() throws Exception{

        Robot robot = new Robot(new Position(1,1, Direction.SOUTH));

        Assert.assertTrue(robot.move());
        Assert.assertEquals(1,robot.getPosition().getXCoordinate());
        Assert.assertEquals(0,robot.getPosition().getYCoordinate());
        Assert.assertEquals(Direction.SOUTH,robot.getPosition().getDirection());

        robot.setPosition(new Position(3, 3, Direction.EAST));
        robot.move();
        robot.move();
        robot.rotateLeft();
        robot.move();

        Assert.assertEquals(5, robot.getPosition().getXCoordinate());
        Assert.assertEquals(4, robot.getPosition().getYCoordinate());
        Assert.assertEquals(Direction.NORTH, robot.getPosition().getDirection());

        robot.setPosition(new Position(0,0,Direction.NORTH));
        robot.rotateLeft();
        Assert.assertEquals(Direction.WEST, robot.getPosition().getDirection());
    }

    /**
     *
     */

    @Test
    public void testToyBoard(){

        ToyBoard board = new ToyBoard(2,5);

        // test to check a position out of board
        Assert.assertFalse(board.checkValidPosition(new Position(6,7,Direction.NORTH)));

        // test to check a valid position on the board
        Assert.assertTrue(board.checkValidPosition(new Position(2,2,Direction.SOUTH)));

        // test to check negative co-ordinates
        Assert.assertFalse(board.checkValidPosition(new Position(-2,-5,Direction.EAST)));
    }
}
