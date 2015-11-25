package day4.library;

public class Launcher {
    public static void main(String[] args) {

        Library library=new Library();

        DemoData demo=new DemoData();
        demo.createLibrary(library);

        System.out.println();
        System.out.println("By name:");
        library.printAllByName();
        System.out.println();
        System.out.println("By author:");
        System.out.println();
        library.printAllByAuthor();
        System.out.println();
        System.out.println("By genre:");
        System.out.println();
        library.printAllByGenre();

        System.out.println();
        System.out.println("Find by author: Rowling");
        library.printBooks(library.findByAuthor("Rowling"));

        System.out.println();
        System.out.println("Find by name: Pride and Prejudice");
        library.printBooks(library.findByName("Pride and Prejudice"));

        System.out.println();
        System.out.println("Find by genre step1: COMPUTERS");
        library.printBooks(library.findByGenre(Genre.COMPUTERS));

        System.out.println();
        System.out.println("Find by genre step2: COMPUTERS");
        library.printBooks(library.findByGenre(Genre.COMPUTERS));


    }
}
