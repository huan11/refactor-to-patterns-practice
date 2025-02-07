package org.example.interpreter2;

// 非终结符表达式：乘法
class MultiplyExpression implements Expression {
    private Expression left, right;

    public MultiplyExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() * right.interpret();
    }
}