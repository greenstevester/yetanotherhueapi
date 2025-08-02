package io.github.greenstevester.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class On {

  @JsonProperty("on")
  private boolean on;

  public boolean isOn() {
    return on;
  }

  @Override
  public String toString() {
    return JsonStringUtil.toJsonString(this);
  }
}
