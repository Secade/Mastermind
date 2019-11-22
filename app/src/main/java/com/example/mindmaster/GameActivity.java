package com.example.mindmaster;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;
    private Spinner first, second, third, fourth;
    private ArrayList<Integer> random;
    private int attempt;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        AppConstants.gameActivityContext = this;
//        gameView = new GameView(this);
//        setContentView(gameView);

        random = new ArrayList<>();
        Random r = new Random();
        for(int i = 0; i < 4; i++){
            int x = r.nextInt(12);
            while(random.contains(x))
                x = r.nextInt(12);
            random.add(x);
        }
        attempt = 0;

        LinearLayout main = new LinearLayout(this);
        main.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        main.setOrientation(LinearLayout.VERTICAL);
        main.setWeightSum(4);
        main.setBackgroundResource(R.drawable.background);

        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1));
        main.addView(frameLayout);

        BackgroundView backgroundView = new BackgroundView(this);
        frameLayout.addView(backgroundView);

        scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        scrollView.setBackgroundColor(Color.GREEN);
        scrollView.setFillViewport(true);
        scrollView.requestDisallowInterceptTouchEvent(true);
        frameLayout.addView(scrollView);

        LinearLayout container = new LinearLayout(this);
        container.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        container.setBackgroundColor(Color.RED);
//        scrollView.addView(container);

        gameView = new GameView(this);
//        gameView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//        gameView.setZOrderOnTop(true);
//        gameView.getHolder().setFixedSize(AppConstants.SCREEN_HEIGHT/4*3, AppConstants.SCREEN_WIDTH);
//        gameView.getHolder().setSizeFromLayout();
        scrollView.addView(gameView);

        LinearLayout bottom = new LinearLayout(this);
        bottom.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 3));
        bottom.setOrientation(LinearLayout.VERTICAL);
//        bottom.setWeightSum(2);
        bottom.setBackgroundColor(Color.WHITE);
        bottom.getBackground().setAlpha(100);
        bottom.bringToFront();
        main.addView(bottom);

        LinearLayout spinners = new LinearLayout(this);
        spinners.setLayoutParams(new LinearLayout.LayoutParams(AppConstants.SCREEN_WIDTH, AppConstants.SCREEN_WIDTH/4));
        spinners.setOrientation(LinearLayout.HORIZONTAL);
        spinners.setWeightSum(4);
        bottom.addView(spinners);

        SimpleImageArrayAdapter adapter = new SimpleImageArrayAdapter(this,
                new Integer[]{R.drawable.core, R.drawable.acads, R.drawable.hrd, R.drawable.rnd, R.drawable.tnd, R.drawable.corpo,
                        R.drawable.publications, R.drawable.pubs, R.drawable.univrel, R.drawable.socio, R.drawable.docu, R.drawable.finance});

        first = new Spinner(this);
        first.setAdapter(adapter);
        first.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1));
        first.setDropDownWidth(AppConstants.SCREEN_WIDTH/4);
//        first.setBackgroundResource(R.drawable.core);
        first.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0: first.setBackgroundResource(R.drawable.core);
                    break;
                    case 1: first.setBackgroundResource(R.drawable.acads);
                        break;
                    case 2: first.setBackgroundResource(R.drawable.hrd);
                        break;
                    case 3: first.setBackgroundResource(R.drawable.rnd);
                        break;
                    case 4: first.setBackgroundResource(R.drawable.tnd);
                        break;
                    case 5: first.setBackgroundResource(R.drawable.corpo);
                        break;
                    case 6: first.setBackgroundResource(R.drawable.publications);
                        break;
                    case 7: first.setBackgroundResource(R.drawable.pubs);
                        break;
                    case 8: first.setBackgroundResource(R.drawable.univrel);
                        break;
                    case 9: first.setBackgroundResource(R.drawable.socio);
                        break;
                    case 10: first.setBackgroundResource(R.drawable.docu);
                        break;
                    case 11: first.setBackgroundResource(R.drawable.finance);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinners.addView(first);

        second = new Spinner(this);
        second.setAdapter(adapter);
        second.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1));
        second.setDropDownWidth(AppConstants.SCREEN_WIDTH/4);
//        second.setBackgroundResource(R.drawable.core);
        second.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0: second.setBackgroundResource(R.drawable.core);
                        break;
                    case 1: second.setBackgroundResource(R.drawable.acads);
                        break;
                    case 2: second.setBackgroundResource(R.drawable.hrd);
                        break;
                    case 3: second.setBackgroundResource(R.drawable.rnd);
                        break;
                    case 4: second.setBackgroundResource(R.drawable.tnd);
                        break;
                    case 5: second.setBackgroundResource(R.drawable.corpo);
                        break;
                    case 6: second.setBackgroundResource(R.drawable.publications);
                        break;
                    case 7: second.setBackgroundResource(R.drawable.pubs);
                        break;
                    case 8: second.setBackgroundResource(R.drawable.univrel);
                        break;
                    case 9: second.setBackgroundResource(R.drawable.socio);
                        break;
                    case 10: second.setBackgroundResource(R.drawable.docu);
                        break;
                    case 11: second.setBackgroundResource(R.drawable.finance);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinners.addView(second);

        third = new Spinner(this);
        third.setAdapter(adapter);
        third.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1));
        third.setDropDownWidth(AppConstants.SCREEN_WIDTH/4);
