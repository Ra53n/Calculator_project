package com.example.calculator_project;

public class Solver {
    private float a;
    private float b;
    private InputSymbol operation;

    public float Solve() {
        if (a != 0 && b != 0 && operation != null) {
            if (operation.equals(InputSymbol.PLUS)) {
                return a + b;
            }
            if (operation.equals(InputSymbol.MINUS)) {
                return a - b;
            }
            if (operation.equals(InputSymbol.DIVIDE)) {
                return (a / b);
            }
            if (operation.equals(InputSymbol.MULTIPLY)) {
                return (a * b);
            }
            if (operation.equals(InputSymbol.ROOT)) {
                return (float) Math.pow(a, 1.0 / b);
            }
            if (operation.equals(InputSymbol.DEGREE)) {
                return (float) Math.pow(a, b);
            }
        }
        if (a == 0 && b != 0 && operation != null) return a;
        if (a != 0 && b == 0 && operation.equals(InputSymbol.DIVIDE)) throw new ArithmeticException();
        if (a != 0 && b == 0 && operation != null) return b;
        return 0;
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public InputSymbol getOperation() {
        return operation;
    }

    public void setOperation(InputSymbol operation) {
        this.operation = operation;
    }
}
