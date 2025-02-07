package org.example.interpreter;

/**
 * Abstract Expression Interface in Interpreter Pattern
 * Defines a unified interface for interpretation operations
 * All concrete expression classes need to implement this interface
 */
public interface PermissionExpression {
  /**
   * Interprets the permissions for a given user
   * @param user The user object to check permissions against
   * @return true if user meets permission requirements, false otherwise
   */
  boolean interpret(User user); 
}
