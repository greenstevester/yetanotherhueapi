package io.github.greenstevester.heuvana.v2.domain;

public class ApiInitializationSuccess {
  private String username;

  public String getUsername() {
    return username;
  }

  @Override
  public String toString() {
    return JsonStringUtil.toJsonString(this);
  }
}
