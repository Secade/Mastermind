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
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GameView extends SurfaceView implements View.OnTouchListener, SurfaceHolder.Callback{

    private SurfaceHolder surfaceHolder = null;

    private Paint paint = null;

    private int height = 0;

    Bitmap mDrawBitmap;
    Canvas mBitmapCanvas;
    Paint mDrawPaint = new Paint();

    public int getMyHeight(){
        return height;
    }

    public GameView(Context context) {

        super(context);
        setFocusable(true);
        if(surfaceHolder == null) {
            surfaceHolder = getHolder();
            surfaceHolder.addCallback(this);
        }

        if(paint == null)
        {
            paint = new Paint();

            paint.setColor(Color.RED);
        }

        this.setZOrderMediaOverlay(true);

        this.getHolder().setFormat(PixelFormat.TRANSPARENT);

        DisplayMetrics disp = new DisplayMetrics();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, measureHeight(heightMeasureSpec));
    }

    private int measureHeight(int measureSpec) {
        int result = 0;
        measureSpec = 8100;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.UNSPECIFIED) {
            result = specSize;
        }
        return result;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public Bitmap scaleIt(Bitmap bit){
        int newWidth = AppConstants.SCREEN_WIDTH / 4;
        int newHeight = newWidth;
        return Bitmap.createScaledBitmap(bit, newWidth, newHeight, true);
    }

    public void drawCode(int correct, int wp, ArrayList<Integer> guess){
        Canvas canvas = surfaceHolder.lockCanvas();

        canvas.drawColor(0, PorterDuff.Mode.CLEAR);

        if(height >= 8100)
            height = 0;

        if (mDrawBitmap == null) {
            mDrawBitmap = Bitmap.createBitmap(getWidth(), 8100, Bitmap.Config.ARGB_8888);
            mBitmapCanvas = new Canvas(mDrawBitmap);
        }

        Paint myPaint = new Paint();
        myPaint.setColor(Color.WHITE);
        myPaint.setStyle(Paint.Style.FILL);
        myPaint.setStrokeWidth(10);

        mBitmapCanvas.drawRect(0,height, AppConstants.SCREEN_WIDTH, height + AppConstants.SCREEN_WIDTH/4 + 20 + 100 + 10 + 100 + 30, myPaint);

        int pic = 0;
        for(int i = 0; i < 4; i++){
            switch (guess.get(i)){
                case 0: pic = R.drawable.core;
                    break;
                case 1: pic = R.drawable.acads;
                    break;
                case 2: pic = R.drawable.hrd;
                    break;
                case 3: pic = R.drawable.rnd;
                    break;
                case 4: pic = R.drawable.tnd;
                    break;
                case 5: pic = R.drawable.corpo;
                    break;
                case 6: pic = R.drawable.publications;
                    break;
                case 7: pic = R.drawable.pubs;
                    break;
                case 8: pic = R.drawable.univrel;
                    break;
                case 9: pic = R.drawable.socio;
                    break;
                case 10: pic = R.drawable.docu;
                    break;
                case 11: pic = R.drawable.finance;
                    break;
            }

            Bitmap bmap = BitmapFactory.decodeResource(getResources(), pic);
            bmap = scaleIt(bmap);

            switch (i){
                case 0: mBitmapCanvas.drawBitmap(bmap, 0, height, null);
                    break;
                case 1: mBitmapCanvas.drawBitmap(bmap, bmap.getWidth(), height, null);
                    break;
                case 2: mBitmapCanvas.drawBitmap(bmap, bmap.getWidth()*2, height, null);
                    break;
                case 3: mBitmapCanvas.drawBitmap(bmap, bmap.getWidth()*3, height, null);
                    break;
            }
        }

        height += (AppConstants.SCREEN_WIDTH/4 + 20);

        Paint scorePaint = new Paint();
        scorePaint.setColor(Color.DKGRAY);
        scorePaint.setTextSize(100);
        scorePaint.setTextAlign(Paint.Align.CENTER);
        mBitmapCanvas.drawText("Correct Answer: " + correct, AppConstants.SCREEN_WIDTH/2, height + 100, scorePaint);
        height += (100 + 10);
        mBitmapCanvas.drawText("Wrong Position: " + wp, AppConstants.SCREEN_WIDTH/2, height + 100, scorePaint);
        height += (100 + 40);

        canvas.drawBitmap(mDrawBitmap, 0, 0, mDrawPaint);

        surfaceHolder.unlockCanvasAndPost(canvas);
        invalidate();
        requestLayout();
        Log.d("hello", "Hello " + height);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}