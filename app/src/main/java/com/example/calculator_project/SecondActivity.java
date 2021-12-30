package com.example.calculator_project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    public static final String DATA_EXTRA_KEY = "data_extra_key";
    private CalculatorData dataSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        getSupportActionBar().hide();

        TextView textView = findViewById(R.id.second_activity_text_view);
        dataSecondActivity = getIntent().getExtras().getParcelable(DATA_EXTRA_KEY);
        textView.setText(dataSecondActivity.getData());

    }
}
