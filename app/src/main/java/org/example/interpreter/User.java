package org.example.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * User class that stores user information and permissions
 * Acts as the Context object in the Interpreter pattern
 */
public class User {

	/**
	 * List of permissions owned by the user
	 */
	private List<String> permissions;
	
	/**
	 * Username of the user
	 */
	private String username;
	
	/**
	 * Creates a new user object
	 * @param username The username
	 * @param permissions Variable arguments list of permissions
	 */
	public User(String username, String... permissions) {
		this.username = username;
		this.permissions = new ArrayList<>();
		Stream.of(permissions).forEach(e->this.permissions.add(e.toLowerCase()));
	}

	/**
	 * Gets the list of user permissions
	 * @return List of permission strings
	 */
	public List<String> getPermissions() {
		return permissions;
	}

	/**
	 * Gets the username
	 * @return Username string
	 */
	public String getUsername() {
		return username;
	}
	
}
