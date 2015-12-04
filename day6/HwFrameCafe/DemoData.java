package day6.HwFrameCafe;

public class DemoData {

    public DemoData() {
    }

    //
    public void setCafe(Cafe cafe){

        Ingredient sugar = createIngredient("sugar", 5, "gr", 1);
        Ingredient milk = createIngredient("milk", 10, "ml", 2);
        Ingredient water = createIngredient("water", 100, "ml", 5);
        Ingredient coffee = createIngredient("coffee", 10, "gr", 15);
        Ingredient tea = createIngredient("tea", 10, "gr", 10);
        Ingredient green = createIngredient("greenTea", 5, "gr", 7);
        Ingredient bergamot = createIngredient("bergamotTea", 5, "gr", 7);
        Ingredient lemon = createIngredient("lemon",1,"pc",3);
        Ingredient chocolate = createIngredient("chocolate",10,"gr",5);
        Ingredient cinnamon = createIngredient("cinnamon",2,"gr",2);

        Ingredient[] ingredients=new Ingredient[]{sugar, milk, water, coffee, tea, green, bergamot, lemon,
                chocolate, cinnamon};

        Drink blackCoffee = createDrink("black coffee", new Ingredient[]{sugar, coffee, water});
        Drink coffeeWithMilk = createDrink("coffee with milk", new Ingredient[]{sugar, coffee,milk,water});
        Drink coffeeAmericano = createDrink("americano", new Ingredient[]{sugar, coffee, water, water});
        Drink cappuccino  = createDrink("cappuccino", new Ingredient[]{sugar, coffee, water, water, milk});
        Drink mokachino  = createDrink("mokachino", new Ingredient[]{sugar, coffee, water, milk, chocolate});
        Drink blackTea  = createDrink("black tea", new Ingredient[]{sugar, tea, water});
        Drink greenTea  = createDrink("green tea", new Ingredient[]{sugar, green, water});
        Drink bergamotTea  = createDrink("bergamot tea", new Ingredient[]{sugar, bergamot, water});

        Drink[] drinks=new Drink[]{blackCoffee,coffeeWithMilk, coffeeAmericano, cappuccino, mokachino,
                blackTea, greenTea, bergamotTea};

        cafe.setIngredients(ingredients);
        cafe.setDrinks(drinks);

    }


    //
    private Drink createDrink(String name, Ingredient[] ingredients){
        Drink drink =new Drink(name);
        drink.setIngredients(ingredients);
        return drink;
    }

    //
    private Ingredient createIngredient(String name, int weight, String measure, double price){
        Ingredient ingredient = new Ingredient(name);
        ingredient.setWeight(weight);
        ingredient.setMeasure(measure);
        ingredient.setPrice(price);
        return ingredient;
    }
}
