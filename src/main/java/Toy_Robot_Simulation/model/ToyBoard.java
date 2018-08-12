package Toy_Robot_Simulation.model;

public class ToyBoard implements Board {

    private int rows, columns;

    public ToyBoard(int rows,int columns){
        this.rows = rows;
        this.columns = columns;
    }

    public boolean checkValidPosition(Position position){

        return (
                position.getXPosition() < this.columns || position.getXPosition() > 0 ||
                        position.getYPosition() < this.rows || position.getYPosition() > 0
        );
    }
}
