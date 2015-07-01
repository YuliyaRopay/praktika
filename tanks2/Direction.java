package tanks2;

/**
 * Created by julia on 23.06.2015.
 */
public enum Direction {
    // 1 - top, 2 - bottom, 3 - left, 4 - right
    Non(0), Top(1), Bottom(2), Left(3), Right(4);

    private int id;
    private Direction(int id){
        this.id=id;
    }
}
