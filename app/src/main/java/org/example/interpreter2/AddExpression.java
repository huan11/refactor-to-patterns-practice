package org.example.interpreter2;

// 非终结符表达式：加法
class AddExpression implements Expression {
    private Expression left, right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

