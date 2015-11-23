package day4.frame17;

import java.util.Date;

public class Book {
    String authorName;
    String authorSurname;
    String painter;
    String publishingHouse;
    Date publishingDate;
    String title;
    int countPart;
    int pageCount;
    int price;
    String description;
    String genre;
    String format;
    String cover;
    String language;
    String font;
    String formatTypes;
    String typographyTypes;
    String hardcover;
    boolean isEbook;
    boolean isChildrenBook;
    long serialNumber;
    boolean isReading;
    int numberOfColors;

    public Book() {
    }

    public Book(String authorName, String authorSurname, String title) {
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.title = title;
    }

    public void putToArchive(){}
    public void getFromArchive(){}
    public boolean isFormatTypes(String formatTypes){return false;}
    public int countReviews(){return 0;}
    public int readsNumber(){return 0;}
    public boolean checkSerialNumber(int  partSerialNumber){
        return false;
    }
    public boolean checkPainter(String painter){
        return false;
    }
    public int numberSales(){return 0;}
    public int lastWeekSales (){return 0;}
    public boolean isRequireOrder(){return true;}
    public void printAllInfo(){}
    public String findDescriptionByWord(){return "";}
}
