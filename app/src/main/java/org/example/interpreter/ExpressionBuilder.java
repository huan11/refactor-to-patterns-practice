package org.example.interpreter;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Expression Builder
 * Responsible for parsing permission strings and building abstract syntax tree
 * Uses two stacks for construction: one for permission expressions and one for operators
 */
public class ExpressionBuilder {
	/**
	 * Stack for storing permission expressions
	 */
	private Stack<PermissionExpression> permissions = new Stack<>();

	/**
	 * Stack for storing operators
	 */
	private Stack<String> operators = new Stack<>();

	/**
	 * Builds permission expression
	 * @param report Report containing permission expression string
	 * @return Built permission expression
	 */
	public PermissionExpression build(Report report) {
		parse(report.getPermission());
		buildExpressions();
		if (permissions.size() > 1 || !operators.isEmpty()) {
			System.out.println("ERROR!");
		}
		return permissions.pop();
	}

	/**
	 * Parses permission string
	 * Breaks string into tokens and stores them in appropriate stacks
	 * @param permission Permission expression string
	 */
	private void parse(String permission) {
		StringTokenizer tokenizer = new StringTokenizer(permission.toLowerCase());
		while (tokenizer.hasMoreTokens()) {
			String token;
			switch ((token = tokenizer.nextToken())) {
			case "and":
				operators.push("and");
				break;
			case "not":
				operators.push("not");
				break;
			case "or":
				operators.push("or");
				break;
			default:
				permissions.push(new Permission(token));
				break;
			}
		}
	}

	/**
	 * Builds expressions
	 * Takes appropriate number of operands from permission stack based on operators
	 * Creates expression objects and pushes results back to permission stack
	 */
	private void buildExpressions() {
		while (!operators.isEmpty()) {
			String operator = operators.pop();
			PermissionExpression perm1;
			PermissionExpression perm2;
			PermissionExpression exp;
			switch (operator) {
			case "not":
				perm1 = permissions.pop();
				exp = new NotExpression(perm1);
				break;
			case "and":
				perm1 = permissions.pop();
				perm2 = permissions.pop();
				exp = new AndExpression(perm1, perm2);
				break;
			case "or":
				perm1 = permissions.pop();
				perm2 = permissions.pop();
				exp = new OrExpression(perm1, perm2);
				break;
			default:
				throw new IllegalArgumentException("Unknown operator:" + operator);
			}
			permissions.push(exp);
		}
	}
}
