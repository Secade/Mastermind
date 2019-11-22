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

    private float circleX = 0;

    private float circleY = 0;

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
//        this.setBackgroundColor(Color.BLUE);
//        this.setBackgroundColor(Color.WHITE);
//        this.getBackground().setAlpha(0);
//        this.setBackgroundResource(R.drawable.background);

        // Set current surfaceview at top of the view tree.
//        this.setZOrderOnTop(true);
        this.setZOrderMediaOverlay(true);

        this.getHolder().setFormat(PixelFormat.TRANSPARENT);

        DisplayMetrics disp = new DisplayMetrics();


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, measureHeight(heightMeasureSpec));
//        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height + 1, MeasureSpec.UNSPECIFIED);
        setMeasuredDimension(widthMeasureSpec,
                measureHeight(heightMeasureSpec));
//        int desiredWidth = getSuggestedMinimumWidth() + getPaddingLeft() + getPaddingRight() + 1;
//        int desiredHeight = getSuggestedMinimumHeight() + getPaddingTop() + getPaddingBottom() + 1;

//        setMeasuredDimension(measureDimension(desiredWidth, widthMeasureSpec),
//                measureDimension(desiredHeight, heightMeasureSpec));
//        setMeasuredDimension(getMeasuredWidth()+1,
//                getMeasuredHeight()+1);
    }

    private int measureDimension(int desiredSize, int measureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = desiredSize;
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }

        if (result < desiredSize){
            Log.e("ChartView", "The view is too small, the content might get cut");
        }
        return result;
    }

    private int measureHeight(int measureSpec) {
        int result = 0;
        //This is because of background image in relativeLayout, which is 1000*1000px
        measureSpec = 8100;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);


        if (specMode == MeasureSpec.UNSPECIFIED) {
            // Here we say how Heigh to be
            result = specSize;
        }
        return result;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
//        Canvas canvas = surfaceHolder.lockCanvas();
//        canvas.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
//        drawBack(canvas);
//        drawRect(canvas);
//        drawIcons(canvas);

//        surfaceHolder.unlockCanvasAndPost(canvas);

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

        canvas.drawRect(0,0, AppConstants.SCREEN_WIDTH/2, AppConstants.SCREEN_HEIGHT/2, myPaint);

//        canvas.drawRect(0, Resources.getSystem().getDisplayMetrics().heightPixels - (AppConstants.SCREEN_WIDTH/4*3) - 80,
//                Resources.getSystem().getDisplayMetrics().widthPixels, Resources.getSystem().getDisplayMetrics().heightPixels, myPaint);

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

        float areaWidth;
        float areaHeight;
        //Bitmap background = BitmapFactory.decodeResource(getResources(), R.drawable.docu);

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
                0, null);

//        canvas.drawBitmap(core, 0,
//                Resources.getSystem().getDisplayMetrics().heightPixels-(core.getHeight()*3) - 60, null);

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
                Resources.getSystem().getDisplayMetrics().heightPixels+fin.getHeight() + 20, null);


       // System.out.println("HELLO "+ Resources.getSystem().getDisplayMetrics().widthPixels);
      //  System.out.println("HELLO "+ Resources.getSystem().getDisplayMetrics().heightPixels);
    }

    public void drawCode(int correct, int wp, ArrayList<Integer> guess){
//        Canvas canvas = surfaceHolder.lockCanvas();
//        surfaceHolder.unlockCanvasAndPost(canvas);
//
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
//        myPaint.setAlpha(200);

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

//        Rect r = new Rect();
//        String text1 = "Correct Answer: " + correct;
//        String text2 = "Wrong Position: " + wp;
//        canvas.getClipBounds(r);
//        int cHeight = r.height();
//        int cWidth = r.width();
//        paint.setTextAlign(Paint.Align.LEFT);
//        paint.getTextBounds(text1, 0, text2.length(), r);
//        float x = cWidth / 2f - r.width() / 2f - r.left;
//        float y = cHeight / 2f + r.height() / 2f - r.bottom;
//        canvas.drawText(text, x, y, paint);

        // draw everything to the screen
        canvas.drawBitmap(mDrawBitmap, 0, 0, mDrawPaint);


        surfaceHolder.unlockCanvasAndPost(canvas);
        invalidate();
        requestLayout();
        Log.d("hello", "Hello " + height);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        // Tap is detected
        if(action == MotionEvent.ACTION_DOWN){

        }
        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}