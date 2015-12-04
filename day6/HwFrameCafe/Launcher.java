package day6.HwFrameCafe;

public class Launcher {

    public static void main(String[] args) {

        Cafe cafe=new Cafe("Cafe drinks");

        DemoData demoData=new DemoData();
        demoData.setCafe(cafe);

        System.out.println(" >>> Menu : ");
        cafe.printMenu();

        System.out.println();
        System.out.println(" >>> Ingredients : ");
        cafe.printIngredients();

        System.out.println();
        System.out.println(" >>> By mokachino: ");
        cafe.printCheck("mokachino");

        System.out.println();
        System.out.println(" >>> By black tea with lemon and sugar: ");
        cafe.printCheck("black tea", new String[]{"lemon","sugar"});

    }
}
