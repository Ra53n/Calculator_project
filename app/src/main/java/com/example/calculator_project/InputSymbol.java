package com.example.calculator_project;


public enum InputSymbol {
    NUM_1('1'), NUM_2('2'), NUM_3('3'), NUM_4('4'), NUM_5('5'),
    NUM_6('6'), NUM_7('7'), NUM_8('8'), NUM_9('9'), NUM_0('0'),
    DOT('.'),
    AC('C'),
    PLUS('+'),
    MINUS('-'),
    DIVIDE('/'),
    MULTIPLY('*'),
    ROOT('√'),
    DEGREE('^'),
    EQUALS('=');

    private final char sign;

    InputSymbol(char s) {
        this.sign = s;
    }

    public char getSign() {
        return sign;
    }
}
