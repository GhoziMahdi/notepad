package com.blank.root.buku.Model;

/**
 * Created by root on 22/06/16.
 */
public class ArticelModel {
    private int id;
    private String title;
    private String descripsi;

    public ArticelModel(int id,String title,String descripsi){
        this.id = id;
        this.title = title;
        this.descripsi = descripsi;
    }
    public int getId(){
        return (id);
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTitle(){
        return(title);
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescripsi(){
        return(descripsi);
    }
    public void setDescripsi(String descripsi){
        this.descripsi = descripsi;
    }
}
