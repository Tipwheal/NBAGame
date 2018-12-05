package com.tipwheal.obscurephoton.config;

/**
 * @author Yzh
 */
public enum Operator {

    /**
     * 加
     */
    ADD ("+") {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    },
    /**
     * 减
     */
    SUB ("-") {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    },
    /**
     * 乘
     */
    MUL ("*") {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    },
    /**
     * 除
     */
    DIV ("/") {
        @Override
        public int calculate(int a, int b) {
            return a + b;
        }
    };

    Operator(String operator) {
        this.operator = operator;
    }

    private String operator;

    public abstract int calculate(int a, int b);

    public static void main(String[] args) {
        Operator.ADD.calculate(1,2);
        Operator.DIV.calculate(2,3);
    }
}
