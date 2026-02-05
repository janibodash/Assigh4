package com.example.libraryrest.entities;

public class LibraryMember extends Person {
    private int id;
    private int borrowedb;
    private int fineAmount;

    public LibraryMember(int id,String name,String phone,int borrowedb,int fineAmount){
        this.id=id;
        this.name=name;
        this.phone=phone;
        this.borrowedb=borrowedb;
        this.fineAmount=fineAmount;
    }
    public int getId(){
        return id;
    }

    public int getBorrowedb(){
        return borrowedb;
    }
    public int getfineAmount(){
        return fineAmount;
    }

    public void setId(int id){
        this.id=id;
    }
    public void setName(String name ){
        this.name=name;
    }
    public void setPhone(String phone ){
        this.phone=phone;
    }
    public void setBorrowedb(int borrowedb ){
        this.borrowedb=borrowedb;
    }
    public void setFineAmount(int fineAmount ){
        this.fineAmount=fineAmount;
    }


}
