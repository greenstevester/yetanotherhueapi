package io.github.greenstevester.heuvana.v2.domain;

/**
 * Represents a successful API initialization result.
 */
public class ApiInitializationSuccess {
  private String username;

  /**
   * Gets the username (API key) for the successfully initialized connection.
   *
   * @return the username/API key
   */
  public String getUsername() {
    return username;
  }

  @Override
  public String toString() {
    return JsonStringUtil.toJsonString(this);
  }
}
