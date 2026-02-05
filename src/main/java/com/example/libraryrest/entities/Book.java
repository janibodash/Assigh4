package com.example.libraryrest.entities;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String title;
    private String author;
    private int year;
    private String description;

    public Book() {}

    public Book(String title, String author, int year, String description) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.description = description;
    }

    public void BookInfo() {
        System.out.println("books title:" + title + " by " + author + " in the " + year + " year , the Description is: " + description);
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //2
    public String toString(){
        return title + " by " + author + " ("+ year +")" + "The Description is: " + description;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass( )!= o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && title.equals(book.title) && author.equals(book.author) && description.equals(book.description);
    }

    public int hashCode() {
        return title.hashCode() + author.hashCode() + year + description.hashCode();
    }
}

