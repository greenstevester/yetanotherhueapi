package io.github.greenstevester.yahueapi.v2.domain;

public class ApiInitializationError {
  private int type;
  private String address;
  private String description;

  public int getType() {
    return type;
  }

  public String getAddress() {
    return address;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return JsonStringUtil.toJsonString(this);
  }
}
