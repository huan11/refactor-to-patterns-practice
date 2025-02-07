package org.example.interpreter;

/**
 * Non-terminal Expression - OR Operation
 * Combines two permission expressions, returns true if either expression is true
 * Implements logical OR for permission combinations
 */
public class OrExpression implements PermissionExpression {
	
	/**
	 * First permission expression
	 */
	private PermissionExpression expression1;
	
	/**
	 * Second permission expression
	 */
	private PermissionExpression expression2;
	
	/**
	 * Creates an OR expression
	 * @param one First permission expression
	 * @param two Second permission expression
	 */
	public OrExpression(PermissionExpression one, PermissionExpression two) {
		this.expression1 = one;
		this.expression2 = two;
	}

	/**
	 * Interprets OR expression
	 * Returns true if either child expression returns true
	 * @param user User to check permissions against
	 * @return Logical OR result of both expressions
	 */
	@Override
	public boolean interpret(User user) {
		return expression1.interpret(user) || expression2.interpret(user);
	}
	
	/**
	 * Returns string representation of the expression
	 * @return Formatted OR expression string
	 */
	@Override
	public String toString() {
		return expression1 +" OR "+expression2;
	}
}
