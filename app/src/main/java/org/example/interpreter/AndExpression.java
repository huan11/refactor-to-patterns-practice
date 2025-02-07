package org.example.interpreter;

/**
 * Non-terminal Expression - AND Operation
 * Combines two permission expressions, returns true only if both expressions are true
 * Implements logical AND for permission combinations
 */
public class AndExpression implements PermissionExpression {

	/**
	 * First permission expression
	 */
	private PermissionExpression expression1;

	/**
	 * Second permission expression
	 */
	private PermissionExpression expression2;
	
	/**
	 * Creates an AND expression
	 * @param expression1 First permission expression
	 * @param expression2 Second permission expression
	 */
	public AndExpression(PermissionExpression expression1, PermissionExpression expression2) {
		this.expression1 = expression1;
		this.expression2 = expression2;
	}
	
	/**
	 * Interprets AND expression
	 * Returns true only if both child expressions return true
	 * @param user User to check permissions against
	 * @return Logical AND result of both expressions
	 */
	@Override
	public boolean interpret(User user) {
		return expression1.interpret(user) && expression2.interpret(user);
	}

	/**
	 * Returns string representation of the expression
	 * @return Formatted AND expression string
	 */
	@Override
	public String toString() {
		return expression1 +" AND "+ expression2;
	}

	
	
}
