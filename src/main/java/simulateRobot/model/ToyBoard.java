package simulateRobot.model;

public class ToyBoard implements Board {

    private int rows;
    private int columns;

    /**
     *
     * @param rows - total rows for the board
     * @param columns - total columns for the board
     */
    public ToyBoard(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    /**
     *
     * @param position - current position on the board
     * @return - true/false depending on robot position
     */
    public boolean checkValidPosition(Position position) {
        return !(
                position.getXCoordinate() > this.columns || position.getXCoordinate() < 0 ||
                        position.getYCoordinate() > this.rows || position.getYCoordinate() < 0
        );


    }
}
