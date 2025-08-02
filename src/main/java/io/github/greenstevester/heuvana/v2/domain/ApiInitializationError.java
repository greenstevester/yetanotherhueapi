package io.github.greenstevester.heuvana.v2.domain;

/**
 * Represents an error that occurred during API initialization.
 */
public class ApiInitializationError {
  private int type;
  private String address;
  private String description;

  /**
   * Gets the error type.
   *
   * @return the error type
   */
  public int getType() {
    return type;
  }

  /**
   * Gets the address where the error occurred.
   *
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Gets the error description.
   *
   * @return the error description
   */
  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return JsonStringUtil.toJsonString(this);
  }
}
