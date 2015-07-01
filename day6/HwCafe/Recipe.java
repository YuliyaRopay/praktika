package day6.HwCafe;

public class Recipe {

    private String name;
    private Ingredient[] ingredients;
    private int[] count;
    private double price;

    public Recipe(String name) {
        this.name = name;
    }

    public Recipe(String name, Ingredient[] ingredients, int[] count) {
        this.name = name;
        this.ingredients = ingredients;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public int[] getCount() {
        return count;
    }

    public void setCount(int[] count) {
        this.count = count;
    }
}
