package com.example.recipes;

public class recipes {
    int image;
    String name;

    public recipes(int image, String name){
        this.image = image;
        this.name = name;
    }

    public int getImage(){
        return image;
    }

    public String getName(){
        return name;
    }

}
