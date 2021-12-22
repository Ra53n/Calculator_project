package com.example.calculator_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        findViewById(R.id.button_1).setOnClickListener(this);
        findViewById(R.id.button_2).setOnClickListener(this);
        findViewById(R.id.button_3).setOnClickListener(this);
        findViewById(R.id.button_4).setOnClickListener(this);
        findViewById(R.id.button_5).setOnClickListener(this);
        findViewById(R.id.button_6).setOnClickListener(this);
        findViewById(R.id.button_7).setOnClickListener(this);
        findViewById(R.id.button_8).setOnClickListener(this);
        findViewById(R.id.button_9).setOnClickListener(this);
        findViewById(R.id.button_0).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        TextView textView = findViewById(R.id.text_view);
        Button button = (Button) v;
        if(textView.getText().length() == 11){
            Toast.makeText(MainActivity.this,"Слишком длинное число",Toast.LENGTH_SHORT).show();
            return;
        }
        String s = (String) textView.getText() + button.getText();
        textView.setText(s);
    }
}