package com.example.weapon_x_tracker.exception;

/**
 * Exception thrown when an operative cannot be found.
 */
public class OperativeNotFoundException extends RuntimeException {

  /**
   * Creates an operative not found exception.
   *
   * @param id the ID of the operative that was not found
   */
  public OperativeNotFoundException(Long id) {
    super("Operative with id " + id + " not found");
  }
}