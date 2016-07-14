package com.blank.root.buku.Helper;


import io.realm.RealmObject;

/**
 * Created by root on 22/06/16.
 */
public class Articel extends RealmObject {
    private int id;
    private String title;
    private String descripsi;

    public int getId(){
        return (id);
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTitle(){
        return (title);
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescripsi(){
        return (descripsi);
    }
    public void setDescripsi(String descripsi){
        this.descripsi = descripsi;
    }
}
