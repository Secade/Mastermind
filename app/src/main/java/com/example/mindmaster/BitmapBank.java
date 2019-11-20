package com.example.mindmaster;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;
    Bitmap core;
    Bitmap pubs, publications, corpo, univrel, socio;
    Bitmap tnd, rnd, hrd, acads;
    Bitmap docu, finance;

    public BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.background);
//        background = scaleImage(background);
        core = BitmapFactory.decodeResource(res, R.drawable.core);
        pubs = BitmapFactory.decodeResource(res, R.drawable.pubs);
        publications = BitmapFactory.decodeResource(res, R.drawable.publications);
        corpo = BitmapFactory.decodeResource(res, R.drawable.corpo);
        univrel = BitmapFactory.decodeResource(res, R.drawable.univrel);
        socio = BitmapFactory.decodeResource(res, R.drawable.socio);
        tnd = BitmapFactory.decodeResource(res, R.drawable.tnd);
        rnd = BitmapFactory.decodeResource(res, R.drawable.rnd);
        hrd = BitmapFactory.decodeResource(res, R.drawable.hrd);
        acads = BitmapFactory.decodeResource(res, R.drawable.acads);
        docu = BitmapFactory.decodeResource(res, R.drawable.docu);
        finance = BitmapFactory.decodeResource(res, R.drawable.finance);
    }

    public Bitmap getCore() {
        return core;
    }

    public Bitmap getPubs() {
        return pubs;
    }

    public Bitmap getPublications() {
        return publications;
    }

    public Bitmap getCorpo() {
        return corpo;
    }

    public Bitmap getUnivrel() {
        return univrel;
    }

    public Bitmap getSocio() {
        return socio;
    }

    public Bitmap getTnd() {
        return tnd;
    }

    public Bitmap getRnd() {
        return rnd;
    }

    public Bitmap getHrd() {
        return hrd;
    }

    public Bitmap getAcads() {
        return acads;
    }

    public Bitmap getDocu() {
        return docu;
    }

    public Bitmap getFinance() {
        return finance;
    }

    public Bitmap getBackground(){
        return background;
    }

    //Return background width
    public int getBackgroundWidth(){
        return background.getWidth();
    }

    //Return background height
    public int getBackgroundHeight(){
        return background.getHeight();
    }

//    public Bitmap scaleImage(Bitmap bitmap){
//        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();
//        /*
//        We'll multiply widthHeightRatio with screenHeight to get scaled width of the bitmap.
//        Then call createScaledBitmap() to create a new bitmap, scaled from an existing bitmap, when possible.
//         */
//        int backgroundScaledWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
//        return Bitmap.createScaledBitmap(bitmap, backgroundScaledWidth, AppConstants.SCREEN_HEIGHT, false);
//    }
}
