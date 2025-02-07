package org.example.interpreter;

/**
 * Report class
 * Contains report name and permission expression required to access it
 */
public class Report {

	/**
	 * Report name
	 */
	private String name;
	//"NOT ADMIN", "FINANCE_USER AND ADMIN"
	/**
	 * Permission expression string
	 * Examples: "NOT ADMIN", "FINANCE_USER AND ADMIN"
	 */
	private String permission;
	
	/**
	 * Creates a report object
	 * @param name Report name
	 * @param permissions Permission expression required to access the report
	 */
	public Report(String name, String permissions) {
		this.name = name;
		this.permission = permissions;
	}

	/**
	 * Gets the report name
	 * @return Report name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the permission expression
	 * @return Permission expression string
	 */
	public String getPermission() {
		return permission;
	}
	
	
}
