package com.dilangunes.landmarkbook;

import android.graphics.Bitmap;

public class Singleton {
    private Bitmap chosemImage;
    private static Singleton singleton;

    public Singleton() {

    }

    public Bitmap getChosemImage() {
        return chosemImage;
    }

    public void setChosemImage(Bitmap chosemImage) {
        this.chosemImage = chosemImage;
    }

    public static Singleton getInstance(){
        if (singleton ==  null){
            singleton = new Singleton();
        }
        return singleton;
    }

}

