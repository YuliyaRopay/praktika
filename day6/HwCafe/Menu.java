package day6.HwCafe;

public class Menu {

    private String name;
    private Recipe[] recipes;


    public Menu(String name){
        this.name=name;
    }

    public Menu(String name, Recipe[] recipes){
        this.name=name;
        this.recipes=recipes;
    }

    public Recipe[] getRecipes() {
        return recipes;
    }



}
