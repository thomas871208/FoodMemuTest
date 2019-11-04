package com.tts.foodmemutest;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed_h;
    EditText ed_f;
    EditText ed_hot;
    EditText ed_d;
    ImageView x1;
    ImageView x2;
    ImageView x3;
    ImageView x4;
    int ham;
    int fries;
    int hotdog;
    int drink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ed_h = findViewById(R.id.ed_h);
        ed_f = findViewById(R.id.ed_f);
        ed_hot = findViewById(R.id.ed_hot);
        ed_d = findViewById(R.id.ed_d);

        x1 = findViewById(R.id.x1);
        x2 = findViewById(R.id.x2);
        x3 = findViewById(R.id.x3);
        x4 = findViewById(R.id.x4);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public  void order(View view){
        ham = ed_h.getText().toString().length();
        fries = ed_f.getText().toString().length();
        hotdog = ed_hot.getText().toString().length();
        drink = ed_d.getText().toString().length();
        if(ham == 0 || fries ==0 || hotdog ==0 || drink == 0){
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Error")
                    .setMessage("cannot be empty, please enter a number")
                    .setPositiveButton("OK",null)
                    .show();
            if(ham == 0){
                x1.setImageResource(R.drawable.x);
                x1.setVisibility(View.VISIBLE);
            }else {
                x1.setVisibility(View.GONE);
            }
            if(fries == 0){
                x2.setImageResource(R.drawable.x);
                x2.setVisibility(View.VISIBLE);
            }else {
            x2.setVisibility(View.GONE);
        }
            if(hotdog == 0){
                x3.setImageResource(R.drawable.x);
                x3.setVisibility(View.VISIBLE);
            }else {
                x3.setVisibility(View.GONE);
            }
            if(drink == 0){
                x4.setImageResource(R.drawable.x);
                x4.setVisibility(View.VISIBLE);
            }else {
                x4.setVisibility(View.GONE);
            }

        }else{
            x1.setVisibility(View.GONE);
            x2.setVisibility(View.GONE);
            x3.setVisibility(View.GONE);
            x4.setVisibility(View.GONE);
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Tip")
                    .setMessage("thank you for your order")
                    .setPositiveButton("OK",null)
                    .show();

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
