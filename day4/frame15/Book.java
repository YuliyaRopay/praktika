package day4.frame15;

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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public String getPainter() {
        return painter;
    }

    public void setPainter(String painter) {
        this.painter = painter;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCountPart() {
        return countPart;
    }

    public void setCountPart(int countPart) {
        this.countPart = countPart;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isEbook() {
        return isEbook;
    }

    public void setEbook(boolean isEbook) {
        this.isEbook = isEbook;
    }

    public boolean isChildrenBook() {
        return isChildrenBook;
    }

    public void setChildrenBook(boolean isChildrenBook) {
        this.isChildrenBook = isChildrenBook;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public boolean isReading() {
        return isReading;
    }

    public void setReading(boolean isReading) {
        this.isReading = isReading;
    }

    public boolean checkSerialNumber(int  partSerialNumber){
        return false;
    }

    public boolean checkPainter(String painter){
        return false;
    }

    public void printAllInfo(){}
}
