package simulation_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import simulateRobot.model.Direction;

public class testDirections {

    @Test
    public void testRobotDirection() throws Exception{

        Direction direction = Direction.NORTH;

        direction = direction.rightDirection();
        Assert.assertEquals(direction,Direction.EAST);

        direction = direction.rightDirection();
        Assert.assertEquals(direction, Direction.SOUTH);
    }
}
