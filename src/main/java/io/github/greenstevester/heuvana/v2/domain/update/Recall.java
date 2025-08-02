package io.github.greenstevester.heuvana.v2.domain.update;

import com.fasterxml.jackson.annotation.JsonProperty;

import static io.github.greenstevester.heuvana.v2.domain.update.SceneAction.ACTIVE;

public class Recall {
  @JsonProperty("action")
  private SceneAction action = ACTIVE;

  public SceneAction getAction() {
    return action;
  }
}
