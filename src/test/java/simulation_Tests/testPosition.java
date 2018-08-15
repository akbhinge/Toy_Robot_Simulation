package simulation_Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import simulateRobot.model.Direction;
import simulateRobot.model.Position;

public class testPosition {

    @Test
    public void testGetNextPosition() throws Exception{

        Position position = new Position(0,0, Direction.NORTH);

        Position newPosition = position.getNextPosition();

        Assert.assertEquals(newPosition.getXCoordinate(),0);
        Assert.assertEquals(newPosition.getYCoordinate(),1);
        Assert.assertEquals(newPosition.getDirection(),Direction.NORTH);

        newPosition.setDirection(Direction.NORTH);
        newPosition = newPosition.getNextPosition();
        Assert.assertNotEquals(newPosition.getXCoordinate(), 1);
        Assert.assertEquals(newPosition.getYCoordinate(), 2);
        Assert.assertNotEquals(newPosition.getDirection(), Direction.WEST);

    }
}
