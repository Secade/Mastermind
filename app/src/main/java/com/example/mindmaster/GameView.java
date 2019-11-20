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

    public Bitmap scaleIt(Bitmap bit){
        Bitmap bm;
        float scale = (float)bit.getHeight()/getHeight();
        int newWidth = Math.round(bit.getWidth()/(scale*10));
        int newHeight = Math.round(bit.getHeight()/(scale*10));
        return Bitmap.createScaledBitmap(bit, newWidth, newHeight, true);
    }
    public void drawIcons(Canvas canvas){


        Bitmap background = BitmapFactory.decodeResource(getResources(), R.drawable.docu);


        float scale = (float)background.getHeight()/(float)getHeight();
        int newWidth = Math.round(background.getWidth()/(scale*10));
        int newHeight = Math.round(background.getHeight()/(scale*10));
       Bitmap scaled = Bitmap.createScaledBitmap(background, newWidth, newHeight, true);
        canvas.drawBitmap(scaled,(float)background.getWidth()/(float)4,(float)background.getHeight()/(float)2,null);


        canvas.drawBitmap(scaled, Resources.getSystem().getDisplayMetrics().widthPixels-newWidth,
                Resources.getSystem().getDisplayMetrics().heightPixels-newHeight, null);


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