package io.github.greenstevester.yahueapi.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SceneActivation {
  @JsonProperty("recall")
  private Recall recall = new Recall();

  public Recall getRecall() {
    return recall;
  }
}
