package com.example.to_do;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void opensignup(View view)
    {
        Intent i=new Intent(this, signup.class);
        startActivity(i);
    }
    public void opentodo(View view)
    {
        Intent i=new Intent(this, todolist.class);
        startActivity(i);
    }
}