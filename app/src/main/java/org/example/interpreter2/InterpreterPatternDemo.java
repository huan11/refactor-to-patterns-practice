package org.example.interpreter2;

public class InterpreterPatternDemo {
    public static void main(String[] args) {
        // 表达式：(5 + 3) * 2
        Expression num1 = new NumberExpression(5);
        Expression num2 = new NumberExpression(3);
        Expression addExpr = new AddExpression(num1, num2);  // 5 + 3
        Expression num3 = new NumberExpression(2);
        Expression multiplyExpr = new MultiplyExpression(addExpr, num3); // (5 + 3) * 2

        System.out.println("Result: " + multiplyExpr.interpret()); // 输出 16
    }
}
