package io.github.greenstevester.heuvana.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.greenstevester.heuvana.v2.domain.ResourceIdentifier;

import java.util.List;

public class UpdateRoom {
  @JsonProperty("children")
  private List<ResourceIdentifier> children;

  public List<ResourceIdentifier> getChildren() {
    return children;
  }

  public void setChildren(final List<ResourceIdentifier> children) {
    this.children = children;
  }
}
