package com.example.calculator_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CalculatorData data = new CalculatorData("");
    private final String DATA_KEY = "data_key";
    private final String INPUT_KEY = "input_key";

    private CalculatorModel calculatorModel;

    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonThree;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private Button buttonSeven;
    private Button buttonEight;
    private Button buttonNine;
    private Button buttonZero;
    private Button buttonAc;
    private Button buttonDot;
    private TextView textView;
    private Button buttonZoom;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonDevide;
    private Button buttonMultiply;
    private Button buttonRoot;
    private Button buttonDegree;

    private Button buttonEquals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        calculatorModel = new CalculatorModel();

        if (savedInstanceState != null && savedInstanceState.containsKey(DATA_KEY)) {
            data.setData(savedInstanceState.getString(DATA_KEY));
            ((TextView) findViewById(R.id.output_result_text_view)).setText(data.getData());
        }

        if (savedInstanceState != null && savedInstanceState.containsKey(INPUT_KEY)) {
            List<InputSymbol> input = new ArrayList<>();
            List<String> symbolList = savedInstanceState.getStringArrayList(INPUT_KEY);
            for (String s : symbolList) {
                input.add(InputSymbol.valueOf(s));
            }
            calculatorModel.setInput(input);
        }

        initView();
        initListeners();

    }

    private void initView() {
        buttonOne = findViewById(R.id.button_1);
        buttonTwo = findViewById(R.id.button_2);
        buttonThree = findViewById(R.id.button_3);
        buttonFour = findViewById(R.id.button_4);
        buttonFive = findViewById(R.id.button_5);
        buttonSix = findViewById(R.id.button_6);
        buttonSeven = findViewById(R.id.button_7);
        buttonEight = findViewById(R.id.button_8);
        buttonNine = findViewById(R.id.button_9);
        buttonZero = findViewById(R.id.button_0);
        buttonDot = findViewById(R.id.button_dot);
        buttonAc = findViewById(R.id.button_ac);
        textView = findViewById(R.id.output_result_text_view);
        buttonZoom = findViewById(R.id.button_zoom);
        buttonPlus = findViewById(R.id.plus_button);
        buttonEquals = findViewById(R.id.button_equals);
        buttonMinus = findViewById(R.id.minus_button);
        buttonDevide = findViewById(R.id.devide_button);
        buttonMultiply = findViewById(R.id.multiply_button);
        buttonDegree = findViewById(R.id.button_degree);
        buttonRoot = findViewById(R.id.button_root);
    }

    private void initListeners() {
        buttonOne.setOnClickListener(v -> updateInput(InputSymbol.NUM_1));
        buttonTwo.setOnClickListener(v -> updateInput(InputSymbol.NUM_2));
        buttonThree.setOnClickListener(v -> updateInput(InputSymbol.NUM_3));
        buttonFour.setOnClickListener(v -> updateInput(InputSymbol.NUM_4));
        buttonFive.setOnClickListener(v -> updateInput(InputSymbol.NUM_5));
        buttonSix.setOnClickListener(v -> updateInput(InputSymbol.NUM_6));
        buttonSeven.setOnClickListener(v -> updateInput(InputSymbol.NUM_7));
        buttonEight.setOnClickListener(v -> updateInput(InputSymbol.NUM_8));
        buttonNine.setOnClickListener(v -> updateInput(InputSymbol.NUM_9));
        buttonZero.setOnClickListener(v -> updateInput(InputSymbol.NUM_0));

        buttonPlus.setOnClickListener(v -> updateInput(InputSymbol.PLUS));
        buttonMinus.setOnClickListener(v -> updateInput(InputSymbol.MINUS));
        buttonRoot.setOnClickListener(v -> updateInput(InputSymbol.ROOT));
        buttonDegree.setOnClickListener(v -> updateInput(InputSymbol.DEGREE));
        buttonMultiply.setOnClickListener(v -> updateInput(InputSymbol.MULTIPLY));
        buttonDevide.setOnClickListener(v -> updateInput(InputSymbol.DIVIDE));
        buttonDot.setOnClickListener(v -> updateInput(InputSymbol.DOT));
        buttonAc.setOnClickListener(v -> updateInput(InputSymbol.AC));
        buttonAc.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return updateInputOnLongClick(InputSymbol.AC);
            }
        });
        buttonZoom.setOnClickListener(v -> {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra(SecondActivity.DATA_EXTRA_KEY, data);
            startActivity(intent);
        });
        buttonEquals.setOnClickListener(v -> updateInput(InputSymbol.EQUALS));
    }

    private String convertInputToString(List<InputSymbol> inputSymbolList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (InputSymbol symbol : inputSymbolList) {
            switch (symbol) {
                case NUM_0:
                    stringBuilder.append(getString(R.string.button_0));
                    break;
                case NUM_1:
                    stringBuilder.append(getString(R.string.button_1));
                    break;
                case NUM_2:
                    stringBuilder.append(getString(R.string.button_2));
                    break;
                case NUM_3:
                    stringBuilder.append(getString(R.string.button_3));
                    break;
                case NUM_4:
                    stringBuilder.append(getString(R.string.button_4));
                    break;
                case NUM_5:
                    stringBuilder.append(getString(R.string.button_5));
                    break;
                case NUM_6:
                    stringBuilder.append(getString(R.string.button_6));
                    break;
                case NUM_7:
                    stringBuilder.append(getString(R.string.button_7));
                    break;
                case NUM_8:
                    stringBuilder.append(getString(R.string.button_8));
                    break;
                case NUM_9:
                    stringBuilder.append(getString(R.string.button_9));
                    break;
                case DOT:
                    stringBuilder.append(getString(R.string.button_dot));
                    break;
                case PLUS:
                    stringBuilder.append(getString(R.string.plus));
                    break;
                case MINUS:
                    stringBuilder.append(getString(R.string.minus));
                    break;
                case MULTIPLY:
                    stringBuilder.append(getString(R.string.multiply));
                    break;
                case DIVIDE:
                    stringBuilder.append(getString(R.string.devide));
                    break;
                case DEGREE:
                    stringBuilder.append(getString(R.string.degree));
                    break;
                case ROOT:
                    stringBuilder.append(getString(R.string.root));
                    break;
                default:
                    stringBuilder.append("$");
            }
        }
        return stringBuilder.toString();
    }

    private void updateInput(InputSymbol inputSymbol) {
        try {
            calculatorModel.onClickButton(inputSymbol);
            textView.setText(convertInputToString(calculatorModel.getInput()));
            data.setData(convertInputToString(calculatorModel.getInput()));
        }catch (Exception e){
            Toast.makeText(MainActivity.this,"Ошибка",Toast.LENGTH_SHORT).show();
        }
    }

    private boolean updateInputOnLongClick(InputSymbol inputSymbol) {
        boolean result = calculatorModel.onLongClickButton(inputSymbol);
        textView.setText(convertInputToString(calculatorModel.getInput()));
        data.setData(convertInputToString(calculatorModel.getInput()));
        return result;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(DATA_KEY, data.getData());
        List<InputSymbol> inputSymbolList = calculatorModel.getInput();
        ArrayList<String> addingList = new ArrayList<>();
        for (InputSymbol i : inputSymbolList) {
            addingList.add(i.name());
        }
        outState.putStringArrayList(INPUT_KEY, addingList);
    }


}