package com.example.calculator_project;

import android.app.Activity;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class CalculatorModel extends Activity {
    private List<InputSymbol> input = new ArrayList<>();
    private Solver solver;


    public void onClickButton(InputSymbol inputSymbol) throws Exception {
        if (inputSymbol == InputSymbol.PLUS || inputSymbol == InputSymbol.DIVIDE || inputSymbol == InputSymbol.DEGREE || inputSymbol == InputSymbol.ROOT || inputSymbol == InputSymbol.MULTIPLY) {
            solver = new Solver();
            solver.setA(Float.parseFloat(convertInputToString(input)));
            solver.setOperation(inputSymbol);
            input.clear();
            input.add(inputSymbol);
            return;
        }

        if (inputSymbol == InputSymbol.MINUS) {
            if (input.size() == 0) {
                input.add(inputSymbol);
                return;
            }
            solver = new Solver();
            solver.setA(Float.parseFloat(convertInputToString(input)));
            solver.setOperation(inputSymbol);
            input.clear();
            input.add(inputSymbol);
            return;
        }

        if (inputSymbol == InputSymbol.EQUALS) {
            input.remove(0);
            solver.setB(Float.parseFloat(convertInputToString(input)));
            float result = 0;
            result = solver.Solve();
            String str = String.valueOf(result);
            if (str.charAt(str.length() - 2) == '.' && str.charAt(str.length() - 1) == '0') {
                str = str.substring(0, str.length() - 2);
            }
            input = convertStringToInput(str);
            return;
        }

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

    private String convertInputToString(List<InputSymbol> inputSymbolList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (InputSymbol symbol : inputSymbolList) {
            switch (symbol) {
                case NUM_0:
                    stringBuilder.append(InputSymbol.NUM_0.getSign());
                    break;
                case NUM_1:
                    stringBuilder.append(InputSymbol.NUM_1.getSign());
                    break;
                case NUM_2:
                    stringBuilder.append(InputSymbol.NUM_2.getSign());
                    break;
                case NUM_3:
                    stringBuilder.append(InputSymbol.NUM_3.getSign());
                    break;
                case NUM_4:
                    stringBuilder.append(InputSymbol.NUM_4.getSign());
                    break;
                case NUM_5:
                    stringBuilder.append(InputSymbol.NUM_5.getSign());
                    break;
                case NUM_6:
                    stringBuilder.append(InputSymbol.NUM_6.getSign());
                    break;
                case NUM_7:
                    stringBuilder.append(InputSymbol.NUM_7.getSign());
                    break;
                case NUM_8:
                    stringBuilder.append(InputSymbol.NUM_8.getSign());
                    break;
                case NUM_9:
                    stringBuilder.append(InputSymbol.NUM_9.getSign());
                    break;
                case DOT:
                    stringBuilder.append(InputSymbol.DOT.getSign());
                    break;
                case MINUS:
                    stringBuilder.append(InputSymbol.MINUS.getSign());
                    break;
                default:
                    stringBuilder.append("$");
            }
        }
        return stringBuilder.toString();
    }

    private List<InputSymbol> convertStringToInput(String str) {
        List<InputSymbol> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == InputSymbol.NUM_0.getSign())
                list.add(InputSymbol.NUM_0);
            if (str.charAt(i) == InputSymbol.NUM_1.getSign())
                list.add(InputSymbol.NUM_1);
            if (str.charAt(i) == InputSymbol.NUM_2.getSign())
                list.add(InputSymbol.NUM_2);
            if (str.charAt(i) == InputSymbol.NUM_3.getSign())
                list.add(InputSymbol.NUM_3);
            if (str.charAt(i) == InputSymbol.NUM_4.getSign())
                list.add(InputSymbol.NUM_4);
            if (str.charAt(i) == InputSymbol.NUM_5.getSign())
                list.add(InputSymbol.NUM_5);
            if (str.charAt(i) == InputSymbol.NUM_6.getSign())
                list.add(InputSymbol.NUM_6);
            if (str.charAt(i) == InputSymbol.NUM_7.getSign())
                list.add(InputSymbol.NUM_7);
            if (str.charAt(i) == InputSymbol.NUM_8.getSign())
                list.add(InputSymbol.NUM_8);
            if (str.charAt(i) == InputSymbol.NUM_9.getSign())
                list.add(InputSymbol.NUM_9);
            if (str.charAt(i) == InputSymbol.DOT.getSign())
                list.add(InputSymbol.DOT);
            if (str.charAt(i) == InputSymbol.MINUS.getSign())
                list.add(InputSymbol.MINUS);
        }
        return list;
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
