package com.example.calculator_project;

public class Solver {
    private float a;
    private float b;
    private Operation operation;

    public float Solve() {
        if (a != 0 && b != 0 && operation != null) {
            if (operation.equals(Operation.PLUS)) {
                return a + b;
            }
            if (operation.equals(Operation.MINUS)) {
                return a - b;
            }
            if (operation.equals(Operation.DIVIDE)) {
                return (a / b);
            }
            if (operation.equals(Operation.MULTIPLY)) {
                return (a * b);
            }
            if (operation.equals(Operation.ROOT)) {
                return (float) Math.pow(a, 1.0 / b);
            }
            if (operation.equals(Operation.DEGREE)) {
                return (float) Math.pow(a, b);
            }


        }
        if (a == 0 && b != 0 && operation != null) return a;
        if (a != 0 && b == 0 && operation.equals(Operation.DIVIDE)) throw new ArithmeticException();
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

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
