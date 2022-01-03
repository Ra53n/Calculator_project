package com.example.calculator_project;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CalculatorModel {
    private List<InputSymbol> input = new ArrayList<>();


    public void onClickButton(InputSymbol inputSymbol) {
        if (input.size() == 11 && inputSymbol != InputSymbol.AC) {
            return;
        }

        if (inputSymbol == InputSymbol.AC) {
            input.remove(input.get(input.size() - 1));
            return;
        }

        if (inputSymbol == InputSymbol.DOT) {
            if (input.size() == 0) {
                input.add(InputSymbol.NUM_0);
                input.add(InputSymbol.DOT);
            }
            if (!input.contains(InputSymbol.DOT)) {
                input.add(InputSymbol.DOT);
            }
            return;
        }

        if (inputSymbol == InputSymbol.NUM_0) {
            if (input.contains(InputSymbol.NUM_0) && input.size() == 1) return;
            else input.add(InputSymbol.NUM_0);
            return;
        }

        if (input.size() == 1 && input.get(0) == InputSymbol.NUM_0) {
            input.remove(InputSymbol.NUM_0);
            input.add(inputSymbol);
            return;
        }
        input.add(inputSymbol);

    }

    public boolean onLongClickButton(InputSymbol inputSymbol) {
        if (inputSymbol == InputSymbol.AC) {
            input.clear();
            return true;
        }
        return false;
    }

    public List<InputSymbol> getInput() {
        return new ArrayList<>(input);
    }

    public void setInput(List<InputSymbol> input) {
        this.input = input;
    }


}
