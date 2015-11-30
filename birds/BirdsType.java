package birds;

public enum BirdsType {
    NONE(0), WATERFOWL(1), BIRD_OF_PREY(2), SONG_BIRD(3), DOMESTIC_BIRD(4), WILD_BIRD(5), EXOTIC_BIRD(6);

    private int id;
    private BirdsType(int id){
        this.id=id;
    }

}
