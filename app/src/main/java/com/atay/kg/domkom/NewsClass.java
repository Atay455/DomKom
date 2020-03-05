package com.atay.kg.domkom;

public class NewsClass {

    private String Text;
    private int Photo;


    public NewsClass() {

    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public int getPhoto() {
        return Photo;
    }

    public void setPhoto(int photo) {
        Photo = photo;
    }

    public NewsClass(String text, int photo) {
        Text = text;
        Photo = photo;
    }


}
