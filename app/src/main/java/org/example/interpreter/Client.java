package org.example.interpreter;

/**
 * Client class
 * Demonstrates the usage of Interpreter pattern
 */
public class Client {

	/**
	 * Main method demonstrating the interpreter pattern usage
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		// Create a report that requires permission validation
		Report report1 = new Report("Cashflow report", "FINANCE_ADMIN OR ADMIN");
		
		// Create expression builder
		ExpressionBuilder builder = new ExpressionBuilder();
		
		// Build permission expression
		PermissionExpression exp = builder.build(report1);
		System.out.println(exp);

		// Create user (as context object)
		User user1 = new User("Dave", "ADMIN");
		
		// Interpret expression to check if user has permission
		System.out.println("User access report: " + exp.interpret(user1));
	}

}
