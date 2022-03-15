package com.example.Model;

public class Livre {
    private int id;
    private String Title;
    private String ISBN;

    public int getId() {
        return id;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return Title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Livre(int id, String title, String ISBN){
        this.ISBN = ISBN;
        this.Title = title;
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}'+'\n';
    }
}
