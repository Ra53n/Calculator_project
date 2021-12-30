package com.example.calculator_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CalculatorData data = new CalculatorData("");
    private final String DATA_KEY = "data_key";
    private Solver solver;

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
        findViewById(R.id.button_0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.text_view);
                String str = (String) textView.getText();
                String zero = (String) ((Button) v).getText();
                if (str.contains(zero) && str.length() == 1) {
                    return;
                } else {
                    textView.setText(textView.getText() + zero);
                }
            }
        });
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
        findViewById(R.id.button_zoom).setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(SecondActivity.DATA_EXTRA_KEY, data);
            startActivity(intent);
        });
        findViewById(R.id.button_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.text_view);
                String str = (String) textView.getText();
                String dot = (String) ((Button) v).getText();
                if (textView.getText().length() == 0) {
                    textView.setText("0" + dot);
                    return;
                }
                if (!str.contains(dot)) {
                    textView.setText(textView.getText() + dot);
                    return;
                }

            }
        });
        findViewById(R.id.plus).setOnClickListener(v -> {
            solver = new Solver();
            TextView textView = findViewById(R.id.text_view);
            solver.setA(Float.parseFloat((String) textView.getText()));
            solver.setOperation(Operation.PLUS);
            textView.setText(((Button) v).getText());
        });
        findViewById(R.id.minus).setOnClickListener(v -> {
            solver = new Solver();
            TextView textView = findViewById(R.id.text_view);
            solver.setA(Float.parseFloat((String) textView.getText()));
            solver.setOperation(Operation.MINUS);
            textView.setText(((Button) v).getText());
        });
        findViewById(R.id.devide).setOnClickListener(v -> {
            solver = new Solver();
            TextView textView = findViewById(R.id.text_view);
            solver.setA(Float.parseFloat((String) textView.getText()));
            solver.setOperation(Operation.DIVIDE);
            textView.setText(((Button) v).getText());
        });
        findViewById(R.id.multiply).setOnClickListener(v -> {
            solver = new Solver();
            TextView textView = findViewById(R.id.text_view);
            solver.setA(Float.parseFloat((String) textView.getText()));
            solver.setOperation(Operation.MULTIPLY);
            textView.setText(((Button) v).getText());
        });
        findViewById(R.id.button_degree).setOnClickListener(v -> {
            solver = new Solver();
            TextView textView = findViewById(R.id.text_view);
            solver.setA(Float.parseFloat((String) textView.getText()));
            solver.setOperation(Operation.DEGREE);
            textView.setText("^");
        });
        findViewById(R.id.button_root).setOnClickListener(v -> {
            solver = new Solver();
            TextView textView = findViewById(R.id.text_view);
            solver.setA(Float.parseFloat((String) textView.getText()));
            solver.setOperation(Operation.ROOT);
            textView.setText(((Button) v).getText());
        });
        findViewById(R.id.button_equals).setOnClickListener(v -> {
            TextView textView = findViewById(R.id.text_view);
            if (((String) textView.getText()).length() > 1) {
                solver.setB(Float.parseFloat(((String) textView.getText()).substring(1)));
                float result = 0;
                try {
                    result = solver.Solve();
                } catch (ArithmeticException e) {
                    Toast.makeText(this, "Нельзя делить на ноль!", Toast.LENGTH_SHORT).show();
                }
                String str = String.valueOf(result);
                if (str.charAt(str.length() - 2) == '.' && str.charAt(str.length() - 1) == '0') {
                    str = str.substring(0, str.length() - 2);
                }
                textView.setText(str);
                data.setData(str);
            }
            solver = new Solver();
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
        if (textView.getText().length() == 1 && textView.getText().charAt(0) == ((Button) findViewById(R.id.button_0)).getText().charAt(0)) {
            textView.setText(button.getText());
            return;
        }
        String s = (String) textView.getText() + button.getText();
        textView.setText(s);
        data.setData(s);
    }
}