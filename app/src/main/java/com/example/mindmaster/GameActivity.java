package com.example.mindmaster;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    GameView gameView;

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

        LinearLayout main = new LinearLayout(this);
        main.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        main.setOrientation(LinearLayout.VERTICAL);
        main.setWeightSum(4);
        main.setBackgroundResource(R.drawable.background);
        setContentView(main);

        ScrollView scrollView = new ScrollView(this);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1));
        main.addView(scrollView);

        LinearLayout bottom = new LinearLayout(this);
        bottom.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 3));
        bottom.setOrientation(LinearLayout.VERTICAL);
        bottom.setWeightSum(2);
        bottom.setBackgroundColor(Color.WHITE);
        bottom.getBackground().setAlpha(100);
        main.addView(bottom);

        LinearLayout spinners = new LinearLayout(this);
        spinners.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1));
        spinners.setOrientation(LinearLayout.HORIZONTAL);
        spinners.setWeightSum(4);
        bottom.addView(spinners);

        SimpleImageArrayAdapter adapter = new SimpleImageArrayAdapter(this,
                new Integer[]{R.drawable.core, R.drawable.acads, R.drawable.hrd, R.drawable.rnd, R.drawable.tnd, R.drawable.corpo,
                        R.drawable.publications, R.drawable.pubs, R.drawable.univrel, R.drawable.socio, R.drawable.docu, R.drawable.finance});

        Spinner first = new Spinner(this);
        first.setAdapter(adapter);
        first.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        first.setDropDownWidth(AppConstants.SCREEN_WIDTH/4);
//        first.setBackground(null);
        spinners.addView(first);

        Spinner second = new Spinner(this);
        second.setAdapter(adapter);
        second.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        second.setDropDownWidth(AppConstants.SCREEN_WIDTH/4);
        spinners.addView(second);

        Spinner third = new Spinner(this);
        third.setAdapter(adapter);
        third.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        third.setDropDownWidth(AppConstants.SCREEN_WIDTH/4);
        spinners.addView(third);

        Spinner fourth = new Spinner(this);
        fourth.setAdapter(adapter);
        fourth.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1));
        fourth.setDropDownWidth(AppConstants.SCREEN_WIDTH/4);
        spinners.addView(fourth);

        Button button = new Button(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1));
        button.setText("CHECK");
        button.setBackgroundColor(Color.BLUE);
        button.setTextColor(Color.WHITE);
        bottom.addView(button);
    }
}

class SimpleImageArrayAdapter extends ArrayAdapter<Integer> {
    private Integer[] images;

    public SimpleImageArrayAdapter(Context context, Integer[] images) {
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
    }

    private View getImageForPosition(int position) {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(images[position]);
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
