package tanks6;

public enum Direction {

    NONE(0), TOP(1), BOTTOM(2), LEFT(3), RIGHT(4);

    private int id;
    private Direction(int id){
        this.id=id;
    }

}
