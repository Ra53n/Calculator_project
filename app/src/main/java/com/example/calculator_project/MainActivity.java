package com.example.calculator_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CalculatorData data = new CalculatorData("");
    private final String DATA_KEY = "data_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        if (savedInstanceState != null && savedInstanceState.containsKey(DATA_KEY)) {
            data.setData(savedInstanceState.getString(DATA_KEY));
        }

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
        findViewById(R.id.button_ac).setOnClickListener(v -> {
            TextView textView = findViewById(R.id.text_view);
            String str = (String) textView.getText();
            textView.setText(str.substring(0, str.length() - 1));
            data.setData(str.substring(0, str.length() - 1));
        });
        findViewById(R.id.button_ac).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                TextView textView = findViewById(R.id.text_view);
                textView.setText("");
                data.setData("");
                return true;
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DATA_KEY, data.getData());
    }

    @Override
    public void onClick(View v) {
        TextView textView = findViewById(R.id.text_view);
        Button button = (Button) v;
        if (textView.getText().length() == 11) {
            Toast.makeText(MainActivity.this, "Слишком длинное число", Toast.LENGTH_SHORT).show();
            return;
        }
        String s = (String) textView.getText() + button.getText();
        textView.setText(s);
        data.setData(s);
    }
}