//        third.setBackgroundResource(R.drawable.core);
        third.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0: third.setBackgroundResource(R.drawable.core);
                        break;
                    case 1: third.setBackgroundResource(R.drawable.acads);
                        break;
                    case 2: third.setBackgroundResource(R.drawable.hrd);
                        break;
                    case 3: third.setBackgroundResource(R.drawable.rnd);
                        break;
                    case 4: third.setBackgroundResource(R.drawable.tnd);
                        break;
                    case 5: third.setBackgroundResource(R.drawable.corpo);
                        break;
                    case 6: third.setBackgroundResource(R.drawable.publications);
                        break;
                    case 7: third.setBackgroundResource(R.drawable.pubs);
                        break;
                    case 8: third.setBackgroundResource(R.drawable.univrel);
                        break;
                    case 9: third.setBackgroundResource(R.drawable.socio);
                        break;
                    case 10: third.setBackgroundResource(R.drawable.docu);
                        break;
                    case 11: third.setBackgroundResource(R.drawable.finance);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinners.addView(third);

        fourth = new Spinner(this);
        fourth.setAdapter(adapter);
        fourth.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1));
        fourth.setDropDownWidth(AppConstants.SCREEN_WIDTH/4);
//        fourth.setBackgroundResource(R.drawable.core);
        fourth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0: fourth.setBackgroundResource(R.drawable.core);
                        break;
                    case 1: fourth.setBackgroundResource(R.drawable.acads);
                        break;
                    case 2: fourth.setBackgroundResource(R.drawable.hrd);
                        break;
                    case 3: fourth.setBackgroundResource(R.drawable.rnd);
                        break;
                    case 4: fourth.setBackgroundResource(R.drawable.tnd);
                        break;
                    case 5: fourth.setBackgroundResource(R.drawable.corpo);
                        break;
                    case 6: fourth.setBackgroundResource(R.drawable.publications);
                        break;
                    case 7: fourth.setBackgroundResource(R.drawable.pubs);
                        break;
                    case 8: fourth.setBackgroundResource(R.drawable.univrel);
                        break;
                    case 9: fourth.setBackgroundResource(R.drawable.socio);
                        break;
                    case 10: fourth.setBackgroundResource(R.drawable.docu);
                        break;
                    case 11: fourth.setBackgroundResource(R.drawable.finance);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinners.addView(fourth);

        final ImageButton button = new ImageButton(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        button.setText("CHECK");
//        button.setBackgroundColor(Color.BLUE);
//        button.setTextColor(Color.WHITE);
        button.setBackgroundResource(R.drawable.checkbutton);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                check(button);
            }
        });
        bottom.addView(button);


        setContentView(main);
    }

    public void check(View v){
        ArrayList<Boolean> flag = new ArrayList<>();
        ArrayList<Integer> guess = new ArrayList<>();
        int correct = 0, wp = 0;

        attempt++;
        guess.add(first.getSelectedItemPosition());
        guess.add(second.getSelectedItemPosition());
        guess.add(third.getSelectedItemPosition());
        guess.add(fourth.getSelectedItemPosition());
        for(int i = 0; i < 4; i++){
            flag.add(guess.get(i) == random.get(i));
        }
        for(int slot = 0; slot < 4; slot++){
            if(guess.get(slot) == random.get(slot))
                correct++;
            else
                for(int s = 0; s < 4; s++)
                    if(!flag.get(s) && guess.get(slot) == random.get(s)){
                        wp++;
                        flag.set(s, true);
                        break;
                    }
        }
        if(correct == 4){
            Intent intent = new Intent(this, GameOver.class);
            intent.putExtra("score", attempt);
            startActivity(intent);
            finish();
        }
        else{
            if(gameView.getMyHeight() >= 8100 || gameView.getMyHeight() == 0){
//                scrollView.smoothScrollTo(0,0);
                ObjectAnimator.ofInt(scrollView, "scrollY",  0).setDuration(500).start();
            } else {
//                scrollView.smoothScrollTo(0, gameView.getMyHeight());
                ObjectAnimator.ofInt(scrollView, "scrollY",  gameView.getMyHeight()).setDuration(500).start();
            }
            gameView.drawCode(correct, wp, guess);
        }
    }
}

class SimpleImageArrayAdapter extends ArrayAdapter<Integer> {
    private Integer[] images;

    public SimpleImageArrayAdapter(Context context, Integer[] images){
        super(context, android.R.layout.simple_spinner_item, images);
        this.images = images;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getImage(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getImageForPosition(position);
//        return new ImageView(getContext());
    }

    private View getImageForPosition(int position) {
        ImageView imageView = new ImageView(getContext());
//        imageView.setBackgroundResource(images[position]);
//        imageView.setBackground(null);
        imageView.setLayoutParams(new AbsListView.LayoutParams(AppConstants.SCREEN_WIDTH/4, AppConstants.SCREEN_WIDTH/4));
        return imageView;
    }

    private View getImage(int position) {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(images[position]);
        imageView.setLayoutParams(new AbsListView.LayoutParams(AppConstants.SCREEN_WIDTH/4, AppConstants.SCREEN_WIDTH/4));
        return imageView;
    }
}
