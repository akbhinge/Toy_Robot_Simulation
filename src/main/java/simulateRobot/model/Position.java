package simulateRobot.model;

public class Position {

    private int x, y;
    Direction direction;


    public Position(Position position) {
        this.x = position.getXPosition();
        this.y = position.getYPosition();
        this.direction = position.getDirection();

    }


    public Position(int x, int y, Direction direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getXPosition(){
        return this.x;
    }

    public int getYPosition() {
        return this.y;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void moveRobot(int x, int y){
        this.x = this.x + x;
        this.y = this.y + y;

    }

    public Position getRobotPosition() throws Exception{

        if(this.direction == null){
            throw new Exception("Invalid robot direction");
        }

        Position newPosition = new Position(this);

        switch (this.direction){

            case NORTH:
                newPosition.moveRobot(0,1);
                break;
            case EAST:
                newPosition.moveRobot(1,0);
                break;
            case WEST:
                newPosition.moveRobot(-1,0);
                break;
            case SOUTH:
                newPosition.moveRobot(0,-1);
                break;
        }

        return newPosition;
    }

}
