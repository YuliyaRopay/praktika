package day6.HwFrameCafe;

public class Cafe {

    private String name;
    private Ingredient[] ingredients;
    private Drink[] drinks;

    public Cafe() {
    }

    public Cafe(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drink[] getDrinks() {
        return drinks;
    }

    public void setDrinks(Drink[] drinks) {
        this.drinks = drinks;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredient[] ingredients) {
        this.ingredients = ingredients;
    }

    public double getDrinkPrice(Drink drink){
        double price=0;
        for(Ingredient ingredient: drink.getIngredients()){
            price=price+ingredient.getPrice();
        }
        return price;
    }

    public  double getDrinkWithIngredientsPrice(Drink drink, Ingredient[] ingredients){
        double price=getDrinkPrice(drink);
        for (Ingredient ingredient:ingredients){
            price=price+ingredient.getPrice();
        }
        return price;
    }

    private Drink getDrinkByName(String drinkName){
        Drink drinkResult=null;
        for(Drink drink:drinks ){
            if(drinkName.equalsIgnoreCase(drink.getName())){
                drinkResult=drink;
            }
        }
        return drinkResult;
    }

    public Ingredient[] getIngredientsByName(String [] ingredientsName){
        Ingredient[] ingredientsResult=new Ingredient[ingredientsName.length];
        for(int i=0;i<ingredientsName.length;i++){
            for(Ingredient ingredient:ingredients){
                if(ingredient.getName().equalsIgnoreCase(ingredientsName[i])){
                    ingredientsResult[i]=ingredient;
                }
            }
        }
        return ingredientsResult;
    }

    public void printCheck(String drinkName){
        Drink drink=this.getDrinkByName(drinkName);
        System.out.println(drink.getName()+" "+this.getDrinkPrice(drink));
    }

    public void printCheck(String drinkName, String[] addIngredientsName){
        Drink drink=this.getDrinkByName(drinkName);
        Ingredient[] ingredients=this.getIngredientsByName(addIngredientsName);


        String listAddIngredients=" |";
        for (Ingredient ingredient:ingredients){
            listAddIngredients=listAddIngredients+ingredient.getName()+"| ";
        }

        System.out.println(drink.getName()+" "+listAddIngredients+" "+this.getDrinkWithIngredientsPrice(drink,ingredients));
    }

    public void printIngredients(){
        for(Ingredient ingredient:ingredients){
            ingredient.printIngredient();
        }
    }

    public void printMenu(){
        for(Drink drink:drinks){
            System.out.println(drink.getName()+" "+drink.getListIngredients()+" "+drink.getDrinkPrice());
        }
    }
}
