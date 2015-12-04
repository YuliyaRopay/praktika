package day6.HwFrameCafe;

public class Drink {

    private String name;
    private Ingredient[] ingredients;


    public Drink() {
    }

    public Drink(String name) {
        this.name = name;
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

    public String getListIngredients(){
        String list=" |";
        for(Ingredient ingredient:this.getIngredients()){
            list=list+ingredient.getName()+"| ";
        }
        return list;
    }

    public double getDrinkPrice(){
        double price=0;
        for(Ingredient ingredient:this.getIngredients()){
            price=price+ingredient.getPrice();
        }
        return price;
    }

}
