package com.atay.kg.domkom;

public class NewsClass {

    private String title;
    private String image_url;
    private String Text;
    private int id;
    private String date;


    public NewsClass() {
    }

    public NewsClass(String title, String text, String date, int id, String image_url) {
        this.title = title;
        Text = text;
        this.id = id;
        this.date = date;
        this.image_url = image_url;
    }

    public String getTitle() { return title;}
    public String getText() { return Text;}
    public int getId() { return id;}
    public String getDate() { return date;}
    public String getImage_url() { return image_url;}

    public void setTitle(String title) {
        this.title = title;
    }
    public void setText(String text) {
        text = text;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}

