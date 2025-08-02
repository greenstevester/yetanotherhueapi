package io.github.greenstevester.heuvana.v2.domain;

/**
 * Represents the status of API initialization, containing either an error or success result.
 */
public class ApiInitializationStatus {
  private ApiInitializationError error;
  private ApiInitializationSuccess success;

  /**
   * Gets the initialization error, if any.
   *
   * @return the error or null if initialization was successful
   */
  public ApiInitializationError getError() {
    return error;
  }

  /**
   * Gets the initialization success result, if any.
   *
   * @return the success result or null if initialization failed
   */
  public ApiInitializationSuccess getSuccess() {
    return success;
  }

  @Override
  public String toString() {
    return JsonStringUtil.toJsonString(this);
  }
}
