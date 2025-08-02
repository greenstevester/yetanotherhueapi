package io.github.greenstevester.heuvana.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metadata {

  @JsonProperty("archetype")
  private String archetype;

  @JsonProperty("name")
  private String name;

  public String getArchetype() {
    return archetype;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return JsonStringUtil.toJsonString(this);
  }
}
