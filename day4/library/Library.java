package day4.library;

public class Library {


    private Book[][] booksByName;
    private Book[][] booksByAuthor;
    private Book[][] booksByGenre;

    private String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int sizeLibrary;
    private int sizeGenre;
    private int countBooks;
    private int stepOutGenre;
    private int currentPositionGenre;

    public Library() {
       this(20);
    }

    public Library(int countBooks) {
        this.countBooks=countBooks;
        this.sizeLibrary=alphabet.length();
        this.sizeGenre=Genre.values().length;
        stepOutGenre=2;
        currentPositionGenre=0;
        booksByName=new Book[sizeLibrary][this.countBooks];
        booksByAuthor=new Book[sizeLibrary][this.countBooks];
        booksByGenre=new Book[sizeGenre][this.countBooks];
    }


    public void addToLibrary(Book book){
        fillLibraryByName(book);
        fillLibraryByAuthor(book);
        fillLibraryByGenre(book);
    }

    private void fillLibraryByName(Book book){
        int position=alphabet.indexOf(book.getName().charAt(0));
        for(int j=0; j<countBooks; j++){
            if(booksByName[position][j]==null){
                booksByName[position][j]=book;
                return;
            }
        }
    }

    private void fillLibraryByAuthor(Book book){
        int position=alphabet.indexOf(book.getAuthor().charAt(0));
        for(int j=0; j<countBooks; j++){
            if(booksByAuthor[position][j]==null){
                booksByAuthor[position][j]=book;
                return;
            }
        }
    }

    private void fillLibraryByGenre(Book book){
        int position=book.getGenre().getIdGenre();
        for(int j=0; j<countBooks; j++){
            if(booksByGenre[position][j]==null){
                booksByGenre[position][j]=book;
                return;
            }
        }
    }


    public Book[] findByAuthor(String author){
        Book[] books=new Book[countBooks];
        int position=alphabet.indexOf(author.charAt(0));
        int i=0;
        for(int j=0;j<countBooks;j++){
            if(booksByAuthor[position][j]!=null && booksByAuthor[position][j].getAuthor().compareToIgnoreCase(author)==0){
                 books[i]=booksByAuthor[position][j];
                i++;
            }
        }
        return books;
    }


    public Book[] findByGenre(Genre genre){
        Book[] books=new Book[countBooks];
        int position=genre.getIdGenre();
        int i=0;
        for(int j=currentPositionGenre;j<currentPositionGenre+stepOutGenre;j++){
            if(booksByGenre[position][j]!=null){
                books[i]=booksByGenre[position][j];
                i++;
            }
        }

        currentPositionGenre=currentPositionGenre+stepOutGenre;
        if(currentPositionGenre>countBooks){
            currentPositionGenre=0;
        }
        return books;
    }

    public Book[] findByName(String name){
        Book[] books=new Book[countBooks];
        int position=alphabet.indexOf(name.charAt(0));

        int i=0;
        for(int j=0;j<countBooks;j++){
            if(booksByName[position][j]!=null && booksByName[position][j].getName().compareToIgnoreCase(name)==0){
                books[i]=booksByName[position][j];
                i++;
            }
        }
        return books;
    }

    public void printBooks(Book[] books){
        if(books!=null){
            for(Book book:books){
                if(book!=null){
                    System.out.println(book.getAuthor()+" "+book.getName()+" "+book.getGenre());
                }
            }
        }
    }


    public void printAllByName(){
        for(int i=0; i<sizeLibrary;i++){
            for(int j=0; j<countBooks;j++) {
                if (booksByName[i][j] != null) {
                     System.out.println(booksByName[i][j].getName() + " " + booksByName[i][j].getAuthor() + " " +
                            booksByName[i][j].getGenre());
                }
            }
        }
    }

    public void printAllByAuthor(){
        for(int i=0; i<sizeLibrary;i++){
            for(int j=0; j<countBooks;j++) {
                if (booksByAuthor[i][j] != null) {
                    System.out.println(booksByAuthor[i][j].getAuthor() + " " + booksByAuthor[i][j].getName() + " " +
                            booksByAuthor[i][j].getGenre());
                }
            }
        }
    }

    public void printAllByGenre(){
        for(int i=0; i<sizeGenre;i++){
            for(int j=0; j<countBooks;j++) {
                if (booksByGenre[i][j] != null) {
                    System.out.println(booksByGenre[i][j].getGenre() + " " + booksByGenre[i][j].getAuthor() + " " +
                            booksByGenre[i][j].getName());
                }
            }
        }
    }


}
