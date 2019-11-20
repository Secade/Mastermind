package com.example.mindmaster;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class GameView extends SurfaceView implements SurfaceHolder.Callback{

    private SurfaceHolder surfaceHolder = null;

    private Paint paint = null;

    private float circleX = 0;

    private float circleY = 0;




    public GameView(Context context) {

        super(context);
        setFocusable(true);
        if(surfaceHolder == null) {
            // Get surfaceHolder object.
            surfaceHolder = getHolder();
            // Add this as surfaceHolder callback object.
            surfaceHolder.addCallback(this);
        }

        if(paint == null)
        {
            paint = new Paint();

            paint.setColor(Color.RED);
        }

        // Set the parent view background color. This can not set surfaceview background color.
        this.setBackgroundColor(Color.BLUE);

        // Set current surfaceview at top of the view tree.
        this.setZOrderOnTop(true);

        this.getHolder().setFormat(PixelFormat.TRANSLUCENT);

        DisplayMetrics disp = new DisplayMetrics();


    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Canvas canvas = surfaceHolder.lockCanvas();
        drawBack(canvas);
        drawRect(canvas);
        drawIcons(canvas);

        surfaceHolder.unlockCanvasAndPost(canvas);

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void drawBack(Canvas canvas){


        Bitmap background = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        float scale = (float)background.getHeight()/(float)getHeight();
        int newWidth = Math.round(background.getWidth()/scale);
        int newHeight = Math.round(background.getHeight()/scale);
        Bitmap scaled = Bitmap.createScaledBitmap(background, newWidth, newHeight, true);

        canvas.drawBitmap(scaled,0,0,null);

    }

    public void drawRect(Canvas canvas){

        Paint myPaint = new Paint();
        myPaint.setColor(Color.WHITE);
        myPaint.setStyle(Paint.Style.FILL);
        myPaint.setStrokeWidth(10);
        myPaint.setAlpha(100);

        canvas.drawRect(0, Resources.getSystem().getDisplayMetrics().heightPixels - (AppConstants.SCREEN_WIDTH/4*3) - 80,
                Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels, myPaint);

//        Bitmap rect = BitmapFactory.decodeResource(getResources(), R.drawable.background);
//        float scale = (float)background.getHeight()/(float)getHeight();
//        int newWidth = Math.round(background.getWidth()/scale);
//        int newHeight = Math.round(background.getHeight()/scale);
//        Bitmap scaled = Bitmap.createScaledBitmap(background, newWidth, newHeight, true);
//
//        canvas.drawBitmap(scaled,0,0,null);

    }

    public Bitmap scaleIt(Bitmap bit){
        Bitmap bm;
        float scale = (float)bit.getHeight()/getHeight();
//        int newWidth = Math.round(bit.getWidth()/(scale*10));
//        int newHeight = Math.round(bit.getHeight()/(scale*10));
        int newWidth = AppConstants.SCREEN_WIDTH / 4;
        int newHeight = newWidth;
        return Bitmap.createScaledBitmap(bit, newWidth, newHeight, true);
    }
    public void drawIcons(Canvas canvas){

        Bitmap core = BitmapFactory.decodeResource(getResources(), R.drawable.core);
        core = scaleIt(core);

        Bitmap acads = BitmapFactory.decodeResource(getResources(), R.drawable.acads);
        acads = scaleIt(acads);

        Bitmap hrd = BitmapFactory.decodeResource(getResources(), R.drawable.hrd);
        hrd = scaleIt(hrd);

        Bitmap rnd = BitmapFactory.decodeResource(getResources(), R.drawable.rnd);
        rnd = scaleIt(rnd);

        Bitmap tnd = BitmapFactory.decodeResource(getResources(), R.drawable.tnd);
        tnd = scaleIt(tnd);

        Bitmap corpo = BitmapFactory.decodeResource(getResources(), R.drawable.corpo);
        corpo = scaleIt(corpo);

        Bitmap publications = BitmapFactory.decodeResource(getResources(), R.drawable.publications);
        publications = scaleIt(publications);

        Bitmap pubs = BitmapFactory.decodeResource(getResources(), R.drawable.pubs);
        pubs = scaleIt(pubs);

        Bitmap univrel = BitmapFactory.decodeResource(getResources(), R.drawable.univrel);
        univrel = scaleIt(univrel);

        Bitmap socio = BitmapFactory.decodeResource(getResources(), R.drawable.socio);
        socio = scaleIt(socio);

        Bitmap docu = BitmapFactory.decodeResource(getResources(), R.drawable.docu);
        docu = scaleIt(docu);

        Bitmap fin = BitmapFactory.decodeResource(getResources(), R.drawable.finance);
        fin = scaleIt(fin);

//        float scale = (float)background.getHeight()/(float)getHeight();
//        int newWidth = Math.round(background.getWidth()/(scale*10));
//        int newHeight = Math.round(background.getHeight()/(scale*10));
//       Bitmap scaled = Bitmap.createScaledBitmap(background, newWidth, newHeight, true);
//        canvas.drawBitmap(scaled,(float)background.getWidth()/(float)4,(float)background.getHeight()/(float)2,null);

        //places the thing on the bottom right corner of the screen
        canvas.drawBitmap(core, 0,
                Resources.getSystem().getDisplayMetrics().heightPixels-(core.getHeight()*3) - 60, null);

        canvas.drawBitmap(acads, acads.getWidth(),
                Resources.getSystem().getDisplayMetrics().heightPixels-(acads.getHeight()*3) - 60, null);

        canvas.drawBitmap(hrd, hrd.getWidth()*2,
                Resources.getSystem().getDisplayMetrics().heightPixels-(hrd.getHeight()*3) - 60, null);

        canvas.drawBitmap(rnd, rnd.getWidth()*3,
                Resources.getSystem().getDisplayMetrics().heightPixels-(rnd.getHeight()*3) - 60, null);

        canvas.drawBitmap(tnd, 0,
                Resources.getSystem().getDisplayMetrics().heightPixels-(tnd.getHeight()*2) - 40, null);

        canvas.drawBitmap(corpo, corpo.getWidth(),
                Resources.getSystem().getDisplayMetrics().heightPixels-(corpo.getHeight()*2) - 40, null);

        canvas.drawBitmap(publications, publications.getWidth()*2,
                Resources.getSystem().getDisplayMetrics().heightPixels-(publications.getHeight()*2) - 40, null);

        canvas.drawBitmap(pubs, pubs.getWidth()*3,
                Resources.getSystem().getDisplayMetrics().heightPixels-(pubs.getHeight()*2) - 40, null);

        canvas.drawBitmap(univrel, 0,
                Resources.getSystem().getDisplayMetrics().heightPixels-univrel.getHeight() - 20, null);

        canvas.drawBitmap(socio, socio.getWidth(),
                Resources.getSystem().getDisplayMetrics().heightPixels-socio.getHeight() - 20, null);

        canvas.drawBitmap(docu, docu.getWidth()*2,
                Resources.getSystem().getDisplayMetrics().heightPixels-docu.getHeight() - 20, null);

        canvas.drawBitmap(fin, fin.getWidth()*3,
                Resources.getSystem().getDisplayMetrics().heightPixels-fin.getHeight() - 20, null);


        System.out.println("HELLO "+ Resources.getSystem().getDisplayMetrics().widthPixels);
        System.out.println("HELLO "+ Resources.getSystem().getDisplayMetrics().heightPixels);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        // Tap is detected
        if(action == MotionEvent.ACTION_DOWN){

        }
        return true;
    }
}