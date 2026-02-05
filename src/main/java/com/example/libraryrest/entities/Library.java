package com.example.libraryrest.entities;

import java.util.ArrayList;
public class Library {
    private String libraryName;
    private String phone;
    private int totalBooks;

    private ArrayList<Book> books;

    public Library(String libraryName, String phone, int totalBooks) {
        this.libraryName = libraryName;
        this.phone = phone;
        this.totalBooks = totalBooks;
        this.books = new ArrayList<>();
    }

    public String getLibraryName() {
        return libraryName;
    }

    public String getPhone() {
        return phone;
    }

    public int getTotalBooks() {
        return totalBooks;
    }
    public void setLibraryName(String libraryName){
        this.libraryName=libraryName;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void setTotalBooks(int totalBooks) {
        this.totalBooks = totalBooks;
    }

    public void LibInf(){
        System.out.println("entities.Library name: "+ libraryName + " have "+totalBooks+ " books. "+ "their phone: "+phone);
    }
    //2


    public void addBook(Book book){
        books.add(book);

    }

    public void showAllBooks(){
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void findBook(String title){
        for(Book book : books){
            if(book.getTitle().equalsIgnoreCase(title)){
                System.out.println(book);
                return;
            }
        }
        System.out.println("entities.Book not found");
    }
    public void sortByYear() {
        books.sort((b1, b2) -> b1.getYear() - b2.getYear());
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

}
