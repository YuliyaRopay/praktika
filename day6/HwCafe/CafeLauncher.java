package day6.HwCafe;

public class CafeLauncher {
    public static void main(String[] args) {

        //
        Ingredient ingredient1= new Ingredient("milk", 5.5, 50, "gr.");
        Ingredient ingredient2= new Ingredient("water", 1, 100, "gr.");
        Ingredient ingredient3= new Ingredient("coffee arabika", 10, 5, "gr.");
        Ingredient ingredient4= new Ingredient("green tea", 10, 5, "gr.");
        Ingredient ingredient5= new Ingredient("black tea", 10, 5, "gr.");
        Ingredient ingredient6= new Ingredient("lemon", 3, 1, "gr.");
        Ingredient ingredient7= new Ingredient("sugar", 8, 5, "gr.");

        //
        Recipe recipe1=new Recipe("green tea",
                new Ingredient[] {ingredient4, ingredient2, ingredient7}, new int[]{5,300,10});

        Recipe recipe2=new Recipe("americano",
                new Ingredient[] {ingredient3, ingredient2, ingredient7}, new int[]{5,100,10});

        Recipe recipe3=new Recipe("cappuccino",
                new Ingredient[] {ingredient3, ingredient2, ingredient7, ingredient1}, new int[]{5,100,10,20});


        //
        Menu menu1=new Menu("Drink menu", new Recipe[]{recipe1,recipe2,recipe3});

        //


    }
}
