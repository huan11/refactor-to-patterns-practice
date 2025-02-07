package org.example.interpreter;

/**
 * Terminal Expression - Concrete Permission
 * Represents the basic permission checking unit
 * Checks if a user has a specific permission
 */
public class Permission implements PermissionExpression {

	/**
	 * Permission name
	 */
	private String permission;
	
	/**
	 * Creates a permission expression
	 * @param permission Permission name (will be converted to lowercase)
	 */
	public Permission(String permission) {
		this.permission = permission.toLowerCase();
	}
	
	/**
	 * Interprets permission expression
	 * Checks if user has this permission
	 * @param user User to check permissions against
	 * @return true if user has the permission, false otherwise
	 */
	@Override
	public boolean interpret(User user) {
		return user.getPermissions().contains(permission);
	}

	/**
	 * Returns string representation of the expression
	 * @return Permission name
	 */
	@Override
	public String toString() {
		return permission;
	}

	
}
