package book;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

class Book {
    private final int id;
    private String name;
    private String author;
    private String year;

    public Book(int id, String name, String author, String year) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
}

class TempBook {//без id
    private String name;
    private String author;
    private String year;

    public TempBook(String name, String author, String year) {
        this.author = author;
        this.name = name;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
}

@Component
class BookStorage{
    ArrayList<Book> books;
    private int count = 0;

    public BookStorage(){
        books = new ArrayList<>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void add(String name, String author, String year){
        books.add(new Book(count, name, author, year));
        count++;
    }

    public void delete(int idToDel) {
        for (int i = 0; i < books.size(); i++ ) {
            if (books.get(i).getId() == idToDel) {
                books.remove(i);
                break;
            }
        }
    }

}

