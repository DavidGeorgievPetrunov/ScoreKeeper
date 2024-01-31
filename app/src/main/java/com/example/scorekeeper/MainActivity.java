package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int STATIC_SCORE_1;
    public static int STATIC_SCORE_2;

    public TextView tv_score_1;
    public TextView tv_score_2;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_score_1 = findViewById(R.id.tv_e1_score);
        tv_score_2 = findViewById(R.id.tv_e2_score);

        if (savedInstanceState != null) {
            STATIC_SCORE_1 = savedInstanceState.getInt("STATIC_SCORE_1", 0);
            STATIC_SCORE_2 = savedInstanceState.getInt("STATIC_SCORE_2", 0);

            setTv_score_1();
            setTv_score_2();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int nightMode = AppCompatDelegate.getDefaultNightMode();

        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        recreate();
        return true;
    }

    public void increase(View view){
        if(view == findViewById(R.id.iv_plus_e1)){
            STATIC_SCORE_1 += 1;
            setTv_score_1();
        } else {
            STATIC_SCORE_2 += 1;
            setTv_score_2();
        }
    }

    public void setTv_score_1(){
        this.tv_score_1.setText(String.valueOf(STATIC_SCORE_1));
    }

    public void setTv_score_2(){
        this.tv_score_2.setText(String.valueOf(STATIC_SCORE_2));
    }
    public void decrease(View view){
        if(view == findViewById(R.id.iv_minus_e1)){
            STATIC_SCORE_1 -= 1;
            setTv_score_1();
        } else {
            STATIC_SCORE_2 -=1;
            setTv_score_2();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt("STATIC_SCORE_1", STATIC_SCORE_1);
        outState.putInt("STATIC_SCORE_2", STATIC_SCORE_2);
        super.onSaveInstanceState(outState);
    }
}