package org.example.interpreter;

/**
 * Non-terminal Expression - NOT Operation
 * Negates a permission expression
 * Implements logical NOT for permission operations
 */
public class NotExpression implements PermissionExpression {
	
	/**
	 * Permission expression to be negated
	 */
	private PermissionExpression expression;
	
	/**
	 * Creates a NOT expression
	 * @param expression Permission expression to be negated
	 */
	public NotExpression(PermissionExpression expression) {
		this.expression = expression;
	}

	/**
	 * Interprets NOT expression
	 * Returns logical NOT of the expression's interpretation
	 * @param user User to check permissions against
	 * @return Logical NOT of the expression result
	 */
	@Override
	public boolean interpret(User user) {
		return !expression.interpret(user);
	}
	
	/**
	 * Returns string representation of the expression
	 * @return Formatted NOT expression string
	 */
	@Override
	public String toString() {
		return " NOT "+expression;
	}
}
