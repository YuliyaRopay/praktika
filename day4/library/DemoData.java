package day4.library;

public class DemoData {

    public DemoData(){
    }

    public void createLibrary(Library library){

        library.addToLibrary(new Book("Rowling","Harry Potter1",Genre.FICTION));
        library.addToLibrary(new Book("Harper Lee","To Kill a Mockingbird",Genre.FICTION));
        library.addToLibrary(new Book("Austen","Pride and Prejudice",Genre.FICTION));
        library.addToLibrary(new Book("Mitchell Margaret","Gone with the Wind",Genre.FICTION));
        library.addToLibrary(new Book("Golding","Lord of the Flies",Genre.FICTION));
        library.addToLibrary(new Book("Rowling","Harry Potter2",Genre.FICTION));
        library.addToLibrary(new Book("Homer","The Odyssey",Genre.FICTION));
        library.addToLibrary(new Book("Nabokov","Lolita",Genre.FICTION));
        library.addToLibrary(new Book("Tolstoy","Anna Karenina",Genre.FICTION));
        library.addToLibrary(new Book("Hemingway","The Old Man and the Sea",Genre.FICTION));
        library.addToLibrary(new Book("McDowell","Cracking the Coding ",Genre.COMPUTERS));
        library.addToLibrary(new Book("Demirov","Learn JavaScript",Genre.COMPUTERS));
        library.addToLibrary(new Book("Sierra","Headfirst Java",Genre.COMPUTERS));
        library.addToLibrary(new Book("Levine","Flex and Bison",Genre.COMPUTERS));
        library.addToLibrary(new Book("Kernighan","The Unix Programming Environment",Genre.COMPUTERS));
        library.addToLibrary(new Book("Vlissides","Design Patterns",Genre.COMPUTERS));
        library.addToLibrary(new Book("Tanenbaum","Modern Operating Systems",Genre.COMPUTERS));
    }
}
