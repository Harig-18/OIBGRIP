package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private int seconds;
    private boolean running;
    private boolean wasRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null)
        {
            savedInstanceState.getInt("seconds");
            savedInstanceState.getInt("running");
            savedInstanceState.getInt("wasRunning");
        }
        runtimer();
    }

    public void start(View view)
    {
        running=true;
    }
    public void stop(View view)
    {
        running=false;
    }
    public void reset(View view)
    {
        running=false;
        seconds=0;
    }
    protected void onPause(View view)
    {
        super.onPause();
        wasRunning=running;
        running=false;
    }
    protected void onResume()
    {
        super.onResume();
        if(wasRunning)
        {
            running=true;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds",seconds);
        outState.putBoolean("running",running);
        outState.putBoolean("running",wasRunning);
    }

    private void runtimer()
    {
        TextView timeview=findViewById(R.id.text_view_1);
        Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours=seconds/3600;
                int minutes=(seconds%3600)/60;
                int secs=seconds%60;
                String time=String.format(Locale.getDefault(),"%02d:%02d:%02d",hours,minutes,secs);
                timeview.setText(time);
                if(running)
                {
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }

        });
    }
}