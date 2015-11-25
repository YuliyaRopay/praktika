package day4.library;

public enum Genre {

    FANTASY(0), FOOD(1), COMPUTERS(2), FICTION(3), HISTORY(4),MEDICAL(5);

    private int idGenre;

    private Genre(int idGenre){
        this.idGenre=idGenre;
    }

    public int getIdGenre(){
        return this.idGenre;
    }
}
