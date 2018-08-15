package ToyRobot_Test_Suite;

import org.testng.Assert;
import org.testng.annotations.Test;
import simulateRobot.model.Direction;

public class testDirections {

    /**
     *  Test cases to check if the robot moves in valid direction
     */

    @Test
    public void testRobotDirection(){

        Direction direction = Direction.NORTH;

        direction = direction.rightDirection();
        Assert.assertEquals(direction,Direction.EAST);

        direction = direction.rightDirection();
        Assert.assertEquals(direction, Direction.SOUTH);
    }
}
