package day8.HwBirds;

public enum BirdsType {
    None(0), Waterfowl(1), BirdOfPrey(2), SongBird(3), DomesticBird(4), WildBird(5), ExoticBird(6);

    private int id;
    private BirdsType(int id){
        this.id=id;
    }


}
